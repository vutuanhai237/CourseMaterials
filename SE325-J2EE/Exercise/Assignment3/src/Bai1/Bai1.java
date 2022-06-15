package Bai1;

import java.util.Scanner;

public class Bai1 {
	public static void main (String args[])
	{
		Scanner NewScanner = new Scanner(System.in);
		Point2D p1 = new Point2D();
		Point2D p2 = new Point2D();
		p1.NhapPoint2D();
		p2.NhapPoint2D();
		System.out.println("Nhap hoang do vector: ");
		//int HoangDoVector = NewScanner.nextInt();
		//int TungDoVector = NewScanner.nextInt();
		System.out.printf("Khoang cach giua 2 diem la: %.3f", (float)p1.GetKhoangCachPoint2D(p2));
	}
}
