package bai2;

import java.util.Scanner;


public class bai2 {
	
	public static void main(String args[])
	{
		MangSo mps = new MangSo();
		
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		int k  = 1;
		while (k != 0)
		{
			System.out.println("--------------------------------------");
			System.out.println("1. Nhap mang, 2. Xuat mang, 3. Them phan tu, 4. Xoa phan tu, 5. Sua phan tu.");
			System.out.println("6. Sap xep tang dan, 7. Tinh trung binh cua mang, 8. Phan tu gan voi gia tri trung binh nhat");
			System.out.println("--------------------------------------");
			System.out.println("Nhap mot trong cac lua chon tren");
			k = scn.nextInt();
			switch(k)
			{
			
				case 1:					
					mps.Nhap();
					break;
				case 2:
					mps.Xuat();
					break;
				case 3:
					System.out.println("Nhap phan tu muon them: ");
					int giatri = scn.nextInt();
					mps.ThemPhanTu(giatri);
					break;
				case 4:
					System.out.println("Nhap chi so phan tu muon xoa: ");
					giatri = scn.nextInt();
					mps.XoaPhanTu(giatri);
					break;
				case 5:
					System.out.println("Nhap chi so phan tu muon sua va gia tri thay the: ");
					int vitri = scn.nextInt();
					giatri = scn.nextInt();	
					mps.SuaPhanTu(giatri, vitri);
					break;
				case 6:
					mps.SapXepTangDan();
					break;
				case 7:
					System.out.println("Trung binh cua phan tu trong mang: " + mps.LayGiaTriTrungBinh());
					break;
				case 8:
					System.out.println("Phan tu gan gia tri trung binh trong mang co chi so la: " + mps.LayViTriGanGiaTriTrungBinhNhat());
					break;
				default:
					break;
			}
		}
		return;
	}
}
