using System;

namespace Bai3
{
    public class Calender
    {
        public int[,] a = new int[6, 7];
        public Calender()
        {
            for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    a[i, j] = 0;
                }
            }
        }
        public void Xuat(int first_day_in_month, int count_day_of_month)
        {
            XuLy(first_day_in_month, count_day_of_month);
            for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (a[i, j] == 0)
                    {
                        Console.Write(" \t");

                    }
                    else
                    {
                        Console.Write(a[i, j] + "\t");

                    }
                }
                Console.WriteLine();
            }
        }
        public void XuLy(int first_day_in_month, int count_day_of_month)
        {
            int day = 1;
            int i = 0;
            int j = first_day_in_month - 2;
            while (day <= count_day_of_month)
            {


                if (j == 7)
                {
                    j = 0;
                    i++;

                }
                a[i, j] = day++;
                j++;
            }

        }
    }
    public class NgayThang
    {

        private int year;
        private int month;
        private int day;
        public NgayThang()
        {
            this.year = 0;
            this.month = 0;
            this.day = 0;
        }
        public NgayThang(int _year, int _month, int _day)
        {
            this.year = _year;
            this.month = _month;
            this.day = _day;
        }

        public bool LaNamNhuan(int year)
        {
            if (year % 4 != 0) return false;
            if (year % 100 != 0) return true;
            if (year % 400 != 0) return false;
            return true;
        }


        public int SoNgayTrongThang(int year, int month)
        {
            switch (month)
            {
                case 4:
                case 6:
                case 9:
                case 11: return 30;
                case 2:
                    {
                        if (LaNamNhuan(month)) return 29;
                        return 28;
                    }
                default: return 31;
            }
        }


        

        public int NgayTrongTuan(int Nam, int Thang, int Ngay)
        {
            DateTime dt = new DateTime(Nam, Thang, Ngay);
            String thu = dt.DayOfWeek.ToString();
            switch (thu)
            {
                case "Saturday": return 7;
                case "Sunday": return 8;
                case "Monday": return 2;
                case "Tuesday": return 3;
                case "Wednesday": return 4;
                case "Thursday": return 5;
                default: return 6;
            }
        }

    }
    public class Bai3
    {
        static int thang = 0;
        static int nam = 0;
        static public void Nhap()
        {

            Console.WriteLine("Nhap thang: ");
            thang = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Nhap nam: ");
            nam = Int32.Parse(Console.ReadLine());
        }
       
        static void Main(string[] args)
        {
            Nhap();
            NgayThang nt = new NgayThang(nam, thang, 1);
            Console.WriteLine("-------");
            Console.WriteLine("Thang " + thang + ", Nam: " + nam);
            Console.WriteLine("T2\tT3\tT4\tT5\tT6\tT7\tCN");
            int count_day = nt.SoNgayTrongThang(nam, thang);
            int first_day = nt.NgayTrongTuan(nam, thang, 1);

            Calender cld = new Calender();
            cld.Xuat(first_day, count_day);
            Console.ReadKey();
        }
    }
}
