using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ActiveMQDoctor.entity
{
    class BacSi
    {
        private string msBacSi;

        public string MsBacSi
        {
            get { return msBacSi; }
            set { msBacSi = value; }
        }
        private string hotenBS;

        public string HotenBS
        {
            get { return hotenBS; }
            set { hotenBS = value; }
        }
        private List<KhamBenh> listKhamBenh;

        public List<KhamBenh> ListKhamBenh
        {
            get { return listKhamBenh; }
        }

        public BacSi(string msBacSi, string hotenBS, List<KhamBenh> listKhamBenh)
        {
            
            this.msBacSi = msBacSi;
            this.hotenBS = hotenBS;
            this.listKhamBenh = listKhamBenh;
        }

        public BacSi(string msBacSi, string hotenBS)
        {
           
            this.msBacSi = msBacSi;
            this.hotenBS = hotenBS;
            this.listKhamBenh = new List<KhamBenh>();
        }

    }
}
