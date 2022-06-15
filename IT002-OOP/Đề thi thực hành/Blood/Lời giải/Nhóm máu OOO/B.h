#pragma once

#include"Loai.h"
class B: public Loai
{
public:
	B();
	B(int _rh);
	bool KiemTraChaMe(Loai* Cha, Loai* Me);
	~B();
};

