namespace DemoTicketApplication
{
    class VipTicket : Ticket
    {
        public override string Type => "Vip";

        public override int Price
        {
            get
            {
                switch (this.shiftNo)
                {
                    case 1:
                        return 8;
                    case 2:
                        return 10;
                    case 3:
                    case 4:
                        return 12;
                    default:
                        return -1;
                }
            }
        }
    }
}
