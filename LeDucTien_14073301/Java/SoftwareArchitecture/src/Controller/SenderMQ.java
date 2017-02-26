package Controller;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

import Models.BenhNhan;

public class SenderMQ {
	private static Connection connection;
	private static MessageProducer producer;
	private static Session session;
	
	public static SenderMQ instance(){
		return new SenderMQ();
	}
	private SenderMQ() {
		BasicConfigurator.configure();
		Properties pros = new Properties();
		pros.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		pros.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		InitialContext jindi;
		try {
			jindi = new InitialContext(pros);
			ConnectionFactory conFac = (ConnectionFactory) jindi.lookup("ConnectionFactory");
			connection = conFac.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue destination = (Queue) jindi.lookup("dynamicQueues/hospital");
			producer = session.createProducer(destination);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void SendText(BenhNhan benhNhan){
		TextMessage text;
		try {
			XMLConvert<BenhNhan> convert = new XMLConvert<BenhNhan>(benhNhan);
			String xml = convert.ObjectToXML(benhNhan);
			text = session.createTextMessage(xml);
			producer.send(text);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void CloseConnection() {
		if (connection != null)
			try {
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
