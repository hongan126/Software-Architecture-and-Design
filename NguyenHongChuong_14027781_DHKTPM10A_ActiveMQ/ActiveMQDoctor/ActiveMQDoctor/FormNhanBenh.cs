using ActiveMQDoctor.activeMQ;
using ActiveMQDoctor.data;
using ActiveMQDoctor.entity;
using ActiveMQDoctor.helper;
using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ActiveMQNurse

{
    public partial class FormNhanBenh : Form
    {
        public FormNhanBenh()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void FormNhanBenh_Load(object sender, EventArgs e)
        {

        }

        private void btnLuuTT_Click(object sender, EventArgs e)
        {
            string masoBN = txtMaSoBN.Text.Trim();
            string soCMND = txtSoCMND.Text.Trim();
            string hoTen = txtHoTen.Text.Trim();
            string diachi = txtDiaChi.Text.Trim();
            BenhNhan bn = new BenhNhan(masoBN, soCMND, hoTen, diachi);
            IConnectionFactory factory = new ConnectionFactory("tcp://localhost:61616");
            IConnection con = factory.CreateConnection("admin", "admin");
            con.Start();
            ISession session = con.CreateSession(AcknowledgementMode.AutoAcknowledge);
            ActiveMQQueue destination = new ActiveMQQueue("hospital");
            IMessageProducer producer = session.CreateProducer(destination);
            producer.Send(bn);

            ActiveMQCloseConnect.closeConnect(con, session);
            Console.WriteLine("MESSAGE WAS SENT!!!!!!");
        }

        private void btnTimkiemMaBN_Click(object sender, EventArgs e)
        {
            BenhNhan bn = DataQuerry.findBN(txtMaSoBN.Text.Trim());
            txtMaSoBN.Text = bn.masoBN;
            txtSoCMND.Text = bn.soCMND;
            txtHoTen.Text = bn.hoTen;
            txtDiaChi.Text = bn.diaChi;
        }

        private void btnTimkiemCMND_Click(object sender, EventArgs e)
        {
            BenhNhan bn = DataQuerry.findBNByCMND(txtSoCMND.Text.Trim());
            txtMaSoBN.Text = bn.masoBN;
            txtSoCMND.Text = bn.soCMND;
            txtHoTen.Text = bn.hoTen;
            txtDiaChi.Text = bn.diaChi;
        }
    }
}
