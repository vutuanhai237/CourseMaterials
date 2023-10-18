namespace BT5._1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rd_logout = new System.Windows.Forms.RadioButton();
            this.rd_shutdown = new System.Windows.Forms.RadioButton();
            this.rd_restart = new System.Windows.Forms.RadioButton();
            this.rd_sleep = new System.Windows.Forms.RadioButton();
            this.cb_timeout = new System.Windows.Forms.ComboBox();
            this.lbl_status = new System.Windows.Forms.Label();
            this.btn_start = new System.Windows.Forms.Button();
            this.btn_stop = new System.Windows.Forms.Button();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.colorDialog1 = new System.Windows.Forms.ColorDialog();
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.rd_logout);
            this.groupBox1.Controls.Add(this.rd_shutdown);
            this.groupBox1.Controls.Add(this.rd_restart);
            this.groupBox1.Controls.Add(this.rd_sleep);
            this.groupBox1.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox1.Location = new System.Drawing.Point(24, 23);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.groupBox1.Size = new System.Drawing.Size(630, 119);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            // 
            // rd_logout
            // 
            this.rd_logout.AutoSize = true;
            this.rd_logout.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.rd_logout.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rd_logout.Location = new System.Drawing.Point(482, 46);
            this.rd_logout.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.rd_logout.Name = "rd_logout";
            this.rd_logout.Size = new System.Drawing.Size(125, 40);
            this.rd_logout.TabIndex = 5;
            this.rd_logout.TabStop = true;
            this.rd_logout.Text = "Logout";
            this.rd_logout.UseVisualStyleBackColor = true;
            // 
            // rd_shutdown
            // 
            this.rd_shutdown.AutoSize = true;
            this.rd_shutdown.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.rd_shutdown.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rd_shutdown.Location = new System.Drawing.Point(306, 46);
            this.rd_shutdown.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.rd_shutdown.Name = "rd_shutdown";
            this.rd_shutdown.Size = new System.Drawing.Size(161, 40);
            this.rd_shutdown.TabIndex = 3;
            this.rd_shutdown.TabStop = true;
            this.rd_shutdown.Text = "Shutdown";
            this.rd_shutdown.UseVisualStyleBackColor = true;
            // 
            // rd_restart
            // 
            this.rd_restart.AutoSize = true;
            this.rd_restart.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.rd_restart.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rd_restart.Location = new System.Drawing.Point(162, 46);
            this.rd_restart.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.rd_restart.Name = "rd_restart";
            this.rd_restart.Size = new System.Drawing.Size(124, 40);
            this.rd_restart.TabIndex = 2;
            this.rd_restart.TabStop = true;
            this.rd_restart.Text = "Restart";
            this.rd_restart.UseVisualStyleBackColor = true;
            // 
            // rd_sleep
            // 
            this.rd_sleep.AutoSize = true;
            this.rd_sleep.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.rd_sleep.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rd_sleep.Location = new System.Drawing.Point(36, 46);
            this.rd_sleep.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.rd_sleep.Name = "rd_sleep";
            this.rd_sleep.Size = new System.Drawing.Size(107, 40);
            this.rd_sleep.TabIndex = 1;
            this.rd_sleep.TabStop = true;
            this.rd_sleep.Text = "Sleep";
            this.rd_sleep.UseVisualStyleBackColor = true;
            // 
            // cb_timeout
            // 
            this.cb_timeout.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cb_timeout.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cb_timeout.FormattingEnabled = true;
            this.cb_timeout.Items.AddRange(new object[] {
            "5",
            "10",
            "15",
            "20",
            "30",
            "60"});
            this.cb_timeout.Location = new System.Drawing.Point(342, 154);
            this.cb_timeout.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.cb_timeout.Name = "cb_timeout";
            this.cb_timeout.Size = new System.Drawing.Size(308, 44);
            this.cb_timeout.TabIndex = 1;
            // 
            // lbl_status
            // 
            this.lbl_status.AutoSize = true;
            this.lbl_status.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_status.Location = new System.Drawing.Point(20, 160);
            this.lbl_status.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.lbl_status.Name = "lbl_status";
            this.lbl_status.Size = new System.Drawing.Size(144, 36);
            this.lbl_status.TabIndex = 2;
            this.lbl_status.Text = "Timeout (s)";
            // 
            // btn_start
            // 
            this.btn_start.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.btn_start.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_start.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_start.ForeColor = System.Drawing.Color.White;
            this.btn_start.Location = new System.Drawing.Point(24, 213);
            this.btn_start.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.btn_start.Name = "btn_start";
            this.btn_start.Size = new System.Drawing.Size(312, 79);
            this.btn_start.TabIndex = 3;
            this.btn_start.Text = "Start";
            this.btn_start.UseVisualStyleBackColor = false;
            this.btn_start.Click += new System.EventHandler(this.btn_start_Click);
            // 
            // btn_stop
            // 
            this.btn_stop.BackColor = System.Drawing.Color.Red;
            this.btn_stop.Enabled = false;
            this.btn_stop.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btn_stop.Font = new System.Drawing.Font("Segoe UI", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_stop.ForeColor = System.Drawing.Color.White;
            this.btn_stop.Location = new System.Drawing.Point(348, 213);
            this.btn_stop.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.btn_stop.Name = "btn_stop";
            this.btn_stop.Size = new System.Drawing.Size(306, 79);
            this.btn_stop.TabIndex = 4;
            this.btn_stop.Text = "Stop";
            this.btn_stop.UseVisualStyleBackColor = false;
            this.btn_stop.Click += new System.EventHandler(this.btn_stop_Click);
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(245, 406);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(342, 152);
            this.button1.TabIndex = 5;
            this.button1.Text = "Nut home";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(678, 626);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btn_stop);
            this.Controls.Add(this.btn_start);
            this.Controls.Add(this.lbl_status);
            this.Controls.Add(this.cb_timeout);
            this.Controls.Add(this.groupBox1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.Name = "Form1";
            this.Text = "System ";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton rd_shutdown;
        private System.Windows.Forms.RadioButton rd_restart;
        private System.Windows.Forms.RadioButton rd_sleep;
        private System.Windows.Forms.ComboBox cb_timeout;
        private System.Windows.Forms.Label lbl_status;
        private System.Windows.Forms.Button btn_start;
        private System.Windows.Forms.Button btn_stop;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.RadioButton rd_logout;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.Button button1;
    }
}

