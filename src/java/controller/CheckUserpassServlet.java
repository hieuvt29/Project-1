/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "CheckUserpassServlet", urlPatterns = {"/CheckUserpassServlet"})
public class CheckUserpassServlet extends HttpServlet {

   
    UserDAO userDAO = new UserDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pass = request.getParameter("password");
        
        if(pass.length() < 8){
            response.getWriter().write("<font color='red'>less than 8 characters</font>");
        }else{
            response.getWriter().write("<img src=\"img/available.png\" />");
        }
        
    }

  

}
