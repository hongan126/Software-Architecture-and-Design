using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ActiveMQDoctor.entity
{
    [Serializable]
    public class BenhNhan
    {
        private string MasoBN;

        public string masoBN
        {
            get { return MasoBN; }
            set { MasoBN = value; }
        }
        private string SoCMND;

        public string soCMND
        {
            get { return SoCMND; }
            set { SoCMND = value; }
        }
        private string HoTen;

        public string hoTen
        {
            get { return HoTen; }
            set { HoTen = value; }
        }
        private string DiaChi;

        public string diaChi
        {
            get { return DiaChi; }
            set { DiaChi = value; }
        }
        /*private List<KhamBenh> listKhamBenh;

        public List<KhamBenh> ListKhamBenh
        {
            get { return listKhamBenh; }
        }*/
        public BenhNhan(string masoBN, string soCMND, string hoTen, string diaChi)
        {
            this.MasoBN = masoBN;
            this.SoCMND = soCMND;
            this.HoTen = hoTen;
            this.DiaChi = diaChi;
           // this.listKhamBenh = new List<KhamBenh>();
        }

       /* public BenhNhan(string masoBN, string soCMND, string hoTen, string diaChi, List<KhamBenh> listKhamBenh)
        {
            this.masoBN = masoBN;
            this.soCMND = soCMND;
            this.hoTen = hoTen;
            this.diaChi = diaChi;
            this.listKhamBenh = listKhamBenh;
        }*/
        public BenhNhan()
        { }
    }
}
