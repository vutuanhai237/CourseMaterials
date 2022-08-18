#pragma once
#include "gate.h"
#include <iostream>
using namespace std;
class power_gate : public gate
{
protected:
	int suc_manh;
public:
	power_gate();

	~power_gate();
	void Nhap()
	{
		cout << "--> Nhap suc manh dung si: "; cin >> suc_manh;
	}
	int TraVe()
	{
		return suc_manh;
	}
};

