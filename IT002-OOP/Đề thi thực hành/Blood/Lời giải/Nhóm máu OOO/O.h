#pragma once
#include"Loai.h"
class O: public Loai
{
public:
	O();
	O(int _rh);
	bool KiemTraChaMe(Loai* Cha, Loai* Me);
	~O();
};

