/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public abstract class Product {
    protected int category_id;
    protected String product_id;
    protected String product_name;
    protected double product_price;
    protected double product_discount;

    public Product() {
    }

    public Product(String product_id, int category_id, double product_price, double product_discount) {
        this.product_id = product_id;
        this.category_id = category_id;       
        this.product_price = product_price;
        this.product_discount = product_discount;
    }   

    public Product(int category_id, String product_id, String product_name, double product_price, double product_discount) {
        this.category_id = category_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
    }

    public double getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(double product_discount) {
        this.product_discount = product_discount;
    }

    public String getProduct_id() {
        return product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

}
