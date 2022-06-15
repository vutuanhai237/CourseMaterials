package Bai9;

import java.util.Scanner;

public class Bai9 {
	public static void main(String args[])
	{
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap so luong nhan vien: ");
		int n = NewScanner.nextInt();
		NhanVien arrPerson[] = new NhanVien[n];
	
		double MaxLuong = 0;
		for (int i = 0; i< n; i++)
		{
			arrPerson[i] = new NhanVien();
			System.out.println("Nhap thong tin nhan vien " + i);
			arrPerson[i].Nhap();
			if (arrPerson[i].GetLuong() > MaxLuong) MaxLuong = arrPerson[i].GetLuong();
		}
		for (int i = 0; i< n; i++)
		{
			System.out.println("Thong tin nhan vien " + i);
			arrPerson[i].Xuat();
		}
		System.out.println("Luong lon nhat la: " + MaxLuong);
		System.out.println("Nhung nhan vien sinh vao thang 2 la: ");
		for (int i = 0; i< n; i++)
		{
			if (arrPerson[i].NgaySinh.substring(3, 5).compareTo("02") == 0)
				System.out.println(arrPerson[i].HoTen + "  ");
		}
		System.out.println("Nhung nhan vien thuoc phong Ke Toan la: ");
		for (int i = 0; i< n; i++)
		{
			if (arrPerson[i].TenDonVi.compareTo("Ke Toan") == 0)
				System.out.println(arrPerson[i].HoTen + "  ");
		}
		int Count = 0;
		for (int i = 0; i< n; i++)
		{
			if (arrPerson[i].HoTen.indexOf("An") != -1)
				Count++;
		}
		System.out.println("So nhan vien ten An la: " + Count);
	}
}
