#pragma once
#include <iostream>
class Loai
{
public:
	int loai;
	bool rh;
	bool rhesus[8];

	Loai();
	Loai(const int &_loai);
	Loai(const bool &_rh);

	void setLoai(const int &_loai) { loai = _loai; };
	int getLoai() { return loai; };

	void setRH(const int &_rh) { rh = _rh; };

	int getRH() { return rh; };

	bool getRhesus(int index) { return rhesus[index]; }
	int getIndexRheus();
	void setRhesus(bool value, int index) { rhesus[index] = value; }

	virtual void NhapRH();
	virtual bool KiemTraChaMe(Loai* Cha, Loai* Me);
	~Loai();
};

