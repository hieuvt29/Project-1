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
public class Dienthoai extends Product {

  //  private int category_id;
   // private String product_id;
    //private String product_name;
    private int supply_id;
    private String product_resolution;

    private String product_os;
    private int product_camera_after; // MP //
    private int product_camera_front; // MP //
    private String product_cpu;
    private int product_ram; // GB //
    private int product_memory; // GB // 
    private String product_mem_card;
    private String product_sim_card;
    private String product_connection;
    private int product_battery; // mAh //
    private String product_design;
    private String product_extra_info;
    //private double product_price;
   // private double product_discount; // phần trăm giảm giá //

    public Dienthoai() {
    }

    public Dienthoai(String product_id, int category_id, double product_price, double product_discount) {
        super(product_id, category_id, product_price, product_discount);
    }   

    public Dienthoai(int supply_id, String product_resolution, String product_os, int product_camera_after, int product_camera_front, String product_cpu, int product_ram, int product_memory, String product_mem_card, String product_sim_card, String product_connection, int product_battery, String product_design, String product_extra_info, int category_id, String product_id, String product_name, double product_price, double product_discount) {
        super(category_id, product_id, product_name, product_price, product_discount);
        this.supply_id = supply_id;
        this.product_resolution = product_resolution;
        this.product_os = product_os;
        this.product_camera_after = product_camera_after;
        this.product_camera_front = product_camera_front;
        this.product_cpu = product_cpu;
        this.product_ram = product_ram;
        this.product_memory = product_memory;
        this.product_mem_card = product_mem_card;
        this.product_sim_card = product_sim_card;
        this.product_connection = product_connection;
        this.product_battery = product_battery;
        this.product_design = product_design;
        this.product_extra_info = product_extra_info;
    }
    
    public int getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(int supply_id) {
        this.supply_id = supply_id;
    }

    public String getProduct_resolution() {
        return product_resolution;
    }

    public void setProduct_resolution(String product_resolution) {
        this.product_resolution = product_resolution;
    }

    public String getProduct_os() {
        return product_os;
    }

    public void setProduct_os(String product_os) {
        this.product_os = product_os;
    }

    public int getProduct_camera_after() {
        return product_camera_after;
    }

    public void setProduct_camera_after(int product_camera_after) {
        this.product_camera_after = product_camera_after;
    }

    public int getProduct_camera_front() {
        return product_camera_front;
    }

    public void setProduct_camera_front(int product_camera_front) {
        this.product_camera_front = product_camera_front;
    }

    public String getProduct_cpu() {
        return product_cpu;
    }

    public void setProduct_cpu(String product_cpu) {
        this.product_cpu = product_cpu;
    }

    public int getProduct_ram() {
        return product_ram;
    }

    public void setProduct_ram(int product_ram) {
        this.product_ram = product_ram;
    }

    public int getProduct_memory() {
        return product_memory;
    }

    public void setProduct_memory(int product_memory) {
        this.product_memory = product_memory;
    }

    public String getProduct_mem_card() {
        return product_mem_card;
    }

    public void setProduct_mem_card(String product_mem_card) {
        this.product_mem_card = product_mem_card;
    }

    public String getProduct_sim_card() {
        return product_sim_card;
    }

    public void setProduct_sim_card(String product_sim_card) {
        this.product_sim_card = product_sim_card;
    }

    public String getProduct_connection() {
        return product_connection;
    }

    public void setProduct_connection(String product_connection) {
        this.product_connection = product_connection;
    }

    public int getProduct_battery() {
        return product_battery;
    }

    public void setProduct_battery(int product_battery) {
        this.product_battery = product_battery;
    }

    public String getProduct_design() {
        return product_design;
    }

    public void setProduct_design(String product_design) {
        this.product_design = product_design;
    }

    public String getProduct_extra_info() {
        return product_extra_info;
    }

    public void setProduct_extra_info(String product_extra_info) {
        this.product_extra_info = product_extra_info;
    }
}
