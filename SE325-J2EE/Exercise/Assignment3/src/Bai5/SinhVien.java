package Bai5;

import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class SinhVien implements Comparable {
	String HoTen;
	double DiemTrungBinh;
	SinhVien()
	{
		this.HoTen = "";
		this.DiemTrungBinh = 0;
	}
	SinhVien(String _HoTen, double _DiemTrungBinh)
	{
		this.HoTen = _HoTen;
		this.DiemTrungBinh = _DiemTrungBinh;
	}
	public void NhapThongTin ()
	{
		
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		
		System.out.println("Nhap ho ten: "); this.HoTen = NewScanner.nextLine();
		System.out.println("Nhap diem trung bihn: "); this.DiemTrungBinh = NewScanner.nextDouble();
		
	}
	public void XuatThongTin ()
	{
		
		System.out.println("Ho ten: " + this.HoTen + ", diem trung binh: " + this.DiemTrungBinh); 
	
	}
	@Override
	public int compareTo(Object arg0) {
		SinhVien Tmp = (SinhVien) arg0;
		
		if (this.DiemTrungBinh > Tmp.DiemTrungBinh)
		{
			return 1;
		}
		else
		{
			if (this.DiemTrungBinh < Tmp.DiemTrungBinh)
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
