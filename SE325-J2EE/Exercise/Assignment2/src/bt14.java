
import java.util.Scanner;

public class bt14 {
	static void KhoiTaoMangHaiChieu(int MangHaiChieu[][], int Bac)
	{
		for (int i = 0; i< Bac;i ++)
		{
			for (int j = 0; j < Bac; j++)
			{
				MangHaiChieu[i][j] = 0;
			}
		}
	}
	static void XuatMangHaiChieu(int MangHaiChieu[][], int Bac)
	{
		for (int i = 0; i< Bac;i ++)
		{
			for (int j = 0; j < Bac; j++)
			{
				if (MangHaiChieu[i][j] != 0)
				{
					System.out.print(MangHaiChieu[i][j]);
				}
				System.out.print("\t");
			}
			System.out.println("");
		}
	}
	static void TaoMangHaiChieuPascal(int MangHaiChieu[][], int Bac)
	{
		int k = 1;
		for (int i = 0; i< Bac;i ++)
		{
			for (int j = 0; j < k; j++)
			{
				if (i == 0 || j == 0)
				{
					MangHaiChieu[i][j] = 1;
				}
				else
				{
					MangHaiChieu[i][j] = MangHaiChieu[i-1][j-1] + MangHaiChieu[i-1][j];
				}
			}
			System.out.println("");
			k++;
		}
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int Bac;	
		int MangHaiChieu[][] = new int [100][100];
		System.out.println("Nhap kich thuoc ma tran: ");
		Bac = NewScanner.nextInt();
		KhoiTaoMangHaiChieu(MangHaiChieu, Bac);
		TaoMangHaiChieuPascal(MangHaiChieu, Bac);
		XuatMangHaiChieu(MangHaiChieu, Bac);
	}
}
