#include "AB.h"



AB::AB()
{
	loai = 4;
	if (rh)
	{
		rhesus[0] = true;
		rhesus[1] = true;
		rhesus[2] = true;
		rhesus[3] = true;
		rhesus[4] = true;
		rhesus[5] = true;
		rhesus[6] = true;
		rhesus[7] = true;

	}
	else
	{
		rhesus[0] = true;
		rhesus[1] = false;
		rhesus[2] = true;
		rhesus[3] = false;
		rhesus[4] = true;
		rhesus[5] = false;
		rhesus[6] = true;
		rhesus[7] = false;
	}
}

AB::AB(int _rh)
{
	rh = _rh;
	if (rh)
	{
		rhesus[0] = true;
		rhesus[1] = true;
		rhesus[2] = true;
		rhesus[3] = true;
		rhesus[4] = true;
		rhesus[5] = true;
		rhesus[6] = true;
		rhesus[7] = true;

	}
	else
	{
		rhesus[0] = true;
		rhesus[1] = false;
		rhesus[2] = true;
		rhesus[3] = false;
		rhesus[4] = true;
		rhesus[5] = false;
		rhesus[6] = true;
		rhesus[7] = false;
	}
}

bool AB::KiemTraChaMe(Loai* Cha, Loai* Me)
{
	if (Cha->getLoai() == 1) return false;
	if ((Cha->getLoai() == 2 && Me->getLoai() == 3) || (Cha->getLoai() == 2 && Me->getLoai() == 4)) return true;
	if ((Cha->getLoai() == 3 && Me->getLoai() == 2) || (Cha->getLoai() == 3 && Me->getLoai() == 4)) return true;
	if ((Cha->getLoai() == 4 && Me->getLoai() == 2) || (Cha->getLoai() == 4 && Me->getLoai() == 3) || (Cha->getLoai() == 4 && Me->getLoai() == 4)) return true;

	if (Me->getLoai() == 1) return false;
	if ((Me->getLoai() == 2 && Cha->getLoai() == 3) || (Me->getLoai() == 2 && Cha->getLoai() == 4)) return true;
	if ((Me->getLoai() == 3 && Cha->getLoai() == 2) || (Me->getLoai() == 3 && Cha->getLoai() == 4)) return true;
	if ((Me->getLoai() == 4 && Cha->getLoai() == 2) || (Me->getLoai() == 4 && Cha->getLoai() == 3) || (Me->getLoai() == 4 && Cha->getLoai() == 4)) return true;





	return false;
	return false;
}



AB::~AB()
{
}
