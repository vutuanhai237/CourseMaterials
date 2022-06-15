using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Bai2
{
    public partial class Form1 : Form
    {
        int istayTrang = 0;
        int iscaoVoi = 0;
        int ischupHinhRang = 0;
        int nrtramRang = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void btnThoat_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnThanhTien_Click(object sender, EventArgs e)
        {
            if (txtTenKH.Text == "")
            {
                MessageBox.Show("Chưa nhập tên khách hàng", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {

                if (isTayTrang.Checked) istayTrang = 1; else istayTrang = 0;
                if (isCaoVoi.Checked) iscaoVoi = 1; else iscaoVoi = 0;
                if (isChupHinhRang.Checked) ischupHinhRang = 1; else ischupHinhRang = 0;
                nrtramRang = Convert.ToInt32(Math.Round(nrTramRang.Value, 0));
                txtThanhTien.Text = ((istayTrang) * 100000 + iscaoVoi * 1200000 + ischupHinhRang*200000 + nrtramRang*80000).ToString();
                AddIntoDB();
            }
        }
        private void AddIntoDB ()
        {
            DataGridViewRow row = (DataGridViewRow)dataGridView1.Rows[0].Clone();
            row.Cells[0].Value = txtTenKH.Text;
            if (isTayTrang.Checked) row.Cells[1].Value = "Có"; else row.Cells[1].Value = "Không";
            if (isCaoVoi.Checked) row.Cells[2].Value = "Có"; else row.Cells[2].Value = "Không";
            if (isChupHinhRang.Checked) row.Cells[3].Value = "Có"; else row.Cells[3].Value = "Không";
            row.Cells[4].Value = Convert.ToInt32(Math.Round(nrTramRang.Value, 0));
            row.Cells[5].Value = txtThanhTien.Text;
            dataGridView1.Rows.Add(row);
        }

        private void btnXuat_Click(object sender, EventArgs e)
        {
            using (TextWriter tw = new StreamWriter("example.txt"))
            {
                for (int i = 0; i < dataGridView1.Rows.Count - 1; i++)
                {
                    for (int j = 0; j < dataGridView1.Columns.Count; j++)
                    {
                        tw.Write($"{dataGridView1.Rows[i].Cells[j].Value.ToString()}");

                        if (!(j == dataGridView1.Columns.Count - 1))
                        {
                            tw.Write(",");
                        }
                    }
                    tw.WriteLine();
                }
            }
            MessageBox.Show("Xuất thành công ở thư mục Debug", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);

        }
    }
}
