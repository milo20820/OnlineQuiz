/*
 * ManageQuizController.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package controller;

import dao.QuestionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.User;
import utils.HTMLHelper;

public class ManageQuizController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try {
            User u = (User) request.getSession(true).getAttribute("user");

            QuestionDAO dao = new QuestionDAO();
            String strItemOnPage = getServletContext().getInitParameter("ItemOnPage");
            int itemOnPage = Integer.parseInt(strItemOnPage);

            int currentPage;

            try {
                currentPage = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                currentPage = 1;
            }

            int totalRecord = dao.countQuest(u.getUser());

            int totalPage = (totalRecord / itemOnPage) + (totalRecord % itemOnPage != 0 ? 1 : 0);

            if (currentPage > totalPage) {
                currentPage = totalPage;
            }
            if (currentPage <= 0) {
                currentPage = 1;
            }

            int start = itemOnPage * (currentPage - 1) + 1;
            int end = start + itemOnPage - 1;

            List<Question> list = dao.getPaggingQuestionsByUser(start, end, u.getUser());

            String pagination = HTMLHelper.pagger(currentPage, totalPage, "manageQuiz");

            request.setAttribute("items", list);
            request.setAttribute("total", totalRecord);
            request.setAttribute("pagination", pagination);
            
            request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
