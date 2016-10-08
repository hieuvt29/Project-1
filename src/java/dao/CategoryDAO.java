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
import model.Category;

/**
 *
 * @author LOREMSUM
 */
public class CategoryDAO {
    public ArrayList<Category> getCategoryList() throws ClassNotFoundException, SQLException{
        ArrayList<Category> resultList = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        
        String sql = "SELECT * FROM category";
        
        PreparedStatement ps = con.prepareCall(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Category category = new Category();
            category.setCategory_id(rs.getInt("category_id"));
            category.setCategory_name(rs.getString("category_name"));
            
            resultList.add(category);
        }
        return resultList;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CategoryDAO categoryDao = new CategoryDAO();
        for(Category c: categoryDao.getCategoryList()){
            System.out.println(c.getCategory_id() +"--"+ c.getCategory_name());
        }
    }
}
