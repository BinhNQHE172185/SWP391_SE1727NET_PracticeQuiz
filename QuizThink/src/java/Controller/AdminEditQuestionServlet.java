/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import Model.Account;
import Model.Question;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author kimdi
 */
@WebServlet(name = "AdminEditQuestionServlet", urlPatterns = {"/AdminEditQuestion"})
public class AdminEditQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int QuestionID = Integer.parseInt(request.getParameter("QuestionID"));
        HttpSession session = request.getSession();
        Account currUser = (Account) session.getAttribute("currUser");
        QuestionDAO qd = new QuestionDAO();
        Question q;
        
        q = qd.getQuestionById(QuestionID);
        
        request.setAttribute("list", q);
        request.getRequestDispatcher("AdminEditQuestion.jsp").include(request, response);
    }
}
