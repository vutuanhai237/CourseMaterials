package bai3;

import java.util.Scanner;




public class bai3 {
	
	public static void main(String args[])
	{
		int year;
	
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhap nam:");
		year = scn.nextInt();
		NgayThang nt = new NgayThang(year, 1, 1);		
		
		for(int i = 1; i <= 12;i++)
		{
			System.out.println("Tháng " + i);			
			System.out.println("T2\tT3\tT4\tT5\tT6\tT7\tCN");
			int first_day_in_month = nt.NgayTrongTuan(year, i, 1);
			int count_day_of_month = nt.SoNgayTrongThang(year, i);
			Calender cld = new Calender();
			cld.Xuat(first_day_in_month, count_day_of_month);
		}
		
	}
	
}
