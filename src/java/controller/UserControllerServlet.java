/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.User;
import utils.MD5;
import utils.Mailer;

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

        } else if (command != null && command.equals("update")) {
            User oldUser = (User) session.getAttribute("user");
            User newUser = new User();
            newUser.setUser_id(oldUser.getUser_id());
            newUser.setUser_name(oldUser.getUser_name());
            newUser.setUser_email(request.getParameter("user_email"));
            newUser.setUser_phonenumber(request.getParameter("user_phonenumber"));

            String pass = request.getParameter("user_pass");
            if (pass.length() >= 8) {
                newUser.setUser_password(MD5.encryption(pass));
            }else{
                newUser.setUser_password(oldUser.getUser_password());
            }
            try {
                user = userDAO.update(newUser);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (user != null) {
            if (user.isUser_role()) {
                session.setAttribute("admin", user);
                session.setMaxInactiveInterval(10 * 60);
                url = "admin/dashboard.jsp";
            } else {
                Mailer.send(user.getUser_email(), "Register successfully!", "Thank you!");
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(10 * 60);
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
            BillDAO billDAO = new BillDAO();
            try {
                ArrayList<Bill> userBills = billDAO.getUserBills(user.getUser_id());
                if(userBills ==  null){
                    url = "login.jsp";
                }
                request.setAttribute("userBills", userBills);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

    }
}
