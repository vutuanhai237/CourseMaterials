package bai2;

import java.util.Arrays;
import java.util.Scanner;

public class MangSo
{
	
	private int a[] = new int[100];
	private int n = 0;
	public MangSo()
	{
		for(int i = 0; i< n; i++)
		{

			this.a[i] = 0;
		}
	}
	public void Nhap()
	{
		@SuppressWarnings("resource")
		Scanner scn2 = new Scanner(System.in);
		System.out.println("Nhap so phan tu: ");
		this.n = scn2.nextInt();
		for(int i = 0; i< n;i++)
		{
			
			System.out.println("Nhap phan tu thu " + (i+1) + ": ");
			this.a[i] = scn2.nextInt();
		}
	}
	public void Xuat()
	{
		for(int i = 0; i< n;i++)
		{
			System.out.println("Phan tu thu " + i + " la: " + this.a[i]);

		}
	}
	public void ThemPhanTu(int giatri)
	{
		n++;		
		this.a[n-1] = giatri;
	}
	public void XoaPhanTu(int vitri)
	{
		this.a[vitri] = 0;
	}
	public void SuaPhanTu(int giatri, int vitri)
	{
		this.a[vitri] = giatri;
	}
	public void SapXepTangDan()
	{
		Arrays.parallelSort(a);
		
	}
	public double LayGiaTriTrungBinh()
	{
		double tong = 0d;
		for(int i = 0; i< n; i++)
		{
			tong += a[i];
		}
		return (double) (tong/n);
	}
	public int LayViTriGanGiaTriTrungBinhNhat()
	{
		return Arrays.binarySearch(a, (int) this.LayGiaTriTrungBinh());
	}
}