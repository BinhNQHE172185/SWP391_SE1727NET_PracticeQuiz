/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import DAO.SubjectDAO;
import Model.Expert;
import Model.Question;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "ExpertDeleteQuestion", urlPatterns = {"/ExpertDeleteQuestion"})
public class ExpertDeleteQuestion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;//target page
            int noOfPages = 1;//default no of page
            int recordsPerPage = 6;
            SubjectDAO subjectDAO = new SubjectDAO();
            QuestionDAO questionDAO = new QuestionDAO();
            HttpSession session= request.getSession();
            Expert ex = (Expert) session.getAttribute("currExpert");
            int questionId = Integer.parseInt(request.getParameter("QuestionID"));
            int expertID = ex.getExpertId();
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            //int subjectId = Integer.parseInt(request.getParameter("subjectId"));

            questionDAO.ExpertDeleteQuestion(expertID, subjectId, questionId);
            
            Subject subject = subjectDAO.getSubjectById(subjectId);
            if (request.getParameter("page") != null) {//restive current page if possible
                page = Integer.parseInt(request.getParameter("page"));
            }
            int noOfRecords = questionDAO.getNumberOfRecordBySubjectIDAndExpertID(expertID, subjectId);
            noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);

            List<Question> questions = questionDAO.getQuestionsBySubjectIdAndExpertID(subjectId, expertID, (page - 1) * recordsPerPage, recordsPerPage);
            request.setAttribute("subject", subject);
            request.setAttribute("questions", questions);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher("ExpertQuestionList.jsp").forward(request, response);
    }
}
