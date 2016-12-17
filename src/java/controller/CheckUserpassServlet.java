/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

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
        //init json object
        response.setContentType("application/json;charset=utf-8");
        JSONObject resJson = new JSONObject();
        PrintWriter pw = response.getWriter();

        //retrieve data for json
        boolean error = false;
        String message = null;

        if (pass.length() < 8) {
            error = true;
            message = "<font color='red'>less than 8 characters</font>";
        } else {
            error = false;
            message = "<img src=\"img/available.png\" />";
        }

        try {
            //write data and close
            resJson.put("error", error);
            resJson.put("message", message);
            pw.print(resJson.toString());

        } catch (JSONException ex) {
            Logger.getLogger(CheckUsernameServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

}
