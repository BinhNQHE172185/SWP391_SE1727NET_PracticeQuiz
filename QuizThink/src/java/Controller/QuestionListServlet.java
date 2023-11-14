/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import DAO.QuestionStatusDAO;
import DAO.ResultDAO;
import DAO.SubjectDAO;
import Model.Account;
import Model.Question;
import Model.QuestionStatus;
import Model.Result;
import Model.Subject;
import Model.SubjectDimension;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author kimdi
 */
public class QuestionListServlet extends HttpServlet {

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

            int page = 1;//target page
            int noOfPages = 1;//default no of page
            int recordsPerPage = 6;
            SubjectDAO subjectDAO = new SubjectDAO();
            QuestionDAO questionDAO = new QuestionDAO();
            QuestionStatusDAO questionStatusDAO = new QuestionStatusDAO();

            int subjectId = 1;
            //int subjectId = Integer.parseInt(request.getParameter("subjectId"));

            Subject subject = subjectDAO.getSubjectById(subjectId);

            GetParentSubjectDimensionTitle getParentSubjectDimensionTitle = new GetParentSubjectDimensionTitle();
            List<SubjectDimension> parentSubjectDimensions = getParentSubjectDimensionTitle.getParentSubjectDimensionTitle(subject.getSubjectId());

            if (session.getAttribute("questionStatusUpdated") == null) {//run once every session or when manually cleared
                updateQuestionStatusInSubject(subject, currUser);
                session.setAttribute("questionStatusUpdated", true);//run once
            }

            if (request.getParameter("page") != null) {//restive current page if possible
                page = Integer.parseInt(request.getParameter("page"));
            }
            int noOfRecords = questionDAO.getNumberOfRecordsBySubjectId(subjectId);
            noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);

            List<Question> questions = questionDAO.getQuestionsBySubjectId(subjectId, (page - 1) * recordsPerPage, recordsPerPage);
            for (Question question : questions) {
                QuestionStatus questionStatus = questionStatusDAO.getQuestionStatusByQuestionIdAndAccountId(question.getQuestionId(), currUser.getAccountId());
                boolean status = (questionStatus != null && questionStatus.isStatus());
                request.setAttribute("questionStatus" + question.getQuestionId(), status);
            }
            request.setAttribute("parentSubjectDimensions", parentSubjectDimensions);
            request.setAttribute("subject", subject);
            request.setAttribute("questions", questions);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher("QuestionList.jsp").forward(request, response);
        }
    }

    protected void updateQuestionStatusInSubject(Subject subject, Account currUser) {
        QuestionDAO questionDAO = new QuestionDAO();
        QuestionStatusDAO questionStatusDAO = new QuestionStatusDAO();
        ResultDAO resultDAO = new ResultDAO();
        List<QuestionStatus> questionStatuses = questionStatusDAO.getQuestionStatusListBySubjectIdAndUserId(subject.getSubjectId(), currUser.getAccountId());
        for (QuestionStatus questionStatus : questionStatuses) {
            if (!questionStatus.isStatus()) {
                Question question = questionDAO.getQuestionById(questionStatus.getQuestionId());
                Result result = resultDAO.getHighestMarkResultByQuestionIdAndAccountId(questionStatus.getQuestionId(), currUser.getAccountId());
                if (result != null) {
                    if ((result.getMark() * 10) >= question.getRequirement()) {
                        questionStatusDAO.updateQuestionStatusToTrue(questionStatus.getQuestionStatusId());
                    }
                }
            }
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
