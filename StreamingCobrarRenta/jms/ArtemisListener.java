/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.ConcatenarBusiness;
import com.soa.dto.Persona;
import com.soa.dto.Respuesta;

/**
 * Class for receiving messages in an artemis queue
 */
@Component
public class ArtemisListener {
    
    @Autowired
    private ConcatenarBusiness business;
    
    @Autowired
    private JmsSender sender;

    @Value("${queue.name.out}")
    private String outQueueName;

    @JmsListener(destination = "${queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));        
        Gson gson = new Gson();
        Persona persona = gson.fromJson(message, Persona.class);
        System.out.println(persona);
        Respuesta respuesta = business.formarNombre(persona);
        System.out.println(respuesta);
        try {
            sender.sendMessage(respuesta.toString(), outQueueName);
            System.out.println(String.format("Mensaje enviado: %s", 
                    respuesta.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }       
        
    }
}
