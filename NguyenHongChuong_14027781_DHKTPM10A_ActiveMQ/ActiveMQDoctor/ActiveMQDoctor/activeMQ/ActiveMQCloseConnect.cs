using Apache.NMS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ActiveMQDoctor.activeMQ
{
    class ActiveMQCloseConnect
    {
        public static void closeConnect(IConnection con, ISession session)
        {
            if (session != null)
            {
                session.Close();
            }
            if (con != null)
            {
                con.Close();
            }
        }
    }
}
