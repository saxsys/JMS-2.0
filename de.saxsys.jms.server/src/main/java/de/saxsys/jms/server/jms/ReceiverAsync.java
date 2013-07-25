package de.saxsys.jms.server.jms;

import java.util.Date;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/exampleTopic")
public class ReceiverAsync implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(message.getIntProperty("currentTemperature"));
			System.out.println(message.getJMSPriority());
			System.out.println(new Date(message.getJMSExpiration()));
			System.out.println("I received: " + message.getBody(String.class));
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
