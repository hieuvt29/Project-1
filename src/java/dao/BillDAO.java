/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connector.DBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;

/**
 *
 * @author user
 */
public class BillDAO {

    public Bill getBill(int bill_id) throws SQLException {
        Bill res = new Bill();
        try {
            Connection con = DBConnector.getConnection();

            String sql = "SELECT * FROM bills WHERE bill_id = '" + bill_id + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            res.setBill_id(rs.getInt("bill_id"));
            res.setBill_total(rs.getDouble("bill_total"));
            res.setBill_address(rs.getString("bill_address"));
            res.setBill_payment(rs.getString("bill_payment"));
            res.setBill_order_date(rs.getDate("bill_order_date"));
            res.setBill_receipt_date(rs.getDate("bill_receipt_date"));
            res.setUser_id(rs.getInt("user_id"));

            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;

    }

    public ArrayList<Bill> getUserBills(int user_id) throws ClassNotFoundException, SQLException {
        ArrayList<Bill> res = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT bill_id FROM bills WHERE user_id = '" + user_id + "'";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Bill bill = getBill(rs.getInt("bill_id"));
            res.add(bill);
        }
        return res;
    }

    public ArrayList<Bill> getBills() throws ClassNotFoundException, SQLException {
        ArrayList<Bill> res = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT bill_id FROM bills";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Bill bill = getBill(rs.getInt("bill_id"));
            res.add(bill);
        }
        return res;
    }

    public boolean insertBill(Bill bill) {
        try {
            Connection con = DBConnector.getConnection();

            String sql = "INSERT INTO bills VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, bill.getBill_id());
            ps.setInt(2, bill.getUser_id());
            ps.setDouble(3, bill.getBill_total());
            ps.setString(4, bill.getBill_payment());
            ps.setString(5, bill.getBill_address());
            ps.setDate(6, bill.getBill_order_date());
            ps.setDate(7, bill.getBill_receipt_date());

            return ps.executeUpdate() == 1;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateBill(Bill bill) {
        try {
            Connection con = DBConnector.getConnection();

            String sql = "UPDATE bills SET bill_receipt_date = ? "
                    + "WHERE bill_id = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setDate(1, bill.getBill_receipt_date());
            ps.setInt(2, bill.getBill_id());
            
            return ps.executeUpdate() == 1;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BillDAO billDAO = new BillDAO();
        Bill bill = new Bill();
        bill.setBill_id(5);
//        bill.setBill_address("N/A");
//        bill.setUser_id(43);
//        bill.setBill_payment("ONLINE");
//        bill.setBill_total(20.0);
//        bill.setBill_order_date(new Date(2016-1900, 0, 1));
//        billDAO.insertBill(bill);
        bill.setBill_receipt_date(new Date(System.currentTimeMillis()));
        billDAO.updateBill(bill);

    }
}
