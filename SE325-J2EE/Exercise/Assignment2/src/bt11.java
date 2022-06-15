import java.util.Calendar;
import java.util.Scanner;


public class bt11 {
	
	@SuppressWarnings("static-access")
	public static void main (String args[])
	{
		Calendar LichA = Calendar.getInstance();
		Calendar LichB = Calendar.getInstance();
		int SoSanh = LichA.compareTo(LichB);
		System.out.println("Ngay A: " + LichA.getTime());
		System.out.println("Ngay B: " + LichB.getTime());
		//a
		if (SoSanh == 0)
		{
			System.out.println("a. 2 ngay bang nhau");	
		}
		else
		{
			if (SoSanh == -1)
			{
				System.out.println("a. Ngay B lon hon");	
			}
			else
			{
				System.out.println("a. Ngay A lon hon");	
			}
		}
		//b
		Calendar Temp = LichA;
		Temp.add(Temp.DATE, 1);
		System.out.println("b. Ngay sau A: " + Temp.getTime());
		//c
		Temp = LichA;
		Temp.add(Temp.DATE, -1);
		System.out.println("c. Ngay truoc A: " + Temp.getTime());
		//d
		System.out.println("d. A la ngay thu " + LichA.get(LichA.DAY_OF_YEAR) + " cua nam");
		//e
		int Month = LichA.get(LichA.MONTH) + 1;
		if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12)
		{
			System.out.println("e. Thang chua A co 31 ngay");
		}
		else
		{
			if (Month == 2)
			{
				if (LichA.get(LichA.YEAR) % 400 == 0 || (LichA.get(LichA.YEAR) % 4 == 0 && LichA.get(LichA.YEAR) % 100 != 0))
				{
					System.out.println("e. Thang chua A co 29 ngay");
				}
				else
				{
					System.out.println("e. Thang chua A co 28 ngay");
				}
			}
			else
			{
				System.out.println("e. Thang chua A co 30 ngay");
			}
		}
		
		
		
		
		
	}
}
