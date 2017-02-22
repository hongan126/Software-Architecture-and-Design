package main;

import javax.jms.JMSException;
import javax.naming.NamingException;

import form.FormDoctor;

public class Application {
	
	public static void main(String[] args) {
		try {
			new FormDoctor().setVisible(true);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
