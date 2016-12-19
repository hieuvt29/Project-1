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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Supplier;

/**
 *
 * @author LOREMSUM
 */
public class SupplierDAO {
    public ArrayList<Supplier> getSupplierList(String table) throws ClassNotFoundException, SQLException{
        ArrayList<Supplier> resultList = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        
        String sql = "SELECT * FROM "+ table;
        
         
        PreparedStatement ps = con.prepareCall(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Supplier category = new Supplier();
            category.setSupplier_id(rs.getInt("supplier_id"));
            category.setSupplier_name(rs.getString("supplier_name"));
            
            resultList.add(category);
        }
        con.close();
        return resultList;
    }
    
    // them moi supply
    public boolean insertSupply(Supplier supplier) {
        try {
            Connection con = DBConnector.getConnection();
            String sql = "INSERT INTO supplier_dienthoai VALUES (?, ?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, supplier.getSupplier_id());
            ps.setString(2, supplier.getSupplier_name());
            return ps.executeUpdate() == 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SupplierDAO categoryDao = new SupplierDAO();
        for(Supplier c: categoryDao.getSupplierList("supplier_dienthoai")){
            System.out.println(c.getSupplier_id() +"--"+ c.getSupplier_name());
        }
    }
}

