/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.MembershipDAO;
import Model.Membership;
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
 * @author QUYBINH
 */
@WebServlet(name = "EditMembership", urlPatterns = {"/EditMembership"})
public class EditMembership extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        MembershipDAO md = new MembershipDAO();

        Membership mem = md.getMembershipByID(id);

        request.setAttribute("MemList", mem);
        request.getRequestDispatcher("EditMembership.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        String status = "Successfully";
        MembershipDAO md = new MembershipDAO();

        Membership m = md.getMembershipByID(id);

        if (m.getTitle().equals(title) && m.getPrice() == price && m.getDiscount() == discount && m.getDescription().equals(desc)) {
            status = "No changes found.";
            Membership mem = md.getMembershipByID(id);
            request.setAttribute("status", status);
            request.setAttribute("MemList", mem);

            // Forward to JSP
            request.getRequestDispatcher("EditMembership.jsp").forward(request, response);
        } else {
            // Check if discount changed
            if (m.getDiscount() != discount) {
                // Update price based on the new discount
                price = price - (price * discount);
                md.EditMembership(id, price, discount, desc, title);
                status = "Changes saved.";
            } else if (m.getPrice() != price) {
                price = price - (price * discount);
                md.EditMembership(id, price, discount, desc, title);
                status = "Changes saved.";
            } else {
                md.EditMembership(id, price, discount, desc, title);
                status = "Changes saved.";
            }

            Membership mem = md.getMembershipByID(id);
            // Set attributes
            request.setAttribute("status", status);
            request.setAttribute("MemList", mem);

            // Forward to JSP
            request.getRequestDispatcher("EditMembership.jsp").forward(request, response);
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
