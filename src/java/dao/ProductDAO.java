/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Product;
import model.Supplier;

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
    public abstract boolean insertProduct(Product product);
    public abstract boolean updateProduct(Product product);
    public abstract boolean removeProduct(Product product);
}
