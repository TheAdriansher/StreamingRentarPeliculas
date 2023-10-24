/**
 * 
 */
package com.soa.business;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.CobroDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Solicitud;
import com.soa.dto.Tarjeta;

/**
 * Capa de negocio que coloca la fecha de inicio de reproducción a la renta.
 * 
 */
@Component
public class CobrarRentaBusiness {

    /** Objeto de acceso a datos */
    @Autowired
    private CobroDao cobroDao;

    /**
     * Calcula la fecha de inicio de reproducción de una película rentada.
     * 
     * @param renta
     * @return
     */
    public Respuesta cobrarMonto(Solicitud solicitud) {
        Respuesta respuesta = new Respuesta();
        try {
            List<Tarjeta> tarjetas = cobroDao.buscarTarjeta(solicitud);
            if (tarjetas.isEmpty()) {
                respuesta.setMessage("El número de tarjeta no existe.");
                return respuesta;
            }
            
            Tarjeta tarjeta = tarjetas.get(0);
            if (tarjeta.getIdusuario() != solicitud.getIdusuario()) {
                respuesta.setMessage("El número de tarjeta no coincide con el usuario.");
                return respuesta;
            }
            
            Double monto = 100.0 * solicitud.getTiempo();
            if (tarjeta.getSaldo() < monto) {
                respuesta.setMessage("La tarjeta no tiene saldo suficiente.");
            } else {
                cobroDao.actualizarSaldo(tarjeta, monto);
                respuesta.setMessage("Cobro realizado con ÉXITO.");
                respuesta.setIdpelicula(solicitud.getIdpelicula());
                respuesta.setIdusuario(solicitud.getIdusuario());
                respuesta.setTiempo(solicitud.getTiempo());
                respuesta.setMonto(monto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

}
