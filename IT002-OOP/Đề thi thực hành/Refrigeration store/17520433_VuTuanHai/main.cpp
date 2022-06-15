#include <iostream>
#include "HoaDon.h"
using namespace std;
int main()
{
	cout << "So luong hoa don muon nhap: ";
	
	int n; cin >> n;
	HoaDon *a = new HoaDon[n];
	for (int i = 0; i < n; i++)
	{
		cout << "Nhap thong tin hoa don " << i + 1 <<": "<< endl;
		cin.ignore();
		a[i].Nhap();
	}
	for (int i = 0; i < n; i++)
	{
		
		a[i].Xuat();
	}

	system("pause");
	return 0;
}