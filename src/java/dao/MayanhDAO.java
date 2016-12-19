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
import java.util.ArrayList;
import model.Mayanh;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Supplier;

public class MayanhDAO extends ProductDAO {

    public ArrayList<Product> getProducts(String supplier) {
        ArrayList<Product> listProduct = new ArrayList<>();
        Connection con;
        try {
            con = DBConnector.getConnection();
            String sql = null;
            if (supplier.equals("*")) {
                sql = "SELECT product_id FROM mayanh";
            } else {
                sql = "SELECT product_id FROM mayanh WHERE supplier_id = '" + supplier + "'";
            }
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String product_id = rs.getString(1);
                Mayanh lt = getMayanh(product_id);
                listProduct.add(lt);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MayanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MayanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }
    
    public ArrayList<Mayanh> getManyProduct(int category_id) {
        ArrayList<Mayanh> list = new ArrayList<>();
        try {
            Connection con = DBConnector.getConnection();
            String sql = "SELECT * FROM mayanh WHERE category_id = '" + category_id + "' ORDER BY RAND() LIMIT 6";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Mayanh ma = new Mayanh();
                ma.setProduct_id(rs.getString("product_id"));
                list.add(ma);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Mayanh getMayanh(String product_id) {
        Mayanh res = new Mayanh();
        try {
            Connection con = DBConnector.getConnection();
            String sql = "SELECT * FROM mayanh WHERE product_id = '" + product_id + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            res.setProduct_id(rs.getString("product_id"));
            res.setCategory_id(rs.getInt("category_id"));
            res.setSupplier_id(rs.getInt("supplier_id"));
            res.setProduct_name(rs.getString("product_name"));
            res.setProduct_price(rs.getDouble("product_price"));
            res.setProduct_image_processor(rs.getString("product_image_processor"));
            res.setProduct_lens(rs.getString("product_lens"));
            res.setProduct_film(rs.getString("product_film"));
            res.setProduct_screen(rs.getString("product_screen"));
            res.setProduct_shutter_speed(rs.getString("product_shutter_speed"));
            res.setProduct_mem_card(rs.getString("product_mem_card"));
            res.setProduct_made_in(rs.getString("product_made_in"));
            res.setProduct_warranty(rs.getString("product_warranty"));
            res.setProduct_sensor(rs.getString("product_sensor"));
            res.setProduct_categorize(rs.getString("product_categorize"));
            res.setProduct_connection(rs.getString("product_connection"));
            res.setProduct_battery(rs.getString("product_battery"));
            res.setProduct_weight(rs.getDouble("product_weight"));
            res.setProduct_discount(rs.getDouble("product_discount"));
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MayanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MayanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MayanhDAO ldao = new MayanhDAO();
        System.out.println(ldao.getMayanh("ma0001").getCategory_id());
        System.out.println(ldao.getMayanh("ma0001").getProduct_name());
        System.out.println(ldao.getMayanh("ma0001").getProduct_weight() + "g");
    }

}
