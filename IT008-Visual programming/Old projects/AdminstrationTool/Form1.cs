using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BT5._1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }
        private int time_out;
        private void btn_stop_Click(object sender, EventArgs e)
        {
            btn_stop.Enabled = false;
            timer1.Stop();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            try
            {
                time_out--;
                lbl_status.Text = "Timeout " + time_out + " (s)";
                if (time_out == 0)
                {
                    if (rd_restart.Checked == true)
                    {
                        timer1.Stop();
                        Process.Start("shutdown", "/r /t 0");
                        Application.Exit();
                    }

                    if (rd_shutdown.Checked == true)
                    {
                        timer1.Stop();
                        Process.Start("shutdown", "/s /t 0");
                        Application.Exit();
                    }                   
                    if (rd_sleep.Checked == true)
                    {
                        timer1.Stop();
                        Process.Start("shutdown", "/h");
                        Application.Exit();
                    }
                    if (rd_logout.Checked == true)
                    {
                        timer1.Stop();
                        Process.Start("shutdown", "/l");
                        Application.Exit();
                    }
                }
            }

            catch (Exception) {  }
           
        }

        private void btn_start_Click(object sender, EventArgs e)
        {
            btn_stop.Enabled = true;
            time_out = Convert.ToInt32(cb_timeout.Text);
            timer1.Start();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.button1.Text = "abc";
        }
    }
}
