#pragma once
#include <string>
using namespace std;
class KhachHang
{
protected:
	string ma;
	string ten;
	string sdt;
	string diachi;
public:
	void Nhap();
	void Xuat();
	KhachHang();
	~KhachHang();
};

