/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import DLL.Lop;
import DLL.ThongKe;
import GUI.Static;
import static GUI.Static.ds;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormController implements Initializable {

    ///
    boolean IsSua = true;
    boolean IsLuu = true;
    String TrangThai = "";

    ///
    @FXML
    private TextField txt_STT;

    @FXML
    private TextField txt_TenGV;

    @FXML
    private TextField txt_MaLop;

    @FXML
    private TextField txt_TenMon;

    @FXML
    private TextField txt_SiSo;

    @FXML
    private TextField txt_SoTiet;

    @FXML
    private DatePicker txt_NgayBD;

    @FXML
    private DatePicker txt_NgayKT;

    @FXML
    private TableView<Lop> list;

    @FXML
    private Button btn_connect;

    @FXML
    private Button btn_timkiem;

    @FXML
    private Button btn_huy;

    @FXML
    private Button btn_Thoat;

    @FXML
    private Button btn_Luu;

    @FXML
    private Button btn_Xoa;

    @FXML
    private Button btn_Sua;

    @FXML
    private Button btn_them;

    @FXML
    private Button btn_connect2;

    @FXML
    private TableColumn<Lop, String> STT;

    @FXML
    private TableColumn<Lop, String> TenGV;

    @FXML
    private TableColumn<Lop, String> MaLop;

    @FXML
    private TableColumn<Lop, String> TenMon;

    @FXML
    private TableColumn<Lop, String> SiSo;

    @FXML
    private TableColumn<Lop, String> NgayBD;

    @FXML
    private TableColumn<Lop, String> NgayKT;

    @FXML
    private TableColumn<Lop, String> SoTiet;

    @FXML
    private Label txt_tongsolop;

    @FXML
    private Label txt_sogiangvien;

    @FXML
    private Label txt_slkt;

    @FXML
    private Label txt_sldgd;

    @FXML
    private Label txt_lcssin;

    @FXML
    private Label txt_lcssnn;

    @FXML
    private TableView<ThongKe> list2;

    @FXML
    private TableColumn<ThongKe, String> TenGV2;

    @FXML
    private TableColumn<ThongKe, String> TongSoLop;

    @FXML
    private TableColumn<ThongKe, String> TongSoTiet;

    @FXML
    private TableColumn<ThongKe, String> DatChuan;

    @FXML
    void btn_LuuClick(ActionEvent event) {
        if (TrangThai.compareTo("Sua") == 0) {

            try {

                Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
                Statement st = cnt.createStatement();
                String sql_command = "UPDATE Lop SET STT = '" + txt_STT.getText()
                        + "', TenGV = '" + txt_TenGV.getText()
                        + "', MaLop = '" + txt_MaLop.getText()
                        + "', TenMon = '" + txt_TenMon.getText()
                        + "', SiSo = '" + txt_SiSo.getText()
                        + "', NgayBD = '" + txt_NgayBD.getValue()
                        + "', NgayKT = '" + txt_NgayKT.getValue()
                        + "', SoTiet = '" + txt_SoTiet.getText() + "' WHERE STT = '" + list.getSelectionModel().getSelectedItem().getSTT() + "';";
                st = cnt.createStatement();
                st.executeUpdate(sql_command);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Lop id = list.getSelectionModel().getSelectedItem();
            System.out.println(id.getMaLop());
            btn_connect.fire();
        }

        if (TrangThai.compareTo("Them") == 0) {
            try {

                Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
                Statement st = cnt.createStatement();
                String sql_command = "INSERT INTO Lop (STT, TenGV, MaLop, TenMon, SiSo, NgayBD, NgayKT, SoTiet) VALUES ('" + (BLL.Query.getMaxSTT() + 1) + "', '"
                        + txt_TenGV.getText() + "', '" + txt_MaLop.getText() + "', '" + txt_TenMon.getText() + "', '"
                        + txt_SiSo.getText() + "', '" + txt_NgayBD.getValue() + "', '" + txt_NgayKT.getValue() + "', '" + txt_SoTiet.getText() + "');";
                st = cnt.createStatement();
                st.executeUpdate(sql_command);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        btn_connect.fire();
        IsSua = true;
        KichHoatTrangThaiSua();

        btn_Luu.setDisable(true);
        btn_them.setDisable(false);
        btn_Sua.setDisable(false);
        btn_Xoa.setDisable(false);
    }

    @FXML
    void btn_SuaClick(ActionEvent event) {
        IsSua = false;
        KichHoatTrangThaiSua();
        TrangThai = "Sua";
        btn_Luu.setDisable(false);
        btn_Sua.setDisable(true);
        btn_them.setDisable(true);
        btn_Xoa.setDisable(true);

    }

    @FXML
    void btn_XoaClick(ActionEvent event) {
        try {

            Connection cnt = (Connection) DriverManager.getConnection(Static.connection);
            Statement st = cnt.createStatement();
            String sql_command = "DELETE FROM Lop WHERE STT = '" + list.getSelectionModel().getSelectedItem().getSTT() + "';";
            st = cnt.createStatement();
            st.executeUpdate(sql_command);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Lop id = list.getSelectionModel().getSelectedItem();
        System.out.println(id.getMaLop());
        btn_connect.fire();
    }

    @FXML
    void btn_connectClick(ActionEvent event) {
        BLL.Event.connect();
        list.getItems().clear();
        list.getItems().addAll(ds);
    }

    @FXML
    void btn_huyClick(ActionEvent event) {
        list.getItems().clear();
    }

    @FXML
    void btn_themClick(ActionEvent event) {
        txt_STT.clear();
        txt_MaLop.clear();
        txt_TenGV.clear();
        txt_TenMon.clear();
        txt_SiSo.clear();
        txt_NgayBD.setValue(null);
        txt_NgayKT.setValue(null);
        txt_SoTiet.clear();
        IsSua = false;
        KichHoatTrangThaiSua();
        TrangThai = "Them";
        btn_Luu.setDisable(false);

        btn_them.setDisable(true);
        btn_Sua.setDisable(true);
        btn_Xoa.setDisable(true);
    }

    @FXML
    void btn_thoatClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btn_timkiemClick(ActionEvent event) {

    }

    @FXML
    void btn_connect2Click(ActionEvent event) throws SQLException {
        txt_tongsolop.setText("Tổng số lớp hiện có: " + BLL.Query.count_Lop());
        txt_sogiangvien.setText("Số giảng viên được phân công: " + BLL.Query.count_GV());
        txt_sldgd.setText("Số lớp đang giảng dạy: " + BLL.Query.getSoLopGD());
        txt_slkt.setText("Số lớp kết thúcy: " + BLL.Query.getSoLopKT());

        txt_lcssin.setText("Lớp có sĩ số ít nhất: " + BLL.Query.getMinSiSo());
        txt_lcssnn.setText("Lớp có sĩ số nhiều nhất: " + BLL.Query.getMaxSiSo());

        BLL.Event.connect2();

        list2.getItems().clear();
        list2.getItems().addAll(Static.dstk);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        KichHoatTrangThaiSua();
        txt_STT.setDisable(true);
        btn_Luu.setDisable(true);
        btn_them.setDisable(false);
        btn_Sua.setDisable(false);

        btn_connect.fire();
        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String ngay_bd = list.getSelectionModel().getSelectedItem().getNgayBD();
            LocalDate ngaybd = LocalDate.parse(ngay_bd, formatter);

            String ngay_kt = list.getSelectionModel().getSelectedItem().getNgayKT();
            LocalDate ngaykt = LocalDate.parse(ngay_kt, formatter);

            txt_STT.setText(list.getSelectionModel().getSelectedItem().getSTT());
            txt_TenGV.setText(list.getSelectionModel().getSelectedItem().getTenGV());
            txt_MaLop.setText(list.getSelectionModel().getSelectedItem().getMaLop());
            txt_SiSo.setText(String.valueOf(list.getSelectionModel().getSelectedItem().getSiSo()));
            txt_NgayBD.setValue(ngaybd);
            txt_NgayKT.setValue(ngaykt);
            txt_TenMon.setText(list.getSelectionModel().getSelectedItem().getTenMon());
            txt_SoTiet.setText(String.valueOf(list.getSelectionModel().getSelectedItem().getSoTiet()));

        });
    }

    public void KichHoatTrangThaiSua() {
        txt_MaLop.setDisable(IsSua);
        txt_TenGV.setDisable(IsSua);
        txt_TenMon.setDisable(IsSua);
        txt_SiSo.setDisable(IsSua);
        txt_NgayBD.setDisable(IsSua);
        txt_NgayKT.setDisable(IsSua);
        txt_SoTiet.setDisable(IsSua);
    }

}
