/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connector.DBConnector;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Laptop;
import model.Product;

/**
 *
 * @author LOREMSUM
 */
public class LaptopDAO extends ProductDAO {

    public ArrayList<Product> getProducts(String supplier, String category, int limit) {
        ArrayList<Product> listProduct = new ArrayList<>();
        Connection con;
        try {
            con = DBConnector.getConnection();
            String sql = null;
//            if(supplier.equals("*")){
//                sql = "SELECT product_id FROM laptop";
//            }else{
//                
//            }
            sql = "SELECT product_id FROM laptop WHERE supplier_id LIKE '" + supplier + "' AND category_id LIKE '"+category+"' LIMIT "+limit+"";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String product_id = rs.getString(1);
                Laptop lt = getProduct(product_id);
                listProduct.add(lt);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }

    public Laptop getProduct(String product_id) {
        Laptop res = new Laptop();
        try {
            Connection con = DBConnector.getConnection();

            String sql = "SELECT * FROM laptop WHERE product_id = '" + product_id + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            res.setProduct_id(rs.getString("product_id"));
            res.setCategory_id(rs.getInt("category_id"));
            res.setSupply_id(rs.getInt("supplier_id"));
            res.setProduct_name(rs.getString("product_name"));
            res.setProduct_price(rs.getDouble("product_price"));
            res.setProduct_CPU(rs.getString("product_CPU"));
            res.setProduct_RAM(rs.getString("product_RAM"));
            res.setProduct_hard_disk(rs.getString("product_hard_disk"));
            res.setProduct_screen(rs.getString("product_screen"));
            res.setProduct_touch(rs.getBoolean("product_touch"));
            res.setProduct_graphic(rs.getString("product_graphic"));
            res.setProduct_optical_disk(rs.getString("product_optical_disk"));
            res.setProduct_webcam(rs.getInt("product_webcam"));
            res.setProduct_material(rs.getString("product_material"));
            res.setProduct_gates(rs.getString("product_gates"));
            res.setProduct_connection(rs.getString("product_connection"));
            res.setProduct_battery(rs.getString("product_battery"));
            res.setProduct_weight(rs.getDouble("product_weight"));
            res.setProduct_discount(rs.getDouble("product_discount"));
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public void setLaptop_test() throws SQLException, IOException, ClassNotFoundException {
        try (Connection con = DBConnector.getConnection()) {
            String name = null,
                    price = null,
                    cpu = null,
                    ram = null,
                    harddisk = null,
                    screen = null,
                    touch = null,
                    graphic = null,
                    opticaldisk = null,
                    webcam = null,
                    gate = null,
                    connection = null,
                    battery = null,
                    weight = null,
                    material = null,
                    fileName = "inputTest.txt";

            BufferedReader bufferReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName), "UTF8"));
            //Variable to hold the one line data
            String line;
            // Read file line by line and print on the console
            int stt = -1;
            while ((line = bufferReader.readLine()) != null) {
                if (line != " ") {
                    String[] arr = line.split(":");
                    //System.out.println("STT: " + stt);
                    //System.out.println(line);

                    switch (stt) {
                        case -1:
                            name = arr[1].substring(1);
                            break;
                        case 0:
                            price = arr[1].substring(1);
                            //System.out.println("____" + price + "____");
                            break;
                        case 1:
                            cpu = arr[1].substring(1);
                            break;
                        case 2:
                            ram = arr[1].substring(1);
                            break;
                        case 3:
                            harddisk = arr[1].substring(1);
                            break;
                        case 4:
                            screen = arr[1].substring(1);
                            break;
                        case 5:
                            if (arr[1].substring(1).equals("Không")) {
                                touch = "0";
                            } else {
                                touch = "1";
                            }

                            break;
                        case 6:
                            graphic = arr[1].substring(1);
                            break;
                        case 7:
                            opticaldisk = arr[1].substring(1);
                            break;
                        case 8:
                            webcam = arr[1].substring(1);
                            break;
                        case 9:
                            material = arr[1].substring(1);
                            break;
                        case 10:
                            gate = arr[1].substring(1);
                            break;
                        case 11:
                            connection = arr[1].substring(1);
                            break;
                        case 12:
                            battery = arr[1].substring(1);
                            break;
                        case 13:
                            weight = arr[1].substring(1);
                            break;

                    }

                }
                stt++;
            }
            bufferReader.close();

            String sql;
            sql = "INSERT INTO `laptop` (`product_id`, `category_id`, `supplier_id`, `product_name`, `product_price`, `product_CPU`, `product_RAM`, `product_hard_disk`, `product_screen`, `product_touch`, `product_graphic`,"
                    + " `product_optical_disk`, `product_webcam`, `product_material`, `product_gates`, `product_connection`, `product_battery`, `product_weight`, `product_discount`) "
                    + "VALUES ('', '1', '4', '" + name + "', '" + price + "', '" + cpu + "', '" + ram + "', '" + harddisk + "', '" + screen + "', '" + touch + "', '" + graphic + "', '" + opticaldisk + "', '" + webcam + "', '" + material + "', '" + gate + "', '" + connection + "', '" + battery + "', '" + weight + "', '')";
            System.out.println(sql);
//            Statement st = con.createStatement();
//            int rs = st.executeUpdate(sql);
//            System.out.println(rs + "row effected!");
        }
    }

