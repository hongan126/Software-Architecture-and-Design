namespace ReciverActiveMQ
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
            this.bt_goikham = new System.Windows.Forms.Button();
            this.lv_goikham = new System.Windows.Forms.ListView();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.bt_capnhat = new System.Windows.Forms.Button();
            this.tf_diachi = new System.Windows.Forms.TextBox();
            this.tf_hoten = new System.Windows.Forms.TextBox();
            this.tf_socmnd = new System.Windows.Forms.TextBox();
            this.tf_masobenhnhan = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.tf_noidungkham = new System.Windows.Forms.TextBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.bt_goikham);
            this.groupBox1.Controls.Add(this.lv_goikham);
            this.groupBox1.Location = new System.Drawing.Point(12, 4);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(192, 322);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Danh sách bện nhân chờ khám";
            // 
            // bt_goikham
            // 
            this.bt_goikham.Location = new System.Drawing.Point(13, 292);
            this.bt_goikham.Name = "bt_goikham";
            this.bt_goikham.Size = new System.Drawing.Size(162, 24);
            this.bt_goikham.TabIndex = 1;
            this.bt_goikham.Text = "Gọi khám ...";
            this.bt_goikham.UseVisualStyleBackColor = true;
            // 
            // lv_goikham
            // 
            this.lv_goikham.Location = new System.Drawing.Point(13, 21);
            this.lv_goikham.Name = "lv_goikham";
            this.lv_goikham.Size = new System.Drawing.Size(163, 260);
            this.lv_goikham.TabIndex = 0;
            this.lv_goikham.UseCompatibleStateImageBehavior = false;
            this.lv_goikham.SelectedIndexChanged += new System.EventHandler(this.lv_goikham_SelectedIndexChanged);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.bt_capnhat);
            this.groupBox2.Controls.Add(this.tf_diachi);
            this.groupBox2.Controls.Add(this.tf_hoten);
            this.groupBox2.Controls.Add(this.tf_socmnd);
            this.groupBox2.Controls.Add(this.tf_masobenhnhan);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.groupBox3);
            this.groupBox2.Location = new System.Drawing.Point(210, 7);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(350, 313);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Thông tin bệnh nhân được chọn";
            // 
            // bt_capnhat
            // 
            this.bt_capnhat.Location = new System.Drawing.Point(90, 284);
            this.bt_capnhat.Name = "bt_capnhat";
            this.bt_capnhat.Size = new System.Drawing.Size(177, 23);
            this.bt_capnhat.TabIndex = 9;
            this.bt_capnhat.Text = "Cập nhật thông tin khám bệnh";
            this.bt_capnhat.UseVisualStyleBackColor = true;
            this.bt_capnhat.Click += new System.EventHandler(this.bt_capnhat_Click);
            // 
            // tf_diachi
            // 
            this.tf_diachi.Location = new System.Drawing.Point(133, 111);
            this.tf_diachi.Multiline = true;
            this.tf_diachi.Name = "tf_diachi";
            this.tf_diachi.Size = new System.Drawing.Size(210, 72);
            this.tf_diachi.TabIndex = 8;
            // 
            // tf_hoten
            // 
            this.tf_hoten.Location = new System.Drawing.Point(133, 85);
            this.tf_hoten.Name = "tf_hoten";
            this.tf_hoten.Size = new System.Drawing.Size(210, 20);
            this.tf_hoten.TabIndex = 7;
            // 
            // tf_socmnd
            // 
            this.tf_socmnd.Location = new System.Drawing.Point(133, 59);
            this.tf_socmnd.Name = "tf_socmnd";
            this.tf_socmnd.Size = new System.Drawing.Size(210, 20);
            this.tf_socmnd.TabIndex = 6;
            // 
            // tf_masobenhnhan
            // 
            this.tf_masobenhnhan.Location = new System.Drawing.Point(133, 33);
            this.tf_masobenhnhan.Name = "tf_masobenhnhan";
            this.tf_masobenhnhan.Size = new System.Drawing.Size(210, 20);
            this.tf_masobenhnhan.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(87, 114);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(40, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Địa chỉ";
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(69, 88);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(58, 13);
            this.label3.TabIndex = 3;
            this.label3.Text = "Họ và Tên";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(72, 62);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Số CMND";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(37, 33);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(90, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Mã số bệnh nhân";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.tf_noidungkham);
            this.groupBox3.Location = new System.Drawing.Point(6, 203);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(337, 75);
            this.groupBox3.TabIndex = 0;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Nội dung khám";
            // 
            // tf_noidungkham
            // 
            this.tf_noidungkham.Location = new System.Drawing.Point(6, 19);
            this.tf_noidungkham.Multiline = true;
            this.tf_noidungkham.Name = "tf_noidungkham";
            this.tf_noidungkham.Size = new System.Drawing.Size(325, 50);
            this.tf_noidungkham.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(572, 326);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button bt_goikham;
        private System.Windows.Forms.ListView lv_goikham;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.TextBox tf_diachi;
        private System.Windows.Forms.TextBox tf_hoten;
        private System.Windows.Forms.TextBox tf_socmnd;
        private System.Windows.Forms.TextBox tf_masobenhnhan;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.TextBox tf_noidungkham;
        private System.Windows.Forms.Button bt_capnhat;
    }
}

