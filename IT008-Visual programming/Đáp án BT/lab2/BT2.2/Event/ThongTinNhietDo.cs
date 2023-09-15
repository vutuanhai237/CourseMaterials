using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Event
{
    public class ThongTinNhietDo: System.EventArgs
    {
        private int nhietdo;
        public ThongTinNhietDo(int nhietdo)
        {
            this.nhietdo = nhietdo;
        }
        public int NhietDo
        {
            get { return nhietdo; }
            set { nhietdo = value; }
        }

    }
}
