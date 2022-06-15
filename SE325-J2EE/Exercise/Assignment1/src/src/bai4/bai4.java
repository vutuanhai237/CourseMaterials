package bai4;

import java.util.Scanner;

public class bai4 {
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		int n;
		PhanSo mangps[] = new PhanSo[100];
		System.out.println("Nhap so luong phan so: ");
		n = scn.nextInt();
		double max = 0d;
		double min = 0d;
		int imax = 0;
		int imin = 0;
		
		for (int i = 0 ; i < n; i++)
		{
			
			int tmp1, tmp2;
			System.out.println("Nhap tu so phan so " + (i+1) + " : ");
			tmp1 = scn.nextInt();
			System.out.println("Nhap mau so phan so " + (i+1) + " : ");
			tmp2 = scn.nextInt();
		
			mangps[i] = new PhanSo(tmp1,tmp2);
			if (mangps[i].GiaTri() > max) { max = mangps[i].GiaTri(); imax = i;}
			else
			{
				min = mangps[i].GiaTri(); imin = i;
			}
		}
		System.out.println("Phan so max la: " + mangps[imax].Xuat());
		System.out.println("Phan so min la: " + mangps[imin].Xuat());
		
		
	}
}
