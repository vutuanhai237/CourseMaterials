import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class bt13 {
	static Scanner NewScanner = new Scanner(System.in);
	static void NhapMang(int arrSoNguyen[], int n)
	{
		for (int i = 0; i< n;i++)
		{
			System.out.println("Nhap phan tu thu " + (i+1) + ": ");
			arrSoNguyen[i] = NewScanner.nextInt();
		}
	}
	static void XuatMang(int arrSoNguyen[], int n)
	{
		
		for (int i = 0; i< n;i++)
		{
			System.out.println(arrSoNguyen[i] + " ");
			
		}
	}
	
	static void RandomMang(int arrSoNguyen[], int n)
	{
		for (int i = 0; i< n;i++)
		{
			Random rd = new Random();
			arrSoNguyen[i] = rd.nextInt(n);
		}
	}
	public static void main (String args[])
	{
		//a
		int arrA[] = new int[100];
		int n;
		System.out.println("a/ Nhap kich thuoc mang a");
		n = NewScanner.nextInt();
		System.out.println("Nhap mang a");
		NhapMang(arrA, n);
		//b
		int arrB[] = new int[100];
		int m;
		System.out.println("b/ Nhap kich thuoc mang b");
		m = NewScanner.nextInt();
		RandomMang(arrB, m);
		XuatMang(arrB, m);
		//c
		
		int arrC[] = new int[100];
		arrC = Arrays.copyOf(arrA, n);
		//d
		System.arraycopy(arrB, m-3, arrC, 0, 3);
		System.out.println("d/ Xuat mang c sau khi thay the:");
		XuatMang(arrC, n);
		//e
		Arrays.sort(arrC);
		System.out.println("c/ Xuat mang c sau khi sort:");
		XuatMang(arrC, n);
		//f
		System.out.println("f/ Nhap so x: ");
		int x = NewScanner.nextInt();
		if (Arrays.binarySearch(arrC, x) >= 0)
		{
			System.out.println(x + " nam trong mang C");
		}
		else
		{
			System.out.println(x + " khong nam trong mang C");
		}
	}
}