/**
 * 
 */
package com.soa.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Renta;


/**
 * Capa de acceso a datos
 */
@Repository
public class PeliculaDao {
    
    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Consulta rentas disponibles
     * @param idPelicula
     * @return
     */
    public List<Renta> mostrarRenta(Long idPelicula) {
        List<Renta> disponibles = new ArrayList<>();
        
        // Consultar la tabla rentas
        List<Map<String, Object>> lista = jdbcTemplate.queryForList(
            "select folio, fechainicio, tiempo, idpelicula, idusuario, total from rentas"
            + " where idpelicula = ?;",
            idPelicula);

        // Iterar sobre la lista de registros
        for (Map<String, Object> registro : lista) {
            // Crear una nueva instancia de Renta
            Renta renta = new Renta();

            // Asignar los valores del registro a los atributos de la instancia de Renta
            renta.setFolio((Long)registro.get("folio"));
            renta.setFechaInicio((Date)registro.get("fechainicio"));
            renta.setTiempo((Integer)registro.get("tiempo"));
            renta.setIdPelicula((Long)registro.get("idpelicula"));
            renta.setIdUsuario((Long)registro.get("idusuario"));
            renta.setTotal((Double)registro.get("total"));

            // Agregar la renta a la lista de rentas disponibles
            disponibles.add(renta);
        }

        return disponibles;
    }
    
    /**
     * Crea una renta
     * @param renta
     * @return
     */
    public int crearRenta(Renta renta) {
        return jdbcTemplate.update(
            "insert into rentas (fechainicio, tiempo, idpelicula, idusuario, total)"
            + " values (?, ?, ?, ?, ?);",
            renta.getFechaInicio(),
            renta.getTiempo(),
            renta.getIdPelicula(),
            renta.getIdUsuario(),
            renta.getTotal());
    }
    
    /**
     * Actualiza renta
     * @param renta
     * @return
     */
    public int actualizarRenta(Renta renta) {
        return jdbcTemplate.update(
            "update rentas set fechainicio = ?, tiempo = ?, idpelicula = ?, idusuario = ?, total = ? where folio = ?;",
            renta.getFechaInicio(),
            renta.getTiempo(),
            renta.getIdPelicula(),
            renta.getIdUsuario(),
            renta.getTotal(),
            renta.getFolio());
    }
    
    /**
     * Elimina renta
     * @param folio
     * @return
     */
    public int eliminarRenta(Long folio) {
        return jdbcTemplate.update(
            "delete from rentas where folio = ?;",
            folio);
    }

    public void updateEstado(Object id, String string) {
        // TODO Auto-generated method stub
        
    }
}