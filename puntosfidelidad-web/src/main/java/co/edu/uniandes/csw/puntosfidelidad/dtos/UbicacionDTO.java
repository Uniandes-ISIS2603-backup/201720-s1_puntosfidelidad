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
        if(entity != null){
        this.direccion = entity.getDireccion();
        this.latitud = entity.getLatitud();
        this.longitud = entity.getLongitud();      
        }
    }
    
    public UbicacionEntity toEntity(){
        UbicacionEntity entity = new UbicacionEntity();
        entity.setDireccion(this.getDTODireccion());
        entity.setLatitud(this.getDTOLatitud());
        entity.setLongitud(this.getDTOLongitud());
        return entity;
    }

    /**
     * @return the direccion
     */
    public String getDTODireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDTODireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the latitud
     */
    public Long getDTOLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setDTOLatitud(Long latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Long getDTOLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setDTOLongitud(Long longitud) {
        this.longitud = longitud;
    }

    
}
