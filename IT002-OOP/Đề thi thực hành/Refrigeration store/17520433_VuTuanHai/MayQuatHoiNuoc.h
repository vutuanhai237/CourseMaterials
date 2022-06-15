#pragma once
#include "MayQuat.h"
class MayQuatHoiNuoc: public MayQuat
{
protected:
	int dung_tich;
public:
	void Nhap();
	void Xuat();
	MayQuatHoiNuoc();
	~MayQuatHoiNuoc();
};

