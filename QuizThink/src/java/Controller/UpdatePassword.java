/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.*;
import Model.*;
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
@WebServlet(name = "UpdatePassword", urlPatterns = {"/UpdatePassword"})
public class UpdatePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");
        String reEnter = request.getParameter("reEnter");
        String accountID = request.getParameter("accountID");
        String expertId = request.getParameter("expertId");
        String email = request.getParameter("email");
        String status = "Password doesn't match";
        String passStatus = "Password must be at least 8 characters long included letters and numbers";

        AccountDAO ad = new AccountDAO();
        Account acc = ad.checkEmail(email);
        ExpertDAO ed = new ExpertDAO();
        Expert ex = ed.checkMail(email);
        if (ad.checkPass(password)) {
            if (password.equals(reEnter)) {
                if(acc!=null){
                    ad.updatePassword(password, accountID);
                }else if(ex!=null){
                    ed.updatePassword(password, expertId);
                }
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.setAttribute("Account", acc);
                request.setAttribute("Expert", ex);
                request.setAttribute("status", status);
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("Account", acc);
            request.setAttribute("status", passStatus);
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }
    }
}
