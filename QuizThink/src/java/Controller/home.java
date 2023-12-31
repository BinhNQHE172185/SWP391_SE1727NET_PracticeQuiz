/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.*;
import Model.*;
import Model.Expert;
import Model.Slider;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author QUYBINH
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

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

        Cookie[] ck = request.getCookies();
        String username = null;
        String password = null;
        ExpertDAO ed = new ExpertDAO();
        AccountDAO ad = new AccountDAO();
        MarketerDAO mkd = new MarketerDAO();
        
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
        
        if (username != null && password != null) {
            Account accCookie = ad.getAccount(username, password);
            Expert expCookie = ed.getExpert(username, password);
            Marketer mktCookie = mkd.getMarketer(username, password);
            if (accCookie != null) {
                request.getSession().setAttribute("currUser", accCookie);
            }
            if (expCookie != null) {
                request.getSession().setAttribute("currExpert", expCookie);
            }
            if(mktCookie != null){
                request.getSession().setAttribute("currMarketer", mktCookie);
            }
        }
        SliderDAO sliderDAO = new SliderDAO();
        List<Slider> sliders = sliderDAO.listSliders();
        request.setAttribute("sliders", sliders);
        SubjectDAO subjectDAO = new SubjectDAO();
        List<Subject> recentSubjects = subjectDAO.getRecentSubject();
        request.setAttribute("recentSubjects", recentSubjects);

        request.getRequestDispatcher("home.jsp").forward(request, response);
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
