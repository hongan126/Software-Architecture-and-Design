package Controller;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;

import org.apache.log4j.BasicConfigurator;

import Models.BenhNhan;

public class ReciverMMQ {
	 static IReciveMessage iReciveMessage = null;
	private static Connection connection;
	private static Session session;
	private static ReciverMMQ reciverMMQ = null;

	public static ReciverMMQ instance(IReciveMessage iReciveMessage) {
		ReciverMMQ.iReciveMessage = iReciveMessage;
		if (reciverMMQ != null)
			return reciverMMQ;
		else
			return reciverMMQ = new ReciverMMQ();
	}

	private ReciverMMQ() {
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
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message arg0) {

					TextMessage mess = (TextMessage) arg0;
					try {
						BenhNhan bn = ReciveText(mess.getText());
						iReciveMessage.OnReciveMessage(bn);
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					try {
//						System.out.println("----------" + ReciveText(mess.getText()).toString());
//					} catch (JMSException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (JAXBException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			});

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public BenhNhan ReciveText(String xml) throws JAXBException, JMSException {
		BenhNhan bn = new BenhNhan();
		return new XMLConvert<BenhNhan>(bn).XMLToObject(xml);
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
