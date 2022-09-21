using System;

namespace DemoTicketApplication
{
    /*
     * Ticket Shift Info
     * Shift 1 = 9:00, Shift 2 = 14:00, Shift 3 = 18:00, Shift 4 = 22:00
     */

    public abstract class Ticket
    {
        protected char row;
        protected int col;
        protected int shiftNo;

        public char Row { get => row; set => row = value; }
        public int Col { get => col; set => col = value; }
        public int ShiftNo { get => shiftNo; set => shiftNo = value; }

        public Ticket(char row, int col, int shiftNo)
        {
            this.row = row;
            this.col = col;
            this.shiftNo = shiftNo;
        }

        public abstract string Type { get; }
        public abstract int Price { get; }

        public string ShiftTime
        {
            get
            {
                switch (shiftNo)
                {
                    case 1:
                        return "09:00";
                    case 2:
                        return "14:00";
                    case 3:
                        return "18:00";
                    case 4:
                        return "22:00";
                    default:
                        return "";
                }
            }
        }

        public void Print()
        {
            Console.WriteLine(string.Format(
                    "\n[Ticket Info]\n" +
                    "- Seat: {0}{1}\n" +
                    "- Shift: {2}\n" +
                    "- Ticket Type: {3}\n" +
                    "- Price: ${4}",
                    this.row, this.col, this.ShiftTime, this.Type, this.Price));
        }
    }
}
