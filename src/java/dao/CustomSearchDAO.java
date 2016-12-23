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
import model.Dienthoai;
import model.Laptop;
import model.Mayanh;
import model.Product;

/**
 *
 * @author user
 */
public class CustomSearchDAO {

    private LaptopDAO laptopDAO;
    private DienthoaiDAO dienthoaiDAO;
    private MayanhDAO mayanhDAO;

    public CustomSearchDAO() {
        laptopDAO = new LaptopDAO();
        dienthoaiDAO = new DienthoaiDAO();
        mayanhDAO = new MayanhDAO();
    }

    public ArrayList<Product> searchProducts(String name) throws ClassNotFoundException, SQLException {
        ArrayList<Product> resList = null;
        Connection con = DBConnector.getConnection();

        String sql = "SELECT product_id as pid FROM dienthoai WHERE instr(lower(product_name), ?) > 0 "
                + "UNION SELECT product_id as pid FROM laptop WHERE instr(lower(product_name), ?) > 0 "
                + "UNION SELECT product_id as pid FROM mayanh WHERE instr(lower(product_name), ?) > 0";

        PreparedStatement ps = con.prepareCall(sql);

        ps.setString(1, name.toLowerCase());
        ps.setString(2, name.toLowerCase());
        ps.setString(3, name.toLowerCase());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resList = new ArrayList<>();
            do {
                String product_id = rs.getString(1);
                String product = product_id.substring(0, 2);
                if (product.equals("dt")) {
                    Dienthoai dt = dienthoaiDAO.getProduct(product_id);
                    resList.add(dt);
                } else if (product.equals("mt")) {
                    Laptop lt = laptopDAO.getProduct(product_id);
                    resList.add(lt);
                } else if (product.equals("ma")) {
                    Mayanh ma = mayanhDAO.getProduct(product_id);
                    resList.add(ma);
                }
            } while (rs.next());
        }

        return resList;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CustomSearchDAO ctsDAO = new CustomSearchDAO();
        ArrayList<Product> list = ctsDAO.searchProducts("a");
        for(Product pd: list){
            System.out.println("Name: "+ pd.getProduct_name());
        }
        
    }
}
