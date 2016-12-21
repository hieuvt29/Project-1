/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomSearchDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.Product;

/**
 *
 * @author user
 */
@WebServlet(name = "CustomSearchServlet", urlPatterns = {"/CustomSearchServlet"})
public class CustomSearchServlet extends HttpServlet {

    CustomSearchDAO customSearchDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        customSearchDAO = new CustomSearchDAO();
        
        String product_name, product, supplier, category,
                url;
        product_name = request.getParameter("product_name");
//        product = request.getParameter("product");
//        supplier = request.getParameter("supplier");
//        category = request.getParameter("category");

        try {
            ArrayList<Product> resList = customSearchDAO.searchProducts(product_name);
            if(resList != null){
                request.setAttribute("productList", resList);
                url = "products.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }else{
                response.sendRedirect(request.getHeader("referer"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
