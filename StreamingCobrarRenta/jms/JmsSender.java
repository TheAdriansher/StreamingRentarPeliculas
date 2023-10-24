/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

/**
 * Clase para enviar mensajes jms
 */
@Component
public class JmsSender {

    @Autowired
    JmsTemplate jmsTemplate;

    /**
     * Envia mensajes jms a una cola
     * @param message Mensaje a enviar
     * @param queueName Nombre de la cola destino
     */
    public void sendMessage(String message, String queueName) {        
        this.jmsTemplate.send(queueName, new MessageCreator(){

            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }

        });
    }
}
