using ActiveMQDoctor.entity;
using ActiveMQDoctor.helper;
using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ActiveMQDoctor.activeMQ
{
    class ActiveMQConnect
    {
        private static IConnection con = null;
        private ActiveMQConnect()
        {
            IConnectionFactory factory = new ConnectionFactory("tcp://localhost:61616");
            con = factory.CreateConnection("admin", "admin");
            con.Start();
            
        }
        public static IConnection getConnection()
        {
            if (con == null)
                new ActiveMQConnect();
            return con;
        }
    }
}
