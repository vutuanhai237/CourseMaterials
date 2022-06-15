#include "Loai.h"

using namespace std;

Loai::Loai()
{
	rh = true;
	loai = 0;
}

Loai::Loai(const bool &_rh)
{
	rh = _rh;
}

Loai::Loai(const int &_loai)
{
	loai = _loai;
}

int Loai::getIndexRheus()
{
	if (this->loai == 1) {
		if (this->rh == false) {
			return 0;
		}
		else return 1;
	}
	if (this->loai == 2) {
		if (this->rh == false) {
			return 2;
		}
		else return 3;
	}
	if (this->loai == 3) {
		if (this->rh == false) {
			return 4;
		}
		else return 5;
	}
	if (this->loai == 4) {
		if (this->rh == false) {
			return 6;
		}
		else return 7;
	}
}

void Loai::NhapRH()
{
	int temp;
	cout << "Nhap loai Rh (1. rh+, 0. rh-): ";

	cin >> temp;
	if (temp == 0) { rh = false; }
	if (temp == 1) { rh = true; }
}

bool Loai::KiemTraChaMe(Loai* Cha, Loai* Me)
{
	return true;
}

Loai::~Loai()
{
	/*if (rhesus)
	{
		delete []rhesus;
	}*/
}
