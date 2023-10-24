package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información de la solicitud de renta ACEPTADA Y COBRADA.
 */
public class Solicitud {
    
    /* Tiempo en segundos por el cual se rentó la película */
    private Integer tiempo;
    
    /* Id de la película renta */
    private Integer idpelicula;
    
    /* Id del usuario que rentó la película */
    private Integer idusuario;
    
    /* Número de la tarjeta a cobrar */
    private String numtarjeta;

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

    /**
     * @return the numtarjeta
     */
    public String getNumtarjeta() {
        return numtarjeta;
    }

    /**
     * @param numtarjeta the numtarjeta to set
     */
    public void setNumtarjeta(String numtarjeta) {
        this.numtarjeta = numtarjeta;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }

}
