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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.MD5;

/**
 *
 * @author user
 */
@WebServlet(name = "UserControllerServlet", urlPatterns = {"/UserControllerServlet"})
public class UserControllerServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = null;
        String command = request.getParameter("command");
        HttpSession session = request.getSession();
        String url = "index.jsp";
        //Register Handler
        if (command.equals("register")) {
            String user_name = request.getParameter("user_name").trim(),
                    user_email = request.getParameter("user_email").trim(),
                    user_password = MD5.encryption(request.getParameter("user_pass").trim()),
                    user_phonenumber = request.getParameter("user_phonenumber").trim();

            user = new User(user_name, user_email, user_password, user_phonenumber, false);
            try {
                userDAO.addUser(user);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Login Handler
        } else if (command.equals("login")) {
            String user_email = request.getParameter("user_email").trim(),
                    user_password = MD5.encryption(request.getParameter("user_pass").trim());
            try {
                user = userDAO.login(user_email, user_password);
                if (user == null) {
                    url = "login.jsp";
                    request.setAttribute("error", "Email or Password is invalid!");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (user != null) {
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(10 * 60);
            if (user.isUser_role()) {
                url = "admin/dashboard.jsp";
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String url = null;

        if (command != null && command.equals("logout")) {
            //Logout Handler
            session.invalidate();

            url = "index.jsp";

        } else if (command != null && command.equals("profile")) {
            //Profile Handler
            url = "profile.jsp";

        } else if (command != null && command.equals("gotoDashboard") && user != null && user.isUser_role()) {
            // Dashboard redirect
            url = "admin/dashboard.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

    }
}
