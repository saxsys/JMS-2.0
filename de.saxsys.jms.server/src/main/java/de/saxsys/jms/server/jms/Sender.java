package de.saxsys.jms.server.jms;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Stateless
public class Sender {

	@Resource(lookup = "jms/exampleTopic")
	private Topic topic;

	@Inject
	private JMSContext context;

	public String sendMessage() {
		String text = "Hey, it's " + new Date();
		context.createProducer().send(topic, text);
		return text;
	}
}