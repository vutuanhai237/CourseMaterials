#include "MayLanh1chieu.h"


MayLanh1chieu::MayLanh1chieu()
{
}
void MayLanh1chieu::Nhap()
{
	MayLanh::Nhap();
	
	
}
void MayLanh1chieu::Xuat()
{
	cout << "\t\tMay quat: " << ma << " 1 chieu " << ten << nsx << " " << gia << " ";
	if (ho_tro_inverter == true)
	{
		cout << "ho tro inverter ";
	}
	else
	{
		cout << "khong ho tro inverter ";
	}
	cout << so_luong_ban << endl;
}
MayLanh1chieu::~MayLanh1chieu()
{
}
