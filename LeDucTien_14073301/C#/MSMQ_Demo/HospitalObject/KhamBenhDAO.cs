using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HospitalObject
{
    public class KhamBenhDAO
    {
        public static void SaveKhamBenhToDTB(KhamBenh kb)
        {
            //try
            //{
                string q = "insert into khambenh(msbn,msbacsy,ngaykham,ghichu) values ('" + kb.msbn + "','" + kb.msbacsy + "','" + kb.ngaykham + "','" + kb.ghichu + "')";
                SqlCommand cmd = new SqlCommand(q, ConnectDB.instance());
                cmd.ExecuteNonQuery();
                cmd.Dispose();

            //}
            //catch(Exception e)
            //{
            //    e.ToString();
            //    //Console.WriteLine("Khong the kham 2 lan trong 1 ngay trong cung 1 bac si");
            //}
        }
        private static bool checkID(KhamBenh kb)
        {
            string q = "select * from khambenh where msbn = " + "'" + kb.msbn+ "'" 
                        + " and msbacsy = " + "'" + kb.msbacsy + "'";
            SqlCommand cmd = new SqlCommand(q, ConnectDB.instance());

            SqlDataReader dr = cmd.ExecuteReader();
            if (dr.HasRows)
                if (dr.Read())
                    return true;
            dr.Close();
            return false;
        }
    }
}
