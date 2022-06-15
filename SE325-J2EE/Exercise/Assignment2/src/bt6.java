import java.util.Scanner;


public class bt6 {
	public static boolean IsUocSo(int SoKiemTra, int ChiSo)
	{
		if (SoKiemTra % ChiSo == 0)
		return true;
		else
			return false;
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int SoKiemTra = 0;
		System.out.println("Nhap he so n: ");
		SoKiemTra = NewScanner.nextInt();	
		System.out.println("Uoc so la: ");
		
		for (int i = 1; i <= SoKiemTra; i++)
		{
			if (IsUocSo(SoKiemTra, i) == true)
			{
				System.out.println(i);
				
			}
		
		}
	
	}
}
