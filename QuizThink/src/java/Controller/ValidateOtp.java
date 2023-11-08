/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.*;
import Model.*;
import jakarta.servlet.RequestDispatcher;
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
 * @author QUYBINH
 */
@WebServlet(name = "ValidateOtp", urlPatterns = {"/ValidateOtp"})
public class ValidateOtp extends HttpServlet {

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
                int value = Integer.parseInt(request.getParameter("otp"));
                HttpSession session = request.getSession();
                int otp = (int) session.getAttribute("otp");
                String email = (String) session.getAttribute("email");
                AccountDAO ad = new AccountDAO();
                Account acc = ad.checkEmail(email);
                ExpertDAO ed = new ExpertDAO();
                Expert ex = ed.checkMail(email);
                MarketerDAO mkd = new MarketerDAO();
                Marketer mk = mkd.checkMail(email);
                RequestDispatcher dispatcher = null;
                
                if (value == otp) {
                    
                    request.setAttribute("email", request.getParameter("email"));
                    request.setAttribute("status", "success");
                    if (acc != null) {
                        request.setAttribute("Account", acc);
                    } else if (ex != null) {
                        request.setAttribute("Expert", ex);
                    } else if (mk != null) {
                        request.setAttribute("Marketer", mk);
                    }
                    dispatcher = request.getRequestDispatcher("ChangePassword.jsp");
                    dispatcher.forward(request, response);
                    
                } else {
                    request.setAttribute("status", "Wrong Otp");
                    
                    dispatcher = request.getRequestDispatcher("ValidateOtp.jsp");
                    dispatcher.forward(request, response);
                    
                }
            } catch (Exception e) {
                request.setAttribute("status", "Wrong Otp.");
                
                request.getRequestDispatcher("ValidateOtp.jsp").forward(request, response);
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
