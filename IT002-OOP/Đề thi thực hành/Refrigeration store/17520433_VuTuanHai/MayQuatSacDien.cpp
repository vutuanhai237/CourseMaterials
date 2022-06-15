#include "MayQuatSacDien.h"


MayQuatSacDien::MayQuatSacDien()
{
}
void MayQuatSacDien::Nhap()
{
	MayQuat::Nhap();
	cout << "\t\t\t\tDung luong pin toi da: ";
	cin >> gia;
}
void MayQuatSacDien::Xuat()
{
	cout << "\t\tMay quat: " << ma << " may quat dung " << ten << " " << nsx << " " << gia << " " << dung_luong << " " << so_luong_ban << endl;

}

MayQuatSacDien::~MayQuatSacDien()
{
}
