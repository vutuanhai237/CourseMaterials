package Bai9;

import java.util.Scanner;

public class QuanLy extends Person{
	int SoLuongNhanVienQL;
	public  QuanLy()
	{
		super();
		this.SoLuongNhanVienQL = 0;
	}
	public QuanLy(String _HoTen, String _NgaySinh, double _HeSoLuong, int _SoLuongNhanVienQL)
	{
		super();
		this.SoLuongNhanVienQL = _SoLuongNhanVienQL;
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		super.Nhap();
		System.out.println("Nhap so luong nhan vien quan ly: "); this.SoLuongNhanVienQL = NewScanner.nextInt();
	}
	public void Xuat()
	{
		super.Xuat();
		System.out.println("So luong nhan vien quan ly: " + this.SoLuongNhanVienQL);
	}
	@Override
	public double GetLuong() {
		// TODO Auto-generated method stub
		return this.HeSoLuong * 1200000;
	}
}
