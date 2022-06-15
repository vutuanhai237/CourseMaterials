import java.util.Scanner;


public class bt8 {
	public static int CountSoChuSo(int SoKiemTra)
	{
		int SoChuSo = 0;
		while (SoKiemTra != 0)
		{
			SoKiemTra /= 10;
			SoChuSo++;
		}
		return SoChuSo;
	}
	public static int GetSoDaoNguoc(int SoKiemTra)
	{
		int SoDaoNguoc = 0;
		int Temp = SoKiemTra;
		for (int i = 1; i<= CountSoChuSo(SoKiemTra); i++)
		{
			SoDaoNguoc *= 10;
			SoDaoNguoc += Temp % 10;
			Temp /= 10;
		}
		return SoDaoNguoc;
	}
	public static boolean IsSoDoiXung (int SoKiemTra)
	{
		int VeTrai = SoKiemTra;
		int VePhai = SoKiemTra;
		int SoChia = 1;
		for (int i = 1; i <= CountSoChuSo(SoKiemTra)/2; i++)
		{
			SoChia *= 10;
			
		}
		if (CountSoChuSo(SoKiemTra) % 2 == 1) 
		{
			VeTrai /= 10;
		}
		VeTrai /= SoChia;
		VePhai %= SoChia;
		VePhai = GetSoDaoNguoc(VePhai);
		
		if (VeTrai == VePhai) return true;
		else return false;
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int SoKiemTra = 0;
		System.out.println("Nhap he so n: ");
		SoKiemTra = NewScanner.nextInt();	
		if (IsSoDoiXung(SoKiemTra) == true)
		{
			System.out.println(SoKiemTra + " la so doi xung");			
		}
		else
		{
			System.out.println(SoKiemTra + " khong phai la so doi xung");	
		}
		
	
	
	}
}
