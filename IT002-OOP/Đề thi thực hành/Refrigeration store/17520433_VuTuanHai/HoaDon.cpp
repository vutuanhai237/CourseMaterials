#include "HoaDon.h"


HoaDon::HoaDon()
{
}

void HoaDon::Nhap()
{
	
	cout << "\tMa hoa don:"; 
	//cin.ignore();
	std::fflush(stdin);
	getline(cin, ma);
	
	cout << "\tNgay lap hoa don:"; 
	//cin.ignore(); 
	std::fflush(stdin);
	getline(cin, ngay);
	cout << "\tThong tin khach hang:" << endl;
	kh.Nhap();
	cout << "\tNhap danh sach cac chi tiet hoa don:" << endl;
	cout << "\t\tSo luong chi tiet trong danh sach cac chi tiet hoa don:"; cin >> so_chi_tiet;
	ct = new ChiTiet*[so_chi_tiet];
	for (int i = 0; i < so_chi_tiet; i++)
	{
		cout << "\t\tNhap chi tiet hoa don thu " << i + 1 << endl;
		cout << "\t\t\tChon loai thiet bi dien (1- May Quat, 2 - Bong Dien, 3 - May Lanh):";
		int x; cin >> x;
		if (x == 1)
		{
			cout << "\t\t\t\tChon loai may quat ( 1- May quat dung, 2 - May quat hop, 3 - May Quat hoi nuoc, 4 - May Quat sac dien): ";
			int y; cin >> y;
			if (y == 1)
			{
				ct[i] = new MayQuatDung();
				ct[i]->setLoai(1);
			}
			if (y == 2)
			{
				ct[i] = new MayQuatHop();
				ct[i]->setLoai(2);
			}
			if (y == 3)
			{
				ct[i] = new MayQuatHoiNuoc();
				ct[i]->setLoai(3);
			}
			if (y == 4)
			{
				ct[i] = new MayQuatSacDien();
				ct[i]->setLoai(4);
			}
			ct[i]->Nhap();
		}
		if (x == 2)
		{
			cout << "\t\t\t\tChon loai bong den (1 - Bong den dai, 2 - Bong den tron): ";
			ct[i] = new BongDen();
			int z; cin >> z;
			if (z == 1) ct[i]->setLoai(1);
			if (z == 2) ct[i]->setLoai(2);
			ct[i]->Nhap();
		}
		if (x == 3)
		{
			cout << "\t\t\t\tChon loai may quat ( 1- May lanh 1 chieu, 2 - May lanh 2 chieu): ";
			int t; cin >> t;
			if (t == 1)
			{
				ct[i] = new MayLanh1chieu();
				ct[i]->setLoai(1);
			}
			if (t == 2)
			{
				ct[i] = new MayLanh2chieu();
				ct[i]->setLoai(2);
			}
		
			ct[i]->Nhap();

		}
		cout << "\t\t\tSo luong ban ra: "; int q; cin >> q;
		ct[i]->setSoluongBan(q);
	}
	this->CapNhapGia();
}
void HoaDon::Xuat()
{
	cout << "Hoa don: " << ma << " " << ngay << " " << gia << endl;
	kh.Xuat();
	cout << "\tDanh sach cac chi tiet hoa don: " << endl;
	for (int i = 0; i < so_chi_tiet; i++)
	{
		ct[i]->Xuat();
	}

}
HoaDon::~HoaDon()
{
}
