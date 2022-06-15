package Bai3;

import java.util.Scanner;

public class Bai3 {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap so luong nhan vien: ");
		int n = NewScanner.nextInt();
		double TongLuong = 0d;
		double LuongCaoNhat = 0;
		int iLuongCaoNhat = 0;
		NhanVien arrNhanVien[] = new NhanVien[n];
		for (int i = 0; i< n; i++)
		{
			arrNhanVien[i] = new NhanVien();
			arrNhanVien[i].NhapThongTin();
			TongLuong = TongLuong + arrNhanVien[i].GetLuong();
			if (LuongCaoNhat < arrNhanVien[i].GetLuong())
			{
				LuongCaoNhat = arrNhanVien[i].GetLuong();
				iLuongCaoNhat = i;
			}
		}
		System.out.println("Tong luong la: " + TongLuong);
		System.out.println("Nhan vien co luong cao nhat la:");
		arrNhanVien[iLuongCaoNhat].XuatThongTin();
	}
}
