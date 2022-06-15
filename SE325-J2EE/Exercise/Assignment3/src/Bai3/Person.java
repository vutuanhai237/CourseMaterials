package Bai3;

import java.util.Scanner;

abstract public class Person {
	String HoTen;
	String DiaChi;
	int Tuoi;
	public Person()
	{
		this.HoTen = "";
		this.DiaChi = "";
		this.Tuoi = 0;
	}
	public Person(String _HoTen, String _DiaChi, int _Tuoi)
	{
		this.HoTen = _HoTen;
		this.DiaChi = _DiaChi;
		this.Tuoi = _Tuoi;
	}
	public void NhapThongTin()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap ho va ten: "); this.HoTen = NewScanner.nextLine();
		System.out.println("Nhap dia chi: "); this.DiaChi = NewScanner.nextLine();
		System.out.println("Nhap tuoi: "); this.Tuoi = NewScanner.nextInt();
		
	}
	public void XuatThongTin()
	{
		System.out.println("Ho va ten: " + this.HoTen);
		System.out.println("Dia chi: " + this.DiaChi);
		System.out.println("Tuoi: " + this.Tuoi);
		
	}
}
