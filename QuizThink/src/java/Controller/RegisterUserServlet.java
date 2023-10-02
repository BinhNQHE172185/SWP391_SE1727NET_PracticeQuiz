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
@WebServlet(name = "RegisterUserServlet", urlPatterns = {"/RegisterUser"})
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String status = "Password must be at least 8 characters long included letters and numbers";
        
        Account x;
        AccountDAO ad = new AccountDAO();

        if (ad.checkPass(password)) {
            ad.RegisterAcc(username, password, email);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
            request.setAttribute("status", status);
            request.getRequestDispatcher("Register.jsp").include(request, response);
        }
    }

}
