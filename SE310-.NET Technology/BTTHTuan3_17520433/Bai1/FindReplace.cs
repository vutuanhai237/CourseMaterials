using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Bai1
{
    public partial class FindReplace : Form
    {
        public static string text;
        public Form1 main_form = null;
        public FindReplace()
        {
            InitializeComponent();
           
        }

        public FindReplace(string _text, Form1 _main_form)
        {
            InitializeComponent();
            text = _text;
            main_form = _main_form;
        }
        private void btnFind_Click(object sender, EventArgs e)
        {
            string findvalue = txtFind.Text.ToString();
            int index = text.IndexOf(findvalue);    
            this.main_form.PassResultFind(index);
            this.Close();
        }

        private void btnReplace_Click(object sender, EventArgs e)
        {
            string new_text = text.Replace(txtFind.Text.ToString(), txtReplace.Text.ToString());
            this.main_form.PassResultReplace(new_text);
            this.Close();
        }
    }
}
