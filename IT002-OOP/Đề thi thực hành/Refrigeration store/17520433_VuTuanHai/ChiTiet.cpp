#include "ChiTiet.h"


ChiTiet::ChiTiet()
{
}
void ChiTiet::Nhap()
{
	cout << "\t\t\t\tNhap ma:";
	//cin.ignore();
	std::fflush(stdin);
	getline(cin, ma);
	cout << "\t\t\t\tTen san pham:";
	//cin.ignore();
	std::fflush(stdin);
	getline(cin, ten);
	cout << "\t\t\t\tNoi san xuat:";
	//cin.ignore();
	std::fflush(stdin);
	getline(cin, nsx);
	cout << "\t\t\t\tGia tien:";
	cin >> gia;
}
void ChiTiet::Xuat()
{

}
ChiTiet::~ChiTiet()
{

}
