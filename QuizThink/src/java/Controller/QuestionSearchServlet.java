/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import DAO.SubjectDAO;
import Model.Question;
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
@WebServlet(name = "QuestionSearchServlet", urlPatterns = {"/QuestionSearchServlet"})
public class QuestionSearchServlet extends HttpServlet {

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

            int page = 1;//target page
            int noOfPages = 1;//default no of page
            int recordsPerPage = 6;
            String searchQuery = "";
            SubjectDAO subjectDAO = new SubjectDAO();
            QuestionDAO questionDAO = new QuestionDAO();

            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            
            GetParentSubjectDimensionTitle getParentSubjectDimensionTitle = new GetParentSubjectDimensionTitle();
            List<SubjectDimension> parentSubjectDimensions = getParentSubjectDimensionTitle.getParentSubjectDimensionTitle(subjectId);

            Subject subject = subjectDAO.getSubjectById(subjectId);
            if (request.getParameter("page") != null) {//restive current page if possible
                page = Integer.parseInt(request.getParameter("page"));
            }
            if ((request.getParameter("searchQuery") != null) && (request.getParameter("searchQuery") != "")) {//restive current page if possible
                searchQuery = request.getParameter("searchQuery");
            }
            int noOfRecords = questionDAO.getNumberOfRecordsBySubjectIdAndSearch(subjectId, searchQuery);
            noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);

            List<Question> questions = questionDAO.searchQuestionsBySubjectId(subjectId, searchQuery, (page - 1) * recordsPerPage, recordsPerPage);

            List<Subject> recentSubjects = subjectDAO.getRecentSubject();
            request.setAttribute("recentSubjects", recentSubjects);
            request.setAttribute("parentSubjectDimensions", parentSubjectDimensions);
            request.setAttribute("subject", subject);
            request.setAttribute("questions", questions);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("searchQuery", searchQuery);
            request.getRequestDispatcher("QuestionSearch.jsp").forward(request, response);
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