    public ArrayList<Laptop> getProduct() throws ClassNotFoundException, SQLException {
        ArrayList<Laptop> list = new ArrayList<>();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM laptop";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Laptop res = new Laptop();
            res.setProduct_id(rs.getString("product_id"));
            res.setCategory_id(rs.getInt("category_id"));
            res.setSupply_id(rs.getInt("supplier_id"));
            res.setProduct_name(rs.getString("product_name"));
            res.setProduct_price(rs.getDouble("product_price"));
            res.setProduct_CPU(rs.getString("product_CPU"));
            res.setProduct_RAM(rs.getString("product_RAM"));
            res.setProduct_hard_disk(rs.getString("product_hard_disk"));
            res.setProduct_screen(rs.getString("product_screen"));
            res.setProduct_touch(rs.getBoolean("product_touch"));
            res.setProduct_graphic(rs.getString("product_graphic"));
            res.setProduct_optical_disk(rs.getString("product_optical_disk"));
            res.setProduct_webcam(rs.getInt("product_webcam"));
            res.setProduct_material(rs.getString("product_material"));
            res.setProduct_gates(rs.getString("product_gates"));
            res.setProduct_connection(rs.getString("product_connection"));
            res.setProduct_battery(rs.getString("product_battery"));
            res.setProduct_weight(rs.getDouble("product_weight"));
            res.setProduct_discount(rs.getDouble("product_discount"));
            list.add(res);
        }
        con.close();
        return list;
    }

    public ArrayList<Laptop> getManyProduct(int category_id) {
        ArrayList<Laptop> list = new ArrayList<>();
        try {
            Connection con = DBConnector.getConnection();
            String sql = "SELECT * FROM laptop WHERE category_id = '" + category_id + "' ORDER BY RAND() LIMIT 6";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Laptop lt = new Laptop();
                lt.setProduct_id(rs.getString("product_id"));
                lt.setSupply_id(rs.getInt("supplier_id"));
                list.add(lt);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean insertProduct(Product product) {
        try {
            Connection con = DBConnector.getConnection();
            if (product instanceof Laptop) {
                String sql = "INSERT INTO laptop VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, product.getProduct_id());
                ps.setInt(2, product.getCategory_id());
                ps.setInt(3, ((Laptop) product).getSupply_id());
                ps.setString(4, product.getProduct_name());
                ps.setDouble(5, product.getProduct_price());
                ps.setString(6, ((Laptop) product).getProduct_CPU());
                ps.setString(7, ((Laptop) product).getProduct_RAM());
                ps.setString(8, ((Laptop) product).getProduct_hard_disk());
                ps.setString(9, ((Laptop) product).getProduct_screen());
                ps.setBoolean(10, ((Laptop) product).getProduct_touch());
                ps.setString(11, ((Laptop) product).getProduct_graphic());
                ps.setString(12, ((Laptop) product).getProduct_optical_disk());
                ps.setDouble(13, ((Laptop) product).getProduct_webcam());
                ps.setString(14, ((Laptop) product).getProduct_material());
                ps.setString(15, ((Laptop) product).getProduct_gates());
                ps.setString(16, ((Laptop) product).getProduct_connection());
                ps.setString(17, ((Laptop) product).getProduct_battery());
                ps.setDouble(18, ((Laptop) product).getProduct_weight());
                ps.setDouble(19, product.getProduct_discount());
                return ps.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        try {
            Connection con = DBConnector.getConnection();
            if (product instanceof Laptop) {
                String sql = "UPDATE laptop SET category_id = ?, product_price = ?, product_discount = ? "
                        + "WHERE product_id = ?";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setInt(1, product.getCategory_id());
                ps.setDouble(2, product.getProduct_price());
                ps.setDouble(3, product.getProduct_discount());
                ps.setString(4, product.getProduct_id());
                return ps.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        try {
            Connection con = DBConnector.getConnection();
            if (product instanceof Laptop) {
                String sql = "DELETE FROM laptop WHERE product_id = ?";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, product.getProduct_id());
                return ps.executeUpdate() == 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DienthoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        System.out.println("It's run!");
        LaptopDAO ldao = new LaptopDAO();
        ArrayList<Product> list = ldao.getProducts("%", "%", 5);
        System.out.println(list.size());
    }


}
