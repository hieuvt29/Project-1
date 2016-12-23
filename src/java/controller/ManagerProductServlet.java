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
        String product = request.getParameter("product");
        String command = request.getParameter("command");
        String product_id = request.getParameter("product_id");
        String category_id = null, product_price = null, product_discount = null;
        category_id = request.getParameter("category_id");
        product_price = request.getParameter("product_price");
        product_discount = request.getParameter("product_discount");
        String error = null, url = null;

        try {
            if (command.equals("update")) {
                if (category_id.equals("") && product_price.equals("") && product_discount.equals("")) {
                    error = "Please enter information update!";
                    request.setAttribute("error", error);
                }
                if (error == null) {
                    if (product.equals("mobile")) {
                        productDAO = new DienthoaiDAO();
                        productDAO.updateProduct(new Dienthoai(product_id, Integer.parseInt(category_id),
                                Double.parseDouble(product_price), Double.parseDouble(product_discount)));
                        url = "admin/mobile.jsp";
                    } else if (product.equals("laptop")) {
                        productDAO = new LaptopDAO();
                        productDAO.updateProduct(new Laptop(product_id, Integer.parseInt(category_id),
                                Double.parseDouble(product_price), Double.parseDouble(product_discount)));
                        url = "admin/laptop.jsp";
                    } else if (product.equals("camera")) {
                        productDAO = new MayanhDAO();
                        productDAO.updateProduct(new Mayanh(product_id, Integer.parseInt(category_id),
                                Double.parseDouble(product_price), Double.parseDouble(product_discount)));
                        url = "admin/camera.jsp";
                    }
                } else {
                    url = "admin/updateProduct.jsp";
                }
            } else if (command.equals("remove")) {
                if (product.equals("mobile")) {
                    productDAO = new DienthoaiDAO();
                    productDAO.removeProduct(product_id);
                    url = "admin/mobile.jsp";
                } else if (product.equals("laptop")) {
                    productDAO = new LaptopDAO();
                    productDAO.removeProduct(product_id);
                    url = "admin/laptop.jsp";
                } else if (product.equals("camera")) {
                    productDAO = new MayanhDAO();
                    productDAO.removeProduct(product_id);
                    url = "admin/camera.jsp";
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String product = request.getParameter("product");
        String command = request.getParameter("command");
        String url = null, error = null;

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

                    if (category_id.equals("") || supply_id.equals("") || name.equals("") || price.equals("")
                            || resolution.equals("") || operaSystem.equals("") || cameraAfter.equals("")
                            || cameraFront.equals("") || cpu.equals("") || ram.equals("") || memory.equals("") || memoryCard.equals("")
                            || simCard.equals("") || connection.equals("") || battery.equals("") || design.equals("")
                            || extraInfo.equals("") || discount.equals("")) {
                        error = "Please enter full information!";
                        request.setAttribute("error", error);
                    }

                    if (error == null) {
                        productDAO.insertProduct(new Dienthoai(Integer.parseInt(supply_id), resolution, operaSystem,
                                Integer.parseInt(cameraAfter), Integer.parseInt(cameraFront), cpu, Integer.parseInt(ram),
                                Integer.parseInt(memory), memoryCard, simCard, connection, Integer.parseInt(battery),
                                design, extraInfo, product_id, Integer.parseInt(category_id), name,
                                Double.parseDouble(price), Double.parseDouble(discount)));
                        url = "admin/mobile.jsp";
                    } else {
                        url = "admin/insertProduct.jsp";
                    }
                } else if (product.equals("laptop")) {
                    productDAO = new LaptopDAO();
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

                    if (category_id.equals("") || supply_id.equals("") || name.equals("")
                            || price.equals("") || cpu.equals("") || ram.equals("") || hardDisk.equals("") || screen.equals("")
                            || touch.equals("") || graphic.equals("") || opticalDisk.equals("") || webcam.equals("")
                            || material.equals("") || gates.equals("") || connection.equals("") || battery.equals("")
                            || weight.equals("") || discount.equals("")) {
                        error = "Please enter full information!";
                        request.setAttribute("error", error);
                    }

                    if (error == null) {
                        productDAO.insertProduct(new Laptop(Integer.parseInt(supply_id), cpu, ram, hardDisk, screen,
                                touch, graphic, opticalDisk, Double.parseDouble(webcam), material, gates,
                                connection, battery, Double.parseDouble(weight), product_id, Integer.parseInt(category_id),
                                name, Double.parseDouble(price), Double.parseDouble(discount)));
                        url = "admin/laptop.jsp";
                    } else {
                        url = "admin/insertProduct.jsp";
                    }
                } else if (product.equals("camera")) {
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

                    if (category_id.equals("") || supply_id.equals("") || name.equals("")
                            || categorize.equals("") || sensor.equals("") || imageProcessor.equals("") || lens.equals("")
                            || film.equals("") || shutterSpeed.equals("") || connection.equals("") || screen.equals("")
                            || battery.equals("") || memoryCard.equals("") || madeIn.equals("") || warranty.equals("")
                            || weight.equals("") || price.equals("") || discount.equals("")) {
                        error = "Please enter full information!";
                        request.setAttribute("error", error);
                    }

                    if (error == null) {
                        productDAO.insertProduct(new Mayanh(Integer.parseInt(supply_id), categorize, sensor,
                                imageProcessor, lens, film, shutterSpeed, connection, screen, battery, memoryCard,
                                madeIn, warranty, Double.parseDouble(weight), product_id, Integer.parseInt(category_id),
                                name, Double.parseDouble(price), Double.parseDouble(discount)));
                        url = "admin/camera.jsp";
                    } else {
                        url = "admin/insertProduct.jsp";
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new MayanhDAO();
//        productDAO.insertProduct(new Dienthoai(2, "product_resolution", "product_os", 0, 0, "product_cpu", 0, 0, "product_mem_card", "product_sim_card", "product_connection", 0, "product_design", "product_extra_info", "product_id", 2, "product_name", 0, 0));
//        productDAO.insertProduct(new Laptop(3, "product_CPU", "product_RAM", "product_hard_disk", "product_screen", "k", "product_graphic", "product_optical_disk", 0, "product_material", "product_gates", "product_connection", "product_battery", 0, "product_id", 1, "product_name", 0, 0));
//        System.out.println(productDAO.removeProduct(new Mayanh("ma0028")));
        productDAO.updateProduct(new Mayanh("ma0026", 3, 41.5, 5));
//        productDAO.insertProduct(new Mayanh(2, "product_categorize", "product_sensor", "product_image_processor", "product_lens", "product_film", "product_shutter_speed", "product_connection", "product_screen", "product_battery", "product_mem_card", "product_made_in", "product_warranty", 0, "XX", 1, "product_name", 0, 0));
//        productDAO.removeProduct("XX");
    }
}
