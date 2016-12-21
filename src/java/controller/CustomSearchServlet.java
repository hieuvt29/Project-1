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
import java.util.Iterator;
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
        int price;
        product_name = request.getParameter("product_name");
        price = Integer.parseInt(request.getParameter("price"));

        try {
            ArrayList<Product> resList = customSearchDAO.searchProducts(product_name);
            //process price searching
            Iterator<Product> it = resList.iterator();
            while (it.hasNext()) {
                Product pd = it.next();
                double product_price = pd.getProduct_price()*(100 - pd.getProduct_discount())/100;
                if (price == 1 && product_price > 8.0) {
                    it.remove();
                }else if(price == 2 && (product_price <= 8.0 || product_price > 10.0)){
                    it.remove();
                }else if(price == 3 && (product_price <= 10.0 || product_price > 12.0)){
                    it.remove();
                }else if(price == 4 && product_price <= 12.0){
                    it.remove();
                }
            }
            if (resList != null) {
                request.setAttribute("productList", resList);
                url = "products.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
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
