#pragma once
#include "ChiTiet.h"
class MayLanh: public ChiTiet
{
protected:
	bool ho_tro_inverter;
public:
	void Nhap();
	void Xuat();
	MayLanh();
	~MayLanh();
};

