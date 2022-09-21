using System;
using System.Windows.Forms;

namespace DemoWinformGame
{
    public partial class Form1 : Form
    {
        private int gridSize = 5;

        public Form1()
        {
            InitializeComponent();
            InitializeGrid();
        }

        private void playButton_Click(object sender, EventArgs e)
        {
            AddButtonsToGrid();
        }

        private void InitializeGrid()
        {
            this.tableLayoutPanel.ColumnCount = gridSize;
            this.tableLayoutPanel.RowCount = gridSize;
            this.tableLayoutPanel.ColumnStyles.Clear();
            this.tableLayoutPanel.RowStyles.Clear();

            for (int i = 0; i < gridSize; i++)
            {
                this.tableLayoutPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100 / gridSize));
                this.tableLayoutPanel.RowStyles.Add(new RowStyle(SizeType.Percent, 100 / gridSize));
            }
        }

        private void AddButtonsToGrid()
        {
            this.tableLayoutPanel.Controls.Clear();

            for (int row = 0; row < gridSize; row++)
            {
                for (int col = 0; col < gridSize; col++)
                {
                    var button = new Button();
                    button.Text = string.Format("{0}{1}", row, col);
                    button.Dock = DockStyle.Fill;
                    this.tableLayoutPanel.Controls.Add(button, col, row);
                }
            }
        }
    }
}
