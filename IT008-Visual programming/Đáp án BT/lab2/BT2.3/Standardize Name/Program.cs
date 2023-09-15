using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Standardize_Name
{



    class Program
    {
        



        static void Main(string[] args)
        {
            string name;
            name = Convert.ToString(Console.ReadLine());
            name = name.Trim().ToLower();
            while (name.Contains("  "))
            {
                name = name.Replace("  ", " ");
            }
            string[] arr = name.Split(' ');
            name = "";
            foreach (string item in arr)
            {
                name += item.Substring(0, 1).ToUpper() + item.Substring(1) + " ";
            }
            name.TrimEnd();
            Console.WriteLine(name);
            Console.ReadLine();
        }
    }
}
