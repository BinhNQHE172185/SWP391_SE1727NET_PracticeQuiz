/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AnswerDAO;
import DAO.QuestionDAO;
import DAO.QuizDAO;
import DAO.SubjectDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import Model.Subject;
import DAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuestionDetailServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            SubjectDAO subjectDAO = new SubjectDAO();
            QuizDAO quizDAO = new QuizDAO();
            AnswerDAO answerDAO = new AnswerDAO();

            Question question = questionDAO.getQuestionById(questionId);
            Subject subject = subjectDAO.getSubjectById(question.getSubjectId());

            int page = 1; // target page
            int noOfPages = 1; // default no of page
            int recordsPerPage = 5; // number of quizzes per page

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            int noOfRecords = quizDAO.getNumberOfRecordsByQuestionId(questionId);
            noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);

            List<Quiz> quizzes = quizDAO.getQuizzesByQuestionId(questionId, (page - 1) * recordsPerPage, recordsPerPage);

            for (Quiz quiz : quizzes) {
                List<Answer> answers = answerDAO.getAnswersByQuizId(quiz.getQuizId());
                request.setAttribute("answers" + quiz.getQuizId(), answers);
            }
            
            request.setAttribute("subject", subject);
            request.setAttribute("question", question);
            request.setAttribute("quizzes", quizzes);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher("QuestionDetail.jsp").forward(request, response);
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
