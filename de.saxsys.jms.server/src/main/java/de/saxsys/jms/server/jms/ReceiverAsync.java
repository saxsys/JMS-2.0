package de.saxsys.jms.server.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/exampleQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class ReceiverAsync implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("I received: " + message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
