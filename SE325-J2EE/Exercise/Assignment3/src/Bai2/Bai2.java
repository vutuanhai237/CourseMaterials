package Bai2;




public class Bai2 {
	
	
	public static void main (String args[]) throws InterruptedException
	{
		
		Time t1 = new Time();
		Time t2 = new Time();
		t1.NhapThoiGian();
		t2.NhapThoiGian();
		if (t1.SoSanhThoiGian(t2) == 1)
		{
			System.out.print("Thoi gian lon hon la: ");
			t1.XuatThoiGian();		
		}
		else
		{
			if (t1.SoSanhThoiGian(t2) == -1)
			{
				System.out.print("Thoi gian lon hon la: ");
				t2.XuatThoiGian();		
			}
			else
			{
				System.out.print("2 thoi gian giong nhau ");	
			}
		}
		int tmp = 10;
		while (tmp > 0)
		{
			t1.TangGiay1DonVi();
			t1.XuatThoiGian();
			Thread.sleep(1000);
			tmp--;
			
		}
		
	}


}
