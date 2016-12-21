/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SupplierDAO;
import java.io.IOException;
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
        String table = request.getParameter("table");
        String supplyId = request.getParameter("supplyId");
        String supplyName = request.getParameter("supplyName");
        
        String url = null , error = null ;
        if(supplyId.equals("") || supplyName.equals("") || table == null) {
            error = "Please enter supply id or supply name!";
            request.setAttribute("error", error);
        }
        
        try {
            if(error == null) {
                if(command.equals("insert")) {
                    if(table.equals("supplier_dienthoai")) {
                        supplierDAO.insertSupply(new Supplier(Integer.parseInt(supplyId), supplyName), table);
                        url = "admin/supplyMobileAndProduct.jsp";
                    } else if(table.equals("supplier_laptop")) {
                        supplierDAO.insertSupply(new Supplier(Integer.parseInt(supplyId), supplyName), table);
                        url = "admin/supplyLaptopAndProduct.jsp";
                    } else if(table.equals("supplier_mayanh")) {
                        supplierDAO.insertSupply(new Supplier(Integer.parseInt(supplyId), supplyName), table);
                        url = "admin/supplyCameraAndProduct.jsp";
                    }
                }
            } else {
                url = "admin/insertSupply.jsp";
            }
        } catch(Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
    
    public static void main(String[] args) {
        String table = "supplier_dienthoai";
        SupplierDAO supplierDAO = new SupplierDAO();
        supplierDAO.insertSupply(new Supplier(8, "a"), table);
    }
}