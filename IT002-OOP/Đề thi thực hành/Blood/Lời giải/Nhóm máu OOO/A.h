#pragma once
#include"Loai.h"
class A: public Loai
{

public:
	A();
	A(int _rh);
	bool KiemTraChaMe(Loai* Cha, Loai* Me);
	~A();
};

