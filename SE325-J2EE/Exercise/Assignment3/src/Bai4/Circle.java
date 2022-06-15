package Bai4;

import java.util.Scanner;

public class Circle extends Shape{

	int BanKinh;
	public Circle()
	{
		this.BanKinh = 0;
		this.DienTich = 0;
		this.Ten = "Hinh tron";
	}
	public Circle(int _BanKinh)
	{
		this.BanKinh = _BanKinh;
	}
	@Override
	public void ToString() {
		// TODO Auto-generated method stub
		System.out.println(this.Ten + ", ban kinh la " + this.BanKinh);
		
	}
	@Override
	public void Nhap() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap ban kinh hinh tron: "); this.BanKinh = NewScanner.nextInt();
	}
	@Override
	public double GetDienTich() {
		// TODO Auto-generated method stub
		return Math.PI*Math.PI*this.BanKinh;
	}

}
