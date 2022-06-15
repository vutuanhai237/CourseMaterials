#include "O.h"
#include "A.h"
#include "B.h"
#include "AB.h"
using namespace std;
int main()
{
	int n;

	// YC 1
	cout << "Nhap so luong nguoi: ";
	cin >> n;
	Loai *nhommau[100];
	for (int i = 0; i < n;i++)
	{

		int temp;
		cout << "Nhap nhom mau (1. O, 2. A, 3. B, 4. AB): ";
		cin >> temp;
		int rh;
		cout << "Nhap loai Rh (1. rh+, 0. rh-): ";
		cin >> rh;

		switch (temp) {
		case 1:
			nhommau[i] = new O(rh);
			nhommau[i]->setLoai(1);

			break;
		case 2:
			nhommau[i] = new A(rh);
			nhommau[i]->setLoai(2);

			break;
		case 3:
			nhommau[i] = new B(rh);
			nhommau[i]->setLoai(3);

			break;
		case 4:
			nhommau[i] = new AB(rh);
			nhommau[i]->setLoai(4);

			break;
		default:
			break;
		}
	}

	// YC 2
	int sbd[3];
	cout << "Nhap so bao danh cua cha: ";
	cin >> sbd[0];
	cout << "Nhap so bao danh cua me: ";
	cin >> sbd[1];
	cout << "Nhap so bao danh cua con: ";
	cin >> sbd[2];

	if (nhommau[sbd[2]]->KiemTraChaMe(nhommau[sbd[0]], nhommau[sbd[1]])) {
		cout << "Con dung la con cua cha me" << endl;
	}
	else {
		cout << "Con khong phai la con cua cha me" << endl;
	}


	// YC3
	int temp;
	cout << "Chon mot nguoi trong danh sach: ";
	cin >> temp;
	for (int i = 0; i < n; i++)
	{
		if (i != temp) {
			if (nhommau[temp]->rhesus[(nhommau[i]->getIndexRheus())])
			{
				cout << "Nguoi thu " << i << " ";
			}
		}
	

	}
	cout << " co nhom mau thich hop";
	cout << endl;

	system("pause");
	return 0;
}