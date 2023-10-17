/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AnswerDAO;
import DAO.QuizDAO;
import DAO.ResultDAO;
import Model.Answer;
import Model.Quiz;
import Model.Result;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author admin
 */
@WebServlet(name = "ViewPracticedDetailServlet", urlPatterns = {"/ViewPracticedDetail"})
public class ViewPracticedDetailServlet extends HttpServlet {

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
        Map<Integer, List<Answer>> answerMap = new HashMap<>();
        QuizDAO quizDao = new QuizDAO();
        ResultDAO resultDao = new ResultDAO();
        AnswerDAO answerDao = new AnswerDAO();
        Result rs = resultDao.getResultByID("5");
        List<Quiz> listQuiz = quizDao.getQuizzesByQuestionId(2);
        for (Quiz quiz : listQuiz) {
            // Lấy list câu trả lời cho mỗi câu hỏi
            List<Answer> answerList = answerDao.getAnswersByQuizId(quiz.getQuizId());
            // Lưu vào attribute của quiz
            answerMap.put(quiz.getQuizId(), answerList);
        }

        String selected = rs.getSelectedChoice();
        String[] selectedChoices = selected.replaceAll("[\\[\\]\"]", "").split(", ");
        int[] intArray = new int[selectedChoices.length];

        for (int i = 0; i < selectedChoices.length; i++) {
            intArray[i] = Integer.parseInt(selectedChoices[i]);
        }
//        Set<String> selectedChoicesSet = new HashSet<>();
//        for (String selectedChoice : selectedChoices) {
//            selectedChoicesSet.add((selectedChoice));
//        }

        request.setAttribute("listQuiz", listQuiz);
        request.setAttribute("rs", rs);
        request.setAttribute("answerMap", answerMap);
        request.setAttribute("selectedChoices", selectedChoices);
        request.getRequestDispatcher("ViewPracticedDetail.jsp").forward(request, response);

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
