using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace DemoStudentManagement
{
    public partial class Form1 : Form
    {
        private const string CONNECTION_STRING = "Data Source=DESKTOP-UNPHIQP\\SQLEXPRESS;Initial Catalog=demo;Integrated Security=True";

        public Form1()
        {
            InitializeComponent();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            using (var conn = new SqlConnection(CONNECTION_STRING))
            {
                conn.Open();
                var query = "SELECT * FROM Students";
                var adapter = new SqlDataAdapter(query, conn);
                var dt = new DataTable();
                adapter.Fill(dt);
                dgvStudent.DataSource = dt;
            }
        }
    }
}
