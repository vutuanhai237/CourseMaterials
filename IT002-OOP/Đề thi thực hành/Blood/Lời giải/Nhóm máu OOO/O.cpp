#include "O.h"



O::O()
{
	loai = 1;
	if (rh == true)
	{
		rhesus[0] = true;
		rhesus[1] = true;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = false;
		rhesus[5] = false;
		rhesus[6] = false;
		rhesus[7] = false;

	}
	else
	{
		rhesus[0] = true;
		rhesus[1] = false;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = false;
		rhesus[5] = false;
		rhesus[6] = false;
		rhesus[7] = false;
	}
}

O::O(int _rh)
{
	loai = 1;
	rh = _rh;
	if (rh == true)
	{
		rhesus[0] = true;
		rhesus[1] = true;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = false;
		rhesus[5] = false;
		rhesus[6] = false;
		rhesus[7] = false;

	}
	else
	{
		rhesus[0] = true;
		rhesus[1] = false;
		rhesus[2] = false;
		rhesus[3] = false;
		rhesus[4] = false;
		rhesus[5] = false;
		rhesus[6] = false;
		rhesus[7] = false;
	}
}

bool O::KiemTraChaMe(Loai* Cha, Loai* Me)
{
	if ((Cha->getLoai() == 1 && Me->getLoai() == 1) || (Cha->getLoai() == 1 && Me->getLoai() == 2) || (Cha->getLoai() == 1 && Me->getLoai() == 4)) return true;
	if ((Cha->getLoai() == 2 && Me->getLoai() == 1) || (Cha->getLoai() == 2 && Me->getLoai() == 2) || (Cha->getLoai() == 2 && Me->getLoai() == 4)) return true;
	if ((Cha->getLoai() == 3 && Me->getLoai() == 1) || (Cha->getLoai() == 3 && Me->getLoai() == 2) || (Cha->getLoai() == 3 && Me->getLoai() == 4)) return true;
	if (Cha->getLoai() == 4) return false;
	
	if ((Me->getLoai() == 1 && Cha->getLoai() == 1) || (Me->getLoai() == 1 && Cha->getLoai() == 2) || (Me->getLoai() == 1 && Cha->getLoai() == 4)) return true;
	if ((Me->getLoai() == 2 && Cha->getLoai() == 1) || (Me->getLoai() == 2 && Cha->getLoai() == 2) || (Me->getLoai() == 2 && Cha->getLoai() == 4)) return true;
	if ((Me->getLoai() == 3 && Cha->getLoai() == 1) || (Me->getLoai() == 3 && Cha->getLoai() == 2) || (Me->getLoai() == 3 && Cha->getLoai() == 4)) return true;
	if (Me->getLoai() == 4) return false;




}

O::~O()
{
}
