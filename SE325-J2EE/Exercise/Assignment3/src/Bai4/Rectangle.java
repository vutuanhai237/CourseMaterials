package Bai4;

import java.util.Scanner;

public class Rectangle extends Shape{

	int ChieuDai;
	int ChieuRong;
	public Rectangle()
	{
		this.ChieuDai = 0;
		this.ChieuRong = 0;
		this.Ten = "Hinh chu nhat";
		this.DienTich = 0;
	}
	public Rectangle(int _ChieuDai, int _ChieuRong)
	{
		this.ChieuDai = _ChieuDai;
		this.ChieuRong = _ChieuRong;
	}
	
	@Override
	public void ToString() {
		// TODO Auto-generated method stub
		System.out.println(this.Ten + ", chieu dai " + this.ChieuDai + ", chieu rong " + this.ChieuRong);
	}
	@Override
	public void Nhap() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap chieu dai hinh chu nhat: "); this.ChieuDai = NewScanner.nextInt();
		System.out.println("Nhap chieu rong hinh chu nhat: "); this.ChieuRong = NewScanner.nextInt();

	}
	@Override
	public double GetDienTich() {
		// TODO Auto-generated method stub
		return this.ChieuDai *this.ChieuRong;
	}

}
