/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AnswerDAO;
import DAO.QuestionDAO;
import DAO.QuestionStatusDAO;
import DAO.QuizDAO;
import DAO.ResultDAO;
import Model.Account;
import Model.Answer;
import Model.Question;
import Model.QuestionStatus;
import Model.Quiz;
import Model.Result;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.sql.Date;
import java.sql.Time;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author kimdi
 */
public class QuizSubmitServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Account currUser = (Account) session.getAttribute("currUser");

            // Read the request body
            StringBuilder requestBody = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
            reader.close();

            // Parse the JSON data
            JsonObject jsonData = new Gson().fromJson(requestBody.toString(), JsonObject.class);
            String questionIdParam = jsonData.get("questionId").getAsString();
            String timeLeftParam = jsonData.get("timeLeft").getAsString();
            JsonArray selectedChoicesArray = jsonData.get("selectedChoices").getAsJsonArray();

            if (questionIdParam == null || timeLeftParam == null) {
                // Handle the case when the required parameters are missing
                String json = new Gson().toJson("error");
                response.getWriter().write(json);
            } else {
                session.removeAttribute("endTime");//clear timer sesstion
                session.removeAttribute("question");//clear question sesstion
                session.removeAttribute("quizzes");//clear quizzes sesstion
                // clear answers sesstion
                Enumeration<String> attributeNames = session.getAttributeNames();
                while (attributeNames.hasMoreElements()) {
                    String attributeName = attributeNames.nextElement();
                    if (attributeName.startsWith("answer")) {
                        session.removeAttribute(attributeName);
                    }
                }
                QuestionDAO questionDAO = new QuestionDAO();
                QuizDAO quizDAO = new QuizDAO();
                AnswerDAO answerDAO = new AnswerDAO();

                int questionId = Integer.parseInt(questionIdParam);
                //get timeLEft
                // Get timeLeft
                long millisecondsLeft = Long.parseLong(timeLeftParam);

                Question question = questionDAO.getQuestionById(questionId);
                Time duration = question.getDuration();

                // Calculate the time taken
                long durationMillis = duration.getTime();
                long timeTakenMillis = durationMillis - millisecondsLeft;

                // Create a new 'Time' object for the time taken
                Time timeTaken = new Time(timeTakenMillis);
                //get selected choice
                Set<Integer> selectedChoicesSet = new HashSet<>();
                for (JsonElement choice : selectedChoicesArray) {
                    selectedChoicesSet.add(choice.getAsInt());
                }

                List<Quiz> quizzes = quizDAO.getQuizzesByQuestionId(questionId);
                float totalQuizCount = question.getQuizCount();
                float quizCount = 0;
                for (Quiz quizz : quizzes) {
                    int correctChoiceCount = 0;
                    List<Answer> answers = answerDAO.getCorrectAnswersByQuizId(quizz.getQuizId());
                    for (Answer answer : answers) {
                        if (selectedChoicesSet.contains(answer.getAnswerId())) {
                            correctChoiceCount++;
                        }
                    }
                    quizCount += (correctChoiceCount / answers.size());
                    //clear answers sesstion
                    String attributeKey = "answers" + quizz.getQuizId();
                    session.removeAttribute(attributeKey);
                }
                float mark = (quizCount / totalQuizCount) * 10;

                ResultDAO resultDAO = new ResultDAO();
                Result result = new Result(questionId, currUser.getAccountId(), setToString(selectedChoicesSet), new Date(System.currentTimeMillis()), timeTaken, question.getDuration(), mark, question.getQuizCount());
                int resultId = resultDAO.addResult(result);

                session.removeAttribute("questionStatusUpdated");//force client to update status 
                updateQuestionStatus(question, currUser);
                

                String jsonResponse = new Gson().toJson(resultId);
                response.getWriter().write(jsonResponse);
            }
        }
    }

    public static String setToString(Set<Integer> set) {
        return set.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    protected void updateQuestionStatus(Question question, Account currUser) {
        QuestionStatusDAO questionStatusDAO = new QuestionStatusDAO();
        ResultDAO resultDAO = new ResultDAO();
        QuestionStatus questionStatus = questionStatusDAO.getQuestionStatusByQuestionIdAndAccountId(question.getQuestionId(), currUser.getAccountId());
        if (!questionStatus.isStatus()) {
            Result result = resultDAO.getHighestMarkResultByQuestionIdAndAccountId(question.getQuestionId(), currUser.getAccountId());
            if (result != null) {
                if ((result.getMark() * 10) >= question.getRequirement()) {
                    questionStatusDAO.updateQuestionStatusToTrue(questionStatus.getQuestionStatusId());
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
