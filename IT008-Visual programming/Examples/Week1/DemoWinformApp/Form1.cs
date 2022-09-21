using System;
using System.Windows.Forms;

namespace DemoWinformApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnTong_Click(object sender, EventArgs e)
        {
            int tong = (int)(nudFirstNum.Value + nudSecondNum.Value);
            MessageBox.Show(tong.ToString(), "Tổng hai số", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnHieu_Click(object sender, EventArgs e)
        {
            int hieu = (int)(nudFirstNum.Value - nudSecondNum.Value);
            MessageBox.Show(hieu.ToString(), "Hiệu hai số", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnTich_Click(object sender, EventArgs e)
        {
            int tich = (int)(nudFirstNum.Value * nudSecondNum.Value);
            MessageBox.Show(tich.ToString(), "Tích hai số", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnThuong_Click(object sender, EventArgs e)
        {
            if (nudSecondNum.Value == 0)
            {
                MessageBox.Show("Không thể chia cho 0", "Thương hai số", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                float thuong = (float)(nudFirstNum.Value / nudSecondNum.Value);
                MessageBox.Show(thuong.ToString(), "Thương hai số", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }
    }
}
