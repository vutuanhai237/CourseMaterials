using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Delegate
{
    class Program
    {
        static void Main(string[] args)
        {

            //Construct a lots of temp variable

            Delegate.CompareHandler compare = Delegate.CompareInt;
            int tmp = -1; int i = 0;
            double tmp2 = -1.0;
            string tmp3 = "string";

            //Test with CompareInteger

            int[] arrint = new int[20];
            Console.WriteLine("Enter a array of integer (exit with 0): ");
            do
            {

                tmp = Convert.ToInt32(Console.ReadLine());
                if (tmp == 0) break;
                arrint[i++] = tmp;
              
            } while (tmp != 0);
            Console.WriteLine("Max value: {0}", (int)Delegate.MaxValue(arrint, compare));
            Console.WriteLine("Min value: {0}", (int)Delegate.MinValue(arrint, compare));

            //Test with CompareDouble

            i = 0; compare = Delegate.CompareDouble;
            double[] arrdouble = new double[20];
            Console.WriteLine("Enter a array of double (exit with 0): ");
            while (tmp2 != 0)
            {
                tmp2 = Convert.ToDouble(Console.ReadLine());
                arrdouble[i++] = tmp2;
            }
            Console.WriteLine("Max value: {0}", (double)Delegate.MaxValue(arrdouble, compare));
            Console.WriteLine("Min value: {0}", (double)Delegate.MinValue(arrdouble, compare));

            //Test with CompareString

            i = 0; compare = Delegate.CompareInt; 
            int[] arrstring = new int[20];
            Console.WriteLine("Enter a array of string (exit with 0): ");
            while (tmp3 != "0")
            {
               
                tmp3 = Convert.ToString(Console.ReadLine());
                arrstring[i++] = tmp3.Length;
            }
          
            Console.WriteLine("Max value: {0}", (int)Delegate.MaxValue(arrstring, compare));
            Console.WriteLine("Min value: {0}", (int)Delegate.MinValue(arrstring, compare));
            Console.ReadLine();
        }
    }
}
