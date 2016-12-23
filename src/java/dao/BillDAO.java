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
            res.setBill_receive_date(rs.getDate("bill_receive_date"));
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
        while(rs.next()){
            Bill bill = getBill(rs.getInt("bill_id"));
            res.add(bill);
        }
        return res;
    }
}
