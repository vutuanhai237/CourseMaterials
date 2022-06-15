#pragma once
#include "MayQuat.h"
class MayQuatSacDien: public MayQuat
{
protected:
	int dung_luong;
public:
	void Nhap();
	void Xuat();
	MayQuatSacDien();
	~MayQuatSacDien();
};

