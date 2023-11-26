/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ExpertDAO;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "ExpertQuestionSearch", urlPatterns = {"/ExpertQuestionSearch"})
public class ExpertQuestionSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;//target page
        int noOfPages = 1;//default no of page
        int recordsPerPage = 6;
        String searchQuery = "";
        SubjectDAO subjectDAO = new SubjectDAO();
        QuestionDAO questionDAO = new QuestionDAO();
        HttpSession session = request.getSession();
        Expert ex = (Expert) session.getAttribute("currExpert");

        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        Subject subject = subjectDAO.getSubjectById(subjectId);
        if (request.getParameter("page") != null) {//restive current page if possible
            page = Integer.parseInt(request.getParameter("page"));
        }
        if ((request.getParameter("search") != null) && (request.getParameter("search") != "")) {//restive current page if possible
            searchQuery = request.getParameter("search");
        }
        int noOfRecords = questionDAO.getNumberOfRecordsBySubjectAndExpertIdIdAndSearch(subjectId, ex.getExpertId(), searchQuery);
        noOfPages = (int) Math.ceil((double) noOfRecords / recordsPerPage);
        if (page > noOfPages) {
            page = noOfPages;
        }

        List<Question> questions = questionDAO.searchQuestionsBySubjectIdAndExpertId(subjectId, ex.getExpertId(), searchQuery, (page - 1) * recordsPerPage, recordsPerPage);
        request.setAttribute("subject", subject);
        request.setAttribute("search", searchQuery);
        request.setAttribute("questions", questions);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("searchQuery", searchQuery);
        request.getRequestDispatcher("ExpertQuestionList.jsp").forward(request, response);

    }
}
