using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BT5._2
{
    public partial class Form1 : Form
    {
        //current variable
        string path;
        //
        public Form1()
        {
            InitializeComponent();        
        }
        //
        private void Form1_Load(object sender, EventArgs e)
        {
            Login fr = new Login();
            fr.Close();
        }
        //
        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }
        //
        private void ReadFile(FileStream fs)
        {
            //For over check condition while
            string value = ".";
            StreamReader rd = new StreamReader(fs);
            while (String.IsNullOrEmpty(value) == false)
            {
                //Read line by line
                value = rd.ReadLine();
                txt.Text += value + Environment.NewLine;
            }
        }
        //Open file by openfiledialog
        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {          
            OpenFileDialog theDialog = new OpenFileDialog();
            theDialog.Title = "Open Text File";
            theDialog.Filter = "TXT files|*.txt";
            theDialog.InitialDirectory = @"C:\";
            theDialog.Multiselect = false;
            DialogResult result = theDialog.ShowDialog();
            path = theDialog.FileName;   
            
            if (result == DialogResult.OK)
            {                
                FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read, FileShare.ReadWrite);               
                txt.Clear();
                ReadFile(fs);
                this.Text = "Text Editor";
            }
        }
        //Save file by savefiledialog
        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SaveFileDialog save = new SaveFileDialog();
            save.FileName = "Name.txt";
            save.Filter = "Text File | *.txt";

            if (save.ShowDialog() == DialogResult.OK)
            {
                StreamWriter writer = new StreamWriter(save.OpenFile());
                //Write line by line
                for(int i = 0; i < txt.Lines.Count(); i++)
                {
                    writer.WriteLine(txt.Lines[i]);
                }

                saveToolStripMenuItem.Enabled = false;
                saveMenuItem2.Enabled = false;
                this.Text = "Text Editor (Saved)";
                writer.Dispose();
                writer.Close();
            }                   
        }
        //Exit tool, save.PerformClick() if text has not saved
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (saveToolStripMenuItem.Enabled == true)
            {
                string message = "Want you save your changes on this file?";
                string caption = "Message";
                MessageBoxButtons buttons = MessageBoxButtons.YesNo;
                DialogResult result;
                // Displays the MessageBox.
                result = MessageBox.Show(this, message, caption, buttons,
                    MessageBoxIcon.Question, MessageBoxDefaultButton.Button1,
                    MessageBoxOptions.RightAlign);
                //User want to save text
                if (result == DialogResult.Yes)
                {
                    saveToolStripMenuItem.PerformClick();                   
                }
                //No
                else
                {
                    this.Hide();
                    Login fr = new Login();
                    fr.ShowDialog();
                    this.Close();
                }
            }
            //No
            else
            {
                this.Hide();
                Login fr = new Login();
                fr.ShowDialog();
                this.Close();
            }        
        }
        //Get pointer position
        private void txt_SelectionChanged(object sender, EventArgs e)
        {
            // Get the row
            int index =txt.SelectionStart;
            int line = txt.GetLineFromCharIndex(index);
            // Get the column
            int firstChar = txt.GetFirstCharIndexFromLine(line);
            int column = index - firstChar;

            statusBar.Text = "Line " + line + " Col " + column;
        }
        //Setting save_as/save button 's status (Enable/Disable)
        private void txt_TextChanged(object sender, EventArgs e)
        {
            //Case new file
            saveToolStripMenuItem.Enabled = true;
            saveMenuItem2.Enabled = true;
            //Case normal
            if (saveToolStripMenuItem.Enabled == true)
            {
                this.Text = "Text Editor (Unsaved)";
            }
            else
            {
                this.Text = "Text Editor (Saved)";
            }

        }
        //New file event
        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {
            //Case unsaved
            if (saveToolStripMenuItem.Enabled == true)
            {
                string message = "Want you save your changes on this file?";
                string caption = "Message";
                MessageBoxButtons buttons = MessageBoxButtons.YesNo;
                DialogResult result;
                // Displays the MessageBox.
                result = MessageBox.Show(this, message, caption, buttons,
                    MessageBoxIcon.Question, MessageBoxDefaultButton.Button1,
                    MessageBoxOptions.RightAlign);
                //If user want to save text
                if (result == DialogResult.Yes)
                {
                    saveToolStripMenuItem.PerformClick();
                    this.Close();
                }
                //No, create new file text, path = null
                else
                {
                    this.Text = "Text Editor";
                    path = "";
                    txt.Clear();
                }

            }
            //Case saved, create new file text, path = null
            else
            {
                path = "";
                txt.Clear();
            }
        }
        //
        private void saveMenuItem2_Click(object sender, EventArgs e)
        {
            try
            {
                SaveFileDialog save = new SaveFileDialog();
                save.FileName = "Name.txt";
                save.Filter = "Text File | *.txt";                
                StreamWriter writer = new StreamWriter(path);
                for (int i = 0; i < txt.Lines.Count(); i++)
                {
                    writer.WriteLine(txt.Lines[i]);
                }

                saveToolStripMenuItem.Enabled = false;
                saveMenuItem2.Enabled = false;
                this.Text = "Text Editor (Saved)";
                writer.Dispose();
                writer.Close();
            }
            catch (Exception) {
                saveToolStripMenuItem.PerformClick();
            }
           
        }
    }
}
