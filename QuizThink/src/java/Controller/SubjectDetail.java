/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ExpertDAO;
import DAO.SubjectDAO;
import DAO.SubjectDimensionDAO;
import DAO.SubjectStatusDAO;
import Model.Account;
import Model.Expert;
import Model.Subject;
import Model.SubjectDimension;
import Model.SubjectStatus;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author minhk
 */
@WebServlet(name = "SubjectDetail", urlPatterns = {"/subjectdetail"})
public class SubjectDetail extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account currUser = (Account) session.getAttribute("currUser");
        String subjectIdString = request.getParameter("pid");
        int subjectId = Integer.parseInt(subjectIdString);
        SubjectDAO subjectDAO = new SubjectDAO();
        ExpertDAO expertDAO = new ExpertDAO();
        SubjectDimensionDAO subjectDimensionDAO = new SubjectDimensionDAO();
           
        Subject subject = subjectDAO.getSubjectById(subjectId);
        request.setAttribute("subjectdetail", subject);
        Expert expert = expertDAO.getExpertBySubjectID(subjectId);
        request.setAttribute("expert", expert);

        SubjectDimension ss = subjectDimensionDAO.getSubjectDimensionBySubject(subjectId);
        request.setAttribute("ss", ss);
        
        SubjectStatusDAO dao = new SubjectStatusDAO();
        if(currUser!=null){
        SubjectStatus status = dao.getSubjectStatus(subjectId,currUser.getAccountId() );
            
        request.setAttribute("status", status);
        }
        request.getRequestDispatcher("SubjectDetail.jsp").forward(request, response);
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
