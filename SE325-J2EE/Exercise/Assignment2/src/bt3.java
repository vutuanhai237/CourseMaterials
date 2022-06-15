import java.util.Scanner;


public class bt3 {
	public static int GetTongDaySo(int Bac)
	{
		int TongDaySo = 0;
		for (int i = 1; i <= Bac; i++)
		{
			TongDaySo += Math.pow(i, i);
		}
		return TongDaySo;
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int Bac = 0;
		System.out.println("Hay nhap bac: ");
		Bac = NewScanner.nextInt();
		
		System.out.println("Tong day so la: " + GetTongDaySo(Bac));
		
	}
}
