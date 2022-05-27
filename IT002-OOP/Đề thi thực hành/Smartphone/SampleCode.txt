##################################################
#### The below codes are copied from somebody ####
##################################################

#include <iostream>
#include <string>

using namespace std;

class Vo{
public:
    string maVo;
    string hang;
    string loai;
    double giaNhap;
    string mauSac;
    void setMaVo(string x){
        maVo = x;
    }
    void setHang(string x){
        hang = x;
    }
    void setGiaNhap(double x){
        giaNhap = x;
    }
    void setMauSac(int x){
        if(x == 1){
            mauSac = "Do";
        }
        else if(x == 2){
            mauSac = "Den";
        }
        else if(x == 3){
            mauSac = "Xanh";
        }
    }
    double getGiaNhap(){
        return giaNhap;
    }
    void print(){
        cout << "Vo smartphone: " << maVo << " " << loai << " " << hang << " " << mauSac << " " << giaNhap;
    }
};
class Nhom : public Vo{
public:
    Nhom(){
        loai = "Nhom";
        giaNhap = 400;
        hang = "Black";
    }
};
class Nhua : public Vo{
public:
    Nhua(){
        loai = "Nhua";
        giaNhap = 200;
        hang = "White";
    }
};

class CPU{
public:
    string ma;
    string loai;
    string hang;
    int soCore;
    double xungNhip;
    double giaNhap;
    void setMa(string x){
        ma = x;
    }
    double getGiaNhap(){
        return giaNhap;
    }
    void print(){
        cout << "CPU: " << ma << " " << loai << " " << hang << " " << soCore << " " << xungNhip << " " << giaNhap;
    }
};
class Alpha : public CPU{
public:
    Alpha(){
        loai = "Alpha";
        giaNhap = 200;
        soCore = 2;
        xungNhip = 1.8;
        hang = "Black";
    }
};
class Beta : public CPU{
public:
    Beta(){
        loai = "Beta";
        giaNhap = 400;
        soCore = 4;
        xungNhip = 2.46;
        hang = "Black";
    }
};
class Gamma : public CPU{
public:
    Gamma(){
        loai = "Gamma";
        giaNhap = 600;
        soCore = 4;
        xungNhip = 2.6;
        hang = "White";
    }
};

class ManHinh{
public:
    string ma;
    string hang;
    string doPhanGiai;
    double giaNhap;
    double kichThuoc;
    int chongLoa;
    ManHinh(){
        ma = hang = doPhanGiai = "";
        giaNhap = 0;
        kichThuoc = 4.7;
        chongLoa = 0;
    }
    void setMa(){
        cin.ignore(); cin >> ma;
    }
    void setHang(){
        cin.ignore();cin >> hang;
    }
    void setDoPhanGiai(int x){
        if(x == 1){
            doPhanGiai = "HD";
            giaNhap = 200;
        }
        else if(x == 2){
            doPhanGiai = "FullHD";
            cin >> chongLoa;
            if(chongLoa == 1) giaNhap = 500;
            else giaNhap = 300;
        }
    }
    void print(){
        cout << "Man hinh: " << ma << " " << hang << " " << doPhanGiai << " " << giaNhap;
        if(chongLoa == 1) cout << " Chong Loa";
    }
};

class SmartPhone{
public:
    string maSmartPhone;
    string ma;
    string dong;
    Vo* vo;
    CPU* cpu;
    ManHinh manHinh;
    double gia;
    SmartPhone(){
        maSmartPhone = "";
        ma = "";
        dong = "";
        vo = new Vo;
        cpu = new CPU;
    }
    void setMa(){
        cin.ignore();
        cin >> ma;
    }
    void print(){
        cout << "Smartphone: " << maSmartPhone << " " << dong << " " << TinhGia() << endl;
        cpu->print();
        cout << endl;
        manHinh.print();
        cout << endl;
        vo->print();
    }
    virtual void input(){}
    virtual double TinhGia() = 0;
};

class Venus : public SmartPhone{
public:
    Venus(){
        dong = "Venus";
    }
    void input(){
        cin.ignore(); cin >> maSmartPhone;
        int lc; cin >> lc;
        if(lc == 1) cpu = new Alpha;
        else if(lc == 2) cpu = new Beta;
        string tmp; 
        cin.ignore(); cin >> tmp;
        cpu->setMa(tmp);
        manHinh.setMa();
        manHinh.setHang();
        int n; cin >> n;
        manHinh.setDoPhanGiai(n);
        cin >> lc;
        if(lc == 1){
            vo = new Nhom;
        }
        else if(lc == 2){
            vo = new Nhua;
        }
        cin.ignore(); cin >> tmp;
        vo->setMaVo(tmp);
        cin >> lc;
        vo->setMauSac(lc);
    }
    double TinhGia(){
        return 1.3 * (vo->giaNhap + cpu->giaNhap + manHinh.giaNhap);
    }
};

class Mars : public SmartPhone{
public:
    Mars(){
        dong = "Mars";
    }
    void input(){
        cin.ignore(); cin >> maSmartPhone;
        int lc; cin >> lc;
        if(lc == 1) cpu = new Alpha;
        else if(lc == 2) cpu = new Beta;
        else if(lc == 3) cpu = new Gamma;
        string tmp; 
        cin.ignore(); cin >> tmp;
        cpu->setMa(tmp);
        manHinh.setMa();
        manHinh.setHang();
        manHinh.setDoPhanGiai(2);
        vo = new Nhom;
        cin.ignore(); cin >> tmp;
        vo->setMaVo(tmp);
        cin >> lc;
        vo->setMauSac(lc);
    }
    double TinhGia(){
        return 1.5 * (vo->giaNhap + cpu->giaNhap + manHinh.giaNhap);
    }
};

class Jupiter : public SmartPhone{
public:
    Jupiter(){
        dong = "Jupiter";
    }
    void input(){
        cin.ignore(); cin >> maSmartPhone;
        cpu = new Gamma;
        string tmp; cin.ignore(); cin >> tmp;
        cpu->setMa(tmp);
        manHinh.setMa();
        manHinh.setHang();
        manHinh.setDoPhanGiai(2);
        vo = new Nhom;
        cin.ignore(); cin >> tmp;
        vo->setMaVo(tmp);
        int lc; cin >> lc;
        vo->setMauSac(lc);
    }
    double TinhGia(){
        return 1.8 * (vo->giaNhap + cpu->giaNhap + manHinh.giaNhap);
    }
};

int main(){
    int n; cin >> n;
    SmartPhone** sp = new SmartPhone*[n];
    int dong;
    for(int i=0; i<n; i++){
        cin >> dong;
        if(dong == 1){
            sp[i] = new Venus;
        }
        else if(dong == 2){
            sp[i] = new Mars;
        }
        else if(dong == 3){
            sp[i] = new Jupiter;
        }
        sp[i]->input();
    }
    for(int i=0; i<n; i++){
        sp[i]->print();
    }
    return 0;
}