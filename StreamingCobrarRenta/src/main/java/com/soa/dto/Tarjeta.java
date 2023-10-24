/**
 * 
 */
package com.soa.dto;

import com.google.gson.Gson;

/**
 * 
 */
public class Tarjeta {
    
    /**ID de la Tarjeta **/
    private Integer idtarjeta;
    
    /** ID del Usuario **/
    private Integer idusuario;
    
    /** Saldo disponible de la tarjeta**/
    private Double saldo;

    /**
     * @return the idtarjeta
     */
    public Integer getIdtarjeta() {
        return idtarjeta;
    }

    /**
     * @param idtarjeta the idtarjeta to set
     */
    public void setIdtarjeta(Integer idtarjeta) {
        this.idtarjeta = idtarjeta;
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
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }
    

}
