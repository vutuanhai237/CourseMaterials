/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.Lop;
import DLL.ThongKe;
import GUI.Static;
import static GUI.Static.ds;
import static GUI.Static.dstk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Event {

    public static void insert() {

    }

    public static void delete() {

    }

    public static void add() {

    }

    public static void connect() {
        ds.clear();
        PreparedStatement prs = null;
        ResultSet res = null;
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "SELECT *FROM Lop";
            res = st.executeQuery(sql_command);

            while (res.next()) {
                System.out.print(res.getString("STT") + " " + res.getString("TenGV") + " ");
                System.out.print(res.getString("MaLop") + " " + res.getString("TenMon") + " " + res.getString("SiSo"));
                System.out.println(res.getString("NgayBD") + " " + res.getString("NgayKT") + res.getString("SoTiet"));
                Static.ds.add(new Lop(res.getString("STT"), res.getString("TenGV"), res.getString("MaLop"), res.getString("TenMon"), res.getInt("SiSo"), res.getString("NgayBD"), res.getString("NgayKT"), res.getInt("SoTiet")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void connect2() {
        dstk.clear();
        PreparedStatement prs = null;
        ResultSet res = null;
        try {
            res = Query.getBang2();
            while (res.next()) {
                String IsDatChuan = null;
                if (Integer.parseInt(res.getString("TongSoTiet")) >= 135) {
                    IsDatChuan = "Đạt chuẩn";
                } else {
                    IsDatChuan = "Không đạt chuẩn";
                }
                Static.dstk.add(new ThongKe(res.getString("TenGV2"), res.getString("TongSoLop"), res.getString("TongSoTiet"), IsDatChuan));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
