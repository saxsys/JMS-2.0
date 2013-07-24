package de.saxsys.jms.server.jms;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class Sender {

	@Resource
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "jms/exampleQueue")
	private Queue queue;

	public String sendMessage() {
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer producer = session.createProducer(queue);
			TextMessage message = session.createTextMessage("Hello, it's " + new Date().toString());
			producer.send(message);
			return message.getText();
		} catch (JMSException e) {
			return "ERROR";
		}
	}
}