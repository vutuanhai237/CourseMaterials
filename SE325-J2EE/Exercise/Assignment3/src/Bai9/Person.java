package Bai9;

import java.util.Scanner;

abstract class Person {
	String HoTen;
	String NgaySinh;
	double HeSoLuong;
	public Person()
	{
		this.HoTen = "";
		this.NgaySinh = "";
		this.HeSoLuong = 0;
	}
	public Person(String _HoTen, String _NgaySinh, double _HeSoLuong)
	{
		this.HoTen = _HoTen;
		this.NgaySinh = _NgaySinh;
		this.HeSoLuong = _HeSoLuong;
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap ho va ten: "); this.HoTen = NewScanner.nextLine();
		System.out.println("Nhap ngay sinh: "); this.NgaySinh = NewScanner.nextLine();
		System.out.println("Nhap he so luong: "); this.HeSoLuong = NewScanner.nextDouble();
	}
	public void Xuat()
	{
		System.out.println("Ho va ten: " + this.HoTen);
		System.out.println("Ngay sinh: " + this.NgaySinh);
		System.out.println("He so luong: " + this.HeSoLuong);
		
	}
	abstract public double GetLuong();
}
