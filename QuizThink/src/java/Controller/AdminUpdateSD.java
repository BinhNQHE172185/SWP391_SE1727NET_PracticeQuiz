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
import java.util.Objects;

/**
 *
 * @author kimdi
 */
@WebServlet(name = "AdminUpdateSD", urlPatterns = {"/AdminUpdateSD"})
public class AdminUpdateSD extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//submit add
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String image = request.getParameter("image");
        String desc = request.getParameter("desc");
        int subjectDimensionId = Integer.parseInt(request.getParameter("subjectDimensionId"));
        // DAO
        SubjectDimensionDAO sdDAO = new SubjectDimensionDAO();

        // Create SubjectDimension object
        SubjectDimension subjectDimension = new SubjectDimension();
        subjectDimension.setSubjectDimensionId(subjectDimensionId);
        subjectDimension.setTitle(title);
        subjectDimension.setImageURL(image);
        subjectDimension.setDescription(desc);

        if (request.getParameter("parentId") != null && !request.getParameter("parentId").isEmpty()) {
            subjectDimension.setParentSDId(Integer.parseInt(request.getParameter("parentId")));
        }

        // Update SubjectDimension
        if (sdDAO.updateSubjectDimension(subjectDimension)) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "Error, please try again later");
        }
        
        
        //load info again
        List<SubjectDimension> SDlist = new ArrayList<>();
        getAllChildSD(subjectDimensionId, SDlist);//get all child sd in hierarchy
        List<SubjectDimension> allSD = sdDAO.getAllSubjectDimension();
        //get all sd not a child
        List<SubjectDimension> subtractedSD = new ArrayList<>(allSD);
        for (SubjectDimension sd : SDlist) {
            subtractedSD.removeIf(item -> (item.getSubjectDimensionId() == sd.getSubjectDimensionId()));
        }
        subtractedSD.removeIf(item -> item.getSubjectDimensionId() == subjectDimensionId);

        subjectDimension = sdDAO.getSubjectDimensionByID(subjectDimensionId);
        request.setAttribute("subjectDimension", subjectDimension);
        request.setAttribute("SDlist", subtractedSD);

        request.getRequestDispatcher("AdminUpdateSD.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)//load add page
            throws ServletException, IOException {
        SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();
        int subjectDimensionId = Integer.parseInt(request.getParameter("subjectDimensionId"));
        List<SubjectDimension> SDlist = new ArrayList<>();
        getAllChildSD(subjectDimensionId, SDlist);//get all child sd in hierarchy
        List<SubjectDimension> allSD = subjectDimensionDAO.getAllSubjectDimension();
        //get all sd not a child
        List<SubjectDimension> subtractedSD = new ArrayList<>(allSD);
        for (SubjectDimension sd : SDlist) {
            subtractedSD.removeIf(item -> (item.getSubjectDimensionId() == sd.getSubjectDimensionId()));
        }
        subtractedSD.removeIf(item -> item.getSubjectDimensionId() == subjectDimensionId);

        SubjectDimension subjectDimension = subjectDimensionDAO.getSubjectDimensionByID(subjectDimensionId);
        request.setAttribute("subjectDimension", subjectDimension);
        request.setAttribute("SDlist", subtractedSD);
        request.getRequestDispatcher("AdminUpdateSD.jsp").forward(request, response);
    }

    protected void getAllChildSD(int subjectDimensionId, List<SubjectDimension> SDlist) {
        SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();
        List<SubjectDimension> childSD = subjectDimensionDAO.getAllChildSubjectDimensions(subjectDimensionId);
        SDlist.addAll(childSD);
        if (!childSD.isEmpty()) {
            for (SubjectDimension subjectDimension : childSD) {
                getAllChildSD(subjectDimension.getSubjectDimensionId(), SDlist);
            }
        }
    }
}
