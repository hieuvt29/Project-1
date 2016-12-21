/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DienthoaiDAO;
import dao.LaptopDAO;
import dao.MayanhDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "/ProductsPageServlet", urlPatterns = {"/ProductsPageServlet"})
public class ProductsPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String product = null,
                supplier = null,
                url = "/products.jsp";
        ProductDAO productDAO = null;

        product = request.getParameter("product");
        supplier = request.getParameter("supplier");
        
        if(product == null|| supplier == null){
            response.sendRedirect(request.getHeader("referer"));
        }else if (product.equals("Dienthoai")) {
            productDAO = new DienthoaiDAO();
        } else if (product.equals("Laptop")) {
            productDAO = new LaptopDAO();
        } else if (product.equals("Mayanh")) {
            productDAO = new MayanhDAO();
        } else {
            //redirect response
        }

        ArrayList<Product> productList = productDAO.getProducts(supplier, "%", 1000);
        request.setAttribute("productList", productList);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public static void main(String[] args) {
        String product = "Dienthoai",
                supplier = "*";
        ProductDAO productDAO = null;

        if (product.equals("Dienthoai")) {
            productDAO = new DienthoaiDAO();
        } else if (product.equals("Laptop")) {
            productDAO = new LaptopDAO();
        } else if (product.equals("Mayanh")) {
            productDAO = new MayanhDAO();
        } else {
            //redirect response
        }

        ArrayList<Product> productList = productDAO.getProducts(supplier, "%", 1000);
        
        for (Product pd : productList) {
            System.out.println(pd.getProduct_id() +": "+ pd.getProduct_name());
        }
    }
}
