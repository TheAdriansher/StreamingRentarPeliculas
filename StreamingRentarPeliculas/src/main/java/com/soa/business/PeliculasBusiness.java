/**
 * 
 */
package com.soa.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.PeliculaDao;
import com.soa.dto.Pelicula;
import com.soa.dto.Respuesta;


/**
 * Clase para concatenación de datos personales.
 */
@Component
public class PeliculasBusiness {
    /** Objeto de acceso a datos. */
    @Autowired
    private PeliculaDao peliculaRepositorio;

    /**
     * Forma el nombre completo de una persona.
     * @param persona Persona recibida.
     * @return Respuesta con el nombre completo.
     */
    public Respuesta validarPelicula(Pelicula pelicula) {
        if (pelicula.getEstado().equals("alquilada")) {
            return new Respuesta(null, "Película ya está alquilada");
        } else {
            peliculaRepositorio.updateEstado(pelicula.getId(), "alquilada");
            return new Respuesta();
        }
    }

    public Respuesta validarPelicula(String peliculaSolicitada) {
        // TODO Auto-generated method stub
        return null;
    }

    public void actualizarEstado(Object idpelicula, String string) {
        // TODO Auto-generated method stub
        
    }

    public void registrarRenta(Object idpelicula, Object idUsuario) {
        // TODO Auto-generated method stub
        
    }
}