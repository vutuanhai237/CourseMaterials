package Bai7;

import java.util.Scanner;

public class NhanVien implements Measurable{

	String HoTen;
	String MaNhanVien;
	int SoGioLam;
	double GiaTheoGio;
	public NhanVien()
	{
		this.HoTen = "";
		this.MaNhanVien = "";
		this.SoGioLam = 0;
		this.GiaTheoGio = 0;
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap ho va ten: "); this.HoTen = NewScanner.nextLine();
		System.out.println("Nhap ma nhan vien: "); this.MaNhanVien = NewScanner.nextLine();
		System.out.println("Nhap so gio lam: "); this.SoGioLam = NewScanner.nextInt();
		System.out.println("Nhap gia theo gio: "); this.GiaTheoGio = NewScanner.nextDouble();
		
	}
	@Override
	public double Valuate() {
		// TODO Auto-generated method stub
		return this.SoGioLam * this.GiaTheoGio;
	}

}
