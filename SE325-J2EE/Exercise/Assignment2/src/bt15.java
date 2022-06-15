
import java.util.Scanner;

public class bt15 {
	static Scanner NewScanner = new Scanner(System.in);
	static void NhapMangHaiChieu(int MangHaiChieu[][], int m, int n)
	{
		for (int i = 0; i< m;i ++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print("Nhap phan tu [" + i + "]["+ j + "]: ");
				MangHaiChieu[i][j] = NewScanner.nextInt();
			}
		}
	}
	static void XuatMangHaiChieu(int MangHaiChieu[][], int m, int n)
	{
		for (int i = 0; i< m;i ++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(MangHaiChieu[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
	}
	static int GetMaxMangHaiChieu(int MangHaiChieu[][], int m, int n)
	{
		int Max = MangHaiChieu[0][0];
		for (int i = 0; i< m;i ++)
		{
			for (int j = 0; j < n; j++)
			{
				if (MangHaiChieu[i][j] > Max) Max = MangHaiChieu[i][j];
			}
		}
		return Max;
	}
	static int GetMinMangHaiChieu(int MangHaiChieu[][], int m, int n)
	{
		int Min = MangHaiChieu[0][0];
		for (int i = 0; i< m;i ++)
		{
			for (int j = 0; j < n; j++)
			{
				if (MangHaiChieu[i][j] < Min) Min = MangHaiChieu[i][j];
			}
		}
		return Min;
	}
	static int GetTongMangHaiChieu(int MangHaiChieu[][], int m, int n)
	{
		int Tong = 0;
		for (int i = 0; i< m;i ++)
		{
			for (int j = 0; j < n; j++)
			{
				Tong += MangHaiChieu[i][j];
			}
		}
		return Tong;
	}
	public static boolean IsSoNguyenTo (int SoKiemTra)
	{
		for (int i = 2; i < SoKiemTra/2; i++)
		{
			if (SoKiemTra % i == 0) return false;
		}
		return true;
			
	}
	static void PrintSoNguyenToInMangHaiChieu(int MangHaiChieu[][], int m, int n)
	{

		for (int i = 0; i< m;i ++)
		{
			for (int j = 0; j < n; j++)
			{
				if (IsSoNguyenTo(MangHaiChieu[i][j]) == true)
				{
					System.out.print(MangHaiChieu[i][j]);
					System.out.print("\t");
				}
				
			}
		}
	}
	public static void main (String args[])
	{
		int m ,n;	
		int MangHaiChieu[][] = new int [100][100];
		System.out.println("Nhap kich thuoc ma tran [m]: ");
		m = NewScanner.nextInt();
		n = NewScanner.nextInt();
		NhapMangHaiChieu(MangHaiChieu, m, n);
		System.out.println("So lon nhat trong mang hai chieu la: " + GetMaxMangHaiChieu(MangHaiChieu, m, n));
		System.out.println("So nho nhat trong mang hai chieu la: " + GetMinMangHaiChieu(MangHaiChieu, m, n));
		System.out.println("Tong cac phan tu trong mang hai chieu la: " + GetTongMangHaiChieu(MangHaiChieu, m, n));
		System.out.println("Cac phan tu nguyen to trong mang hai chieu la: "); PrintSoNguyenToInMangHaiChieu(MangHaiChieu, m, n);
	}
}
