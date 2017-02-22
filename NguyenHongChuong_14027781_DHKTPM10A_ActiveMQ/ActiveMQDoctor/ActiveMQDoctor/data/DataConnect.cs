using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ActiveMQDoctor.data
{
    class DataConnect
    {
        private DataConnect()
        {
            new DataConnect();
        }
        
        public static SqlConnection CheckConnection()
        {
                string connetionString = @"Server = .\SQLEXPRESS;" + "Integrated Security = True;" + "Database = Hospital;"
            + "User ID = sa;" + "Password = sapassword";
                SqlConnection cnn;
                cnn = new SqlConnection(connetionString);
                return cnn;
           
           
        }
        public static void CloseConnection(SqlConnection con)
        {
            if(con!=null)
            {
                con.Close();
            }
        }
    }
}
