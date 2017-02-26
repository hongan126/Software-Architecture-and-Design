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
namespace ReciverActiveMQ
{
    public partial class Form1 : Form
    {
         ListView lv;
        List<BenhNhan> listBenhNhan;
        public Form1()
        {
            listBenhNhan = new List<BenhNhan>();
            InitializeComponent();
            tf_masobenhnhan.ReadOnly = true;
            tf_socmnd.ReadOnly = true;
            tf_hoten.ReadOnly = true;
            init();
        }
        public void init()
        {
            IConnectionFactory fac = new ConnectionFactory("tcp://localhost:61616");
            IConnection con = fac.CreateConnection();
            con.Start();
            ISession session = con.CreateSession(AcknowledgementMode.AutoAcknowledge);
            ActiveMQQueue queu = new ActiveMQQueue("hospital");
            IMessageConsumer consumer = session.CreateConsumer(queu);
            
            consumer.Listener += consumer_Listener;
            Console.ReadLine();
        }
        public void consumer_Listener(IMessage message)
        {
            if (message is ActiveMQTextMessage)
            {
                ActiveMQTextMessage ms = (ActiveMQTextMessage)message;
                string s = ms.Text;
                BenhNhan bn = new XMLObjectConvert<BenhNhan>().XMLToObject(ms.Text);
                listBenhNhan.Add(bn);
                Console.WriteLine(bn.msbn);
                //lv_goikham.Items.Add("asdsadsadad");
                if (lv_goikham.InvokeRequired)
                {
                    lv_goikham.BeginInvoke(new MethodInvoker(() => lv_goikham.Items.Add(bn.msbn)));
                    //lv_goikham.Items.Add(".");
                }
            }
        }

        private void lv_goikham_SelectedIndexChanged(object sender, EventArgs e)
        {
            int index = -1;
            index = lv_goikham.FocusedItem.Index;
           
            Console.WriteLine(index);
            if(index != -1) {
                tf_diachi.Text = listBenhNhan.ElementAt(index).diachi;
                tf_hoten.Text = listBenhNhan.ElementAt(index).hoten;
                tf_masobenhnhan.Text = listBenhNhan.ElementAt(index).msbn;
                tf_socmnd.Text = listBenhNhan.ElementAt(index).socmnd;
            }
        }

        private void bt_capnhat_Click(object sender, EventArgs e)
        {
            foreach(ListViewItem item in lv_goikham.SelectedItems)
            {
                listBenhNhan.Remove(listBenhNhan.ElementAt(item.Index));
                lv_goikham.Items.Remove(item);
            }
            if(listBenhNhan.Count > 0)
            {
                Console.WriteLine("size of list != 0 ");
                
                lv_goikham.Items[lv_goikham.Items.Count - 1].Selected = true;
                lv_goikham.Items[lv_goikham.Items.Count - 1].Focused = true;
                lv_goikham.Select();
            }
            string msbn = tf_masobenhnhan.Text;
            string msbacsy = "BS01";
            DateTime time = DateTime.Now;
            string ngaykham = time.ToString("yyyy-MM-dd HH:mm:ss.fff");
            string ghichu = tf_noidungkham.Text;
            KhamBenh kb = new KhamBenh();
            kb.ngaykham = ngaykham;
            kb.msbacsy = msbacsy;
            kb.msbn = msbn;
            kb.ghichu = ghichu;
            KhamBenhDAO.SaveKhamBenhToDTB(kb);
                
        }
    }
}
