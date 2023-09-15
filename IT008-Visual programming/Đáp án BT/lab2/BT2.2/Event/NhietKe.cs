using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Event
{
    public class NhietKe
    {
        private int nhietdo;
        public delegate void NhietKeHandler(object obj, ThongTinNhietDo nhietDo);
        public event NhietKeHandler ThayDoiNhietDo;
        public NhietKe (int nhietdo)
        {
            this.nhietdo = nhietdo;
        }
        public int NhietDo
        {
            get { return nhietdo; }
            set { if (value != nhietdo) nhietdo = value; if (ThayDoiNhietDo != null) ThayDoiNhietDo(this, new ThongTinNhietDo(value)); }

        }


    }
}
