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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
@WebServlet(name = "AdminAddSD", urlPatterns = {"/AdminAddSD"})
public class AdminAddSD extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//submit add
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String image = request.getParameter("image");
        String desc = request.getParameter("desc");

        // DAO
        SubjectDimensionDAO sdDAO = new SubjectDimensionDAO();

        // Create SubjectDimension object
        SubjectDimension subjectDimension = new SubjectDimension();
        subjectDimension.setTitle(title);
        subjectDimension.setImageURL(image);
        subjectDimension.setDescription(desc);

        if (request.getParameter("parentId") != null) {
            subjectDimension.setParentSDId(Integer.parseInt(request.getParameter("parentId")));
        }

        // Add SubjectDimension
        if (sdDAO.addSubjectDimension(subjectDimension)) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "Error, please try again later");
        }

        request.getRequestDispatcher("AdminAddSD.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)//load add page
            throws ServletException, IOException {
        SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();
        List<SubjectDimension> SDlist = subjectDimensionDAO.getAllSubjectDimension();
        request.setAttribute("SDlist", SDlist);
        request.getRequestDispatcher("AdminAddSD.jsp").forward(request, response);
    }
}
