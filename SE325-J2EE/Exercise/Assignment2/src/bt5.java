import java.util.Scanner;


public class bt5 {
	public static int GetTongDaySo(int HeSo)
	{
		int TongDaySo = 0;
		for (int i = 1; i <= HeSo; i++)
		{
			TongDaySo += i;
		}
		return TongDaySo;
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		int HeSo = 0;
		System.out.println("Hay he so n: ");
		HeSo = NewScanner.nextInt();		
		System.out.println("Tong day so la: " + GetTongDaySo(HeSo));
		
	}
}
