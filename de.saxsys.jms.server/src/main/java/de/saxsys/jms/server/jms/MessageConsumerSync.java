package de.saxsys.jms.server.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

import de.saxsys.jms.server.domain.User;

@Stateless
public class MessageConsumerSync {

	@Inject
	private JMSContext context;

	@Resource(mappedName = "jms/exampleQueue")
	private Queue myQueue;

	public void receiveMessage() {
		try {
			User user = context.createConsumer(myQueue).receiveBody(User.class);
			System.out.println("Synchronously received message: " + user);
		} catch (JMSRuntimeException e) {
			System.err.println("Error while fetching message user: " + e.getMessage());
		}
	}
}