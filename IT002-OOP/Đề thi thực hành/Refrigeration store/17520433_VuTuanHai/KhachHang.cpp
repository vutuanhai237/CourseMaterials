#include "KhachHang.h"
#include <iostream>
using namespace std;
KhachHang::KhachHang()
{
}

void KhachHang::Nhap()
{
	cout << "\t\tMa khach hang: ";
	//cin.ignore();
	std::fflush(stdin);
	getline(cin, ma);
	cout << "\t\tTen khach hang: ";
	std::fflush(stdin);
	//cin.ignore();
	getline(cin, ten);
	cout << "\t\tDia chi: ";
	//cin.ignore();
	std::fflush(stdin);
	getline(cin, diachi);
	cout << "\t\tSo dien thoai: ";
	std::fflush(stdin);
	//cin.ignore();
	getline(cin, sdt);
}
void KhachHang::Xuat()
{
	cout << "\tThong tin khach hang: " << ma << " " << ten << " " << diachi << " " << sdt << endl;
}
KhachHang::~KhachHang()
{
}
