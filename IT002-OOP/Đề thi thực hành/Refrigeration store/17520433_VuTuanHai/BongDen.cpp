#include "BongDen.h"


BongDen::BongDen()
{
}
void BongDen::Nhap()
{
	ChiTiet::Nhap();
	cout << "\t\t\t\tKich thuoc (chieu dai hoac ban kinh): ";
	cin >>kich_thuoc;
}
void BongDen::Xuat()
{
	cout << "\t\tBong den: " << ma << " ";
	if (loai == 1)
	{
		cout << "bong den dai ";
	}
	else
	{
		cout << "bong den tron ";
	}
	cout << ten << " " << nsx << " " << gia << " " << so_luong_ban << endl;
}
BongDen::~BongDen()
{
}
