package Bai2;

import java.util.Scanner;

public class Time {
	int Gio;
	int Phut;
	int Giay;
	public Time()
	{
		this.Gio = 0;
		this.Phut = 0;
		this.Giay = 0;
	}
	public Time (int _Gio, int _Phut, int _Giay)
	{
		this.Giay = _Giay;
		this.Phut = _Phut;
		this.Gio = _Gio;
		
	}
	public void NhapThoiGian()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner (System.in);
		System.out.println("Nhap vao gio: "); this.Gio = NewScanner.nextInt();
		System.out.println("Nhap vao phut: "); this.Phut = NewScanner.nextInt();
		System.out.println("Nhap vao giay: "); this.Giay = NewScanner.nextInt();
		
	}
	public void XuatThoiGian()
	{
		System.out.println(this.Gio + ":" + this.Phut + ":" + this.Giay);
		
	}
	public void TangGiay1DonVi()
	{
		this.Giay++;
		if (this.Giay == 60)
		{
			this.Phut++;
			this.Giay = 0;
			if (this.Phut == 60)
			{
				this.Gio++;
				this.Phut = 0;
				if (this.Gio == 24)
				{
					this.Gio = 0;
				}
			}
		}
	}
	public Time clone ()
	{
		Time tmp = new Time(this.Gio, this.Phut, this.Giay);
		return tmp;
	}
	public int SoSanhThoiGian(Time t)
	{
		// Gio
		if (this.Gio > t.Gio)
		{
			return 1;			
		}
		else
		{
			if (this.Gio < t.Gio)
			{
				return -1;
			}
			else
			{
				// Gio bang nhau, so sanh phut
				if (this.Phut > t.Phut)
				{
					return 1;
					
				}
				else
				{
					if (this.Phut < t.Phut)
					{
						return -1;
					}
					else
					{
						// Gio phut bang nhau, so sanh giay
						if (this.Giay > t.Giay)
						{
							return 1;
							
						}
						else
						{
							if (this.Giay < t.Giay)
							{
								return -1;
							}
							else
							{
								return 0;
							}
						}
					}
				}
			}
		}
	}
}
