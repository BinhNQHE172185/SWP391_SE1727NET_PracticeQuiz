/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.TransactionDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
@WebServlet(name = "ProcessCheckoutServlet", urlPatterns = {"/ProcessCheckout"})
public class ProcessCheckoutServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account currUser = (Account) session.getAttribute("currUser");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String payMethod = request.getParameter("paymentMethod");
        String nameOnCard = request.getParameter("nameOnCard");
        String creditNumber = request.getParameter("creditNumber");
        String expirationDate = request.getParameter("expiration");
        String cvv = request.getParameter("cvv");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDateTime currentTime = LocalDateTime.now();
        Date transactionDate = Date.valueOf(currentTime.toLocalDate()); 
        Date expiration = Date.valueOf(expirationDate);
        
        String exp = sdf.format(expiration);
        Date expi =Date.valueOf(exp);
        
        TransactionDAO dao = new TransactionDAO();
        if(dao.isValidFullName(fullname) != true || dao.isValidFullName(nameOnCard) != true){
            String mess = "Invalid name" ;
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        }
        if(dao.isValidCreditCard(creditNumber) != true){
            String mess = "Invalid credit card number. Make sure you input correct credit number!" ;
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        }
        if(transactionDate.after(expiration)){
            String mess = "Your card has expired";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        }
        if(dao.isValid(cvv)){
            String mess = "Invalid cvv. Make sure you input correct cvv number!" ;
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        }
        
        dao.addTransaction(currUser.getAccountId(), 1, transactionDate, fullname, email, payMethod, nameOnCard, creditNumber, expi, cvv, 20);
        response.sendRedirect("ThankYou.jsp");
        
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
        processRequest(request, response);
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
