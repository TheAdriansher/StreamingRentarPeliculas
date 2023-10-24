/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Renta;
import com.soa.dto.Respuesta;


/**
 * Capa de acceso a datos
 */
@Repository
public class RentaDao {
    
    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Colocar la fecha de inicio en renta.
     * @param renta
     */
   
    /**
     *  Crea una renta
     * @param solicitud
     * @return
     */
    public boolean crearRenta(Renta renta) {
        try {
            String sql = "INSERT INTO rentas (idusuario, idpelicula, monto, tiempo) VALUES (?, ?, ?, ?)";
            Object[] params = new Object[] { renta.getIdusuario(), renta.getIdpelicula(), renta.getMonto(), renta.getTiempo() };

            int filasAfectadas = jdbcTemplate.update(sql, params);

            boolean insercionExitosa = filasAfectadas > 0;
            return insercionExitosa;
        } catch (DataAccessException e) {
            e.printStackTrace(); // Manejo de excepciones
            return false;
        }
    }

    public void save(Renta renta) {
        // TODO Auto-generated method stub
        
    }

}
