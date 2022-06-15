#pragma once
#include "MayLanh.h"
class MayLanh2chieu: public MayLanh
{
protected:
	bool ho_tro_khu_mui;
	bool ho_tro_khang_khuan;
public:
	void Nhap();
	void Xuat();
	MayLanh2chieu();
	~MayLanh2chieu();
};

