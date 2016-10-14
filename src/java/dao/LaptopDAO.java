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
import model.Laptop;

/**
 *
 * @author LOREMSUM
 */
public class LaptopDAO {

    public Laptop getLaptop(String product_id) throws ClassNotFoundException, SQLException {
        Laptop res = new Laptop();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM laptop WHERE product_id '"+product_id+"'";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        res.setProduct_id(rs.getString("product_id"));
        res.setCategory_id(rs.getInt("category_id"));
        res.setSupply_id(rs.getInt("supplier_id"));
        res.setProduct_name(rs.getString("product_name"));
        res.setProduct_price(rs.getDouble("product_price"));
        res.setProduct_CPU(rs.getString("product_CPU"));
        res.setProduct_RAM(rs.getString("product_RAM"));
        res.setProduct_hard_disk(rs.getString("product_hard_disk"));
        res.setProduct_screen(rs.getString("product_screen"));
        res.setProduct_touch(rs.getBoolean("product_touch"));
        res.setProduct_graphic(rs.getString("product_graphic"));
        res.setProduct_optical_disk(rs.getString("product_optical_disk"));
        res.setProduct_webcam(rs.getInt("product_webcam"));
        res.setProduct_material(rs.getString("product_material"));
        res.setProduct_gates(rs.getString("product_gates"));
        res.setProduct_connection(rs.getString("product_connection"));
        res.setProduct_battery(rs.getString("product_battery"));
        res.setProduct_weight(rs.getDouble("product_weight"));
        res.setProduct_discount(rs.getDouble("product_discount"));
        con.close();
        return res;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        LaptopDAO ldao = new LaptopDAO();
        Laptop lap = ldao.getLaptop("mt0001");
        System.out.println(lap.getCategory_id());
        System.out.println(lap.getProduct_name());
        System.out.println(lap.getProduct_weight() + "Kg");
    } 
}
