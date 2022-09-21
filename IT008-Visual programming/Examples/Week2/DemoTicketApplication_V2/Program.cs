using System;

namespace DemoTicketApplication
{
    class Program
    {
        static void Main(string[] args)
        {
            TicketManager manager = new TicketManager();
         
            Ticket ticket = manager.CreateTicketByUserInput();
            manager.PrintTicketInfo(ticket);

            Console.WriteLine();

            Ticket[] tickets = manager.CreateTicketArrByUserInput();
            manager.PrintTicketArrInfo(tickets);
        }
    }
}
