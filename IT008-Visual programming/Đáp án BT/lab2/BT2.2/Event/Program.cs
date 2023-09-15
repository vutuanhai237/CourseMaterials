using System;
using System.Threading;

namespace Event
{
    class Program
    {
        static void Main(string[] args)
        {
            NhietKe nhietKe = new NhietKe(28);
            ManHinh manhinh = new ManHinh(nhietKe);
            for (; ; )
            {
                Thread.Sleep(1000);
                Random random = new Random();
                int nhietdo = random.Next(10) - 5;
                nhietKe.NhietDo += nhietdo;
            }
            
        }
    }
}
