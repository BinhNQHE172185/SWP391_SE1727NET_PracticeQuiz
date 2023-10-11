/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AnswerDAO;
import DAO.QuestionDAO;
import DAO.QuizDAO;
import Model.Account;
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Account currUser = (Account) session.getAttribute("currUser");
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int timeLeft = Integer.parseInt(request.getParameter("timeLeft"));
            String[] selectedChoices = request.getParameterValues("selectedChoices");
            Set<Integer> selectedChoicesSet = new HashSet<>();
            for (String selectedChoice : selectedChoices) {
                selectedChoicesSet.add(Integer.parseInt(selectedChoice));
            }
            QuestionDAO questionDAO = new QuestionDAO();
            QuizDAO quizDAO = new QuizDAO();
            AnswerDAO answerDAO = new AnswerDAO();
            Question question = questionDAO.getQuestionById(questionId);
            List<Quiz> quizzes = quizDAO.getQuizzesByQuestionId(questionId);
            float totalQuizCount = question.getQuizCount();
            int quizCount = 0;
            for (Quiz quizz : quizzes) {
                int correctChoiceCount = 0;
                List<Answer> answers = answerDAO.getCorrectAnswersByQuizId(quizz.getQuizId());
                for (Answer answer : answers) {
                    if (selectedChoicesSet.contains(answer.getAnswerId())) {
                        correctChoiceCount++;
                    }
                }
                quizCount += (correctChoiceCount/answers.size());
            }
            float mark = (quizCount/totalQuizCount)*10;
            request.setAttribute("mark", mark);
            request.getRequestDispatcher("QuizHandleResult.jsp").forward(request, response);
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
