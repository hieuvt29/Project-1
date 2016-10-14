/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connector.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Dienthoai;

/**
 *
 * @author admin
 */
public class DienthoaiDAO {
    public Dienthoai getDienthoai(String product_id) throws ClassNotFoundException, SQLException {
        Dienthoai res = new Dienthoai();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM dienthoai WHERE product_id = '"+product_id+"'";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        res.setProduct_id(rs.getString("product_id"));
        res.setCategory_id(rs.getInt("category_id"));
        res.setSupply_id(rs.getInt("category_id"));
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
        con.close();
        return res;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DienthoaiDAO dtDAO = new DienthoaiDAO();
        Dienthoai dt = dtDAO.getDienthoai("dt0001");
            System.out.println(dt.getCategory_id());
            System.out.println(dt.getProduct_name());
            System.out.println(dt.getProduct_cpu());
    }
}
