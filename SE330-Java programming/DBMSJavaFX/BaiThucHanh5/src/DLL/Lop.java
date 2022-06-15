/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Admin
 */
public class Lop {

    private StringProperty STT = new SimpleStringProperty("");
    private StringProperty TenGV = new SimpleStringProperty("");
    private StringProperty MaLop = new SimpleStringProperty("");
    private StringProperty TenMon = new SimpleStringProperty("");
    private int SiSo;
    private StringProperty NgayBD = new SimpleStringProperty("");
    private StringProperty NgayKT = new SimpleStringProperty("");
    private int SoTiet;

    public Lop(String _STT, String _TenGV, String _MaLop, String _TenMon, int _SiSo, String _NgayBD, String _NgayKT, int _SoTiet) {
        this.STT = new SimpleStringProperty(_STT);
        this.TenGV = new SimpleStringProperty(_TenGV);
        this.MaLop = new SimpleStringProperty(_MaLop);
        this.TenMon = new SimpleStringProperty(_TenMon);
        this.SiSo = _SiSo;
        this.NgayBD = new SimpleStringProperty(_NgayBD);
        this.NgayKT = new SimpleStringProperty(_NgayKT);
        this.SoTiet = _SoTiet;

    }

    public String getSTT() {
        return STT.get();
    }

    public String getTenGV() {
        return TenGV.get();
    }

    public String getMaLop() {
        return MaLop.get();
    }

    public String getTenMon() {
        return TenMon.get();
    }

    public int getSiSo() {
        return SiSo;
    }

    public String getNgayBD() {
        return NgayBD.get();
    }
    
    public String getNgayKT() {
        return NgayKT.get();
    }
     public int getSoTiet() {
        return SoTiet;
    }
    
}
