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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        String expirationDate = request.getParameter("expriration");
        String cvv = request.getParameter("cvv");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate localDate = currentTime.toLocalDate();
        java.sql.Date transactionDate = java.sql.Date.valueOf(localDate);
        Date expiration = null;
        if (expirationDate != null && !expirationDate.isEmpty()) {
            try {
                java.util.Date parsedDate = sdf.parse(expirationDate);
                expiration = new Date(parsedDate.getTime());
            } catch (ParseException e) {
                // Handle parsing error if necessary.
            }
        }

        TransactionDAO dao = new TransactionDAO();
        if (dao.isValidFullName(fullname) != true) {
            String mess = "Invalid name";
            request.setAttribute("account", currUser);
            request.setAttribute("mess1", mess);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        } else if (dao.isValidCardName(nameOnCard) != true) {
            String mess = "Invalid name";
            request.setAttribute("mess2", mess);
            request.setAttribute("account", currUser);
            request.setAttribute("account", currUser);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        } else if (dao.isValidCreditCard(creditNumber) != true) {
            String mess = "Invalid credit card number. Make sure you input correct credit number!";
            request.setAttribute("mess3", mess);
            request.setAttribute("account", currUser);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        } else if (expiration != null && transactionDate.after(expiration)) {
            String mess = "Your card has expired";
            request.setAttribute("mess4", mess);
            request.setAttribute("account", currUser);
            request.getRequestDispatcher("CheckOut.jsp").include(request, response);
        } else {
            dao.addTransaction(currUser.getAccountId(), 1, transactionDate, fullname, email, payMethod, nameOnCard, creditNumber, expiration, cvv, 20);
            dao.updateAccountRole(2, currUser.getAccountId());
            response.sendRedirect("ThankYou.jsp");
        }

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
