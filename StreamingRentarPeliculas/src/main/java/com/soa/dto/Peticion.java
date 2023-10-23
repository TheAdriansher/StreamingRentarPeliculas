package com.soa.dto;

public class Peticion {

    private String peliculaSolicitada;

    public Peticion() {
    }

    public Peticion(String peliculaSolicitada) {
        this.peliculaSolicitada = peliculaSolicitada;
    }

    public String getPeliculaSolicitada() {
        return peliculaSolicitada;
    }

    public void setPeliculaSolicitada(String peliculaSolicitada) {
        this.peliculaSolicitada = peliculaSolicitada;
    }

    @Override
    public String toString() {
        return "Peticion{" +
                "peliculaSolicitada='" + peliculaSolicitada + '\'' +
                '}';
    }

    public Object getIdUsuario() {
        // TODO Auto-generated method stub
        return null;
    }
}