/*
 * MakeQuizController.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package controller;

import dao.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.User;

public class MakeQuizController extends HttpServlet {

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

            String question = request.getParameter("question");
            String ans_1 = request.getParameter("ans_1");
            String ans_2 = request.getParameter("ans_2");
            String ans_3 = request.getParameter("ans_3");
            String ans_4 = request.getParameter("ans_4");
            String true_ans = request.getParameter("true_ans") == null ? "" : request.getParameter("true_ans");

            if (question != null && ans_1 != null && ans_2 != null && ans_3 != null && ans_4 != null && true_ans != null) {

                // check if user forget to input any field
                if (question.isEmpty() || ans_1.isEmpty() || ans_2.isEmpty() || ans_3.isEmpty() || ans_4.isEmpty() || true_ans.isEmpty()) {
                    
                    if (question.isEmpty()) {
                        request.setAttribute("noti", "Question must not be empty");
                    } else if (ans_1.isEmpty()) {
                        request.setAttribute("noti", "Please input answer number 1");
                    } else if (ans_2.isEmpty()) {
                        request.setAttribute("noti", "Please input answer number 2");
                    } else if (ans_3.isEmpty()) {
                        request.setAttribute("noti", "Please input answer number 3");
                    } else if (ans_4.isEmpty()) {
                        request.setAttribute("noti", "Please input answer number 4");
                    }else{
                        request.setAttribute("noti", "Please choose one correct answer");
                    }

                    request.setAttribute("question", question);
                    request.setAttribute("ans_1", ans_1);
                    request.setAttribute("ans_2", ans_2);
                    request.setAttribute("ans_3", ans_3);
                    request.setAttribute("ans_4", ans_4);
                    request.setAttribute("true_ans", true_ans);

                    request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
                } else {
                    QuestionDAO dao = new QuestionDAO();
                    User u = (User) request.getSession(true).getAttribute("user");
                    // add question to database
                    dao.addNewQuestion(new Question(question, null, ans_1, ans_2, ans_3, ans_4, true_ans, u.getUser()));

                    // go back to home   
                    request.setAttribute("warning", "Question is created successful!");
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            } else {

                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            }

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
