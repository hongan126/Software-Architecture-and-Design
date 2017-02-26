using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
namespace HospitalObject
{
    public class ConnectDB
    {
        private static SqlConnection con = null;
        private ConnectDB()
        {
            con = ConnectDatabase.GetDBConnection("ADMIN", "QLKhamBenh", "lldtien", "thienthan");
            con.Open();
        }
        public static SqlConnection instance()
        {
            
            if (con == null)
                 new ConnectDB();
            return con;
        }
           public static void disconnect()
        {
            if(con!=null)
                con.Close();
        }
    }
    class ConnectDatabase
    {
        public static SqlConnection GetDBConnection(string source, string dtb, string username, string pass)
        {
            string connectString = "Data Source=" + source + ";Initial Catalog=" + dtb
                + ";User ID=" + username + ";Password=" + pass;
            //Data Source=ADMIN;Initial Catalog=QLKhamBenh;User ID=lldtien;Password=***********
            SqlConnection con = new SqlConnection(connectString);
            return con;
        }
    }
}
