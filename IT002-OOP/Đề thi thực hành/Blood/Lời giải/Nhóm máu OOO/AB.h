#pragma once

#include"Loai.h"
class AB: public Loai
{
public:
	AB();
	AB(int _rh);
	bool KiemTraChaMe(Loai* Cha, Loai* Me);
	~AB();
};

