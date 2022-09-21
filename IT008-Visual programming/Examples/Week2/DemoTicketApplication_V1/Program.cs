using System;

namespace DemoTicketApplication
{
    class Program
    {
        static void Main(string[] args)
        {
            ProcessTicket();
            Console.WriteLine();
            ProcessTicketArr();
        }

        static void ProcessTicket()
        {
            Console.WriteLine("[Input Info Of Ticket]");
            Console.Write("- Seat Location: ");
            string seat = Console.ReadLine();

            Console.Write("- Shift Number: ");
            int shiftNo = int.Parse(Console.ReadLine());

            char row = seat[0];
            int col = int.Parse(seat.Substring(1, seat.Length - 1));
            Ticket ticket;

            if (row == 'D' || row == 'E' || row == 'F' || row == 'G')
            {
                ticket = new VipTicket(row, col, shiftNo);
            } 
            else
            {
                ticket = new NormalTicket(row, col, shiftNo);
            }

            ticket.Print();
        }

        static void ProcessTicketArr()
        {
            Console.Write("Number of tickets: ");
            int numberOfTickets = int.Parse(Console.ReadLine());
            Ticket[] tickets = new Ticket[numberOfTickets];

            for (int i = 0; i < numberOfTickets; i++)
            {
                Console.WriteLine("\n[Input Info Of Ticket]");
                Console.Write("- Seat Location: ");
                string seat = Console.ReadLine();

                Console.Write("- Shift Number: ");
                int shiftNo = int.Parse(Console.ReadLine());

                char row = seat[0];
                int col = int.Parse(seat.Substring(1, seat.Length - 1));

                if (row == 'D' || row == 'E' || row == 'F' || row == 'G')
                {
                    tickets[i] = new VipTicket(row, col, shiftNo);
                }
                else
                {
                    tickets[i] = new NormalTicket(row, col, shiftNo);
                }
            }

            for (int i = 0; i < numberOfTickets; i++)
            {
                tickets[i].Print();
            }
        }
    }
}
