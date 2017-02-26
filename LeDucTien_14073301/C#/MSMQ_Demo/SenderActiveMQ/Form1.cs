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
using HospitalObject;
namespace SenderActiveMQ
{
    public partial class Form1 : Form
    {
        private static string QUEUE_NAME = "hospital";
        IMessageProducer producer;
        public Form1()
        {
            ConnectDB.instance();
            InitializeComponent();
            init();
        }
        public void init()
        {
            IConnectionFactory fac = new ConnectionFactory("tcp://localhost:61616");
            IConnection con = fac.CreateConnection();
            con.Start();
            ISession session = con.CreateSession(AcknowledgementMode.AutoAcknowledge);
            ActiveMQQueue queu = new ActiveMQQueue(QUEUE_NAME);
            producer = session.CreateProducer(queu);
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void bt_luu_Click(object sender, EventArgs e)
        {
            BenhNhan bn = new BenhNhan();
            bn.diachi = tf_diachi.Text;
            bn.hoten = tf_hoten.Text;
            bn.msbn = tf_msbn.Text;
            bn.socmnd = tf_socmnd.Text;
            ConnectDB.instance();

            if(BenhNhanDAO.InsertBenhNhan(bn))
            {
                SendText(bn);
                MessageBox.Show("Success");
                tf_diachi.Text = "";
                tf_hoten.Text = "";
                tf_msbn.Text = "";
                tf_socmnd.Text = "";
                tf_diachi.Focus();
            }
            else
            {
                if (tf_msbn != null)
                {
                    SendText(BenhNhanDAO.FindBenhNhanById(tf_msbn.Text));
                    MessageBox.Show("Success");
                }
                else if(tf_socmnd != null)
                {
                    SendText(BenhNhanDAO.FindBenhNhanByCMND(tf_socmnd.Text));
                    MessageBox.Show("Success");
                }
                else
                    MessageBox.Show("Error");
            }
                
            ConnectDB.disconnect();
            Console.WriteLine("send oke");
            Console.ReadLine();
        }
    

        private void button1_Click(object sender, EventArgs e)
        {
            BenhNhan bn = BenhNhanDAO.FindBenhNhanById(tf_msbn.Text);
            if(bn != null)
            {
                tf_msbn.Text = bn.msbn;
                tf_hoten.Text = bn.hoten;
                tf_diachi.Text = bn.diachi;
                tf_socmnd.Text = bn.socmnd;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            BenhNhan bn = BenhNhanDAO.FindBenhNhanByCMND(tf_socmnd.Text);
            if (bn != null)
            {
                tf_msbn.Text = bn.msbn;
                tf_hoten.Text = bn.hoten;
                tf_diachi.Text = bn.diachi;
                tf_socmnd.Text = bn.socmnd;
            }
        }
        public void SendText(BenhNhan bn)
        {
            string xml = new XMLObjectConvert<BenhNhan>().ObjectToXML(bn);
            producer.Send(new ActiveMQTextMessage(xml));
        }

    }
}
