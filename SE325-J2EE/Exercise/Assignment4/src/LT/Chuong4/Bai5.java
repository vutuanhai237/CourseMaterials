package LT.Chuong4;

import java.util.Scanner;

class PINException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PINException(String msg) {
		super(msg);
	}
	public PINException(String msg, Throwable cause){
		super(msg, cause);
	}

}
public class Bai5 {
	public static String ChuyenDoi(String Chuoi) throws PINException
	{
		try
		{
			if (Integer.parseInt(Chuoi) < 0 || Integer.parseInt(Chuoi) > 9999 || Chuoi.length() != 4)
			{
				throw new PINException("PIN phai bao gom 4 chu so");
			}
			return Chuoi;
			
		}
		catch (NumberFormatException e){
			throw new PINException("PIN khong hop le");
		}
		
	}
	public static void main(String args[]) throws PINException
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		String Chuoi = NewScanner.nextLine();
		System.out.print("Ma PIN " + ChuyenDoi(Chuoi) + " hop le");
	}
}

