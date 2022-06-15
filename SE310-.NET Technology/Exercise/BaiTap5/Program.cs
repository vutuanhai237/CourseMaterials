using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTap5
{
 
    class Program
    {
        static bool IsNT(int soA)
        {
            if (soA < 2)
            {
                return false;
            }
            else
            {
                for (int i = 2; i <= Math.Sqrt((float)soA); i++)
                {
                    if (soA % i == 0)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        static void Main(string[] args)
        {
            double n;
            Console.WriteLine("Nhap n: ");
            n = Int32.Parse(Console.ReadLine());
            double tong = 0;
            int dem = 0;
            for (int i = 2; i < n; i++)
            {
                if (IsNT(i))
                {
                    tong += i;
                    dem++;
                }
            }
            Stopwatch st = new Stopwatch();
            st.Start();
            Console.WriteLine("Tong so nguyen to nho hon " + n + " la: " + tong);
            Console.WriteLine("Ti le so nguyen to nho hon " + n + " la: " + (dem/n));
            st.Stop();
            Console.WriteLine("Thoi gian thuc thi: " + st.Elapsed.TotalSeconds.ToString() + " s");
            Console.ReadKey();
        }
    }
}
