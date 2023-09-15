using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PS
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Nhap hai phan so can tinh toan");
            Console.Write("Nhap tu so phan so 1: ");
            int ts1 = Convert.ToInt32(Console.ReadLine());
            Console.Write("Nhap mau so phan so 1: ");
            int ms1 = Convert.ToInt32(Console.ReadLine());
            PhanSo ps1 = new PhanSo(ts1, ms1);
            Console.Write("Nhap tu so phan so 2: ");
            int ts2 = Convert.ToInt32(Console.ReadLine());
            Console.Write("Nhap mau so phan so 2: ");
            int ms2 = Convert.ToInt32(Console.ReadLine());
            PhanSo ps2 = new PhanSo(ts2, ms2);
            Console.Write("Chon (1) Cong (2) Tru (3) Nhan (4) Chia: ");
            int key = Convert.ToInt32(Console.ReadLine());
            if (key == 1) Console.WriteLine("{0} / {1}", (ps1 + ps2).Tu, (ps1 + ps2).Mau);
            if (key == 2) Console.WriteLine("{0} / {1}", (ps1 - ps2).Tu, (ps1 + ps2).Mau);
            if (key == 3) Console.WriteLine("{0} / {1}", (ps1 * ps2).Tu, (ps1 + ps2).Mau);
            if (key == 4) Console.WriteLine("{0} / {1}", (ps1 / ps2).Tu, (ps1 + ps2).Mau);
            ArrayList ArrayPS = new ArrayList();
            ArrayPS.Add(new PhanSo(2, 3));
            ArrayPS.Add(new PhanSo(4, 3));
            ArrayPS.Add(new PhanSo(6, 4));
            ArrayPS.Add(new PhanSo(7, 2));
            ArrayPS.Sort();
            foreach (var ps in ArrayPS)
            {
                Console.Write(ps.ToString() + " ");
            }
            Console.ReadLine();
        }
    }
}
