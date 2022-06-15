package Bai5;

import java.util.Arrays;
import java.util.Scanner;

public class Bai5 {
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap so luong sinh vien: "); 
		int n = NewScanner.nextInt();
		SinhVien arrSinhVien[] = new SinhVien[n];
		for (int i = 0; i< n; i++)
		{
			arrSinhVien[i] = new SinhVien();
			arrSinhVien[i].NhapThongTin();
		}
		Arrays.sort(arrSinhVien);
		
		for (int i = 0; i< n; i++)
		{
			arrSinhVien[i].XuatThongTin();
		}
		
		// Tim kiem theo ten
		System.out.println("Nhap ten sinh vien can tim: "); 
		
		NewScanner.nextLine();
		String TenTimKiem = NewScanner.nextLine();
		System.out.println("Sinh vien can tim la: "); 
		for (int i = 0; i< n; i++)
		{
			if (arrSinhVien[i].HoTen.compareTo(TenTimKiem) == 0)
			{
				arrSinhVien[i].XuatThongTin();
			}
			
		}
		
		//Tim kiem nhung sinh vien ho le
		System.out.println("Nhung sinh vien co ho Le la: ");
		for (int i = 0; i< n; i++)
		{
			if (arrSinhVien[i].HoTen.substring(0, 2).compareTo("Le") == 0)
			{
				arrSinhVien[i].XuatThongTin();
			}
			
		} 
	}
}
