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
import java.util.List;

/**
 *
 * @author Dell
 */
@WebServlet(name = "EditUser", urlPatterns = {"/edituser"})
public class EditUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        RoleDAO roleDAO = new RoleDAO();
        AccountDAO accDAO = new AccountDAO();
        ExpertDAO expDAO = new ExpertDAO();
        MarketerDAO marDAO = new MarketerDAO();

        String a = request.getParameter("accountId");
        String m = request.getParameter("marketerID");
        String e = request.getParameter("expertId");
        String username = request.getParameter("username");

        if (a != null) {

            int acc = Integer.parseInt(a);
            int acc_role = roleDAO.getRoleByAccountID(Integer.parseInt(a));
            Account account = accDAO.getAccountByID(acc);

            String existEmail = account.getEmail();
            String existUsername = account.getUsername();

            request.setAttribute("existEmail", existEmail);
            request.setAttribute("existUsername", existUsername);

            request.setAttribute("account", account);
            request.setAttribute("acc_role", acc_role);

            List<Role> listRole = roleDAO.getAllRole();
            request.setAttribute("listRole", listRole);
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        }
        if (m != null) {
            int mar = Integer.parseInt(m);
            Marketer marketer = marDAO.getMarketerByID(mar);
            List<Role> listRole = roleDAO.getAllRole();

            String existEmail = marketer.getEmail();
            String existUsername = marketer.getUsername();

            request.setAttribute("existEmail", existEmail);
            request.setAttribute("existUsername", existUsername);

            request.setAttribute("listRole", listRole);
            request.setAttribute("marketer", marketer);
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        }
        if (e != null) {
            int exp = Integer.parseInt(e);
            Expert expert = expDAO.getExpertByID(exp);
            List<Role> listRole = roleDAO.getAllRole();

            String existEmail = expert.getEmail();
            String existUsername = expert.getUsername();

            request.setAttribute("existEmail", existEmail);
            request.setAttribute("existUsername", existUsername);

            request.setAttribute("listRole", listRole);
            request.setAttribute("expert", expert);
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        }
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

        String existEmail = request.getParameter("existEmail");
        String existUsername = request.getParameter("existUsername");

        String emailMessage = "Email already exist. Try another email";
        String usernameMessage = "Username already exist. Try another one";
        String usernameMessage2 = "Username invalid. Try another one";
        String passwordMessage = "Password invalid, must be longer than 8 character. Try another password";
        String notice = "Edit successful";

        //----------------------------Marketer TABLE----------------------------
        String markID = request.getParameter("marketerID");
        if (markID != null) {

            int marketerID = Integer.parseInt(markID);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String avatar = request.getParameter("avatar");
            String name = request.getParameter("fullname");
            String selfIntroduction = request.getParameter("self-introduction");

            String ban = request.getParameter("Ban");
                String unban = request.getParameter("Unban");
                if (ban.equals("true")) {
                    marketDAO.BanAccount(marketerID);
                }
                if (unban.equals("true")) {
                    marketDAO.UnbanAccount(marketerID);
                }
                
            if (!DAO.checkPass(password)) {
                request.setAttribute("notice", passwordMessage);
            } else if (!DAO.checkUsername(username)) {
                request.setAttribute("notice", usernameMessage2);
            } else if (!DAO.UsernameExist(username)) {
                request.setAttribute("notice", usernameMessage);
            } else {
                //
                marketDAO.editUser(marketerID, username, password, email, avatar, name, selfIntroduction);
                // Ban Unban 
                
                request.setAttribute("notice", notice);
            }

            Marketer marketer = marketDAO.getMarketerByID(Integer.parseInt(markID));
            List<Role> listRole = roleDAO.getAllRole();

            existEmail = marketer.getEmail();
            existUsername = marketer.getUsername();

            request.setAttribute("existEmail", existEmail);
            request.setAttribute("existUsername", existUsername);

            request.setAttribute("listRole", listRole);
            request.setAttribute("marketer", marketer);

            request.getRequestDispatcher("EditUser.jsp").forward(request, response);

        }

        //----------------------------Expert TABLE----------------------------
        String expID = request.getParameter("expertId");
        if (expID != null) {
            int expertID = Integer.parseInt(expID);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String avatar = request.getParameter("avatar");
            String name = request.getParameter("fullname");
            String selfIntroduction = request.getParameter("self-introduction");

            String ban = request.getParameter("Ban");
            String unban = request.getParameter("Unban");
            if (ban.equals("true")) {
                expDAO.BanAccount(expertID);
            }
            if (unban.equals("true")) {
                expDAO.UnbanAccount(expertID);
            }
            
            if (!DAO.checkPass(password)) {
                request.setAttribute("notice", passwordMessage);
            } else if (!DAO.checkUsername(username)) {
                request.setAttribute("notice", usernameMessage2);
            } else if (!DAO.UsernameExist(username)) {
                request.setAttribute("notice", usernameMessage);
            } else {

                expDAO.editUser(expertID, username, password, email, avatar, name, selfIntroduction);
                // Ban Unban 
                
                request.setAttribute("notice", notice);
            }
            Expert expert = expDAO.getExpertByID(Integer.parseInt(expID));
            List<Role> listRole = roleDAO.getAllRole();

            existEmail = expert.getEmail();
            existUsername = expert.getUsername();

            request.setAttribute("existEmail", existEmail);
            request.setAttribute("existUsername", existUsername);

            request.setAttribute("listRole", listRole);
            request.setAttribute("expert", expert);
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        }
        //----------------------------ACCOUNT TABLE----------------------------
        String accID = request.getParameter("accountID");
        if (accID != null) {
            int accountID = Integer.parseInt(accID);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String status = request.getParameter("status");
            String gender = request.getParameter("gender");
            String avatar = request.getParameter("avatar");
            String fullname = request.getParameter("fullname");
            String DOB = request.getParameter("DOB");
            String phonenumber = request.getParameter("phonenumber");

            // Ban Unban 
                String ban = request.getParameter("Ban");
                String unban = request.getParameter("Unban");
                if (ban.equals("true")) {
                    DAO.BanAccount(accountID);
                }
                if (unban.equals("true")) {
                    DAO.UnbanAccount(accountID);
                }

            if (!DAO.checkPass(password)) {
                request.setAttribute("notice", passwordMessage);
            } else if (!DAO.checkUsername(username)) {
                request.setAttribute("notice", usernameMessage2);
            } else if (!DAO.UsernameExist(username)) {
                request.setAttribute("notice", usernameMessage);
            } else {
                
                DAO.editUser(accountID, username, password, email, status, gender, avatar, fullname, DOB);
                request.setAttribute("notice", notice);
            }
            Account account = DAO.getAccountByID(Integer.parseInt(accID));
            int acc_role = roleDAO.getRoleByAccountID(Integer.parseInt(accID));

            existEmail = account.getEmail();
            existUsername = account.getUsername();

            request.setAttribute("existEmail", existEmail);
            request.setAttribute("existUsername", existUsername);

            request.setAttribute("account", account);
            request.setAttribute("acc_role", acc_role);

            List<Role> listRole = roleDAO.getAllRole();
            request.setAttribute("listRole", listRole);
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        }
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */

