/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.SubjectDimensionDAO;
import Model.SubjectDimension;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "AdminSDSearch", urlPatterns = {"/AdminSDSearch"})
public class AdminSDSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;//target page
        int noOfPages = 1;//default no of page
        int recordsPerPage = 6;
        int parentId = -1;
        String searchQuery = "";
        SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();

        if (request.getParameter("page") != null) {//restive current page if possible
            page = Integer.parseInt(request.getParameter("page"));
        }
        if ((request.getParameter("search") != null) && (request.getParameter("search") != "")) {//restive current search query if possible
            searchQuery = request.getParameter("search");
        }
        int noOfRecords = subjectDimensionDAO.getNumberOfRecordsByTitle(searchQuery);
        noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
        if (page > noOfPages) {
            page = noOfPages;
        }

        List<SubjectDimension> SDlist = subjectDimensionDAO.searchSubjectDimensionsByTitle(searchQuery, (page - 1) * recordsPerPage, recordsPerPage);
        request.setAttribute("SDlist", SDlist);
        request.setAttribute("parentId", parentId);
        request.setAttribute("search", searchQuery);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("AdminSDList.jsp").forward(request, response);

    }
}
