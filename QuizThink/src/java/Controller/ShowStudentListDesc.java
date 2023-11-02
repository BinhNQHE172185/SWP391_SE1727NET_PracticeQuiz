/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.SubjectDAO;
import DAO.SubjectStatusDAO;
import Model.Account;
import Model.Expert;
import Model.Subject;
import Model.SubjectStatus;
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
 * @author QUYBINH
 */
@WebServlet(name = "ShowStudentListDesc", urlPatterns = {"/ShowStudentListDesc"})
public class ShowStudentListDesc extends HttpServlet {

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
            try {
                SubjectStatusDAO ssd = new SubjectStatusDAO();
                SubjectDAO sd = new SubjectDAO();
                AccountDAO ad = new AccountDAO();
                HttpSession session = request.getSession();
                Expert ex = (Expert) session.getAttribute("currExpert");
                int subjectId = (Integer) session.getAttribute("subjectId");

                List<SubjectStatus> ss = ssd.getStudentListExpert(subjectId);
                List<Account> a = ad.getStudentListByNameDesc(subjectId);
                List<Subject> s = sd.getSubjectByExpert(ex.getExpertId());
                List<Account> studentList = ad.getAllStudentByRole();
                
                request.setAttribute("student", studentList);
                session.setAttribute("subjectId", subjectId);
                request.setAttribute("list", s);
                request.setAttribute("studentList", a);
                request.setAttribute("subjectStatus", ss);
                request.getRequestDispatcher("ExpertStudentList.jsp").forward(request, response);
            }catch (Exception e){
                request.getRequestDispatcher("ExpertStudentList").forward(request, response);
            }
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
