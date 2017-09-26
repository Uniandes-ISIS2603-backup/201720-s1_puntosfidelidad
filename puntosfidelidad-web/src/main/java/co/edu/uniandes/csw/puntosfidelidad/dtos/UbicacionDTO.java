/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import java.io.Serializable;

/**
 *
 * @author cass_
 */
public class UbicacionDTO implements Serializable{
    
    private String direccion;
    
    private Long latitud;
    
    private Long longitud;
    
    public UbicacionDTO(){
        //Método vacio obligatorio.   
    }
    
    public UbicacionDTO(UbicacionEntity entity){
        this.direccion = entity.getDireccion();
        this.latitud = entity.getLatitud();
        this.longitud = entity.getLongitud();      
    }
    
    public UbicacionEntity toEntity(){
        UbicacionEntity entity = new UbicacionEntity();
        entity.setDireccion(this.getDireccion());
        entity.setLatitud(this.getLatitud());
        entity.setLongitud(this.getLongitud());
        return entity;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the latitud
     */
    public Long getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Long getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    
}
