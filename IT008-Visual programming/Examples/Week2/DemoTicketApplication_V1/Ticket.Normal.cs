namespace DemoTicketApplication
{
    class NormalTicket : Ticket
    {
        public NormalTicket(char row, int col, int shiftNo) : base(row, col, shiftNo) { }

        public override string Type => "Normal";

        public override int Price => 5;
    }
}
