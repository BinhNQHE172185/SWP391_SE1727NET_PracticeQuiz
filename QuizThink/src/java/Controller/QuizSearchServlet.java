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
import Model.SubjectDimension;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author kimdi
 */
@WebServlet(name = "QuizSearchServlet", urlPatterns = {"/QuizSearchServlet"})
public class QuizSearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            int page = 1; // Target page
            int noOfPages = 1; // Default number of pages
            int recordsPerPage = 6;
            String searchQuery = "";
            QuizDAO quizDAO = new QuizDAO();
            QuestionDAO questionDAO = new QuestionDAO();
            SubjectDAO subjectDAO = new SubjectDAO();
            AnswerDAO answerDAO = new AnswerDAO();

            int questionId = Integer.parseInt(request.getParameter("questionId"));
            Question question = questionDAO.getQuestionById(questionId);
            Subject subject = subjectDAO.getSubjectById(question.getSubjectId());
            
            GetParentSubjectDimensionTitle getParentSubjectDimensionTitle = new GetParentSubjectDimensionTitle();
            List<SubjectDimension> parentSubjectDimensions = getParentSubjectDimensionTitle.getParentSubjectDimensionTitle(subject.getSubjectId());


            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (request.getParameter("searchQuery") != null && !request.getParameter("searchQuery").isEmpty()) {
                searchQuery = request.getParameter("searchQuery");
            }
            int noOfRecords = quizDAO.getNumberOfRecordsByQuestionIdAndSearch(questionId, searchQuery);
            noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);

            List<Quiz> quizzes = quizDAO.searchQuizzesByQuestionId(questionId, searchQuery, (page - 1) * recordsPerPage, recordsPerPage);

            for (Quiz quiz : quizzes) {
                List<Answer> answers = answerDAO.getAnswersByQuizId(quiz.getQuizId());
                request.setAttribute("answers" + quiz.getQuizId(), answers);
            }

            List<Subject> recentSubjects = subjectDAO.getRecentSubject();
            request.setAttribute("recentSubjects", recentSubjects);
            request.setAttribute("parentSubjectDimensions", parentSubjectDimensions);
            request.setAttribute("subject", subject);
            request.setAttribute("question", question);
            request.setAttribute("quizzes", quizzes);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("searchQuery", searchQuery);
            request.getRequestDispatcher("QuizSearch.jsp").forward(request, response);
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
