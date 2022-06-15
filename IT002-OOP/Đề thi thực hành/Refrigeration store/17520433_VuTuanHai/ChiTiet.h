#pragma once
#include <string>
#include <iostream>
using namespace std;
class ChiTiet
{
protected:
	string ma;
	string ten;
	string nsx;
	int gia;
	int loai;
	int so_luong_ban;
public:
	virtual void Nhap();
	virtual void Xuat();
	int getGia()
	{
		return gia;
	}
	int getLoai()
	{
		return loai;
	}
	void setLoai(int a)
	{
		loai = a;
	}
	void setSoluongBan(int a)
	{
		so_luong_ban = a;
	}
	int getSoluongBan()
	{
		return so_luong_ban;
	}
	ChiTiet();
	~ChiTiet();
};

