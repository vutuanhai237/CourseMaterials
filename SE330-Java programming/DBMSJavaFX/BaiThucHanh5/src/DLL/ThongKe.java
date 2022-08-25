
package DLL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThongKe {
    private StringProperty TenGV2 = new SimpleStringProperty("");
    private StringProperty TongSoLop = new SimpleStringProperty("");
    private StringProperty TongSoTiet = new SimpleStringProperty("");
    private StringProperty DatChuan = new SimpleStringProperty("");
  

    public ThongKe(String _TenGV2, String _TongSoLop, String _TongSoTiet, String _DatChuan) {
        this.TenGV2 = new SimpleStringProperty(_TenGV2);
        this.TongSoLop = new SimpleStringProperty(_TongSoLop);
        this.TongSoTiet = new SimpleStringProperty(_TongSoTiet);
        this.DatChuan = new SimpleStringProperty(_DatChuan);
       
    }

    public String getTenGV2() {
        return TenGV2.get();
    }

    public void setTenGV(String _TenGV) {
        TenGV2.set(_TenGV);
    }

    public StringProperty TenGV2Property() {
        return TenGV2;
    }

    // tônso
    public String getTongSoLop() {
        return TongSoLop.get();
    }

    public void setTongSoLop(String _TongSoLop) {
        TongSoLop.set(_TongSoLop);
    }

    public StringProperty TongSoLopProperty() {
        return TongSoLop;
    }

    // tong so tiet
    public String getTongSoTiet() {
        return TongSoTiet.get();
    }

    public void setTongSoTiet(String _TongSoTiet) {
        TongSoTiet.set(_TongSoTiet);
    }

    public StringProperty TongSoTietProperty() {
        return TongSoTiet;
    }

    public String getDatChuan() {
        return DatChuan.get();
    }

    public void setSiSo(String _DatChuan) {
        DatChuan.set(_DatChuan);
    }

    public StringProperty DatChuanProperty() {
        return DatChuan;
    }
}
