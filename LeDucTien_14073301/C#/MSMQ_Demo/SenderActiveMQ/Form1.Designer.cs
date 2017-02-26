namespace SenderActiveMQ
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.bt_luu = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.tf_socmnd = new System.Windows.Forms.TextBox();
            this.tf_hoten = new System.Windows.Forms.TextBox();
            this.tf_diachi = new System.Windows.Forms.TextBox();
            this.tf_msbn = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.bt_luu);
            this.groupBox1.Controls.Add(this.button2);
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Controls.Add(this.tf_socmnd);
            this.groupBox1.Controls.Add(this.tf_hoten);
            this.groupBox1.Controls.Add(this.tf_diachi);
            this.groupBox1.Controls.Add(this.tf_msbn);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(-3, 50);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(287, 216);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Thông tin bệnh nhân";
            // 
            // bt_luu
            // 
            this.bt_luu.Location = new System.Drawing.Point(113, 176);
            this.bt_luu.Name = "bt_luu";
            this.bt_luu.Size = new System.Drawing.Size(139, 23);
            this.bt_luu.TabIndex = 10;
            this.bt_luu.Text = "Lưu Thông tin";
            this.bt_luu.UseVisualStyleBackColor = true;
            this.bt_luu.Click += new System.EventHandler(this.bt_luu_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(258, 70);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(23, 23);
            this.button2.TabIndex = 9;
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(258, 38);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(23, 23);
            this.button1.TabIndex = 8;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // tf_socmnd
            // 
            this.tf_socmnd.Location = new System.Drawing.Point(113, 72);
            this.tf_socmnd.Name = "tf_socmnd";
            this.tf_socmnd.Size = new System.Drawing.Size(139, 20);
            this.tf_socmnd.TabIndex = 7;
            // 
            // tf_hoten
            // 
            this.tf_hoten.Location = new System.Drawing.Point(113, 103);
            this.tf_hoten.Name = "tf_hoten";
            this.tf_hoten.Size = new System.Drawing.Size(139, 20);
            this.tf_hoten.TabIndex = 6;
            // 
            // tf_diachi
            // 
            this.tf_diachi.Location = new System.Drawing.Point(113, 134);
            this.tf_diachi.Name = "tf_diachi";
            this.tf_diachi.Size = new System.Drawing.Size(139, 20);
            this.tf_diachi.TabIndex = 5;
            // 
            // tf_msbn
            // 
            this.tf_msbn.Location = new System.Drawing.Point(113, 41);
            this.tf_msbn.Name = "tf_msbn";
            this.tf_msbn.Size = new System.Drawing.Size(139, 20);
            this.tf_msbn.TabIndex = 4;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(60, 141);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "Dịa Chỉ";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(58, 110);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(43, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Họ Tên";
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(46, 79);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Số CMND";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 48);
            this.label1.Name = "label1";
            this.label1.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.label1.Size = new System.Drawing.Size(95, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Mã Số Bệnh Nhân";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label1.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(107, 19);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(61, 13);
            this.label5.TabIndex = 1;
            this.label5.Text = "Nhận Bệnh";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox tf_socmnd;
        private System.Windows.Forms.TextBox tf_hoten;
        private System.Windows.Forms.TextBox tf_diachi;
        private System.Windows.Forms.TextBox tf_msbn;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button bt_luu;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label5;
    }
}

