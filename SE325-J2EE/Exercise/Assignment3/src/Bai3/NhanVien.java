package Bai3;

import java.util.Scanner;

public class NhanVien extends Person{
	double LuongCoBan;
	double HeSoLuong;
	public NhanVien()
	{
		super();
		this.LuongCoBan = 0;
		this.HeSoLuong = 0;
	}
	public NhanVien(String _HoTen, String _DiaChi, int _Tuoi, double _LuongCoBan, double _HeSoLuong)
	{
		super(_HoTen, _DiaChi, _Tuoi);
		this.LuongCoBan = _LuongCoBan;
		this.HeSoLuong = _HeSoLuong;
	}
	public void NhapThongTin()
	{
		super.NhapThongTin();
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap luong co ban: "); this.LuongCoBan = NewScanner.nextDouble();
		System.out.println("Nhap he so luong: "); this.HeSoLuong = NewScanner.nextDouble();
	}
	public void XuatThongTin()
	{
		super.XuatThongTin();
		System.out.println("Luong co ban: " + this.LuongCoBan);
		System.out.println("He so luong: " + this.HeSoLuong);
		
	}
	public double GetLuong()
	{
		return this.LuongCoBan*this.HeSoLuong;
	}
}
