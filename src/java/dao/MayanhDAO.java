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
import model.Mayanh;


public class MayanhDAO extends ProductDAO {
    
    public Mayanh getMayanh(String product_id) throws ClassNotFoundException, SQLException {
        Mayanh res = new Mayanh();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM mayanh WHERE product_id = '"+product_id+"'";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        res.setProduct_id(rs.getString("product_id"));
        res.setCategory_id(rs.getInt("category_id"));
        res.setSupplier_id(rs.getInt("supplier_id"));
        res.setProduct_name(rs.getString("product_name"));
        res.setProduct_price(rs.getDouble("product_price"));
        res.setProduct_image_processor(rs.getString("product_image_processor"));
        res.setProduct_lens(rs.getDouble("product_lens"));
        res.setProduct_film (rs.getDouble("product_film "));
        res.setProduct_screen(rs.getString("product_screen"));
        res.setProduct_shutter_speed(rs.getString("product_shutter_speed"));
        res.setProduct_mem_card(rs.getString("product_mem_card"));
        res.setProduct_size(rs.getDouble("product_size"));
        res.setProduct_power_charger(rs.getString("product_power_charger"));
        res.setProduct_sensor(rs.getString("product_sensor"));
        res.setProduct_categorize(rs.getString("product_categorize"));
        res.setProduct_connection(rs.getString("product_connection"));
        res.setProduct_battery(rs.getString("product_battery"));
        res.setProduct_weight(rs.getDouble("product_weight"));
        res.setProduct_discount(rs.getDouble("product_discount"));
        con.close();
        return res;
}
      public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MayanhDAO ldao = new MayanhDAO();
        Mayanh lap = ldao.getMayanh("ma0001");
        System.out.println(lap.getCategory_id());
        System.out.println(lap.getProduct_name());
        System.out.println(lap.getProduct_weight() + "g");
    }

}
