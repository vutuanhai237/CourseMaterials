#pragma once
class gate
{
protected:
	int loai;
public:
	gate();
	~gate();
	virtual void Nhap() = 0;
	virtual int TraVe() = 0;
	int GetLoai()
	{
		return loai;
	}
};

