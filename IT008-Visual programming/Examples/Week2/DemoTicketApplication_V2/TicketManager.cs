using System;
using System.Linq;

namespace DemoTicketApplication
{
    class TicketManager
    {
        private char[] VIP_ROWS = new char[] { 'D', 'E', 'F', 'G' };

        public Ticket CreateTicketByUserInput()
        {
            Console.WriteLine("[Input Info Of Ticket]");
            Console.Write("- Seat Location: ");
            string seat = Console.ReadLine();
            Console.Write("- Shift Number: ");
            int shiftNo = int.Parse(Console.ReadLine());
            return createTicketBySeatAndShiftNo(seat, shiftNo);
        }

        private Ticket createTicketBySeatAndShiftNo(string seat, int shiftNo)
        {
            char row = seat[0];
            int col = int.Parse(seat[1..]);

            if (VIP_ROWS.Contains(row))
            {
                return new VipTicket
                {
                    Row = row,
                    Col = col,
                    ShiftNo = shiftNo
                };
            }

            return new NormalTicket
            {
                Row = row,
                Col = col,
                ShiftNo = shiftNo
            };
        }

        public void PrintTicketInfo(Ticket ticket)
        {
            Console.WriteLine();
            Console.WriteLine("[Ticket Info]");
            Console.WriteLine(ticket.Info);
        }

        public Ticket[] CreateTicketArrByUserInput()
        {
            Console.Write("Number of ticket(s): ");
            int numberOfTickets = int.Parse(Console.ReadLine());
            Ticket[] tickets = new Ticket[numberOfTickets];

            for (int i = 0; i < numberOfTickets; i++)
            {
                Console.WriteLine();
                tickets[i] = CreateTicketByUserInput();
            }
            return tickets;
        }

        public void PrintTicketArrInfo(Ticket[] tickets)
        {
            foreach (Ticket ticket in tickets)
            {
                PrintTicketInfo(ticket);
            }
        }
    }
}
