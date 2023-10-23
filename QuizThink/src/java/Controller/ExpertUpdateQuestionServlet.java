/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import Model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "ExpertUpdateQuestionServlet", urlPatterns = {"/ExpertUpdateQuestion"})
public class ExpertUpdateQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int QuestionID = Integer.parseInt(request.getParameter("QuestionID"));
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

        qd.ExpertUpdateQuestion(expertID, QuestionID, title, image, desc, requirement, time);
        Question q;

        q = qd.getQuestionById(QuestionID);

        request.setAttribute("list", q);
        request.setAttribute("status", status);
        request.getRequestDispatcher("ExpertEditQuestion.jsp").include(request, response);
    }

}
