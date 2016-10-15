/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connector.DBConnector;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Laptop;

/**
 *
 * @author LOREMSUM
 */
public class LaptopDAO {

    public Laptop getLaptop(String product_id) throws ClassNotFoundException, SQLException {
        Laptop res = new Laptop();
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
        return res;
    }

    public void setLaptop() throws SQLException, IOException, ClassNotFoundException {
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        System.out.println("It's run!");

        LaptopDAO ldao = new LaptopDAO();
        Laptop lt = ldao.getLaptop("mt0001");
        System.out.println(lt.getProduct_CPU());
        ldao.setLaptop();

    }

}
