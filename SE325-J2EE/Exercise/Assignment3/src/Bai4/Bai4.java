package Bai4;

import java.util.Scanner;

public class Bai4 {
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap so luong hinh: "); int n = NewScanner.nextInt();
		Shape arrShape[] = new Shape[n];
		double MaxDienTich = 0;
		int iMaxDienTich = 0;
		int CountHinhChuNhat = 0;
		for (int i = 0; i < n; i++)
		{
			System.out.println("Nhap lua chon (1. Hinh chu nhat, 2. Hinh tron): "); 
			int LuaChon = NewScanner.nextInt();
			if (LuaChon == 1)
			{
				arrShape[i] = new Rectangle();	
				CountHinhChuNhat++;
			}
			else
			{
				arrShape[i] = new Circle();
			}
			arrShape[i].Nhap();
			if (MaxDienTich < arrShape[i].GetDienTich())
			{
				MaxDienTich = arrShape[i].GetDienTich();
				iMaxDienTich = i;
			}	
			
		}
		System.out.println("So luong hinh chu nhat: " + CountHinhChuNhat);
		System.out.println("Hinh co dien tich lon nhat la: ");
		arrShape[iMaxDienTich].ToString();
		
	}
}
