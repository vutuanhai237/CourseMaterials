using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTap2
{
    class Bai2
    {
        static int ngay = 0;
        static int thang = 0;
        static int nam = 0;
        static public bool laNamNhuan(int nYear)
        {
            if ((nYear % 4 == 0 && nYear % 100 != 0) || nYear % 400 == 0)
            {
                return true;
            }
            return false;
        }
        static public int tinhSoNgayTrongThang(int nMonth, int nYear)
        {
            int nNumOfDays = 0;
            switch (nMonth)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    nNumOfDays = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    nNumOfDays = 30;
                    break;
                case 2:
                    if (laNamNhuan(nYear))
                    {
                        nNumOfDays = 29;
                    }
                    else
                    {
                        nNumOfDays = 28;
                    }
                    break;
            }

            return nNumOfDays;
        }

        static bool laNgayHopLe(int nDay, int nMonth, int nYear)
        {
            // Kiểm tra năm
            if (nYear < 0)
            {
                Console.WriteLine("Nam khong hop le, hay nhap lai !");
                return false; // Ngày không còn hợp lệ nữa!
            }

            // Kiểm tra tháng
            if (nMonth < 1 || nMonth > 12)
            {
                Console.WriteLine("Thang khong hop le, hay nhap lai !");
                return false; // Ngày không còn hợp lệ nữa!
            }

            // Kiểm tra ngày
            if (nDay < 1 || nDay > tinhSoNgayTrongThang(nMonth, nYear))
            {
                Console.WriteLine("Ngay khong hop le, hay nhap lai !");
                return false; // Ngày không còn hợp lệ nữa!
            }

            return true; // Trả về trạng thái cuối cùng...
        }
        static public void Nhap()
        {
            Console.WriteLine("Nhap ngay: ");
            ngay = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Nhap thang: ");
            thang = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Nhap nam: ");
            nam = Int32.Parse(Console.ReadLine());
        }
        public static void Main()
        {
            // Task1
            do
            {
                Nhap();
                Console.WriteLine("-------");
            }
            while (laNgayHopLe(ngay, thang, nam) == false);
            DateTime ngay_nhap_vao = new DateTime(nam, thang, ngay);
            Console.WriteLine("Thu trong tuan la: " + ngay_nhap_vao.DayOfWeek.ToString());
            Console.ReadKey();
        }

    }
}
