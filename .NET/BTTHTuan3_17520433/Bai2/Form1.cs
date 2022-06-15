using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _17520096_NguyenDuLich
{
    public partial class Form1 : Form
    {
        Color SelectedColor { get; set; } = Color.Red;
        ColorDialog ColorDialog { get; } = new ColorDialog();
        FontDialog FontDialog { get; } = new FontDialog();

        public Form1()
        {
            InitializeComponent();
            this.KeyPreview = true;

            foreach (Control item in panel1.Controls)
            {
                item.GotFocus += (sender, e) => { richTextBox1.Focus(); };
          
                item.Name = getkey(item.Text);
                switch (item.Name)
                {
                    case "~":
                        item.Name = "lde";
                        break;
                    case "-":
                        item.Name = "nus";
                        break;
                    case "+":
                        item.Name = "lus";
                        break;
                    case "[":
                        item.Name = "ets";
                        break;
                    case "]":
                        item.Name = "em6";
                        break;
                    case "\\":
                        item.Name = "em5";
                        break;
                    case ":":
                        item.Name = "em1";
                        break;
                    case "\"":
                        item.Name = "em7";
                        break;
                    case "ent":
                        item.Name = "ret";
                        break;
                    case "<":
                        item.Name = "mma";
                        break;
                    case ">":
                        item.Name = "iod";
                        break;
                    case "?":
                        item.Name = "ion";
                        break;
                    case "ctr":
                        item.Name = "con";
                        break;
                    case "alt":
                        item.Name = "men";
                        break;
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    case "0":
                        item.Name = "d"+item.Name;
                        break;
                    default:
                        break;
                }
            }
            //TransparentPanel panel = new TransparentPanel() { Dock = DockStyle.Fill };
            //panel1.Controls.Add(panel);
            //panel.BringToFront();

            richTextBox1.PreviewKeyDown += (sender, e) =>
            {
                Control[] c = panel1.Controls.Find(getkey(e.KeyCode), false);
                if (c.Length == 0)
                    return;
                c[0].BackColor = SelectedColor;
            };

            this.KeyUp += (sender, e) =>
            {
                Control[] c = panel1.Controls.Find(getkey(e.KeyCode), false);
                if (c.Length == 0)
                    return;
                if (c[0] is Button)
                    (c[0] as Button).UseVisualStyleBackColor = true;
            };
        }

        string getkey(object o)
        {
            string ret = o.ToString().ToLower();
            if (ret.StartsWith("oem"))
                return ret.Substring(ret.Length - 3, 3);
            if (ret.Length > 3)
                return ret.Substring(0, 3);
            return ret;
        }

        private void clearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            richTextBox1.Text = "";
        }

        private void highlightToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (ColorDialog.ShowDialog() == DialogResult.OK)
                SelectedColor = ColorDialog.Color;
        }

        private void fontToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (FontDialog.ShowDialog() == DialogResult.OK)
            {
                if (richTextBox1.SelectedText.Length > 0)
                    richTextBox1.SelectionFont = FontDialog.Font;
                else
                    richTextBox1.Font = FontDialog.Font;
            }
        }

        private void colorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (ColorDialog.ShowDialog() == DialogResult.OK)
            {
                if (richTextBox1.SelectedText.Length > 0)
                    richTextBox1.SelectionColor = ColorDialog.Color;
                else
                    richTextBox1.ForeColor = ColorDialog.Color;
            }
        }
    }
}
