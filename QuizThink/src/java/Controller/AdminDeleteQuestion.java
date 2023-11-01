/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import DAO.SubjectDAO;
import Model.Question;
import Model.Subject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author kimdi
 */
@WebServlet(name = "AdminDeleteQuestion", urlPatterns = {"/AdminDeleteQuestion"})
public class AdminDeleteQuestion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;//target page
        int noOfPages = 1;//default no of page
        int recordsPerPage = 6;
        SubjectDAO subjectDAO = new SubjectDAO();
        QuestionDAO questionDAO = new QuestionDAO();
        HttpSession session = request.getSession();
        int questionId = Integer.parseInt(request.getParameter("QuestionID"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        //int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        questionDAO.deleteQuestion(questionId);

        Subject subject = subjectDAO.getSubjectById(subjectId);
        if (request.getParameter("page") != null) {//restive current page if possible
            page = Integer.parseInt(request.getParameter("page"));
        }
        int noOfRecords = questionDAO.getNumberOfRecordsBySubjectId(subjectId);
        noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
        if (page > noOfPages) {
            page = noOfPages;
        }

        List<Question> questions = questionDAO.getQuestionsBySubjectId(subjectId, (page - 1) * recordsPerPage, recordsPerPage);
        request.setAttribute("subject", subject);
        request.setAttribute("questions", questions);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("AdminQuestionList.jsp").forward(request, response);
    }
}
