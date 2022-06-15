package bai4;

public class PhanSo {
	private double Tu;
	private double Mau;
	public PhanSo()
	{
		this.Tu = 0;
		this.Mau = 1;
	}
	public PhanSo(int a, int b)
	{
		this.Tu = a;
		this.Mau = b;
	}
	public String Xuat()
	{
		return (this.Tu + "/ " + this.Mau);
	}
	public double GiaTri()
	{
		return  (this.Tu/this.Mau);
	}
}
