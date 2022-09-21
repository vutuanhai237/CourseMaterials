using System;
using System.Drawing;
using System.Windows.Forms;

namespace DemoWeek2
{
    public partial class Form1 : Form
    {
        enum DrawMode
        {
            LINE,
            RECTANGLE,
            DIAMOND
        }

        private bool shouldDraw = false;
        private DrawMode drawMode = DrawMode.LINE;
        private Pen pen = new Pen(Color.Black, 3);
        private Point lastMousePosition;

        public Form1()
        {
            InitializeComponent();
        }

        private void lineButton_Click(object sender, EventArgs e)
        {
            drawMode = DrawMode.LINE;
            shouldDraw = false;
        }

        private void rectButton_Click(object sender, EventArgs e)
        {
            drawMode = DrawMode.RECTANGLE;
            shouldDraw = false;
        }

        private void drawingPanel_Click(object sender, EventArgs e)
        {
            // First click to panel
            if (!shouldDraw)
            {
                shouldDraw = true;
                lastMousePosition = drawingPanel.PointToClient(Cursor.Position);
                return;
            }

            // Second click to panel
            Point curMousePosition = drawingPanel.PointToClient(Cursor.Position);
            switch (drawMode)
            {
                case DrawMode.LINE:
                    DrawLine(lastMousePosition, curMousePosition);
                    break;
                case DrawMode.RECTANGLE:
                    DrawRect(lastMousePosition, curMousePosition);
                    break;
            }
            shouldDraw = false;
        }

        private void DrawLine(Point point1, Point point2)
        {
            using (Graphics g = drawingPanel.CreateGraphics())
            {
                g.DrawLine(pen, point1, point2);
            }
        }

        private void DrawRect(Point point1, Point point2)
        {
            using (Graphics g = drawingPanel.CreateGraphics())
            {
                float left = Math.Min(point1.X, point2.X);
                float top = Math.Min(point1.Y, point2.Y);
                float width = Math.Abs(point1.X - point2.X);
                float height = Math.Abs(point1.Y - point2.Y);
                g.DrawRectangle(pen, left, top, width, height);
            }
        }
    }
}
