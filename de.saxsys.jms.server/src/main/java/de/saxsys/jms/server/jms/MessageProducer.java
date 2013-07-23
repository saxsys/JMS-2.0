package de.saxsys.jms.server.jms;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import de.saxsys.jms.server.domain.User;

@Stateless
public class MessageProducer {

	@Resource(lookup = "jms/exampleQueue")
	private Queue queue;

	@Inject
	private JMSContext jmsContext;

	public void sendMessage() {
		User user = new User("sbley", new Date());
		jmsContext.createProducer().send(queue, user);
	}
}