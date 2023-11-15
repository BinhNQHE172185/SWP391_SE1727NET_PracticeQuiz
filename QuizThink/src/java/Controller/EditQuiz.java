/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AnswerDAO;
import DAO.QuestionDAO;
import DAO.QuizDAO;
import DAO.SubjectDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Dell
 */
public class EditQuiz extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String question_id = request.getParameter("questionId");
        String quiz_id = request.getParameter("quizID");
        int quiz_ID = Integer.parseInt(quiz_id);
        
        QuizDAO quizDAO = new QuizDAO();
        AnswerDAO answerDAO = new AnswerDAO();
        
        Quiz quiz = quizDAO.getQuizByID(quiz_id);
        List<Answer> answerList = answerDAO.getAnswersByQuizId(quiz_ID);
        request.setAttribute("questionId", question_id);
        request.setAttribute("quiz", quiz);
        request.setAttribute("answerList", answerList);
        request.getRequestDispatcher("EditQuiz.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AnswerDAO answerDAO = new AnswerDAO();
        QuizDAO quizDAO = new QuizDAO();
        
        //String question_id = request.getParameter("question_Id"); // GET PARAM form jsp
        //String question_id = "5";
        
        String quiz_Id = request.getParameter("quiz_Id");
        int quiz_id = Integer.parseInt(quiz_Id);
        String description = request.getParameter("description");
        if(description == null){
            description = "null";
        }
        String type = request.getParameter("quizType");
        String content = request.getParameter("content"); // CONTENT of quiz
        String[] isExist = request.getParameterValues("exist"); // LIST Exist
        String[] isDelete = request.getParameterValues("delete"); // LIST Exist
        String[] answerArray = request.getParameterValues("answer"); // LIST ANSWER
        String[] isCorrectArray = request.getParameterValues("isCorrect"); //Is correct
        quizDAO.editQuiz(quiz_Id, type, content, description, isCorrectArray, isDelete);
        for (int i = 0; i < isExist.length; i++) {
            if(isExist[i].equals("none") && isDelete[i].equals("false")){
                if(answerArray[i] != ""){
                    if(isCorrectArray[i].equals("correct")){
                        answerDAO.addAnswer(quiz_id, "1", answerArray[i]);    
                    }else{
                        answerDAO.addAnswer(quiz_id, "0", answerArray[i]);
                    }
                }
            }else if(!isExist[i].equals("none") && isDelete[i].equals("false")){
                answerDAO.editAnswer(isExist[i], isCorrectArray[i], answerArray[i]);
            }else if(!isExist[i].equals("none") && isDelete[i].equals("true")){
                answerDAO.removeAnswer(isExist[i]);
            }
        }
        QuestionDAO questionDAO = new QuestionDAO();
        SubjectDAO subjectDAO = new SubjectDAO();

        int questionId = Integer.parseInt(request.getParameter("questionId"));
        Question question = questionDAO.getQuestionById(questionId);
        Subject subject = subjectDAO.getSubjectById(question.getSubjectId());

        List<Quiz> quizzes = quizDAO.getQuizzesByQuestionId(questionId);

        for (Quiz quiz : quizzes) {
            List<Answer> answers = answerDAO.getAnswersByQuizId(quiz.getQuizId());
            request.setAttribute("answers" + quiz.getQuizId(), answers);
        }

        request.setAttribute("subject", subject);
        request.setAttribute("question", question);
        request.setAttribute("quizzes", quizzes);
        request.getRequestDispatcher("ExpertQuizList.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
