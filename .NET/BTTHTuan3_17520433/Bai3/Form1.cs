using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Bai3
{
    public partial class Form1 : Form
    {
        public FontFamily[] Families { get; }
        public static int i = 0;
        public Form1()
        {
            InitializeComponent();
        }
       

      

      

        private void Form1_Load(object sender, EventArgs e)
        {

            foreach (FontFamily oneFontFamily in FontFamily.Families)
            {
                Label label = new Label();
                label.Text = oneFontFamily.Name.ToString();
                label.Font = new Font(oneFontFamily.Name.ToString(), 9);

                if (label != null)
                {
                    label.Location = new System.Drawing.Point(0, 25 * (i++));
                    panel1.Controls.Add(label);
                }

            }
            int a = 0;
           
        }
     
     
    }
}
