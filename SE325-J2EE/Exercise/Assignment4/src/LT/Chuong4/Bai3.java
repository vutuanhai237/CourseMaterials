package LT.Chuong4;

import java.util.Scanner;
class WebAdressException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WebAdressException(String msg) {
		super(msg);
	}
	public WebAdressException(String msg, Throwable cause){
		super(msg, cause);
	}

}
public class Bai3 {
	public static boolean CheckURL(String URL) throws WebAdressException
	{
		String domain[] = URL.split("\\.");
		if ((domain[0].toString().compareTo("https://www") != 0) && (domain[0].toString().compareTo("http://www") != 0)) throw new WebAdressException("Chuoi khong phai la url");
		if (domain.length <=2) throw new WebAdressException("Chuoi khong phai la url");
		return true;

		
		
	}
	public static void main(String args[]) throws WebAdressException
	{
		@SuppressWarnings({ "resource" })
		Scanner NewScanner = new Scanner(System.in);
		String Chuoi = NewScanner.nextLine();
	
		
		if (CheckURL(Chuoi)) System.out.print("Chuoi la URL hop le");;
	}
}
