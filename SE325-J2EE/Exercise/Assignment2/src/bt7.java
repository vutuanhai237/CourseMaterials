import java.util.Scanner;


public class bt7 {
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
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int SoKiemTra = 0;
		System.out.println("Nhap he so n: ");
		SoKiemTra = NewScanner.nextInt();	
		System.out.println("So chu so la: " + CountSoChuSo(SoKiemTra));
		
	
	
	}
}
