/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.ExpertDAO;
import DAO.MarketerDAO;
import Model.Account;
import Model.Expert;
import Model.Marketer;
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
        Expert e;
        ExpertDAO ed = new ExpertDAO();
        Marketer mk;
        MarketerDAO mkd = new MarketerDAO();

        x = ad.getAccount(username, password);
        e = ed.getExpert(username, password);
        mk = mkd.getMarketer(username, password);
        
        if (x == null && e == null && mk == null) {
            request.setAttribute("status", status);
            request.getRequestDispatcher("Login.jsp").include(request, response);
        } else if (remember != null && remember.equals("on")) {
            //Cookie luu tru username
            if (x != null) {
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60);
                passwordCookie.setMaxAge(60 * 60);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            } else if (e != null) {
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60);
                passwordCookie.setMaxAge(60 * 60);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                passwordCookie.setMaxAge(60 * 60);
            } else if (mk != null) {
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60);
                passwordCookie.setMaxAge(60 * 60);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                passwordCookie.setMaxAge(60 * 60);
            }
        }
        if (x != null) {
            request.getSession().setAttribute("currUser", x);
            request.getRequestDispatcher("home").forward(request, response);
        } else if (e != null) {
            request.getSession().setAttribute("currExpert", e);
            request.getRequestDispatcher("home").forward(request, response);
        } else if (mk != null) {
            request.getSession().setAttribute("currMarketer", mk);
            request.getRequestDispatcher("ListCustomerServlet").forward(request, response);
        }
    }
}
