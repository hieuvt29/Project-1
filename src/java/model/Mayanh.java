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
public class Mayanh extends Product {

  //  private String  product_id ;
    private int supplier_id ;

    //private String  product_name ;
    private String product_categorize ;
    private String product_sensor ;
    private String product_image_processor ;
    private String product_lens ; // mm //
    private String product_film ; // pixel //
    private String product_shutter_speed  ;
    private String product_connection ;
    private String product_screen ;
    private String product_battery ;
    private String product_mem_card ;
    private String product_made_in  ;
    private String product_warranty  ;
    private double product_weight ;
   // private double  product_price ;
 //   private  double product_discount ; // phần trăm giảm giá //

    public Mayanh() {
    }

    public Mayanh(String product_id, int category_id, double product_price, double product_discount) {
        super(product_id, category_id, product_price, product_discount);
    }
    
    public Mayanh(int supplier_id, String product_categorize, String product_sensor, String product_image_processor, String product_lens, String product_film, String product_shutter_speed, String product_connection, String product_screen, String product_battery, String product_mem_card, String product_made_in, String product_warranty, double product_weight, String product_id, int category_id, String product_name, double product_price, double product_discount) {
        super(product_id, category_id, product_name, product_price, product_discount);       
        this.supplier_id = supplier_id;
        this.product_categorize = product_categorize;
        this.product_sensor = product_sensor;
        this.product_image_processor = product_image_processor;
        this.product_lens = product_lens;
        this.product_film = product_film;
        this.product_shutter_speed = product_shutter_speed;
        this.product_connection = product_connection;
        this.product_screen = product_screen;
        this.product_battery = product_battery;
        this.product_mem_card = product_mem_card;
        this.product_made_in = product_made_in;
        this.product_warranty = product_warranty;
        this.product_weight = product_weight;
    }
    
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getProduct_categorize() {
        return product_categorize;
    }

    public void setProduct_categorize(String product_categorize) {
        this.product_categorize = product_categorize;
    }

    public String getProduct_sensor() {
        return product_sensor;
    }

    public void setProduct_sensor(String product_sensor) {
        this.product_sensor = product_sensor;
    }

    public String getProduct_image_processor() {
        return product_image_processor;
    }

    public void setProduct_image_processor(String product_image_processor) {
        this.product_image_processor = product_image_processor;
    }

    public String getProduct_lens() {
        return product_lens;
    }

    public void setProduct_lens(String product_lens) {
        this.product_lens = product_lens;
    }

    public String getProduct_film() {
        return product_film;
    }

    public void setProduct_film(String product_film) {
        this.product_film = product_film;
    }

    public String getProduct_shutter_speed() {
        return product_shutter_speed;
    }

    public void setProduct_shutter_speed(String product_shutter_speed) {
        this.product_shutter_speed = product_shutter_speed;
    }

    public String getProduct_connection() {
        return product_connection;
    }

    public void setProduct_connection(String product_connection) {
        this.product_connection = product_connection;
    }

    public String getProduct_screen() {
        return product_screen;
    }

    public void setProduct_screen(String product_screen) {
        this.product_screen = product_screen;
    }

    public String getProduct_battery() {
        return product_battery;
    }

    public void setProduct_battery(String product_battery) {
        this.product_battery = product_battery;
    }

    public String getProduct_mem_card() {
        return product_mem_card;
    }

    public void setProduct_mem_card(String product_mem_card) {
        this.product_mem_card = product_mem_card;
    }

    public double getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(double product_weight) {
        this.product_weight = product_weight;
    }

    public String getProduct_made_in() {
        return product_made_in;
    }

    public void setProduct_made_in(String product_made_in) {
        this.product_made_in = product_made_in;
    }

    public String getProduct_warranty() {
        return product_warranty;
    }

    public void setProduct_warranty(String product_warranty) {
        this.product_warranty = product_warranty;
    }
}
