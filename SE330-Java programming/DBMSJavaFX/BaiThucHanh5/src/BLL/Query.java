/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.Static;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Query {

    public static int count_Lop() throws SQLException {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT COUNT(STT) FROM Lop";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            res.next();
            result = res.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;

    }

    public static int count_GV() throws SQLException {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT COUNT(DISTINCT TenGV) FROM Lop";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            res.next();
            result = res.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;

    }

    public static int getMaxSTT() {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT MAX(STT) FROM Lop";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            res.next();
            result = res.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int getMaxSiSo() {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT MAX(SiSo) FROM Lop";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            res.next();
            result = res.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int getMinSiSo() {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT MIN(SiSo) FROM Lop";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            res.next();
            result = res.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean IsNhoHonNgayKT(int nam, int thang, int ngay) {
        int ngay_ss = 28;
        int thang_ss = 5;
        int nam_ss = 2018;
        if (nam < nam_ss) {
            return true;
        } else {
            if (nam == nam_ss) {
                if (thang < thang_ss) {
                    return true;
                } else {
                    if (thang == thang_ss) {
                        if (ngay < ngay_ss) {
                            return true;
                        } else {
                            if (ngay == ngay_ss) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return false;

    }

    public static int getSoLopGD() {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT NgayKT FROM Lop";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            while (res.next()) {
                String ngaykt = res.getString("NgayKT");
                String temp[] = ngaykt.split("-");
                int nam = Integer.valueOf(temp[0]);
                int thang = Integer.valueOf(temp[1]);
                int ngay = Integer.valueOf(temp[2]);

                if (IsNhoHonNgayKT(nam, thang, ngay) == true) {
                    result++;
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int getSoLopKT() {
        ResultSet res = null;
        int result = 0;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT Count(MaLop) AS SoLop FROM Lop;";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
            res.next();
            result =  Integer.valueOf(res.getString("SoLop")) - getSoLopGD();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return result;
        
    }

    public static ResultSet getBang2() {
        ResultSet res = null;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command;
            sql_command = "SELECT TenGV AS TenGV2, COUNT(STT) AS TongSoLop, SUM(SoTiet) AS TongSoTiet FROM Lop GROUP BY TenGV;";
            st = cnt.createStatement();
            res = st.executeQuery(sql_command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

}
