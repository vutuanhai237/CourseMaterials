using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BT6._1
{
    public partial class Form1 : Form
    {
        //database connection 's information
        static String connString = @"Data Source=VTHCOMPUTER;Initial Catalog=Thongtinsinhvien;Integrated Security=True";
        SqlConnection connection = new SqlConnection(connString);
        //key of function: index = 0/Save, = 1/Add, = 2/Edit, = 3/Delete
        int index;
        //type: = 0/connect sql server, = 1/connect a text file in debug directory
        int type;

        public Form1()
        {
            InitializeComponent();
        }
        //Exit function
        private void btn_Exit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        //Create and execute query
        private SqlCommand open()
        {
            String sqlQuery = "select * from [Thongtinsinhvien].[dbo].[SINHVIEN]";
            SqlCommand command = new SqlCommand(sqlQuery, connection);
            return command;
        }
        //
        private void insert()
        {
            String sqlQuery = "insert into [Thongtinsinhvien].[dbo].[SINHVIEN] values (@masv, @hoten, @ngsinh)";
            SqlCommand command = new SqlCommand(sqlQuery, connection);
            command.Parameters.Add("@masv", SqlDbType.Char, 4).Value = txt_masv.Text.ToString();
            command.Parameters.Add("@hoten", SqlDbType.VarChar, 40).Value = txt_ten.Text.ToString();
            command.Parameters.Add("@ngsinh", SqlDbType.SmallDateTime, 4).Value = txt_ngsinh.Text.ToString();
            try
            {
                command.ExecuteNonQuery();
            }
            catch (Exception)
            {
                MessageBox.Show("Key combination!");
            }
        }
        //
        private void delete()
        {           
            int CurrentIndex = dataGridView1.CurrentRow.Index;
            string id = dataGridView1.Rows[CurrentIndex].Cells[0].Value.ToString();
            String sqlQuery = "delete from [Thongtinsinhvien].[dbo].[SINHVIEN] where MASV = '" + id + "'";
            SqlCommand command = new SqlCommand(sqlQuery, connection);
            try
            {
                command.ExecuteNonQuery();

            }
            catch (Exception)
            {
                //MessageBox.Show("Delete record failed!");
            }
        }
        //
        private void update()
        {       
            int CurrentIndex = dataGridView1.CurrentRow.Index;
            string id = dataGridView1.Rows[CurrentIndex].Cells[0].Value.ToString();
            String sqlQuery = "update [Thongtinsinhvien].[dbo].[SINHVIEN] set HOTEN = '" + txt_ten.Text.ToString() + "', NGSINH = '" + txt_ngsinh.Text.ToString() + 
                "' where MASV = '" + id + "'";
            SqlCommand command = new SqlCommand(sqlQuery, connection);
            MessageBox.Show(sqlQuery);
            try
            {
                command.ExecuteNonQuery();
            }
            catch (Exception)
            {
                MessageBox.Show("Update record failed!");
            }
        }
        //
        private void Connect()
        {        
            try
            {
                connection.Open();
            }
            catch (InvalidOperationException ex)
            {
                //MessageBox.Show("Cannot connect to server");
            }
            catch (Exception ex)
            {
                //MessageBox.Show("Cannot connect to server");
            }
            finally
            {
                //connection.Close();
            }
        }
        //Connect database
        private void btn_Connect_Click(object sender, EventArgs e)
        {
            type = 0;
            ReadData();
        }
        //Read database
        private void ReadData()
        {
            try
            {
                Connect();
                SqlCommand command = open();
                SqlDataReader reader = command.ExecuteReader();
                dataGridView1.Rows.Clear();
                //Read line by line
                while (reader.HasRows)
                {
                    if (reader.Read() == false) return;
                    dataGridView1.Rows.Add(reader.GetString(0), reader.GetString(1), reader.GetDateTime(2));
                }
                //command.Cancel();
                reader.Close();
                connection.Close();
            }
            catch (Exception) { }
        }
        //Save function
        private void btn_Save_Click(object sender, EventArgs e)
        {    
            if (type == 0)
            {
                try
                {
                    Connect();
                    if (index == 1)
                    {
                        insert();
                    }
                    if (index == 2)
                    {
                        update();
                    }
                    connection.Close();
                    ReadData();
                    index = 0;
                }
                catch (Exception) { }
            }
            if (type == 1)
            {
                FileStream fs = new FileStream("data.txt", FileMode.Open, FileAccess.Read, FileShare.Write);
                StreamWriter writer = new StreamWriter("data.txt");
                if (index == 2)
                {
                    int CurrentIndex = dataGridView1.CurrentRow.Index;
                    string id = dataGridView1.Rows[CurrentIndex].Cells[0].Value.ToString();                  
                    //Write line by line
                    for (int i = 0; i < dataGridView1.Rows.Count - 1; i++)
                    {
                        if (dataGridView1.Rows[i].Cells[0].Value.ToString() == id)
                        {
                            writer.WriteLine(txt_masv.Text.ToString() + "," + txt_ten.Text.ToString() + "," + txt_ngsinh.Text.ToString());
                        }
                        else
                        {
                            writer.WriteLine(dataGridView1.Rows[i].Cells[0].Value + "," + dataGridView1.Rows[i].Cells[1].Value + "," + dataGridView1.Rows[i].Cells[2].Value);
                        }
                    }
                    

                }
                if (index == 1)
                {
                    for (int i = 0; i < dataGridView1.Rows.Count - 1; i++)
                    {                     
                       writer.WriteLine(dataGridView1.Rows[i].Cells[0].Value + "," + dataGridView1.Rows[i].Cells[1].Value + "," + dataGridView1.Rows[i].Cells[2].Value);                   
                    }
                    writer.WriteLine(txt_masv.Text.ToString() + "," + txt_ten.Text.ToString() + "," + txt_ngsinh.Text.ToString());

                }
                writer.Dispose();
                writer.Close();
                fs.Close();
                FileStream fs2 = new FileStream("data.txt", FileMode.Open, FileAccess.Read, FileShare.Read);
                dataGridView1.Rows.Clear();
                String value = ".";
                StreamReader rd = new StreamReader(fs2);
                while (true)
                {
                    //Read line by line
                    value = rd.ReadLine();
                    if (String.IsNullOrEmpty(value) == true) break;
                    String[] col = value.Split(',');
                    dataGridView1.Rows.Add(col[0], col[1], col[2]);
                }
                rd.Close();
                index = 0;
            }
        }
       
        private void btn_Delete_Click(object sender, EventArgs e)
        {
            if (type == 0)
            {
                index = 0;
                Connect();                
                delete();
                connection.Close();
                ReadData();
            }
            else
            {
                FileStream fs = new FileStream("data.txt", FileMode.Open, FileAccess.Read, FileShare.Write);
                StreamWriter writer = new StreamWriter("data.txt");
                int CurrentIndex = dataGridView1.CurrentRow.Index;
                string id = dataGridView1.Rows[CurrentIndex].Cells[0].Value.ToString();
                for (int i = 0; i < dataGridView1.Rows.Count - 1; i++)
                {
                    if (dataGridView1.Rows[i].Cells[0].Value.ToString() != id)
                    {
                        writer.WriteLine(dataGridView1.Rows[i].Cells[0].Value + "," + dataGridView1.Rows[i].Cells[1].Value + "," + dataGridView1.Rows[i].Cells[2].Value);

                    }
                 
                }
                writer.Dispose();
                writer.Close();
                fs.Close();
                FileStream fs2 = new FileStream("data.txt", FileMode.Open, FileAccess.Read, FileShare.Read);
                dataGridView1.Rows.Clear();
                String value = ".";
                StreamReader rd = new StreamReader(fs2);
                while (true)
                {
                    //Read line by line
                    value = rd.ReadLine();
                    if (String.IsNullOrEmpty(value) == true) break;
                    String[] col = value.Split(',');
                    dataGridView1.Rows.Add(col[0], col[1], col[2]);
                }

                index = 0;
            }

        }
        private void btn_Add_Click(object sender, EventArgs e)
        {
            index = 1;
            txt_masv.Clear();
            txt_ngsinh.Clear();
            txt_ten.Clear();
        }
        private void btn_Update_Click(object sender, EventArgs e)
        {
            index = 2;
        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            try
            {
                int CurrentIndex = dataGridView1.CurrentRow.Index;
                txt_masv.Text = dataGridView1.Rows[CurrentIndex].Cells[0].Value.ToString();
                txt_ten.Text = dataGridView1.Rows[CurrentIndex].Cells[1].Value.ToString();
                txt_ngsinh.Text = dataGridView1.Rows[CurrentIndex].Cells[2].Value.ToString();
            }
            catch (Exception) { }
        }
        private void button7_Click_1(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (txt_search.Text == "") btn_Search.Enabled = false;
            else btn_Search.Enabled = true;
            if (index == 0)
            {
                btn_Add.Enabled = true;
                btn_Delete.Enabled = true;
                btn_Update.Enabled = true;
                btn_Save.Enabled = false;

                txt_masv.Enabled = false;
                txt_ngsinh.Enabled = false;
                txt_ten.Enabled = false;
            }
            if (index == 1)
            {
             
                btn_Add.Enabled = false;
                btn_Delete.Enabled = false;
                btn_Update.Enabled = false;
                btn_Save.Enabled = true;

                txt_masv.Enabled = true;
                txt_ngsinh.Enabled = true;
                txt_ten.Enabled = true;
            }
            if (index == 2)
            {
                btn_Add.Enabled = false;
                btn_Delete.Enabled = false;
                btn_Update.Enabled = false;
                btn_Save.Enabled = true;

                txt_masv.Enabled = false;
                txt_ngsinh.Enabled = true;
                txt_ten.Enabled = true;

            }
            if (index == 3)
            {
                btn_Add.Enabled = false;
                btn_Delete.Enabled = false;
                btn_Update.Enabled = false;
                btn_Save.Enabled = true;

                txt_masv.Enabled = false;
                txt_ngsinh.Enabled = false;
                txt_ten.Enabled = false;

            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }

        private void btn_Search_Click(object sender, EventArgs e)
        {
            if (type == 0)
            {
                btn_Connect.PerformClick();
                String searchvalue = txt_search.Text.ToString();
                int[] index = new int[50];
                string[] id = new string[50];
                string[] name = new string[50];
                string[] day = new string[50];
                int i = 0;
                foreach (DataGridViewRow row in dataGridView1.Rows)
                {
                    try
                    {
                        if (row.Cells[1].Value.ToString().Equals(searchvalue) || row.Cells[0].Value.ToString().Equals(searchvalue))
                        {
                            id[i] = dataGridView1.Rows[row.Index].Cells[0].Value.ToString();
                            name[i] = dataGridView1.Rows[row.Index].Cells[1].Value.ToString();
                            day[i] = dataGridView1.Rows[row.Index].Cells[2].Value.ToString();
                            i++;
                        }
                    }
                    catch (Exception)
                    {
                    }

                }
                dataGridView1.Rows.Clear();
                for (int j = 0; j < i; j++)
                {
                    dataGridView1.Rows.Add(id[j], name[j], day[j]);
                }
                connection.Close();
            }
            else
            {
                dataGridView1.Rows.Clear();
                String value = ".";
                FileStream fs = new FileStream("data.txt", FileMode.Open, FileAccess.Read, FileShare.ReadWrite);
                StreamReader rd = new StreamReader(fs);
                while (true)
                {
                    //Read line by line
                    value = rd.ReadLine();
                    if (String.IsNullOrEmpty(value) == true) break;
                    String[] col = value.Split(',');
                    if (col[0] == txt_search.Text.ToString() || col[1] == txt_search.Text.ToString())
                    {
                        dataGridView1.Rows.Add(col[0], col[1], col[2]);

                    }
                }
                rd.Close();
            }
        }

        private void btn_cnt_file_Click(object sender, EventArgs e)
        {
            type = 1;
            dataGridView1.Rows.Clear();
            String value = ".";
            FileStream fs = new FileStream("data.txt", FileMode.Open, FileAccess.Read, FileShare.ReadWrite);
            StreamReader rd = new StreamReader(fs);
            while (true)
            {
                //Read line by line
                value = rd.ReadLine();
                if (String.IsNullOrEmpty(value) == true) break;
                String[] col = value.Split(',');
                dataGridView1.Rows.Add(col[0], col[1], col[2]);
            }
            rd.Close();
        }

      
    }
}
