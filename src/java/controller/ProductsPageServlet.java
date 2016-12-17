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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
        RequestDispatcher jsp = request.getRequestDispatcher("/products.jsp");
        String product = null,
                supplier = null;
        ProductDAO productDAO = null;

        product = request.getParameter("product");
        supplier = request.getParameter("supplier");

        if (product.equals("Dienthoai")) {
            productDAO = new DienthoaiDAO();
        } else if (product.equals("Laptop")) {
            productDAO = new LaptopDAO();
        } else if (product.equals("Mayanh")) {
            productDAO = new MayanhDAO();
        } else {
            //redirect response
        }

        ArrayList<Product> productList = productDAO.getProducts(supplier);
        request.setAttribute("productList", productList);
        jsp.forward(request, response);
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

        ArrayList<Product> productList = productDAO.getProducts(supplier);
        for (Product pd : productList) {
            System.out.println(pd.getProduct_name());
        }
    }
}
