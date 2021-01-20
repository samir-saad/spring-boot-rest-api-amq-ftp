package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class MessageConsumer {
    Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    private ObjectMapper mapper = new ObjectMapper();

    @JmsListener(destination = "inbound.queue")
//    @SendTo("outbound.queue")
    public void receiveMessage(final Message jsonMessage) throws JMSException {
        logger.info("Received message: " + jsonMessage);
        String response = null;
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            String payload = textMessage.getText();
            logger.info("Message payload: " + payload);
            /*Email email = null;
            try {
                email = mapper.readValue(payload, Email.class);
            } catch (Exception e) {
                logger.error("error converting to email", e);
            }*/
        }
    }
}
