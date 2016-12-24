/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author user
 */
public class Bill {

    private int bill_id;
    private int user_id;
    private double bill_total;
    private String bill_payment;
    private String bill_address;
    private Date bill_order_date;
    private Date bill_receipt_date;

    public Bill() {
    }

    public Bill(int bill_id, int user_id, double bill_total, String bill_payment, String bill_address, Date bill_order_date, Date bill_receipt_date) {
        this.bill_id = bill_id;
        this.user_id = user_id;
        this.bill_total = bill_total;
        this.bill_payment = bill_payment;
        this.bill_address = bill_address;
        this.bill_order_date = bill_order_date;
        this.bill_receipt_date = bill_receipt_date;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getBill_total() {
        return bill_total;
    }

    public void setBill_total(double bill_total) {
        this.bill_total = bill_total;
    }

    public String getBill_payment() {
        return bill_payment;
    }

    public void setBill_payment(String bill_payment) {
        this.bill_payment = bill_payment;
    }

    public String getBill_address() {
        return bill_address;
    }

    public void setBill_address(String bill_address) {
        this.bill_address = bill_address;
    }

    public Date getBill_order_date() {
        return bill_order_date;
    }

    public void setBill_order_date(Date bill_order_date) {
        this.bill_order_date = bill_order_date;
    }

    public Date getBill_receipt_date() {
        return bill_receipt_date;
    }

    public void setBill_receipt_date(Date bill_receipt_date) {
        this.bill_receipt_date = bill_receipt_date;
    }
    
    
}
