/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DienthoaiDAO;
import dao.LaptopDAO;
import dao.MayanhDAO;
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
import model.Dienthoai;
import model.Laptop;
import model.Mayanh;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "/SingleServlet", urlPatterns = {"/SingleServlet"})
public class SingleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher jsp = request.getRequestDispatcher("/single.jsp");
        String product_id = request.getParameter("product_id");
        String s1 = product_id.substring(0, 2);
        
        try {
            if (s1.equals("dt")) {
                DienthoaiDAO dienthoaiDAO = new DienthoaiDAO();
                Dienthoai dienthoai = new Dienthoai();
                dienthoai = dienthoaiDAO.getProduct(product_id);
                
                ArrayList<Product> listManyProductDienthoai = new ArrayList<>();
                if(dienthoai.getCategory_id() == 1) {
                    listManyProductDienthoai = dienthoaiDAO.getProducts("%", "%", 5);
                } else if(dienthoai.getCategory_id() == 2) {
                    listManyProductDienthoai = dienthoaiDAO.getProducts("%", "%", 5);
                } else if(dienthoai.getCategory_id() == 3) {
                    listManyProductDienthoai = dienthoaiDAO.getProducts("%", "%", 5);
                }
                request.setAttribute("product", dienthoai);
                request.setAttribute("listManyProduct", listManyProductDienthoai);
            } else if(s1.equals("mt")) {
                LaptopDAO laptopDAO = new LaptopDAO();
                Laptop laptop = new Laptop();
                laptop = laptopDAO.getProduct(product_id);
                
                ArrayList<Product> listManyProductLaptop = new ArrayList<>();
                
                if(laptop.getCategory_id() == 1) {
                    listManyProductLaptop = laptopDAO.getProducts("%", "%", 5);
                } else if(laptop.getCategory_id() == 2) {
                    listManyProductLaptop = laptopDAO.getProducts("%", "%", 5);
                } else if(laptop.getCategory_id() == 3) {
                    listManyProductLaptop = laptopDAO.getProducts("%", "%", 5);
                }
                request.setAttribute("product", laptop);
                request.setAttribute("listManyProduct", listManyProductLaptop);
            } else if(s1.equals("ma")) {
                MayanhDAO mayanhDAO = new MayanhDAO();
                Mayanh mayanh = new Mayanh();
                mayanh = mayanhDAO.getProduct(product_id);
                
                ArrayList<Product> listManyProductMayanh = new ArrayList<>();
                
                if(mayanh.getCategory_id() == 1) {
                    listManyProductMayanh = mayanhDAO.getProducts("%", "%", 5);
                } else if(mayanh.getCategory_id() == 2) {
                    listManyProductMayanh = mayanhDAO.getProducts("%", "%", 5);
                } else if(mayanh.getCategory_id() == 3) {
                    listManyProductMayanh = mayanhDAO.getProducts("%", "%", 5);
                }
                request.setAttribute("product", mayanh);
                request.setAttribute("listManyProduct", listManyProductMayanh);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SingleServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SingleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
