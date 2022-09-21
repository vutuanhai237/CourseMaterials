namespace DemoTicketApplication
{
    class NormalTicket : Ticket
    {
        public override string Type => "Normal";

        public override int Price => 5;
    }
}
