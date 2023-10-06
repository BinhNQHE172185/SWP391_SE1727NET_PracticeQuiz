/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPassword"})
public class ForgotPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String status = "Email doesn't exist.";
        
        AccountDAO ad = new AccountDAO();
        Account acc;
        acc = ad.checkEmail(email);
        if(acc!=null){
            request.setAttribute("Account", acc);
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }else{
            request.setAttribute("status", status);
            request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
        }
    }
}
