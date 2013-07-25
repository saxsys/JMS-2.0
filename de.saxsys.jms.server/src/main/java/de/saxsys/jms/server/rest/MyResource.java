package de.saxsys.jms.server.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.saxsys.jms.server.jms.ReceiverSync;
import de.saxsys.jms.server.jms.Sender;

@Stateless
@Path("jms")
public class MyResource {

	@Inject
	private Sender sender;

	@Inject
	private ReceiverSync receiver;

	@Path("send")
	@GET
	public String produce() {
		return sender.sendMessage();
	}

	@Path("receive")
	@GET
	public String consume() {
		return receiver.receive();
	}
}
