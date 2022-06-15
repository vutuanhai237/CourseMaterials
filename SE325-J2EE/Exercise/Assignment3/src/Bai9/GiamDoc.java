package Bai9;

import java.util.Scanner;

public class GiamDoc extends Person {
	double HeSoChucVu;
	public GiamDoc()
	{
		super();
		this.HeSoChucVu = 0;
	}
	public GiamDoc(String _HoTen, String _NgaySinh, double _HeSoLuong, double _HeSoChucVu)
	{
		super();
		this.HeSoChucVu = _HeSoChucVu;
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		super.Nhap();
		System.out.println("Nhap he so chuc vu: "); this.HeSoChucVu = NewScanner.nextDouble();
	}
	public void Xuat()
	{
		super.Xuat();
		System.out.println("He so chuc vu: " + this.HeSoChucVu);
	}
	@Override
	public double GetLuong() {
		// TODO Auto-generated method stub
		return (this.HeSoChucVu + this.HeSoLuong) * 1200000;
	}
}
