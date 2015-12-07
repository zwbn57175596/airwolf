package com.zz.test.jms.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageProducer {

	private JmsTemplate template;

	private Destination destination;

	public void send(final String message) {

		template.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				Message m = session.createTextMessage(message);

				return m;

			}

		});

	}

	public void setDestination(Destination destination) {

		this.destination = destination;

	}

	public void setTemplate(JmsTemplate template) {

		this.template = template;

	}

}
