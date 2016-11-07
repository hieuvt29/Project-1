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
import java.util.ArrayList;
import model.Dienthoai;
import model.Product;

/**
 *
 * @author admin
 */
public abstract class ProductDAO {

    /**
     *
     * @param product
     * @return list of product
     */
    public abstract ArrayList<Product> getProducts(String product);
}
