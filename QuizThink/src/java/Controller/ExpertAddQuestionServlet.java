/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ExpertDAO;
import DAO.QuestionDAO;
import Model.Expert;
import Model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Time;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "ExpertAddQuestionServlet", urlPatterns = {"/ExpertAddQuestion"})
public class ExpertAddQuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String image = request.getParameter("image");
        String desc = request.getParameter("desc");
        String duration = request.getParameter("duration");
        int subjectID = Integer.parseInt(request.getParameter("subjectID"));
        int expertID = Integer.parseInt(request.getParameter("expertID"));
        int requirement = Integer.parseInt(request.getParameter("requirement"));
        String status = "Successfully";

        //DAO
        QuestionDAO qd = new QuestionDAO();

        //xu li duration---
        int minutes = Integer.parseInt(duration);
        int hours = minutes / 60;
        int remainderMinutes = minutes % 60;

        String timeString = String.format("%02d:%02d:00", hours, remainderMinutes);

        Time time = Time.valueOf(timeString);
        //---
        //Add Question--
        qd.addQuestion(subjectID, expertID, requirement, title, image, desc, time);
        request.setAttribute("status", status);
        request.getRequestDispatcher("ExpertAddQuestion.jsp").include(request, response);
    }
}
