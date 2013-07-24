package de.saxsys.jms.server.jms;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class Sender {

	@Resource(lookup = "jms/exampleQueue")
	private Queue queue;

	@Inject
	private JMSContext jmsContext;

	public String sendMessage() {
		String text = "Hello, it's " + new Date().toString();
		jmsContext.createProducer().send(queue, text);
		return text;
	}
}