/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LOREMSUM
 */
public class Laptop extends Product {
    
   // private int category_id;
    //private String product_name;
    
    private int supply_id;
    private String product_CPU;
    private String product_RAM;
    private String product_hard_disk;
    private String product_screen;
    private String product_touch;
    private String product_graphic;
    private String product_optical_disk;
    private double product_webcam; // MP //
    private String product_material;
    private String product_gates;
    private String product_connection;
    private String product_battery;
    private double product_weight; // Kg //
    //private double product_price;
    //private double product_discount; // phần trăm giảm giá //

    public Laptop() {
    }

    public Laptop(String product_id) {
        super(product_id);
    }
    
    public Laptop(String product_id, int category_id, double product_price, double product_discount) {
        super(product_id, category_id, product_price, product_discount);
    }
    
    public Laptop(int supply_id, String product_CPU, String product_RAM, String product_hard_disk, String product_screen, String product_touch, String product_graphic, String product_optical_disk, double product_webcam, String product_material, String product_gates, String product_connection, String product_battery, double product_weight, String product_id, int category_id, String product_name, double product_price, double product_discount) {
        super(product_id, category_id, product_name, product_price, product_discount);
        this.supply_id = supply_id;
        this.product_CPU = product_CPU;
        this.product_RAM = product_RAM;
        this.product_hard_disk = product_hard_disk;
        this.product_screen = product_screen;
        this.product_touch = product_touch;
        this.product_graphic = product_graphic;
        this.product_optical_disk = product_optical_disk;
        this.product_webcam = product_webcam;
        this.product_material = product_material;
        this.product_gates = product_gates;
        this.product_connection = product_connection;
        this.product_battery = product_battery;
        this.product_weight = product_weight;
    }

    public int getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(int supply_id) {
        this.supply_id = supply_id;
    }

    public String getProduct_CPU() {
        return product_CPU;
    }

    public void setProduct_CPU(String product_CPU) {
        this.product_CPU = product_CPU;
    }

    public String getProduct_RAM() {
        return product_RAM;
    }

    public void setProduct_RAM(String product_RAM) {
        this.product_RAM = product_RAM;
    }

    public String getProduct_hard_disk() {
        return product_hard_disk;
    }

    public void setProduct_hard_disk(String product_hard_disk) {
        this.product_hard_disk = product_hard_disk;
    }

    public String getProduct_screen() {
        return product_screen;
    }

    public void setProduct_screen(String product_screen) {
        this.product_screen = product_screen;
    }

    public String getProduct_touch() {
        return product_touch;
    }

    public void setProduct_touch(String product_touch) {
        this.product_touch = product_touch;
    }

    public String getProduct_graphic() {
        return product_graphic;
    }

    public void setProduct_graphic(String product_graphic) {
        this.product_graphic = product_graphic;
    }

    public String getProduct_optical_disk() {
        return product_optical_disk;
    }

    public void setProduct_optical_disk(String product_optical_disk) {
        this.product_optical_disk = product_optical_disk;
    }

    public double getProduct_webcam() {
        return product_webcam;
    }

    public void setProduct_webcam(double product_webcam) {
        this.product_webcam = product_webcam;
    }

    public String getProduct_material() {
        return product_material;
    }

    public void setProduct_material(String product_material) {
        this.product_material = product_material;
    }

    public String getProduct_gates() {
        return product_gates;
    }

    public void setProduct_gates(String product_gates) {
        this.product_gates = product_gates;
    }

    public String getProduct_connection() {
        return product_connection;
    }

    public void setProduct_connection(String product_connection) {
        this.product_connection = product_connection;
    }

    public String getProduct_battery() {
        return product_battery;
    }

    public void setProduct_battery(String product_battery) {
        this.product_battery = product_battery;
    }

    public double getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(double product_weight) {
        this.product_weight = product_weight;
    }

    public double getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(double product_discount) {
        this.product_discount = product_discount;
    }
    
}
