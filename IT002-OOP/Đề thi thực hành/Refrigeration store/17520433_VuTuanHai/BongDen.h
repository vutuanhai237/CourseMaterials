#pragma once
#include "ChiTiet.h"
class BongDen: public ChiTiet
{
protected:
	int kich_thuoc;
	
public:
	void Nhap();
	void Xuat();
	BongDen();
	~BongDen();
};

