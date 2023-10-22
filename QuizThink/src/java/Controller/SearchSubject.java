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
@WebServlet(name = "SearchSubject", urlPatterns = {"/search"})
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
        try {
            int page = 1; // target page
            int noOfPages = 1; // default no of pages
            int recordsPerPage = 6;
            SubjectDAO subjectDAO = new SubjectDAO();

            if (request.getParameter("page") != null) {
                // Retrieve the page number from the request if available
                page = Integer.parseInt(request.getParameter("page"));
            }

            if (request.getParameter("noOfPages") != null) {
                // Retrieve the noOfPages from the request if available
                noOfPages = Integer.parseInt(request.getParameter("noOfPages"));
            } else {
                // Calculate the number of pages based on the total number of subjects
                int noOfRecords = subjectDAO.getNumberOfRecords();
                noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
            }

            String keyword = request.getParameter("keyword");
            List<Subject> subjects = null;

            if (keyword != null && !keyword.isEmpty()) {
                // Perform a search if a keyword is provided
                subjects = subjectDAO.searchSubjects(keyword, (page - 1) * recordsPerPage, recordsPerPage);
            } else {
                // Retrieve all subjects if no keyword is provided
                subjects = subjectDAO.getAllSubjects((page - 1) * recordsPerPage, recordsPerPage);
            }

            // Set the attributes for the request
            request.setAttribute("subjects", subjects);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("keyword", keyword);

            // Forward the request to the appropriate JSP for displaying subjects
            request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle exceptions
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
