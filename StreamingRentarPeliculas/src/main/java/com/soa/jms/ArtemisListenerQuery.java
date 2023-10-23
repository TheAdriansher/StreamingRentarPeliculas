package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.PeliculasBusiness;
import com.soa.dto.Respuesta;
import com.soa.dto.Peticion;

/**
 * Class for receiving messages in an artemis queue
 */
@Component
public class ArtemisListenerQuery {

    @Autowired
    private PeliculasBusiness business;

    @Autowired
    private JmsSender sender;

    @Value("${queue.name.in}")
    private String inQueueName = "stream.repp.in";

    @Value("${queue.name.out}")
    private String outQueueName = "stream.repp.out";

    @Value("${queue.name.next}")
    private String nextQueueName = "stream.dp.in";

    /**
     * Validar pelicula que solicita el usuario
     * @param message JSON con id y nombre de usuario ademas de pelicula deseada
     */
    @JmsListener(destination = "${queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));        
        Gson gson = new Gson();
        Peticion peticion = gson.fromJson(message, Peticion.class);
        System.out.println(peticion);
        Respuesta respuesta = 
                business.validarPelicula(peticion.getPeliculaSolicitada());
        String colaSalida;
        if(respuesta.getIdpelicula() != null) {
            respuesta.setPeticion(peticion);
            colaSalida = nextQueueName;
        }
        else {
            colaSalida = outQueueName;
        }               
        try {
            business.actualizarEstado(respuesta.getIdpelicula(), "alquilada");
            business.registrarRenta(respuesta.getIdpelicula(), peticion.getIdUsuario());
            // Enviar la respuesta
            sender.sendMessage(respuesta.toString(), colaSalida);
            System.out.println(String.format("Mensaje enviado: %s", 
                    respuesta.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }       
    }
}
