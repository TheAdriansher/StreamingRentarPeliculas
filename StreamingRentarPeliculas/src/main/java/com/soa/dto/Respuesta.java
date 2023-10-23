package com.soa.dto;

/**
 *
 */
public class Respuesta {

    private Long id;
    private String mensaje;

    public Respuesta() {
    }

    public Respuesta(Long id, String mensaje) {
        this.id = id;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }

    public Object getIdpelicula() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setPeticion(Peticion peticion) {
        // TODO Auto-generated method stub
        
    }
}