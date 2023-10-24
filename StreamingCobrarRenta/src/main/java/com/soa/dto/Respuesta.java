package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información necesaria para la siguiente cola.
 */
public class Respuesta {

    /*Mensaje de respuesta*/
    private String message;
    
    /* Tiempo rentado de la película */
    private Integer tiempo;
    
    /*Monto total cobrado */
    private Double monto;
    
    /* ID de la película */
    private Integer idpelicula;
    
    /* ID del usuario */
    private Integer idusuario;
    
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * @return the tiempo
     */
    public Integer getTiempo() {
        return tiempo;
    }


    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }


    /**
     * @return the total
     */
    public Double getMonto() {
        return monto;
    }


    /**
     * @param total the total to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }


    /**
     * @return the idpelicula
     */
    public Integer getIdpelicula() {
        return idpelicula;
    }


    /**
     * @param idpelicula the idpelicula to set
     */
    public void setIdpelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }


    /**
     * @return the idusuario
     */
    public Integer getIdusuario() {
        return idusuario;
    }


    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }
}
