using ActiveMQDoctor.entity;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ActiveMQDoctor.data
{
    class DataQuerry
    {
        private DataQuerry()
        {
            new DataQuerry();
        }

        public static BenhNhan findBN(string msbn)
        {
            SqlConnection con = DataConnect.CheckConnection();
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = @"SELECT * FROM BenhNhan WHERE msbn = @msbn";
            cmd.Parameters.Add("@msbn",SqlDbType.NVarChar,15);
            cmd.Parameters["@msbn"].Value = msbn;
            SqlDataReader reader = cmd.ExecuteReader();
            BenhNhan bn = new BenhNhan();
            while (reader.Read())
            {

                    bn.masoBN = reader.GetValue(0).ToString();
                    bn.soCMND = reader.GetValue(1).ToString();
                    bn.hoTen = reader.GetValue(2).ToString();
                    bn.diaChi = reader.GetValue(3).ToString();


            }

            reader.Close();
            con.Close();
            return bn;
        }

        public static BenhNhan findBNByCMND(string cmnd)
        {
            SqlConnection con = DataConnect.CheckConnection();
            con.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = @"SELECT * FROM BenhNhan WHERE socmnd = @cmnd";
            cmd.Parameters.Add("@cmnd", SqlDbType.NVarChar, 25);
            cmd.Parameters["@cmnd"].Value = cmnd;
            SqlDataReader reader = cmd.ExecuteReader();
            BenhNhan bn = new BenhNhan();
            while (reader.Read())
            {

                bn.masoBN = reader.GetValue(0).ToString();
                bn.soCMND = reader.GetValue(1).ToString();
                bn.hoTen = reader.GetValue(2).ToString();
                bn.diaChi = reader.GetValue(3).ToString();
            }
            reader.Close();
            con.Close();
            return bn;
        }
    }
}
