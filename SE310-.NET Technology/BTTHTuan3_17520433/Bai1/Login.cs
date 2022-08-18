using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Windows.Forms;

namespace Bai1
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
            timer1.Start();
        }
        private void label1_Click(object sender, EventArgs e)
        {
            tabControl1.SelectTab(1);
        }
        private string Encrypt(string user, string password)
        {
            MD5 mh = MD5.Create();
            byte[] inputBytes = System.Text.Encoding.ASCII.GetBytes(user + "," + password);
            //mã hóa chuỗi đã chuyển
            byte[] hash = mh.ComputeHash(inputBytes);
            //tạo đối tượng StringBuilder (làm việc với kiểu dữ liệu lớn)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
            {
                sb.Append(hash[i].ToString("X2"));
            }
            return sb.ToString();
        }
        private int check(string k)
        {
            String value = ".";
            try
            {
                FileStream fs = new FileStream("test.txt", FileMode.Open, FileAccess.Read, FileShare.ReadWrite);
                StreamReader rd = new StreamReader(fs);

                value = rd.ReadToEnd();
                if (value.Contains(k))
                {
                    return 0;
                }
                else
                {
                    return 1;
                }


            }

            catch (Exception)
            {

            }
            return 1;
        }
        private void btn_start_Click(object sender, EventArgs e)
        {
            string k = Encrypt(txt_user.Text.ToString(), txt_password.Text.ToString());
            if (check(k) == 0)
            {
                this.Hide();
                Form1 fr = new Form1();
                fr.ShowDialog();
                this.Close();
            }
            else
            {
                MessageBox.Show("Login failed");
            }

        }

        private void btn_create_Click(object sender, EventArgs e)
        {
            if (txt_user1.Text == "" || txt_password1.Text == "")
            {
                MessageBox.Show("Create Account Failed");
            }
            else
            {
                if (txt_password1.Text.ToString() != txt_password2.Text.ToString())
                {
                    MessageBox.Show("Create Account Failed");
                }
                else
                {
                    try
                    {
                        string sb = Encrypt(txt_user1.Text, txt_password1.Text);
                        if (check(sb.ToString()) == 1)
                        {
                            using (StreamWriter sw = new StreamWriter("test.txt", true)
)
                            {
                                {
                                    MessageBox.Show("Create Account Successful");
                                    sw.WriteLine(sb.ToString());
                                    sw.Close();
                                    tabControl1.SelectTab(0);
                                    txt_user.Text = txt_user1.Text;
                                    txt_password.Text = txt_password1.Text;
                                    txt_user1.Clear();
                                    txt_password1.Clear();
                                    txt_password2.Clear();
                                }

                            }
                        }
                        else
                        {
                            MessageBox.Show("Account has already exist");

                        }

                    }
                    catch (Exception k) { MessageBox.Show(k.Message); }
                }
            }
        }
    }
}
