using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HospitalObject
{
    public class BenhNhanDAO
    {
        public static bool InsertBenhNhan(BenhNhan bn)
        {
            try
            {
                if(FindBenhNhanById(bn.msbn) == null && FindBenhNhanByCMND(bn.socmnd) == null)
                {
                    string q = "insert into benhnhan(msbn,socmnd,hoten,diachi) values ('" + bn.msbn + "','" + bn.socmnd + "','" + bn.hoten + "','" + bn.diachi + "')";
                    SqlCommand cmd = new SqlCommand(q, ConnectDB.instance());
                    cmd.ExecuteNonQuery();
                    cmd.Dispose();
                    Console.WriteLine("true");
                    return true;
                }
                } catch(Exception e)
                {
                    Console.WriteLine(e.ToString());
                }
            Console.WriteLine("false");
            return false;
        }
        public static BenhNhan FindBenhNhanById(string id)
        {
            string q = "select * from benhnhan where msbn = " + "'" + id + "'";
            SqlCommand cmd = new SqlCommand(q, ConnectDB.instance());
            BenhNhan bn = null;
            SqlDataReader dr = cmd.ExecuteReader();
            if (dr.HasRows)
            {
                Console.WriteLine("has row");
                if (dr.Read())
                {
                     bn = new BenhNhan();
                    bn.msbn = dr[0].ToString();
                    bn.socmnd = dr[1].ToString();
                    bn.hoten = dr[2].ToString();
                    bn.diachi = dr[3].ToString();
                    
                }
            }
            dr.Close();
            cmd.Dispose();
            return bn;
        }
        public static BenhNhan FindBenhNhanByCMND(string socmnd)
        {
            string q = "select * from benhnhan where socmnd = " + "'" + socmnd + "'";
            SqlCommand cmd = new SqlCommand(q, ConnectDB.instance());

            SqlDataReader dr = cmd.ExecuteReader();
            BenhNhan bn = null;
            if (dr.HasRows)
            {
                Console.WriteLine("has row");
                if (dr.Read())
                {
                    bn = new BenhNhan();
                    bn.msbn = dr[0].ToString();
                    bn.socmnd = dr[1].ToString();
                    bn.hoten = dr[2].ToString();
                    bn.diachi = dr[3].ToString();
                }
            }
            dr.Close();
            cmd.Dispose();
            return bn;
        }
    }
}
