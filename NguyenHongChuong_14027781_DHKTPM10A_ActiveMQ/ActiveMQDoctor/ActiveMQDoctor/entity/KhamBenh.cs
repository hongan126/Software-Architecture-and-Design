using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ActiveMQDoctor.entity
{
    class KhamBenh
    {
        private DateTime ngayKham;

        public DateTime NgayKham
        {
            get { return ngayKham; }
            set { ngayKham = value; }
        }
        private string ghiChu;

        public string GhiChu
        {
            get { return ghiChu; }
            set { ghiChu = value; }
        }

        public KhamBenh(DateTime ngayKham, string ghiChu)
        {
            this.ngayKham = ngayKham;
            this.ghiChu = ghiChu;
        }
    }
}
