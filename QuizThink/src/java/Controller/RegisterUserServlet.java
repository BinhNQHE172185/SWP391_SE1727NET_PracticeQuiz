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
@WebServlet(name = "RegisterUserServlet", urlPatterns = {"/RegisterUser"})
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String expert = request.getParameter("expert");
        String passStatus = "Password must be at least 8 characters long included letters and numbers";
        String UserStatus = "Username must be 4-20 characters long and only contain letters, numbers, and underscores.";
        String UserExistStatus = "Username exists.";
        String emailExistStatus = "Email exists.";
        int flag = 0;

        AccountDAO ad = new AccountDAO();
        Account acc;

        ExpertDAO ed = new ExpertDAO();
        Expert e;
        //expert
        if (expert != null && expert.equals("on")) {
            if (!ed.UsernameExist(username)) {
                request.setAttribute("UserExistStatus", UserExistStatus);
                flag++;
            }

            if (!ad.checkUsername(username)) {
                request.setAttribute("Ustatus", UserStatus);
                flag++;
            }

            if ((e = ed.getExpertByEmail(email)) != null) {
                request.setAttribute("emailExistStatus", emailExistStatus);
                flag++;
            }

            if (!ad.checkPass(password)) {
                request.setAttribute("Pstatus", passStatus);
                flag++;
            }

            if (flag > 0) {
                request.getRequestDispatcher("Register.jsp").include(request, response);
            } else {
                ed.RegisterExpert(username, password, email);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else { //student

            if (!ad.UsernameExist(username)) {
                request.setAttribute("UserExistStatus", UserExistStatus);
                flag++;
            }

            if (!ad.checkUsername(username)) {
                request.setAttribute("Ustatus", UserStatus);
                flag++;
            }

            if ((acc = ad.checkEmail(email)) != null) {
                request.setAttribute("emailExistStatus", emailExistStatus);
                flag++;
            }

            if (!ad.checkPass(password)) {
                request.setAttribute("Pstatus", passStatus);
                flag++;
            }

            if (flag > 0) {
                request.getRequestDispatcher("Register.jsp").include(request, response);
            } else {
                ad.RegisterAcc(username, password, email);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    }
}
