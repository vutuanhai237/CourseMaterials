#include "MayLanh2chieu.h"


MayLanh2chieu::MayLanh2chieu()
{
}

void MayLanh2chieu::Nhap()
{
	MayLanh::Nhap();
	cout << "\t\t\t\tCo ho tro cong nghe khu mui hay khong (1 - co, 2 - khong): ";
	int x; cin >> x;
	if (x == 1) ho_tro_khu_mui = true;
	else
		ho_tro_khu_mui = false;
	cout << "\t\t\t\tCo ho tro cong nghe khang khuan hay khong (1 - co, 2 - khong): ";
	int y; cin >> y;
	if (y == 1) ho_tro_khang_khuan = true;
	else
		ho_tro_khang_khuan = false;
}
void MayLanh2chieu::Xuat()
{
	cout << "\t\tMay quat: " << ma << " 2 chieu " << ten << nsx << " " << gia << " ";
	if (ho_tro_inverter == true)
	{
		cout << "ho tro inverter ";
	}
	else
	{
		cout << "khong ho tro inverter ";
	}
	if (ho_tro_khu_mui == true)
	{
		cout << "ho tro khu mui ";
	}
	else
	{
		cout << "khong ho tro khu mui ";
	}
	if (ho_tro_khang_khuan == true)
	{
		cout << "ho tro khang khuan ";
	}
	else
	{
		cout << "khong ho tro khang khuan ";
	}
	cout << so_luong_ban << endl;
}
MayLanh2chieu::~MayLanh2chieu()
{
}
