package Bai6;

import java.util.Scanner;

public class SoPhuc {
	double Thuc;
	double Ao;
	public SoPhuc()
	{
		this.Thuc = 0;
		this.Ao = 0;
	}
	public SoPhuc(double _Thuc, double _Ao)
	{
		this.Thuc = _Thuc;
		this.Ao = _Ao;
		
	}
	public void Nhap()
	{
		Scanner NewScanner = new Scanner(System.in);
		System.out.println("Nhap phan thuc: "); this.Thuc = NewScanner.nextDouble();
		System.out.println("Nhap phan tao: "); this.Ao = NewScanner.nextDouble();
		
	}
	public void Xuat()
	{
	
		System.out.println(this.Thuc + " + " + this.Ao + ". i");
		
	}
	public SoPhuc Cong(SoPhuc sp)
	{
		SoPhuc result = new SoPhuc();
		result.Thuc = this.Thuc + sp.Thuc;
		result.Ao = this.Ao + sp.Ao;
		return result;
		
	}
	public SoPhuc Tru(SoPhuc sp)
	{
		SoPhuc result = new SoPhuc();
		result.Thuc = this.Thuc - sp.Thuc;
		result.Ao = this.Ao - sp.Ao;
		return result;
		
	}
	public SoPhuc Nhan(SoPhuc sp)
	{
		SoPhuc result = new SoPhuc();
		result.Thuc = this.Thuc*sp.Thuc - this.Ao*sp.Ao;
		result.Ao = this.Thuc*sp.Ao + sp.Thuc*this.Ao;
		return result;
		
	}
	public SoPhuc Chia(SoPhuc sp)
	{
		SoPhuc result = new SoPhuc();
		result.Thuc = (this.Thuc*sp.Thuc + this.Ao*sp.Ao)/(sp.Thuc*sp.Thuc+sp.Ao*sp.Ao);
	    result.Ao = (sp.Thuc * this.Ao - this.Thuc*sp.Ao)/(sp.Thuc * sp.Thuc + sp.Ao * sp.Ao);
	    return result;
	}
}
