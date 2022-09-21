using System;

namespace DemoConsoleApp
{
    class Program
    {
        static void Print(int height)
        {
            for (int row = 0; row < height; row++)
            {
                for (int col = 0; col < height; col++)
                {
                    // Tam giac xuoi: col <= row
                    // Tam giac nguoc: col >= row
                    if (col >= row)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(" ");
                    }
                }
                Console.WriteLine();
            }
        }

        static void Main(string[] args)
        {
            Print(5);
        }
    }
}