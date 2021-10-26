/*
 * RegisterController.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class RegisterController extends HttpServlet {

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

            String user = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            String role = request.getParameter("role");
            String email = request.getParameter("email");
            
            User registerUser = new User(user, pwd, email, role.equals("1"));

            if (user != null && pwd != null && email != null) {
                // check if user forget to input any field
                if (user == "" || pwd == "" || email == "") {
                    request.setAttribute("noti", "You must input all fields");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }

                UserDAO dao = new UserDAO();
                // check if username already exist
                if (dao.getUserByUserName(user) != null) {
                    request.setAttribute("registerUser", registerUser);
                    request.setAttribute("noti", "Username already exist");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    // add new user to database
                    dao.addNewUser(new User(user, dao.HashMD5(pwd), email, !role.equals("0")));
                    request.setAttribute("noti", "Register successfully !");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
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
