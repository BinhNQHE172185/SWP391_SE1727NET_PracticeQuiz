/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.ExpertDAO;
import DAO.MarketerDAO;
import DAO.RoleDAO;
import Model.Account;
import Model.Expert;
import Model.Marketer;
import Model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CreateAccount", urlPatterns = {"/createaccount"})
public class CreateAccount extends HttpServlet {

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
        RoleDAO roleDAO = new RoleDAO();

        List<Role> listRole = roleDAO.getAllRole();

        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("CreateUser.jsp").forward(request, response);

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
        AccountDAO DAO = new AccountDAO();
        ExpertDAO expDAO = new ExpertDAO();
        MarketerDAO marketDAO = new MarketerDAO();
        RoleDAO roleDAO = new RoleDAO();

        String emailMessage = "Email already exist. Try another email";
        String usernameMessage = "Username already exist. Try another one";
        String usernameMessage2 = "Username invalid. Try another one";
        String passwordMessage = "Password invalid, must be longer than 8 character. Try another password";
        String notice = "Create account successful";

        //----------------------------Marketer TABLE----------------------------
        String createMarketer = request.getParameter("createMarketer");
        if (createMarketer != null) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String avatar = request.getParameter("avatar");
            String name = request.getParameter("fullname");
            String selfIntroduction = request.getParameter("self-introduction");

            if (!DAO.checkPass(password)) {
                request.setAttribute("notice", passwordMessage);
            } else if (!DAO.checkUsername(username)) {
                request.setAttribute("notice", usernameMessage2);
            } else if (!DAO.UsernameExist(username)) {
                request.setAttribute("notice", usernameMessage);
            } else {
                //
                boolean result = marketDAO.addMarketer(username, password, email, name, selfIntroduction, avatar, true);
                request.setAttribute("notice", notice);
            }
            request.getRequestDispatcher("CreateUser.jsp").forward(request, response);

        }

        //----------------------------Expert TABLE----------------------------
        String createExpert = request.getParameter("createExpert");
        if (createExpert != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String avatar = request.getParameter("avatar");
            String name = request.getParameter("fullname");
            String selfIntroduction = request.getParameter("self-introduction");

            if (!DAO.checkPass(password)) {
                request.setAttribute("notice", passwordMessage);
            } else if (!DAO.checkUsername(username)) {
                request.setAttribute("notice", usernameMessage2);
            } else if (!DAO.UsernameExist(username)) {
                request.setAttribute("notice", usernameMessage);
            } else {
                boolean result = expDAO.addExpert(username, password, email, name, selfIntroduction, avatar, true);
                request.setAttribute("notice", notice);
            }
            request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
        }
        //----------------------------ACCOUNT TABLE----------------------------
        String createAccount = request.getParameter("createAccount");
        if (createAccount != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String status = request.getParameter("status");
            String gender = request.getParameter("gender");
            String avatar = request.getParameter("avatar");
            String fullname = request.getParameter("fullname");
            String DOB = request.getParameter("DOB");
            String phonenumber = request.getParameter("phonenumber");
            String selfIntroduction = request.getParameter("self-introduction");

            if (!DAO.checkPass(password)) {
                request.setAttribute("notice", passwordMessage);
            } else if (!DAO.checkUsername(username)) {
                request.setAttribute("notice", usernameMessage2);
            } else if (!DAO.UsernameExist(username)) {
                request.setAttribute("notice", usernameMessage);
            } else {
                int newAccountId = DAO.addAccount(username, password, email, fullname, DOB, gender, selfIntroduction, avatar, true);
                if (newAccountId == 0) {
                    request.setAttribute("notice", "Error, Failed to add new account" + newAccountId);
                } else {
                    roleDAO.createAccountRole(newAccountId, 1);
                    request.setAttribute("notice", notice);
                }
            }
            request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
        }
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
