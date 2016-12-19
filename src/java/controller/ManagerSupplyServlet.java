/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SupplierDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Supplier;

/**
 *
 * @author admin
 */
@WebServlet(name = "ManagerSupplyServlet", urlPatterns = {"/ManagerSupplyServlet"})
public class ManagerSupplyServlet extends HttpServlet {

    SupplierDAO supplierDAO = new SupplierDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String supplyId = request.getParameter("supplyId");
        String supplyName = request.getParameter("supplyName");
        
        String url = "", error= "";
        if(supplyName.equals("")) {
            error = "Please enter supply name!";
            request.setAttribute("error", error);
        }
        
        try {
            if(error.length() == 0) {
                if(command.equals("insert")) {
                    supplierDAO.insertSupply(new Supplier(Integer.parseInt(supplyId), supplyName));
                    url = "/admin/supplyMobileManager.jsp";
                }
            } else {
                url = "/admin/insertSupply.jsp";
            }
        } catch(Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
