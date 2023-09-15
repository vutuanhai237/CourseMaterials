using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Event
{
    class ManHinh
    {
        public ManHinh(NhietKe nhietKe)
        {
            nhietKe.ThayDoiNhietDo += new NhietKe.NhietKeHandler(HienThi);

        }
        public void HienThi(object obj, ThongTinNhietDo thongtinnhietdo)
        {
            Console.WriteLine("Nhiet do hien tai {0}", thongtinnhietdo.NhietDo);
        }
            

    }
}
