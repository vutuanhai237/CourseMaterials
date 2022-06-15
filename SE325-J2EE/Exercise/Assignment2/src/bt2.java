import java.util.Scanner;

public class bt2 {
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		double BanKinh = 0;
		System.out.println("Hay nhap ban kinh: ");
		BanKinh = NewScanner.nextDouble();
		System.out.println("Chu vi hinh tron la: " + BanKinh*2*Math.PI);
		
	}
}
