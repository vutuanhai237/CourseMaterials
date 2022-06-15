#include "B.h"



B::B()
{
	loai = 3;
	if (rh)
	{
		rhesus[0] = true;
		rhesus[1] = true;		
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = true;
		rhesus[5] = true;
		rhesus[6] = false;
		rhesus[7] = false;

	}
	else
	{
		rhesus[0] = true;
		rhesus[1] = false;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = true;
		rhesus[5] = false;
		rhesus[6] = false;
		rhesus[7] = false;
	}
}
B::B(int _rh)
{
	rh = _rh;
	if (rh)
	{
		rhesus[0] = true;
		rhesus[1] = true;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = true;
		rhesus[5] = true;
		rhesus[6] = false;
		rhesus[7] = false;

	}
	else
	{
		rhesus[0] = true;
		rhesus[1] = false;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = true;
		rhesus[5] = false;
		rhesus[6] = false;
		rhesus[7] = false;
	}
}
bool B::KiemTraChaMe(Loai* Cha, Loai* Me)
{
	if ((Cha->getLoai() == 1 && Me->getLoai() == 3) || (Cha->getLoai() == 1 && Me->getLoai() == 4)) return true;
	if ((Cha->getLoai() == 2 && Me->getLoai() == 3) || (Cha->getLoai() == 2 && Me->getLoai() == 4)) return true;
	if (Cha->getLoai() == 3) return true;
	if (Cha->getLoai() == 4) return true;

	if ((Me->getLoai() == 1 && Cha->getLoai() == 3) || (Me->getLoai() == 1 && Cha->getLoai() == 4)) return true;
	if ((Me->getLoai() == 2 && Cha->getLoai() == 3) || (Me->getLoai() == 2 && Cha->getLoai() == 4)) return true;
	if (Me->getLoai() == 3) return true;
	if (Me->getLoai() == 4) return true;




}

B::~B()
{
}
