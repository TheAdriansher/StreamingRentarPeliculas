/**
 * 
 */
package com.soa.dto;

import org.springframework.stereotype.Component;

/**
 * Clase que modela la información de una pelicula.
 */
@Component
public class Pelicula {
    
    /**Id de la pelicula*/
    private Integer idpelicula;
    
    /**Nombre de la pelicula*/
    private String titulo;
    
    /**Año de estreno de la pelicula*/
    private int anio;
    
    /**Genero de la pelicula*/
    private String genero;
    
    /**Duracion de la pelicula*/
    private int duracion;

    public Integer getIpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int id) {
        this.idpelicula = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        switch (genero) {
        case 1: {
            this.genero = "Terror";
            break;            
        }
        case 2: {
            this.genero = "Accion";
            break;            
        }
        case 3: {
            this.genero = "Documental";
            break;            
        }
        case 4: {
            this.genero = "Drama";
            break;            
        }
        case 5: {
            this.genero = "Romance";
            break;            
        }
        case 6: {
            this.genero = "Comedia";
            break;            
        }
        default:
            throw new IllegalArgumentException("No se esperaba el valor: " + genero);
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    public Object getId() {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getEstado() {
        // TODO Auto-generated method stub
        return null;
    }
    
    

}