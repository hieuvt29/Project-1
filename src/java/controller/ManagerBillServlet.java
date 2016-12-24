/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;

/**
 *
 * @author user
 */
@WebServlet(name = "ManagerBillServlet", urlPatterns = {"/ManagerBillServlet"})
public class ManagerBillServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BillDAO billDAO = new BillDAO();
        String url = "admin/billManager.jsp";
        
        String command = request.getParameter("command");
        String id = request.getParameter("bill_id");
        int bill_id;
        
        if(command != null && command.equals("process") && id != null){
            //just update receipt_date attribute
            bill_id = Integer.parseInt(id);
            Bill bill = new Bill();
            bill.setBill_id(bill_id);
            bill.setBill_receipt_date(new Date(System.currentTimeMillis()));
            billDAO.updateBill(bill);
        }else if(command != null && command.equals("cancel") && id != null){
            bill_id = Integer.parseInt(id);
            Bill bill = new Bill();
            bill.setBill_id(bill_id);
            bill.setBill_receipt_date(new Date(0));
            billDAO.updateBill(bill);
        }
        
        try {
            ArrayList<Bill> bills = billDAO.getBills();
            request.setAttribute("bills", bills);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
