#pragma once
#include <iostream>
#include <string>
#include "MayLanh.h"
#include "MayQuat.h"
#include "MayQuatHoiNuoc.h"
#include "MayQuatHop.h"
#include "MayQuatSacDien.h"
#include "MayLanh1chieu.h"
#include "MayLanh2chieu.h"
#include "KhachHang.h"
#include "BongDen.h"
#include "MayQuatDung.h"
using namespace std;
class HoaDon
{
protected:
	string ma;
	ChiTiet **ct;
	int so_chi_tiet;
	int gia;
	string ngay;
	KhachHang kh;
public:
	void Nhap();
	void Xuat();
	void CapNhapGia()
	{
		gia = 0;
		for (int i = 0; i < so_chi_tiet; i++)
		{
			
			gia += ct[i]->getGia()*ct[i]->getSoluongBan();
		}
	}
	HoaDon();
	~HoaDon();
};

