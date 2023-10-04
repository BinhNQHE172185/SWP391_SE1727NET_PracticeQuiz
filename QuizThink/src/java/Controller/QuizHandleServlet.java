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
import java.time.Duration;
import java.time.LocalDateTime;
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
        try ( PrintWriter out = response.getWriter()) {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            QuizDAO quizDAO = new QuizDAO();
            AnswerDAO answerDAO = new AnswerDAO();

            Question question = questionDAO.getQuestionById(questionId);
            List<Quiz> quizzes = quizDAO.getQuizzesByQuestionId(questionId);
            for (Quiz quizz : quizzes) {
                List<Answer> answers = answerDAO.getAnswersByQuizId(quizz.getQuizId());
                request.setAttribute("answers" + quizz.getQuizId(), answers);

            }
            LocalDateTime currentTime = LocalDateTime.now();
            Duration duration = Duration.ofHours(question.getDuration().getHours())
                    .plusMinutes(question.getDuration().getMinutes())
                    .plusSeconds(question.getDuration().getSeconds());
            LocalDateTime endTime = currentTime.plus(duration);
            request.setAttribute("endTime", endTime);
            request.setAttribute("question", question);
            request.setAttribute("quizzes", quizzes);
            request.setAttribute("endTime", endTime);
            request.getRequestDispatcher("QuizHandle.jsp").forward(request, response);
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
