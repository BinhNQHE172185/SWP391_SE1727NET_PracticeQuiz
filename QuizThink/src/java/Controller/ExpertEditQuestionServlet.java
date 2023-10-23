/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import Model.Expert;
import Model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "ExpertEditQuestionServlet", urlPatterns = {"/ExpertEditQuestion"})
public class ExpertEditQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int QuestionID = Integer.parseInt(request.getParameter("QuestionID"));
        HttpSession session = request.getSession();
        Expert ex = (Expert) session.getAttribute("currExpert");
        QuestionDAO qd = new QuestionDAO();
        Question q;
        
        q = qd.getQuestionById(QuestionID);
        
        request.setAttribute("list", q);
        request.getRequestDispatcher("ExpertEditQuestion.jsp").include(request, response);
    }
}
