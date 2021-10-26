/*
 * TakeQuizController.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package controller;

import dao.QuestionDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;
import model.User;


public class TakeQuizController extends HttpServlet {

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
        try {

            QuestionDAO dao = new QuestionDAO();
            HttpSession session = request.getSession(true);

            // user enter new quiz
            if (request.getParameter("number") != null) {
                // Get nnumber of questions
                int number = Integer.parseInt(request.getParameter("number"));
                
                int totalQuestion = dao.countQuest();

                if (number > totalQuestion || number < 0) {
                    request.setAttribute("notice", "Please input valid number question");
                    request.setAttribute("total", dao.countQuest());
                    request.getRequestDispatcher("numberQuiz.jsp").forward(request, response);
                }

                List<Question> all = dao.getAllQuestions();
                List<Question> questions = new ArrayList<>();
                Random r = new Random();

                // Random questions
                if (number > all.size() - 1) {
                    questions = all;
                } else {
                    for (int i = 0; i < number; i++) {
                        int j = r.nextInt(all.size());
                        questions.add(all.get(j));
                        all.remove(j);
                    }
                }
                // save questions to session
                session.setAttribute("quiz", questions);
                request.setAttribute("n", 0);

                // set time for taking quiz
                int time = questions.size() * 60;
                request.setAttribute("time", time);
                // time to end quiz
                long tt = new Date().getTime() + (time * 1000);
                session.setAttribute("timeEnd", tt);
                request.setAttribute("q", questions.get(0));
                request.setAttribute("total", dao.countQuest());
                request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
                
             // next question  
            } else if (session.getAttribute("quiz") != null) {
                List<Question> questions = (List<Question>) session.getAttribute("quiz");
                User u = (User) session.getAttribute("user");

                // check if time out
                long d = (long) session.getAttribute("timeEnd");
                if (request.getParameter("timeout") != null || new Date().getTime() >= d) {
                    int score = 0;
                    for (Question q : questions) {
                        score += q.getScore();
                    }
                    dao.saveResult(u.getUser(), (float) score / (float) questions.size(), questions.size());
                    request.setAttribute("finish", (float) score / (float) questions.size());
                    request.setAttribute("total", dao.countQuest());
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                } else {
                    int n = Integer.parseInt(request.getParameter("n"));
                    String true_ans = request.getParameter("true_ans");
                    if (true_ans == null) {
                        true_ans = "";
                    }
                    // check answer true or false
                    if (true_ans.equals(questions.get(n).getTrue_ans())) {
                        questions.get(n).setScore(1);
                    } else {
                        questions.get(n).setScore(0);
                    }

                    // user finish quiz
                    if (n == questions.size() - 1) {
                        int score = 0;
                        for (Question q : questions) {
                            score += q.getScore();
                        }
                        dao.saveResult(u.getUser(), (float) score / (float) questions.size(), questions.size());
                        request.setAttribute("finish", (float) score / (float) questions.size());
                        request.setAttribute("total", dao.countQuest());
                        request.getRequestDispatcher("result.jsp").forward(request, response);
                    } else {
                        String timee = request.getParameter("timee");
                        request.setAttribute("time", timee);
                        request.setAttribute("n", n + 1);
                        request.setAttribute("total", dao.countQuest());
                        request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
                    }
                }

            } else {
                response.sendRedirect("numberQuiz.jsp");
            }
        } catch (Exception ex) {
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
