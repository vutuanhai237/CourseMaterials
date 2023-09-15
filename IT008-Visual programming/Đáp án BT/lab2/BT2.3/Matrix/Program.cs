using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Matrix
{
    class Program
    {
        
        public static bool IsPrime(int value)
        {
            for (int i = 2; i < (int)value / 2 + 1; i++)
            {
                if (value % i == 0) return false;

            }
            return true;
        }
       public static bool FindByValue(int[,] matrix, int n, int m, int value)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                   if (matrix[i, j] == value)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        static void Main(string[] args)
        {
            //Ênter matrix
            string temp;
            Console.Write("Enter row: ");
            temp = Console.ReadLine();
            int n = int.Parse(temp);
            Console.Write("Enter column: ");
            temp = Console.ReadLine();
            int m = int.Parse(temp);
            int[,] matrix = new int[n, m];
         
            
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    Console.Write("Enter element [{0}, {1}]: ", i+1, j+1);
                    matrix[i, j] = Convert.ToInt32(Console.ReadLine());
                }
            }
            // ask many response

            //Print matrix
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    Console.Write(matrix[i, j] + " ");
                   
                }
                Console.WriteLine();
            }

            //Find by value
            Console.WriteLine("Find a element (Enter value that you want): ");
            int temp2 = Convert.ToInt32(Console.ReadLine());            
            if (FindByValue(matrix, n, m, temp2) == true) Console.WriteLine("Matrix has this value");
            else Console.WriteLine("Matrix hasn't this value");

            //Print prime's element
            Console.WriteLine("Print prime's element");
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (IsPrime(matrix[i, j]) == true)
                    {
                        Console.Write(matrix[i, j] + " ");
                    }

                }
            }
            Console.ReadLine();
        }
    }
}
