
namespace DemoWinformApp
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.nudFirstNum = new System.Windows.Forms.NumericUpDown();
            this.nudSecondNum = new System.Windows.Forms.NumericUpDown();
            this.btnTong = new System.Windows.Forms.Button();
            this.btnHieu = new System.Windows.Forms.Button();
            this.btnTich = new System.Windows.Forms.Button();
            this.btnThuong = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.nudFirstNum)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSecondNum)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(42, 49);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(68, 15);
            this.label1.TabIndex = 0;
            this.label1.Text = "Số thứ nhất";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(42, 93);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "Số thứ hai";
            // 
            // nudFirstNum
            // 
            this.nudFirstNum.Location = new System.Drawing.Point(116, 47);
            this.nudFirstNum.Name = "nudFirstNum";
            this.nudFirstNum.Size = new System.Drawing.Size(120, 23);
            this.nudFirstNum.TabIndex = 2;
            // 
            // nudSecondNum
            // 
            this.nudSecondNum.Location = new System.Drawing.Point(116, 91);
            this.nudSecondNum.Name = "nudSecondNum";
            this.nudSecondNum.Size = new System.Drawing.Size(120, 23);
            this.nudSecondNum.TabIndex = 3;
            // 
            // btnTong
            // 
            this.btnTong.Location = new System.Drawing.Point(42, 141);
            this.btnTong.Name = "btnTong";
            this.btnTong.Size = new System.Drawing.Size(194, 23);
            this.btnTong.TabIndex = 4;
            this.btnTong.Text = "Tổng";
            this.btnTong.UseVisualStyleBackColor = true;
            this.btnTong.Click += new System.EventHandler(this.btnTong_Click);
            // 
            // btnHieu
            // 
            this.btnHieu.Location = new System.Drawing.Point(42, 189);
            this.btnHieu.Name = "btnHieu";
            this.btnHieu.Size = new System.Drawing.Size(194, 23);
            this.btnHieu.TabIndex = 5;
            this.btnHieu.Text = "Hiệu";
            this.btnHieu.UseVisualStyleBackColor = true;
            this.btnHieu.Click += new System.EventHandler(this.btnHieu_Click);
            // 
            // btnTich
            // 
            this.btnTich.Location = new System.Drawing.Point(42, 237);
            this.btnTich.Name = "btnTich";
            this.btnTich.Size = new System.Drawing.Size(194, 23);
            this.btnTich.TabIndex = 6;
            this.btnTich.Text = "Tích";
            this.btnTich.UseVisualStyleBackColor = true;
            this.btnTich.Click += new System.EventHandler(this.btnTich_Click);
            // 
            // btnThuong
            // 
            this.btnThuong.Location = new System.Drawing.Point(42, 290);
            this.btnThuong.Name = "btnThuong";
            this.btnThuong.Size = new System.Drawing.Size(194, 23);
            this.btnThuong.TabIndex = 7;
            this.btnThuong.Text = "Thương";
            this.btnThuong.UseVisualStyleBackColor = true;
            this.btnThuong.Click += new System.EventHandler(this.btnThuong_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(291, 364);
            this.Controls.Add(this.btnThuong);
            this.Controls.Add(this.btnTich);
            this.Controls.Add(this.btnHieu);
            this.Controls.Add(this.btnTong);
            this.Controls.Add(this.nudSecondNum);
            this.Controls.Add(this.nudFirstNum);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.nudFirstNum)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSecondNum)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown nudFirstNum;
        private System.Windows.Forms.NumericUpDown nudSecondNum;
        private System.Windows.Forms.Button btnTong;
        private System.Windows.Forms.Button btnHieu;
        private System.Windows.Forms.Button btnTich;
        private System.Windows.Forms.Button btnThuong;
    }
}

