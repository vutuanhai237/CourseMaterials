package Bai9;

import java.util.Scanner;

class NhanVien extends Person{
	public String TenDonVi;
	public  NhanVien()
	{
		super();
		this.TenDonVi = "";
	}
	public String GetTenDonVi()
	{
		return this.TenDonVi;
	}
	public  NhanVien(String _HoTen, String _NgaySinh, double _HeSoLuong, String _TenDonVi)
	{
		super();
		this.TenDonVi = _TenDonVi;
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		super.Nhap();
		System.out.println("Nhap ten don vi: "); this.TenDonVi = NewScanner.nextLine();
	}
	public void Xuat()
	{
		super.Xuat();
		System.out.println("Ten don vi: " + this.TenDonVi);
	}
	@Override
	public double GetLuong() {
		// TODO Auto-generated method stub
		return this.HeSoLuong * 1200000;
	}

}
