/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author user
 */
@WebServlet(name = "ManagerBillServlet", urlPatterns = {"/ManagerBillServlet"})
public class ManagerBillServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BillDAO billDAO = new BillDAO();
        String url = "admin/billManager.jsp";

        String command = request.getParameter("command");
        String id = request.getParameter("bill_id");

        int bill_id;

        if (command != null && id != null) {
            if (command.equals("process")) {
                //just update receipt_date attribute
                bill_id = Integer.parseInt(id);
                Bill bill = new Bill();
                bill.setBill_id(bill_id);
                bill.setBill_receipt_date(new Date(System.currentTimeMillis()));
                billDAO.updateBill(bill);
            } else if (command.equals("cancel")) {
                bill_id = Integer.parseInt(id);
                Bill bill = new Bill();
                bill.setBill_id(bill_id);
                bill.setBill_receipt_date(new Date(0));
                billDAO.updateBill(bill);
            }
        }

        try {
            ArrayList<Bill> bills = billDAO.getBills();
            request.setAttribute("bills", bills);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BillDAO billDAO = new BillDAO();

        String command = request.getParameter("command");

        if (command != null && command.equals("statistic")) {
            response.setContentType("application/json;charset=utf-8");
            JSONObject resJson = new JSONObject();
            PrintWriter pw = response.getWriter();

            ArrayList<Double> sales = new ArrayList<>();
            ArrayList<Integer> numBills = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                sales.add(0d);
                numBills.add(0);
            }

            try {
                Date now = new Date(System.currentTimeMillis());
                int year = now.toLocalDate().getYear();
                ArrayList<Bill> bills = billDAO.getBills();

                for (Bill bill : bills) {
                    Date receipt_date = bill.getBill_receipt_date();
                    if (receipt_date != null) {
                        if (receipt_date.compareTo(new Date(year - 1900, 0, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 1, 1)) < 0) {
                            sales.set(0, sales.get(0) + bill.getBill_total());
                            numBills.set(0, numBills.get(0) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 1, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 2, 1)) < 0) {
                            sales.set(1, sales.get(1) + bill.getBill_total());
                            numBills.set(1, numBills.get(1) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 2, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 3, 1)) < 0) {
                            sales.set(2, sales.get(2) + bill.getBill_total());
                            numBills.set(2, numBills.get(2) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 3, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 4, 1)) < 0) {
                            sales.set(3, sales.get(3) + bill.getBill_total());
                            numBills.set(3, numBills.get(3) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 4, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 5, 1)) < 0) {
                            sales.set(4, sales.get(4) + bill.getBill_total());
                            numBills.set(4, numBills.get(4) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 5, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 6, 1)) < 0) {
                            sales.set(5, sales.get(5) + bill.getBill_total());
                            numBills.set(5, numBills.get(5) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 6, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 7, 1)) < 0) {
                            sales.set(6, sales.get(6) + bill.getBill_total());
                            numBills.set(6, numBills.get(6) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 7, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 8, 1)) < 0) {
                            sales.set(7, sales.get(7) + bill.getBill_total());
                            numBills.set(7, numBills.get(7) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 8, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 9, 1)) < 0) {
                            sales.set(8, sales.get(8) + bill.getBill_total());
                            numBills.set(8, numBills.get(8) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 9, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 10, 1)) < 0) {
                            sales.set(9, sales.get(9) + bill.getBill_total());
                            numBills.set(9, numBills.get(9) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 10, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900, 11, 1)) < 0) {
                            sales.set(10, sales.get(10) + bill.getBill_total());
                            numBills.set(10, numBills.get(10) + 1);
                        } else if (receipt_date.compareTo(new Date(year - 1900, 11, 1)) >= 0 && receipt_date.compareTo(new Date(year - 1900 + 1, 0, 1)) < 0) {
                            sales.set(11, sales.get(11) + bill.getBill_total());
                            numBills.set(11, numBills.get(11) + 1);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                resJson.put("sales", sales);
                resJson.put("numBills", numBills);
                pw.print(resJson.toString());
                pw.close();
            } catch (JSONException ex) {
                Logger.getLogger(ManagerBillServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
