using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTap4
{
    public partial class Form1 : Form
    {
        private AppService app;
        private List<Student> currentListStds;
        private List<Class> currentListClasses;
        private Student selectedStd;

        public Form1()
        {
            InitializeComponent();
        }

        private void txbStdScore_Validating(object sender, CancelEventArgs e)
        {
            if (!float.TryParse(this.txbStdScore.Text, out float result))
            {
                string errorMsg = "Điểm phải là số";
                e.Cancel = true;
                this.txbStdScore.Focus();
                this.errProvDecimal.SetError(sender as Control, errorMsg);
                MessageBox.Show(errorMsg, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            } else
            {
                e.Cancel = false;
                this.errProvDecimal.SetError(sender as Control, "");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // Create the app service and load initial data
            this.app = new AppService();
            this.currentListStds = this.app.GetAllStudents().ToList();
            this.currentListClasses = this.app.GetAllClasses().ToList();

            this.dtGVStdList.DataSource = this.currentListStds;
            this.cbbStdClass.DataSource = this.currentListClasses;
            this.cbbStdClass.DisplayMember = "Name";
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            this.BindFormToSelectedStudent();
            if (!this.app.UpdateStudent(this.selectedStd, out string errorMsg)) {
                MessageBox.Show(errorMsg, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            this.ResetAllControlValues();
            this.dtGVStdList.DataSource = this.app.GetAllStudents().ToList();
            this.txbStdCode.Enabled = true;
        }

        private void ResetAllControlValues()
        {
            this.txbStdCode.Text =
            this.txbStdName.Text =
            this.txbStdAddress.Text =
            this.txbStdScore.Text = String.Empty;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Student newStd = new Student()
            {
                Code = this.txbStdCode.Text,
                Name = this.txbStdName.Text,
                DateOfBirth = this.dtPickerStdBirth.Value,
                Gender = this.cbStdGender.Checked ? "Nam" : "Nữ",
                Address = this.txbStdAddress.Text,
                Score = float.Parse(this.txbStdScore.Text),
                ClassId = (this.cbbStdClass.SelectedItem as Class).Id
            };
            if (!this.app.AddStudent(newStd, out string errorMsg))
            {
                MessageBox.Show(errorMsg, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            MessageBox.Show("Thêm học sinh mới thành công");
            // Reload students
            this.dtGVStdList.DataSource = this.app.GetAllStudents().ToList();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (this.selectedStd == null)
            {
                MessageBox.Show("Bạn chưa chọn học sinh");
                return;
            }
            this.app.DeleteStudent(this.selectedStd.Code, out string msg);
            MessageBox.Show(msg);
            this.dtGVStdList.DataSource = this.app.GetAllStudents().ToList();
        }

        private void dtGVStdList_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            this.selectedStd = this.dtGVStdList.Rows[e.RowIndex].DataBoundItem as Student;
            this.BindSelectedStudentToForm();
            this.btnDelete.Enabled = true;
            this.txbStdCode.Enabled = false;
        }

        private void BindSelectedStudentToForm()
        {
            this.txbStdCode.Text = this.selectedStd.Code;
            this.txbStdName.Text = this.selectedStd.Name;
            this.dtPickerStdBirth.Value = this.selectedStd.DateOfBirth;
            this.cbStdGender.Checked = this.selectedStd.IsMale();
            this.txbStdAddress.Text = this.selectedStd.Address;
            this.txbStdScore.Text = this.selectedStd.Score.ToString();
            this.cbbStdClass.SelectedItem = this.GetClassOfStudent(this.selectedStd.ClassId);
        }

        private void BindFormToSelectedStudent()
        {
            this.selectedStd.Code = this.txbStdCode.Text;
            this.selectedStd.Name = this.txbStdName.Text;
            this.selectedStd.DateOfBirth = this.dtPickerStdBirth.Value;
            this.selectedStd.Gender = this.cbStdGender.Checked ? "Nam" : "Nữ";
            this.selectedStd.Address = this.txbStdAddress.Text;
            this.selectedStd.Score = float.Parse(this.txbStdScore.Text);
            this.selectedStd.ClassId = (this.cbbStdClass.SelectedItem as Class).Id;
        }

        private Class GetClassOfStudent(int classId)
        {
            return this.cbbStdClass.Items.Cast<Class>().Where(cl => cl.Id == classId).First();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.app.Close();       // Close the app service
            Application.Exit();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            this.ResetAllControlValues();
        }
    }
}
