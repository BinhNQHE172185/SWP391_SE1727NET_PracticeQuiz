/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AccountDAO;
import DAO.RoleDAO;
import Model.Account;
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
@WebServlet(name="EditUser", urlPatterns={"/edituser"})
public class EditUser extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RoleDAO roleDAO = new RoleDAO();
        AccountDAO accDAO = new AccountDAO();
        int a = Integer.parseInt(request.getParameter("accountId"));
        Account account = accDAO.getAccountByID(a);
        
        List<Role> listRole = roleDAO.getAllRole();
        
        request.setAttribute("account", account);
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("EditUser.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // get parameter to create new account
        String accID = request.getParameter("accountID");
        int accountID = Integer.parseInt(accID);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String gender = request.getParameter("gender");
        String avatar = request.getParameter("avatar");
        String fullname = request.getParameter("fullname");
        String DOB = request.getParameter("DOB");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        
        // pending
        String role = request.getParameter("role");
        int role_id = Integer.parseInt(role);
        
        AccountDAO DAO = new AccountDAO();
        
        DAO.editUser(accountID, username, password, email, status, gender, avatar, fullname, DOB, address, phonenumber, role_id);
        //response.sendRedirect("/Front%20End/Admin/Dashboard.jsp");
        response.sendRedirect("userlists");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
