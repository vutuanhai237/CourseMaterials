import java.util.Scanner;


public class bt9 {
	public static boolean IsSoNguyenTo (int SoKiemTra)
	{
		for (int i = 2; i < SoKiemTra/2; i++)
		{
			if (SoKiemTra % i == 0) return false;
		}
		return true;
			
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int SoKiemTra = 0;
		System.out.println("Nhap he so n: ");
		SoKiemTra = NewScanner.nextInt();	
		if (IsSoNguyenTo(SoKiemTra) == true)
		{
			System.out.println(SoKiemTra + " la so nguyen to");			
		}
		else
		{
			System.out.println(SoKiemTra + " khong phai la so nguyen to");	
		}
		
	
	
	}
}
