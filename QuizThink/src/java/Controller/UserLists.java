/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AccountDAO;
import DAO.MarketerDAO;
import DAO.RoleDAO;
import Model.Account;
import Model.Marketer;
import Model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
@WebServlet(name="UserLists", urlPatterns={"/userlists"})
public class UserLists extends HttpServlet {
   
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
        
        
        //-----------------------------------Account-----------------------------------
        AccountDAO dao = new AccountDAO();
        RoleDAO RDAO = new RoleDAO();
        
        List<Account> listAccount = new ArrayList<>();
        List<Role> listRole = RDAO.getAllRole();
        String roleId = request.getParameter("roleId");
        String textSearch = request.getParameter("search");
        
        
        int numOfAccount; 
        if(roleId != null){
            numOfAccount = dao.getNumOfAccountByRole(roleId);
        }else{
            numOfAccount = dao.getNumOfAccount();
        }
        
        int lastPage = numOfAccount/15;
        if(numOfAccount %15 != 0){
            lastPage ++;
        }
        String index = request.getParameter("page");
        if(index == null){
            index = "1";
        }
        int page = Integer.parseInt(index);
        
        
        if(roleId != null && textSearch == null){
            listAccount = dao.getAllAccountByRole(page,roleId);
        }else if(roleId == null && textSearch == null){
            listAccount = dao.getAllAccount(page);
        }else if(roleId == null && textSearch != null){
            listAccount = dao.searchAccountByName(textSearch);
        }
        
        
        
        //-----------------------------------Marketer-----------------------------------
        MarketerDAO Mdao = new MarketerDAO();
        List<Marketer> listMarketer = new ArrayList<>();
        listMarketer = Mdao.getAllMarketer();
        
        
        // ----------------Account------------------
        request.setAttribute("selectedRole", roleId);
        request.setAttribute("listRole", listRole);
        request.setAttribute("currentPage", page);
        request.setAttribute("lastPage", lastPage); 
        request.setAttribute("listAccount", listAccount);
        // ----------------Marketer------------------
        request.setAttribute("listMarketer", listMarketer);
        
        request.getRequestDispatcher("UserLists.jsp").forward(request, response);
        
        
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
        processRequest(request, response);
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
