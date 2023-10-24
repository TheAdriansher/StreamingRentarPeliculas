/**
 * 
 */
package com.soa.business;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.RentaDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Renta;

/**
 * Capa de negocio que coloca la fecha de inicio de reproducción a la renta.
 * 
 */
@Component
public class RentaBusiness {

    /** Objeto de acceso a datos */
    @Autowired
    private RentaDao rentaDao;

    /**
     * Calcula la fecha de inicio de reproducción de una película rentada.
     * 
     * @param renta
     * @return
     */
    public Respuesta crearRenta(Renta renta) {
        Respuesta respuesta = new Respuesta();
        try {
            // Realiza validaciones y lógica de negocio necesarias aquí

            // Guarda la renta en la base de datos utilizando RentaDao
            rentaDao.save(renta);

            respuesta.setMessage("Renta creada con ÉXITO.");
            respuesta.setIdpelicula(renta.getIdpelicula());
            respuesta.setIdusuario(renta.getIdusuario());
            respuesta.setTiempo(renta.getTiempo());
            respuesta.setMonto(renta.getMonto());
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Ocurrió un error al procesar la solicitud.");
        }
        return respuesta;
    }

}


