/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.SubjectDimensionDAO;
import Model.SubjectDimension;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "AdminSDSortAsc", urlPatterns = {"/AdminSDSortAsc"})
public class AdminSDSortAsc extends HttpServlet {

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
 /* TODO output your page here. You may use following sample code. */
            int page = 1;//target page
            int noOfPages = 1;//default no of page
            int recordsPerPage = 6;
            int parentId = -1;
            SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();

            if (request.getParameter("page") != null) {//restive current page if possible
                page = Integer.parseInt(request.getParameter("page"));
            }

            List<SubjectDimension> SDlist = new ArrayList<>();
            if ((request.getParameter("parentId") != null) && (Integer.parseInt(request.getParameter("parentId")) != -1)) {//restive current parentId if possible
                parentId = Integer.parseInt(request.getParameter("parentId"));
                int noOfRecords = subjectDimensionDAO.getNumberOfRecordsChildSD(parentId);
                noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
                if (page > noOfPages) {
                    page = noOfPages;
                }
                SDlist = subjectDimensionDAO.getChildSubjectDimensionsAsc(parentId, (page - 1) * recordsPerPage, recordsPerPage);
            } else {
                int noOfRecords = subjectDimensionDAO.getNumberOfRecordsParentSD();
                noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
                if (page > noOfPages) {
                    page = noOfPages;
                }
                SDlist = subjectDimensionDAO.getAllParentSubjectDimensionsAsc((page - 1) * recordsPerPage, recordsPerPage);
            }
            request.setAttribute("SDlist", SDlist);
            request.setAttribute("parentId", parentId);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher("AdminSDList.jsp").forward(request, response);
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
