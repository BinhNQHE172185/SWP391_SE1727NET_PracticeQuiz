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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LEMONLORD
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = "Wrong username or password.";
        String remember = request.getParameter("remember");

        Account x;
        AccountDAO ad = new AccountDAO();

        x = ad.getAccount(username, password);
        
        if(x==null){
            request.setAttribute("status", status);
            request.getRequestDispatcher("Login.jsp").include(request, response);
        } else if (remember != null && remember.equals("on")) {
            //Cookie luu tru username
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            response.sendRedirect("home.jsp");
        } else {
            request.getSession().setAttribute("currUser", x);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}
