using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BT4
{
    public partial class Message : Form
    {
        public Message(string text)
        {
            InitializeComponent();
            label2.Text = text;

        }

        private void Message_Load(object sender, EventArgs e)
        {
            ;
            timer1.Interval = 1000;
            timer1.Enabled = true;
            timer1.Start();
        }
        int i = 5;
        private void timer1_Tick(object sender, EventArgs e)
        {
            i--;
            label1.Text = "Message will close in " + i + " s";
            if (i == 0)
            {
                this.Close();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
