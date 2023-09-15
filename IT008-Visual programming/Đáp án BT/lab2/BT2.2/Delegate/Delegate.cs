using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Delegate
{
    class Delegate
    {
        public delegate int CompareHandler(object obj1, object obj2);
        public static object MaxValue(Array arr, CompareHandler compare)
        {
            object max = arr.GetValue(0);
            foreach (object obj in arr)
            {
                if (compare(obj, max) == 1)
                {
                    max = obj;
                }
            }
            return max;
        }
        public static object MinValue(Array arr, CompareHandler compare)
        {
            object min = arr.GetValue(0);
            foreach (object obj in arr)
            {
                if (compare(obj, min) == -1)
                {
                    min = obj;
                }
            }
            return min;
        }
        public static int CompareInt(object obj1, object obj2)
        {
            int a = (int)obj1;
            int b = (int)obj2;
            if (a > b)
            {
                return 1;
            }
            if (a < b)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        public static int CompareDouble(object obj1, object obj2)
        {
            double a = (double)obj1;
            double b = (double)obj2;
            if (a > b)
            {
                return 1;
            }
            if (a < b)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        public static int CompareString(object obj1, object obj2)
        {
            int a = ((string)obj1).Length;
            int b = ((string)obj2).Length;
            if (a > b)
            {
                return 1;
            }
            if (a < b)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }

}
