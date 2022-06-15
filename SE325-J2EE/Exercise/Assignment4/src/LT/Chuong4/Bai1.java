package LT.Chuong4;

import java.util.Scanner;

public class Bai1 {
	public static int ChuyenDoi(String Chuoi)
	{
		try
		{
			return Integer.parseInt(Chuoi);
			
		}
		catch (NumberFormatException e){
			System.out.println("NumberFormatException: " + e.getMessage());
		}
		
		return 0;

	}
	public static void main(String args[])
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		String Chuoi = NewScanner.nextLine();
		System.out.print(ChuyenDoi(Chuoi));
	}
}
