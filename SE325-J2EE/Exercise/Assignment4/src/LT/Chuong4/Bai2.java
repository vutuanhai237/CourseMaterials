package LT.Chuong4;

import java.util.Scanner;
class UnsignedIntergerException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnsignedIntergerException(String msg) {
		super(msg);
	}
	public UnsignedIntergerException(String msg, Throwable cause){
		super(msg, cause);
	}

}
public class Bai2 {
	public static int ChuyenDoi(String Chuoi) throws UnsignedIntergerException
	{
		try
		{
			if (Integer.parseInt(Chuoi) < 0)
			{
				throw new UnsignedIntergerException("Chuoi khong phai la so nguyen duong");
			}
			return Integer.parseInt(Chuoi);
			
		}
		catch (NumberFormatException e){
			throw new UnsignedIntergerException("Chuoi khong phai la so nguyen duong");
		}
		
	}
	public static void main(String args[]) throws UnsignedIntergerException
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		String Chuoi = NewScanner.nextLine();
		System.out.print(ChuyenDoi(Chuoi));
	}
}
