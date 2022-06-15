package LT.Chuong4;

import java.util.Scanner;

class AgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AgeException(String msg) {
		super(msg);
	}
	public AgeException(String msg, Throwable cause){
		super(msg, cause);
	}

}
public class Bai4 {
	public static int ChuyenDoi(String Chuoi) throws AgeException
	{
		try
		{
			if (Integer.parseInt(Chuoi) < 0)
			{
				throw new AgeException("Tuoi phai la so nguyen duong");
			}
			return Integer.parseInt(Chuoi);
			
		}
		catch (NumberFormatException e){
			throw new AgeException("Tuoi phai hop le");
		}
		
	}
	public static void main(String args[]) throws AgeException
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		String Chuoi = NewScanner.nextLine();
		System.out.print(ChuyenDoi(Chuoi));
	}
}
