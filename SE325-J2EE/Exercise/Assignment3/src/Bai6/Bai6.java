package Bai6;

public class Bai6 {
	public static void main (String args[])
	{
		SoPhuc so1 = new SoPhuc();
		SoPhuc so2 = new SoPhuc();
		so1.Nhap();
		so2.Nhap();
		System.out.println("Cong: "); (so1.Cong(so2)).Xuat();
		System.out.println("Tru: "); (so1.Tru(so2)).Xuat();
		System.out.println("Nhan: "); (so1.Nhan(so2)).Xuat();
		System.out.println("Chia: "); (so1.Chia(so2)).Xuat();
	}
}
