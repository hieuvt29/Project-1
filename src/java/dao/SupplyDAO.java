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
import model.Supply;

/**
 *
 * @author LOREMSUM
 */
public class SupplyDAO {
    public ArrayList<Supply> getSupplyList(String table) throws ClassNotFoundException, SQLException{
        ArrayList<Supply> resultList = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        
        String sql = "SELECT * FROM "+ table;
        
         
        PreparedStatement ps = con.prepareCall(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Supply category = new Supply();
            category.setSupply_id(rs.getInt("supply_id"));
            category.setSupply_name(rs.getString("supply_name"));
            
            resultList.add(category);
        }
        return resultList;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SupplyDAO categoryDao = new SupplyDAO();
        for(Supply c: categoryDao.getSupplyList("supply_dienthoai")){
            System.out.println(c.getSupply_id() +"--"+ c.getSupply_name());
        }
    }
}

