package de.saxsys.jms.server.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class ReceiverSync {

	@Resource(lookup = "jms/exampleQueue")
	private Queue queue;

	@Inject
	private JMSContext context;

	public String receiveMessage() {
		return context.createConsumer(queue).receiveBody(String.class);
	}
}
