#include <iostream>
#include "gate.h"
#include "business_gate.h"
#include "academic_gate.h"
#include "power_gate.h"

using namespace std;
int main()
{
	cout << "1. Cong giao thuong" << endl;
	cout << "2. Cong hoc thuat" << endl;
	cout << "3. Cong suc manh" << endl;
	cout << "Nhap so luong cong: "; int SoLuong; cin >> SoLuong;
	gate *arrGate[1000];


	//Cau a
	for (int i = 0; i < SoLuong; i++)
	{
		cout << "Nhap loai cong (1,2 hoac 3): ";
		int type; cin >> type;
		if (type == 1) arrGate[i] = new business_gate();
		if (type == 2) arrGate[i] = new academic_gate();
		if (type == 3) arrGate[i] = new power_gate();
		arrGate[i]->Nhap();
	}
	// Cau b
	int SoTien, TriTue, SucManh;
	cout << "[Nhap thong so cua Hoang Tu]" << endl;
	cout << "--> Nhap so tien: "; cin >> SoTien;
	cout << "--> Nhap chi so tri tue: "; cin >> TriTue;
	cout << "--> Nhap chi so suc manh: "; cin >> SucManh;
	int i = 0;
	while (SoTien > 0 && TriTue > 0 && SucManh > 0 && i < SoLuong)
	{
		if (arrGate[i]->GetLoai() == 1)
		{
			SoTien -= arrGate[i]->TraVe();
			if (SoTien < 0)
			{
				cout << "Hoang tu da sml o cong " << i + 1;

				break;
			}
			else
			{
				cout << "- Hoang tu da vuot qua cong giao thuong [" << i + 1 << "]" << endl;
				
			}
		}
		if (arrGate[i]->GetLoai() == 2)
		{

			if (arrGate[i]->TraVe() > TriTue)
			{
				cout << "Hoang tu da sml o cong " << i + 1;

				break;
			}
			else
			{
				cout << "- Hoang tu da vuot qua cong tri tue [" << i + 1 << "]" << endl;
				
			}
		}
		if (arrGate[i]->GetLoai() == 3)
		{
			SucManh -= arrGate[i]->TraVe();
			if (SucManh < 0)
			{
				cout << "Hoang tu da sml o cong " << i + 1;
				break;
			}
			else
			{
				cout << "- Hoang tu da vuot qua cong suc manh [" << i + 1 << "]" << endl;
				
			}
		}
		if (i == SoLuong - 1)
		{
			cout << "Hoang tu da giai cuu duoc cong chua !!!" << endl;
			
			break;
		}
		cout << "Thong so hien tai [" << SoTien << ", " << TriTue << ", " << SucManh << "]" << endl;

		i++;
	}

	system("pause");
	return 0;
}