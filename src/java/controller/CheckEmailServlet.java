/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "CheckEmailServlet", urlPatterns = {"/CheckEmailServlet"})
public class CheckEmailServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        if (email.indexOf("@") == -1) {
            response.getWriter().write("<font color='red'>Invalid Email!</font>");
        } else {
            try {
                if (userDAO.checkEmail(email)) {
                    response.getWriter().write("<img src=\"img/not-available.png\" />");
                } else {
                    response.getWriter().write("<img src=\"img/available.png\" />");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CheckEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
