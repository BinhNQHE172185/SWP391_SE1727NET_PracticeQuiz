/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.SubjectDAO;
import Model.Subject;
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
 * @author minhk
 */
@WebServlet(name = "SearchSubject", urlPatterns = {"/SearchSubject"})
public class SearchSubject extends HttpServlet {

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
            int page = 1;
            int noOfPages = 1;
            int recordsPerPage = 6;
            String searchQuery = "";
            SubjectDAO subjectDAO = new SubjectDAO();

            // Assuming you have a way to get the subjectId parameter, replace this line accordingly
            

            

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (request.getParameter("searchQuery") != null && !request.getParameter("searchQuery").isEmpty()) {
                searchQuery = request.getParameter("searchQuery");
            }
            System.out.println(searchQuery);
            // Update the next line to call a method that retrieves the number of records based on your Subject search criteria
            int noOfRecords = subjectDAO.getNumberOfRecordsBySubjectTitle(searchQuery);
            noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);

            // Update the next line to call a method that retrieves a list of subjects based on your search criteria
            List<Subject> subjects = subjectDAO.searchSubjects(searchQuery, (page - 1) * recordsPerPage, recordsPerPage);

            request.setAttribute("subjects", subjects);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("searchQuery", searchQuery);
            request.getRequestDispatcher("SearchSubject.jsp").forward(request, response);
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
