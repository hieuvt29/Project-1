/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connector.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dienthoai;
import model.Product;

/**
 *
 * @author admin
 */
public class DienthoaiDAO extends ProductDAO {

    public ArrayList<Product> getProducts(String supplier, String category) {
        ArrayList<Product> listProduct = new ArrayList<>();
        Connection con;
        try {
            con = DBConnector.getConnection();
            String sql = null;
//            if (supplier.equals("*")) {
//                sql = "SELECT product_id FROM dienthoai";
//            } else {
//                sql = "SELECT product_id FROM dienthoai WHERE supplier_id = '" + supplier + "'";
//            }
            sql = "SELECT product_id FROM dienthoai WHERE supplier_id LIKE '" + supplier + "' AND category_id LIKE '" + category + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String product_id = rs.getString(1);
                Dienthoai lt = getDienthoai(product_id);
                listProduct.add(lt);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }

    public ArrayList<Dienthoai> getManyProduct(int category_id) {
        ArrayList<Dienthoai> list = new ArrayList<>();
        try {
            Connection con = DBConnector.getConnection();
            String sql = "SELECT * FROM dienthoai WHERE category_id = '" + category_id + "' ORDER BY RAND() LIMIT 6";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dienthoai dt = new Dienthoai();
                dt.setProduct_id(rs.getString("product_id"));
                dt.setProduct_name(rs.getString("product_name"));
                dt.setSupply_id(rs.getInt("supplier_id"));
                list.add(dt);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Dienthoai> getDienthoai() throws ClassNotFoundException, SQLException {
        ArrayList<Dienthoai> list = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM dienthoai";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Dienthoai res = new Dienthoai();
            res.setProduct_id(rs.getString("product_id"));
            res.setCategory_id(rs.getInt("category_id"));
            res.setSupply_id(rs.getInt("supplier_id"));
            res.setProduct_name(rs.getString("product_name"));
            res.setProduct_price(rs.getDouble("product_price"));
            res.setProduct_resolution(rs.getString("product_resolution"));
            res.setProduct_os(rs.getString("product_os"));
            res.setProduct_camera_after(rs.getInt("product_camera_after"));
            res.setProduct_camera_front(rs.getInt("product_camera_front"));
            res.setProduct_cpu(rs.getString("product_cpu"));
            res.setProduct_ram(rs.getInt("product_ram"));
            res.setProduct_memory(rs.getInt("product_memory"));
            res.setProduct_mem_card(rs.getString("product_mem_card"));
            res.setProduct_sim_card(rs.getString("product_sim_card"));
            res.setProduct_connection(rs.getString("product_connection"));
            res.setProduct_battery(rs.getInt("product_battery"));
            res.setProduct_design(rs.getString("product_design"));
            res.setProduct_extra_info(rs.getString("product_extra_info"));
            res.setProduct_discount(rs.getDouble("product_discount"));
            list.add(res);
        }
        con.close();
        return list;
    }

    public Dienthoai getDienthoai(String product_id) throws ClassNotFoundException, SQLException {
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM dienthoai WHERE product_id = '" + product_id + "'";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Dienthoai dt = new Dienthoai();
        while (rs.next()) {
            dt.setProduct_id(rs.getString("product_id"));
            dt.setCategory_id(rs.getInt("category_id"));
            dt.setSupply_id(rs.getInt("supplier_id"));
            dt.setProduct_name(rs.getString("product_name"));
            dt.setProduct_price(rs.getDouble("product_price"));
            dt.setProduct_resolution(rs.getString("product_resolution"));
            dt.setProduct_os(rs.getString("product_os"));
            dt.setProduct_camera_after(rs.getInt("product_camera_after"));
            dt.setProduct_camera_front(rs.getInt("product_camera_front"));
            dt.setProduct_cpu(rs.getString("product_cpu"));
            dt.setProduct_ram(rs.getInt("product_ram"));
            dt.setProduct_memory(rs.getInt("product_memory"));
            dt.setProduct_mem_card(rs.getString("product_mem_card"));
            dt.setProduct_sim_card(rs.getString("product_sim_card"));
            dt.setProduct_connection(rs.getString("product_connection"));
            dt.setProduct_battery(rs.getInt("product_battery"));
            dt.setProduct_design(rs.getString("product_design"));
            dt.setProduct_extra_info(rs.getString("product_extra_info"));
            dt.setProduct_discount(rs.getInt("product_discount"));
        }
        con.close();
        return dt;
    }

    public boolean insertProduct(Product product) {
        try {
            Connection con = DBConnector.getConnection();
            if (product instanceof Dienthoai) {
                String sql = "INSERT INTO dienthoai VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, product.getProduct_id());
                ps.setInt(2, product.getCategory_id());
                ps.setInt(3, ((Dienthoai) product).getSupply_id());
                ps.setString(4, product.getProduct_name());
                ps.setDouble(5, product.getProduct_price());
                ps.setString(6, ((Dienthoai) product).getProduct_resolution());
                ps.setString(7, ((Dienthoai) product).getProduct_os());
                ps.setInt(8, ((Dienthoai) product).getProduct_camera_after());
                ps.setInt(9, ((Dienthoai) product).getProduct_camera_front());
                ps.setString(10, ((Dienthoai) product).getProduct_cpu());
                ps.setInt(11, ((Dienthoai) product).getProduct_ram());
                ps.setInt(12, ((Dienthoai) product).getProduct_memory());
                ps.setString(13, ((Dienthoai) product).getProduct_mem_card());
                ps.setString(14, ((Dienthoai) product).getProduct_sim_card());
                ps.setString(15, ((Dienthoai) product).getProduct_connection());
                ps.setInt(16, ((Dienthoai) product).getProduct_battery());
                ps.setString(17, ((Dienthoai) product).getProduct_design());
                ps.setString(18, ((Dienthoai) product).getProduct_extra_info());
                ps.setDouble(19, product.getProduct_discount());
                return ps.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        try {
            Connection con = DBConnector.getConnection();
            if (product instanceof Dienthoai) {
                String sql = "UPDATE dienthoai SET category_id = ?, product_price = ?, product_discount = ? "
                        + "WHERE product_id = ?";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setInt(1, product.getCategory_id());
                ps.setDouble(2, product.getProduct_price());
                ps.setDouble(3, product.getProduct_discount());
                ps.setString(4, product.getProduct_id());
                return ps.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        try {
            Connection con = DBConnector.getConnection();
            if (product instanceof Dienthoai) {
                String sql = "DELETE FROM dienthoai WHERE product_id = ?";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, product.getProduct_id());
                return ps.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        DienthoaiDAO dtDAO = new DienthoaiDAO();
        Dienthoai dt = new Dienthoai();
        dt.setProduct_id("dt0029");
//        dt.setProduct_price(20);
//        dt.setProduct_discount(15);
//        for (Dienthoai dt : dtDAO.getManyProduct(2)) {
//            System.out.println(dt.getProduct_id());
//            System.out.println(dt.getCategory_id());
//            System.out.println(dt.getProduct_name());
//            System.out.println(dt.getProduct_cpu());
//            
//            System.out.println("---------------------------");
//        }

//        System.out.println(dtDAO.getDienthoai("dt0012").getProduct_name());
//        System.out.println(dtDAO.getDienthoai("dt0003").getProduct_os());
//        System.out.println(dtDAO.getDienthoai("dt0003").getCategory_id());
//        System.out.println(dtDAO.getDienthoai("dt0003").getProduct_sim_card());
//        System.out.println(dtDAO.getDienthoai("dt0003").getProduct_connection());
//            System.out.println(dt.getProduct_id());
//            System.out.println(dt.getProduct_name());
//            System.out.println(dt.getSupply_id());
//        }
//      dtDAO.updateProduct(new Dienthoai("dt0029", 2, 12, 6));
        dtDAO.removeProduct(dt);
    }
}
