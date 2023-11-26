/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import DAO.QuestionStatusDAO;
import DAO.SubjectStatusDAO;
import Model.Account;
import Model.Question;
import Model.QuestionStatus;
import Model.SubjectStatus;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimdi
 */
@WebServlet(name = "SubjectRegisterServlet", urlPatterns = {"/SubjectRegisterServlet"})
public class SubjectRegisterServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Account currUser = (Account) session.getAttribute("currUser");
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            // Create an instance of your DAO classes
            SubjectStatusDAO subjectStatusDAO = new SubjectStatusDAO();
            QuestionStatusDAO questionStatusDAO = new QuestionStatusDAO();
            QuestionDAO questionDAO = new QuestionDAO();

            // Generate SubjectStatus entry
            Date now = Date.valueOf(LocalDate.now());
            SubjectStatus subjectStatus = new SubjectStatus(subjectId, currUser.getAccountId(), false, now, now);

            if (subjectStatusDAO.getSubjectStatusId(subjectStatus.getSubjectId(), subjectStatus.getAccountId()) == -1) {//check if subjectstatus exist, -1 mean not found
                int subjectStatusId = subjectStatusDAO.addSubjectStatus(subjectStatus);//add subjectStatus

                // Generate multiple QuestionStatus entries
                // Assuming you have a list of question IDs for the subject
                List<Question> questions = questionDAO.getQuestionsBySubjectId(subjectId);
                for (Question question : questions) {
                    QuestionStatus questionStatus = new QuestionStatus(subjectId, question.getQuestionId(), currUser.getAccountId(), false, now, now);
                    questionStatusDAO.addQuestionStatus(questionStatus);
                }
            }
            // Redirect to a success page or perform any other necessary actions
            response.sendRedirect("YourSubject");

        } catch (Exception e) {
            // Handle any exceptions that occur during the registration process
            e.printStackTrace();
            response.sendRedirect("YourSubject");
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
