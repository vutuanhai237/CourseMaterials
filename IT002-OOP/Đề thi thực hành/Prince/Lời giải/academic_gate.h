#pragma once
#include "gate.h"
#include <iostream>
using namespace std;
class academic_gate : public gate
{
protected:
	int tri_tue;
public:
	academic_gate();
	~academic_gate();
	void Nhap()
	{
		cout << "--> Nhap tri tue cua nha hien triet: "; cin >> tri_tue;
	}
	int TraVe()
	{
		return tri_tue;
	}
};

