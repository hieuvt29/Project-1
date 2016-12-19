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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.MD5;

/**
 *
 * @author user
 */
public class UserDAO {

    public boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM users WHERE user_email='" + email + "'";
        try {

            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }

    public boolean checkUsername(String username) throws ClassNotFoundException, SQLException {
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM users WHERE user_name='" + username + "'";
        try {

            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }

    public boolean addUser(User user) throws ClassNotFoundException, SQLException {
        Connection con = DBConnector.getConnection();
        String sql = "INSERT INTO `users` (`user_id`, `user_name`, `user_email`, `user_password`, `user_phonenumber`, `user_role`) "
                + "VALUES (NULL, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getUser_email());
            ps.setString(3, user.getUser_password());
            ps.setString(4, user.getUser_phonenumber());
            ps.setBoolean(5, user.isUser_role());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return false;

    }

    public User login(String user_email, String password) throws ClassNotFoundException, SQLException {
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM users WHERE user_email='" + user_email + "' AND user_password='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_email(rs.getString(3));
                user.setUser_password(rs.getString(4));
                user.setUser_phonenumber(rs.getString(5));
                user.setUser_role(rs.getBoolean(6));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }

        return null;
    }
    
    public boolean delete(int user_id) throws ClassNotFoundException, SQLException{
        Connection con = DBConnector.getConnection();
        String sql = "DELETE FROM users WHERE user_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);

            ps.setInt(1, user_id);

            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return false;
    }

    public User update(User user) throws ClassNotFoundException, SQLException {
        Connection con = DBConnector.getConnection();
        String sql = "UPDATE `users` SET  `user_name` = ?, `user_email` = ?, `user_password` = ?, `user_phonenumber`= ?, `user_role`= ? WHERE `user_id` = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getUser_email());
            ps.setString(3, user.getUser_password());
            ps.setString(4, user.getUser_phonenumber());
            ps.setBoolean(5, user.isUser_role());
            ps.setInt(6, user.getUser_id());

            ps.executeUpdate();

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return null;

    }   

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDAO userDAO = new UserDAO();
        User newUser = new User("Hieu1", "admin@gmail.com", MD5.encryption("123321123"), "0966038030", true);
        userDAO.addUser(newUser);
        System.out.println(newUser.getUser_password());
    }
}
