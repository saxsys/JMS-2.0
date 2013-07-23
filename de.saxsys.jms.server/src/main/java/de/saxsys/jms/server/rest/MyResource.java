package de.saxsys.jms.server.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.saxsys.jms.server.jms.MessageConsumerSync;
import de.saxsys.jms.server.jms.MessageProducer;

@Stateless
@Path("jms")
public class MyResource {

	@Inject
	private MessageProducer messageProducer;

	@Inject
	private MessageConsumerSync messageConsumer;

	@Path("send")
	@GET
	public String produce() {
		messageProducer.sendMessage();
		return "Sent";
	}

	@Path("receive")
	@GET
	public String consume() {
		messageConsumer.receiveMessage();
		return "Received";
	}
}
