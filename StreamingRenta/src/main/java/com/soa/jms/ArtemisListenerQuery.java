/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.RentaBusiness;
import com.soa.dto.Respuesta;
import com.soa.dto.Renta;

/**
 * Class for receiving messages in an artemis queue
 */
@Component
public class ArtemisListenerQuery {
    
    @Autowired
    private RentaBusiness business;
    
    @Autowired
    private JmsSender sender;

    @Value("${queue.name.out}")
    private String outQueueName;

    @Value("${queue.name.next}")
    private String nextQueueName;
    
    /**
     * Recibir datos de renta para iniciar la reproducción de una película.
     * @param message JSON con folio, tiempo, idpelicula, idusuario, total.
     */
    @JmsListener(destination = "${queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));
        Gson gson = new Gson();
        Renta renta = gson.fromJson(message, Renta.class); // Cambia de Solicitud a Renta
        System.out.println(renta);
        Respuesta respuesta = business.crearRenta(renta);
        String colaSalida;
        if (respuesta.getMonto() != null) {
            colaSalida = nextQueueName;
        } else {
            colaSalida = outQueueName;
        }
        System.out.println("Resultado de la consulta: " + respuesta);
        try {
            sender.sendMessage(respuesta.toString(), colaSalida);
            System.out.println(String.format("Mensaje enviado: %s", respuesta.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
