import java.util.Scanner;


public class bt10 {
	public static boolean IsSoNguyenTo (int SoKiemTra)
	{
		for (int i = 2; i < SoKiemTra/2; i++)
		{
			if (SoKiemTra % i == 0) return false;
		}
		return true;
			
	}
	public static void main (String args[])
	{
		@SuppressWarnings("resource")
		Scanner NewScanner = new Scanner(System.in);
		String ChuoiX;
		String ChuoiY;
		String ChuoiNoi;
		System.out.println("Nhap chuoi X: ");
		ChuoiX = NewScanner.nextLine();	
		System.out.println("Nhap chuoi X: ");
		ChuoiY = NewScanner.nextLine();	
		//a
		System.out.println("a. Tong chieu dai 2 chuoi la: " + (ChuoiX.length() + ChuoiY.length()));			
		//b
		System.out.println("b. 3 ki tu dau tien trong chuoi X la: " + ChuoiX.substring(0, 3));		
		//c
		System.out.println("c. 3 ki tu cuoi cua chuoi Y la: " + ChuoiY.substring(ChuoiY.length() - 3, ChuoiY.length()));			
		//d
		System.out.println("d. Ki tu thu 6 cua chuoi X la: " + ChuoiX.charAt(5));		
		//e
		ChuoiNoi = ChuoiX.substring(0, 3) + ChuoiY.substring(ChuoiY.length() - 3, ChuoiY.length());
		System.out.println("e. Chuoi noi 3 ki tu dau chuoi X va  ki tu cuoi chuoi Y la: " + ChuoiNoi);		
		//f
		if (ChuoiX.equals(ChuoiY) == true)
		{
			System.out.println("f. Chuoi X giong chuoi Y");	
		} 
		else
		{
			System.out.println("f. Chuoi X khac chuoi Y");	
		}
		//g
		if (ChuoiX.equalsIgnoreCase(ChuoiY) == true)
		{
			System.out.println("g. Chuoi X giong chuoi Y");	
		} 
		else
		{
			System.out.println("g. Chuoi X khac chuoi Y");	
		}
		//h
		if (ChuoiX.indexOf(ChuoiY) == -1)
		{
			System.out.println("h. Chuoi Y khong nam trong chuoi X");	
		} 
		else
		{
			System.out.println("h. Chuoi Y nam tai vi tri " + ChuoiY.indexOf(ChuoiY) + " trong chuoi X");	
		}
		//
	
	}
}
