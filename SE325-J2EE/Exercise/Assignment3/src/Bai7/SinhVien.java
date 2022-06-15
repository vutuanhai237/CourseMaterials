package Bai7;

import java.util.Scanner;

public class SinhVien implements Measurable{
	String HoTen;
	String MaSinhVien;
	double DiemToan;
	double DiemLy;
	double DiemHoa;
	public SinhVien()
	{
		this.HoTen = "";
		this.MaSinhVien = "";
		this.DiemToan = 0;
		this.DiemLy = 0;
		this.DiemHoa = 0;
		
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap ho va ten: "); this.HoTen = NewScanner.nextLine();
		System.out.println("Nhap ma sinh vien: "); this.MaSinhVien = NewScanner.nextLine();
		System.out.println("Nhap diem toan: "); this.DiemToan = NewScanner.nextDouble();
		System.out.println("Nhap diem ly: "); this.DiemLy = NewScanner.nextDouble();
		System.out.println("Nhap diem hoa: "); this.DiemHoa = NewScanner.nextDouble();
		
	}
	@Override
	public double Valuate() {
		// TODO Auto-generated method stub
		return (this.DiemToan + this.DiemLy + this.DiemHoa)/3;
	}
}
