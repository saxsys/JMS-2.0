package de.saxsys.jms.server.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;

@Stateless
public class ReceiverSync {

	@Resource(lookup = "jms/exampleTopic")
	private Topic topic;

	@Inject
	private JMSContext context;

	public String receive() {
		Message message = context.createConsumer(topic).receive();
		try {
			return message.getBody(String.class) + " " + message.getJMSExpiration();
		} catch (JMSException e) {
			return "ERROR";
		}
	}
}
