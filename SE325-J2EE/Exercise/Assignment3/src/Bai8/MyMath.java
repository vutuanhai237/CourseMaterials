package Bai8;

public class MyMath {
	public static int GetUocSoChungLonNhat(int a, int b)
	{
		while (a != b)
		{
			if (a > b) a = a - b;
			else b = b - a;
		}
		return a;
	}
	public static int GetMax(int a, int b, int c)
	{
		if (a >= b && a >=c) return a;
		if (b >= c && b >=a) return b;
		if (c >= a && c >=b) return c;
		return a;
		
	}
	public static int GetMin(int a, int b, int c)
	{
		if (a <= b && a <=c) return a;
		if (b <= c && b <=a) return b;
		if (c <= a && c <=b) return c;
		return a;
		
	}
	public static boolean IsSoNguyenTo (int SoKiemTra)
	{
		for (int i = 2; i < SoKiemTra/2; i++)
		{
			if (SoKiemTra % i == 0) return false;
		}
		return true;
			
	}
	public static int GetTongDaySo(int n)
	{
		int TongDaySo = 0;
		for (int i = 1; i <= n; i++)
		{
			TongDaySo += i;
		}
		return TongDaySo;
	}
	public static int GetTriTuyetDoi (int n)
	{
		return Math.abs(n);
	}
	public static double GetGiaTriLamTron (double n)
	{
		return Math.round(n);
	}
}
