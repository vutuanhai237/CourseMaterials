using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
namespace AboutFolder
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a link to folder:");
            string link = Console.ReadLine();
            if (Directory.Exists(link))
            {
                string[] arraylink = Directory.GetFiles(link, "*.*", SearchOption.TopDirectoryOnly);
                
                if (arraylink.Length != 0)
                {
                    Console.WriteLine();
                    for(int i = 0; i< arraylink.Length; i++)
                    {
                        Console.WriteLine(arraylink[i]);
                    }
                }
                else
                {
                    Console.WriteLine("I can't find any file in your folder!");
                }
            }
            else
            {
                Console.WriteLine("I can't find your link!");
            }
            Console.ReadLine();
        }
    }
}
