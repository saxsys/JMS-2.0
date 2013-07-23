package de.saxsys.jms.server.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import de.saxsys.jms.server.domain.User;

@MessageDriven(mappedName = "jms/exampleQueue")
public class MessageConsumerAsync implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			User user = message.getBody(User.class);
			System.out.println("Asynchronously received message: " + user);
		} catch (JMSException e) {
			System.err.println("Error while fetching message user: " + e.getMessage());
		}
	}
}
