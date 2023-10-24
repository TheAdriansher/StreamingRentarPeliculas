/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Solicitud;
import com.soa.dto.Tarjeta;
import com.soa.dto.Solicitud;

/**
 * Capa de acceso a datos
 */
@Repository
public class CobroDao {
    
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
     * Busca una tarjeta en la base de datos, dado un numtarjeta
     * @param solicitud
     * @return
     */
    public List<Tarjeta> buscarTarjeta(Solicitud solicitud) {
        List<Tarjeta> resp = new ArrayList<>();
        List<Map<String,Object>> list = 
                jdbcTemplate.queryForList(
                        "select idtarjeta, idusuario, saldo "
                + "from tarjetas where numtarjeta = '"
                + solicitud.getNumtarjeta() + "'");
        for (Map<String, Object> registro : list) {
            Tarjeta tarjeta = new Tarjeta();
            tarjeta.setIdtarjeta((Integer) registro.get("idtarjeta"));
            tarjeta.setIdusuario((Integer) registro.get("idusuario"));
            tarjeta.setSaldo((Double) registro.get("saldo"));
            resp.add(tarjeta);
        }
        return resp;
    }
    
    /**
     * Actualiza el saldo de la tarjeta
     * @param tarjeta
     * @param monto
     * @throws Exception
     */
    public void actualizarSaldo(Tarjeta tarjeta, Double monto) throws Exception {                
        
        jdbcTemplate.execute(String.format(
                "update tarjetas set saldo = %s where idtarjeta = %s;",
                monto, tarjeta.getIdtarjeta()));
    }

}
