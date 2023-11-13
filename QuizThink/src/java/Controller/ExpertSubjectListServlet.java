/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ExpertDAO;
import DAO.SubjectDAO;
import Model.Expert;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "ExpertSubjectListServlet", urlPatterns = {"/ExpertSubjectList"})
public class ExpertSubjectListServlet extends HttpServlet {

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
        int page = 1;//target page
        int noOfPages = 1;//default no of page
        int recordsPerPage = 6;
        SubjectDAO dao = new SubjectDAO();
        HttpSession session = request.getSession();
        Expert ex = (Expert) session.getAttribute("currExpert");
        ExpertDAO DAO = new ExpertDAO();
        Expert expert = DAO.getExpertByID(ex.getExpertId());
        List<Subject> list = dao.getSubjectByExpertPaging(ex.getExpertId(), (page - 1) * recordsPerPage, recordsPerPage);
        if (request.getParameter("page") != null) {//restive current page if possible
            page = Integer.parseInt(request.getParameter("page"));
        }
        int noOfRecords = dao.getNumberOfRecordByExpertID(37);
        noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
        if (page > noOfPages) {
            page = noOfPages;
        }
        request.setAttribute("list", list);
        request.setAttribute("expert", expert);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("ExpertSunjectLists.jsp").forward(request, response);
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
