package LT.Chuong4;

import java.util.Scanner;

class TriangleEdgesException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TriangleEdgesException(String msg) {
		super(msg);
	}
	public TriangleEdgesException(String msg, Throwable cause){
		super(msg, cause);
	}

}
public class Bai7 {
	public static void CheckTamGiac(int a, int b, int c) throws TriangleEdgesException
	{
		try
		{
			if (a < 0 || b < 0 || c < 0 || a+b < c || c+b < a || a+c < b)
			{
				throw new TriangleEdgesException("Tam giac khong hop le");
			}
			System.out.print("Tam giac " + a + ", " + b + ", " + c + ") hop le");
		}
		catch (NumberFormatException e){
			throw new TriangleEdgesException("Tam giac khong hop le");
		}
		
	}
	public static void main(String args[]) throws TriangleEdgesException
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		System.out.print("Nhap 3 canh tam giac: ");
		
		int a = NewScanner.nextInt();
		int b = NewScanner.nextInt();
		int c = NewScanner.nextInt();
		CheckTamGiac(a, b, c);
	}
}

