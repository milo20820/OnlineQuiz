/*
 * LoginController.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            request.getSession().invalidate();

            String user = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            // check if user input both username and password
            if (user != null && pwd != null) {
                UserDAO dao = new UserDAO();
                // check if user, password are correct
                User u = dao.getUserByUserName(user);
                if (u != null && u.getPwd().equals(dao.HashMD5(pwd))) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", u);
                    // check user is teacher or normal user
                    if (!u.isRole()) {
                        // user is teacher              
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    } else {
                        // user is normal user
                        request.setAttribute("role", "Normal User");
                        //direct to home.jsp page
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("noti", "wrong username or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
