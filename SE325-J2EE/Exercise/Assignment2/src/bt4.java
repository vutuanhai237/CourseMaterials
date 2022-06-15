import java.util.Scanner;

public class bt4 {
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		double a = 0;
		double b = 1;
		System.out.println("Hay nhap so dau tien: ");
		a = NewScanner.nextDouble();
		System.out.println("Hay nhap so thu hai: ");
		b = NewScanner.nextDouble();
		System.out.printf("a/ b = %.3f", a/b);
		
	}
}
