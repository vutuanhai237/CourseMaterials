#include "MayLanh.h"


MayLanh::MayLanh()
{
}
void MayLanh::Nhap()
{
	ChiTiet::Nhap();
	cout << "\t\t\t\tCo ho tro cong nghe Inverter hay khong (1 - co, 2 - khong): ";
	int x; cin >> x;
	if (x == 1) ho_tro_inverter = true;
	else
		ho_tro_inverter = false;
}
void MayLanh::Xuat()
{

}
MayLanh::~MayLanh()
{
}
