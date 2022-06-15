#include "MayQuatHoiNuoc.h"


MayQuatHoiNuoc::MayQuatHoiNuoc()
{
}
void MayQuatHoiNuoc::Nhap()
{
	MayQuat::Nhap();
	cout << "\t\t\t\tDung tich nuoc toi da: ";
	cin >> dung_tich;
}
void MayQuatHoiNuoc::Xuat()
{
	cout << "\t\tMay quat: " << ma << " may quat dung " << ten << " " << nsx << " " << gia << " " << dung_tich << " " << so_luong_ban << endl;

}

MayQuatHoiNuoc::~MayQuatHoiNuoc()
{
}
