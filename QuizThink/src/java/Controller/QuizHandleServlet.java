/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AnswerDAO;
import DAO.QuestionDAO;
import DAO.QuizDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuizHandleServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//prevent using cache to reload exam
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            // Clear the old exam session
            Enumeration<String> attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                if (attributeName.startsWith("answer")) {
                    session.removeAttribute(attributeName);
                }
            }
            session.removeAttribute("endTime");//clear timer sesstion
            session.removeAttribute("question");//clear question sesstion
            session.removeAttribute("quizzes");//clear quizzes sesstion
            
            QuestionDAO questionDAO = new QuestionDAO();
            QuizDAO quizDAO = new QuizDAO();
            AnswerDAO answerDAO = new AnswerDAO();
            Time time;
            if (session.getAttribute("endTime") == null) {//shuffle quizes and get new endtime
                Question question = questionDAO.getQuestionById(questionId);
                List<Quiz> quizzes = quizDAO.getQuizzesByQuestionId(questionId);
                Collections.shuffle(quizzes); // Shuffle the quizzes list randomly
                for (Quiz quizz : quizzes) {
                    List<Answer> answers = answerDAO.getAnswersByQuizId(quizz.getQuizId());
                    Collections.shuffle(answers); // Shuffle the answers list randomly
                    session.setAttribute("answers" + quizz.getQuizId(), answers);
                }
                LocalDateTime currentTime = LocalDateTime.now();
                LocalTime durationTime = question.getDuration().toLocalTime();
                Duration duration = Duration.ofHours(durationTime.getHour())
                        .plusMinutes(durationTime.getMinute())
                        .plusSeconds(durationTime.getSecond());
                LocalDateTime endTime = currentTime.plus(duration);

                time = Time.valueOf(endTime.toLocalTime());

                session.setAttribute("question", question);
                session.setAttribute("endTime", time);
                session.setAttribute("quizzes", quizzes);
            }
            //request.getRequestDispatcher("QuizHandle.jsp").forward(request, response);
            response.sendRedirect("QuizHandle.jsp");
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
