package Bai1;

import java.util.Scanner;

public class Point2D {
	int x;
	int y;
	public Point2D()
	{
		this.x = 0;
		this.y = 0;
	}
	public Point2D (int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}
	public Point2D get()
	{
		return this;
	}
	public void NhapPoint2D()
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap vao toa do x: ");
		this.x = NewScanner.nextInt();
		System.out.println("Nhap vao toa do y: ");
		this.y = NewScanner.nextInt();
	}
	public void XuatPoint2D()
	{
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
	public double GetKhoangCachPoint2D(Point2D p)
	{
		return Math.sqrt((this.x-p.x)*(this.x-p.x) + (this.y-p.y) * (this.y - p.y));
	}
	public void DiChuyenPoint2D (int KhoangCach, String Huong)
	{
		if (Huong == "Bac") this.x += KhoangCach;
		if (Huong == "Nam") this.x -= KhoangCach;
		if (Huong == "Dong") this.y += KhoangCach;
		if (Huong == "Tay") this.y -= KhoangCach;
	}
	
	
	
	
	
	
	
}
