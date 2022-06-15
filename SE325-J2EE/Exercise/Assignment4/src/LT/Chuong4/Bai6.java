package LT.Chuong4;

import java.util.Scanner;

class PhoneException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PhoneException(String msg) {
		super(msg);
	}
	public PhoneException(String msg, Throwable cause){
		super(msg, cause);
	}

}
public class Bai6 {
	public static String ChuyenDoi(String Chuoi) throws PhoneException
	{
		try
		{
			if (Integer.parseInt(Chuoi) < 0 || Chuoi.length() != 10)
			{
				throw new PhoneException("So DT phai la 10 cs");
			}
			return Chuoi;
			
		}
		catch (NumberFormatException e){
			throw new PhoneException("So DT khong hop le");
		}
		
	}
	public static void main(String args[]) throws PhoneException
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		String Chuoi = NewScanner.nextLine();
		System.out.print("So DT " + ChuyenDoi(Chuoi) + " hop le");
	}
}

