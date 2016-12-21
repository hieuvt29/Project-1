/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DienthoaiDAO;
import dao.MayanhDAO;
import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dienthoai;
import model.Laptop;
import model.Mayanh;

/**
 *
 * @author admin
 */
@WebServlet(name = "ManagerProductServlet", urlPatterns = {"/ManagerProductServlet"})
public class ManagerProductServlet extends HttpServlet {

    ProductDAO productDAO = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String product = request.getParameter("product");
        String command = request.getParameter("command");
        String jsp = "", error = "";

        try {
            if (command.equals("insert")) {
                if (product.equals("mobile")) {
                    productDAO = new DienthoaiDAO();
                    String product_id = request.getParameter("product_id");
                    String category_id = request.getParameter("category_id");
                    String supply_id = request.getParameter("supply_id");
                    String name = request.getParameter("name");
                    String price = request.getParameter("price");
                    String resolution = request.getParameter("resolution");
                    String operaSystem = request.getParameter("operaSystem");
                    String cameraAfter = request.getParameter("cameraAfter");
                    String cameraFront = request.getParameter("cameraFront");
                    String cpu = request.getParameter("cpu");
                    String ram = request.getParameter("ram");
                    String memory = request.getParameter("memory");
                    String memoryCard = request.getParameter("memoryCard");
                    String simCard = request.getParameter("simCard");
                    String connection = request.getParameter("connection");
                    String battery = request.getParameter("battery");
                    String design = request.getParameter("design");
                    String extraInfo = request.getParameter("extraInfo");
                    String discount = request.getParameter("discount");
                    
                    if(product_id.equals("") || category_id.equals("") || supply_id.equals("") || name.equals("") ||
                            price.equals("") || resolution.equals("") || operaSystem.equals("") || cameraAfter.equals("") ||
                            cameraFront.equals("") || cpu.equals("") || ram.equals("") || memory.equals("") || memoryCard.equals("") ||
                            simCard.equals("") || connection.equals("") || battery.equals("") || design.equals("") ||
                            extraInfo.equals("") || discount.equals("")) {
                        error = "Please enter full information!";
                        request.setAttribute("error", error);
                    }
                    
                    if(error.length() == 0) {
                        productDAO.insertProduct(new Dienthoai(Integer.parseInt(supply_id), resolution, operaSystem,
                                Integer.parseInt(cameraAfter), Integer.parseInt(cameraFront), cpu, Integer.parseInt(ram),
                                Integer.parseInt(memory), memoryCard, simCard, connection, Integer.parseInt(battery),
                                design, extraInfo, Integer.parseInt(category_id), product_id, name,
                                Double.parseDouble(price), Double.parseDouble(discount)));
                        jsp = "/admin/supplyMobileAndProduct.jsp";
                    } else {
                        jsp = "/WebBanHang/admin/insertProduct.jsp";
                    }
                } else if(product.equals("laptop")) {
                    productDAO = new DienthoaiDAO();
                    String product_id = request.getParameter("product_id");
                    String category_id = request.getParameter("category_id");
                    String supply_id = request.getParameter("supply_id");
                    String name = request.getParameter("name");
                    String price = request.getParameter("price");
                    String cpu = request.getParameter("cpu");
                    String ram = request.getParameter("ram");
                    String hardDisk = request.getParameter("hardDisk");
                    String screen = request.getParameter("screen");
                    String touch = request.getParameter("touch");
                    String graphic = request.getParameter("graphic");
                    String opticalDisk = request.getParameter("opticalDisk");
                    String webcam = request.getParameter("webcam");
                    String material = request.getParameter("material");
                    String gates = request.getParameter("gates");
                    String connection = request.getParameter("connection");
                    String battery = request.getParameter("battery");
                    String weight = request.getParameter("weight");
                    String discount = request.getParameter("discount");
                    
                    if(product_id.equals("") || category_id.equals("") || supply_id.equals("") || name.equals("") ||
                            price.equals("") || cpu.equals("") || ram.equals("") || hardDisk.equals("") || screen.equals("") ||
                            touch.equals("") || graphic.equals("") || opticalDisk.equals("") || webcam.equals("") ||
                            material.equals("") || gates.equals("") || connection.equals("") || battery.equals("") ||
                            weight.equals("") || discount.equals("")) {
                        error = "Please enter full information!";
                        request.setAttribute("error", error);
                    }
                    
                    if(error.length() == 0) {
                        productDAO.insertProduct(new Laptop(Integer.parseInt(supply_id), cpu, ram, hardDisk, screen,
                            Boolean.parseBoolean(touch), graphic, opticalDisk, Double.parseDouble(webcam), material, gates,
                            connection, battery, Double.parseDouble(weight), Integer.parseInt(category_id), product_id,
                                name, Double.parseDouble(price), Double.parseDouble(discount)));
                        jsp = "/admin/supplyLaptopAndProduct.jsp";
                    } else {
                        jsp = "/WebBanHang/admin/insertProduct.jsp";
                    }
                } else if(product.equals("camera")) {
                    productDAO = new MayanhDAO();
                    String product_id = request.getParameter("product_id");
                    String category_id = request.getParameter("category_id");
                    String supply_id = request.getParameter("supply_id");
                    String name = request.getParameter("name");
                    String categorize = request.getParameter("categorize");
                    String sensor = request.getParameter("sensor");
                    String imageProcessor = request.getParameter("imageProcessor");
                    String lens = request.getParameter("lens");
                    String film = request.getParameter("film");
                    String shutterSpeed = request.getParameter("shutterSpeed");
                    String connection = request.getParameter("connection");
                    String screen = request.getParameter("screen");
                    String battery = request.getParameter("battery");
                    String memoryCard = request.getParameter("memoryCard");
                    String madeIn = request.getParameter("madeIn");
                    String warranty = request.getParameter("warranty");
                    String weight = request.getParameter("weight");
                    String price = request.getParameter("price");
                    String discount = request.getParameter("discount");
                    
                    if(product_id.equals("") || category_id.equals("") || supply_id.equals("") || name.equals("") ||
                            categorize.equals("") || sensor.equals("") || imageProcessor.equals("") || lens.equals("") ||
                            film.equals("") || shutterSpeed.equals("") || connection.equals("") || screen.equals("") ||
                            battery.equals("") || memoryCard.equals("") || madeIn.equals("") || warranty.equals("") ||
                            weight.equals("") || price.equals("") || discount.equals("")) {
                        error = "Please enter full information!";
                        request.setAttribute("error", error);
                    }
                    
                    if(error.length() == 0) {
                        productDAO.insertProduct(new Mayanh(Integer.parseInt(supply_id), categorize, sensor,
                                imageProcessor, lens, film, shutterSpeed, connection, screen, battery, memoryCard,
                                madeIn, warranty, Double.parseDouble(weight), Integer.parseInt(category_id), product_id,
                                name, Double.parseDouble(price), Double.parseDouble(discount)));
                        jsp = "/admin/supplyCameraAndProduct.jsp";
                    } else {
                        jsp = "/WebBanHang/admin/insertProduct.jsp";
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

}
