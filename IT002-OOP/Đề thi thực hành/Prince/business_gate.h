#pragma once
#include "gate.h"
#include <iostream>
using namespace std;
class business_gate : public gate
{
protected:
	int don_gia;
	int so_hang;
public:
	business_gate();

	~business_gate();
	void Nhap()
	{
		cout << "--> Nhap don gia: "; cin >> don_gia;
		cout << "--> Nhap so luong hang: "; cin >> so_hang;
	}
	int TraVe()
	{
		return don_gia * so_hang;
	}
};

