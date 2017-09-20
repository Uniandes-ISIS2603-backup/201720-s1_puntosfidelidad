/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;

/**
 *
 * @author cass_
 */
public class UbicacionDTO {
    private String direcion;
    private Long latitud;
    private Long longitud;
    
    public UbicacionDTO() {
    }
    
    public UbicacionDTO(UbicacionEntity entity) {
        this.direcion = entity.getDireccion();
        this.latitud = entity.getLatitud();
        this.longitud = entity.getLongitud();
    }
    
    public UbicacionEntity toEntity(){
        UbicacionEntity entity = new UbicacionEntity();
        entity.setDireccion(this.direcion;
        entity.setNombre(this.getNombre());
        entity.setId(this.getId());
        entity.setHoraApertura(this.getHoraApertura());
        entity.setHoraCierre(this.getHoraCierre());
        return entity;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the horaApertura
     */
    public Date getHoraApertura() {
        return horaApertura;
    }

    /**
     * @param horaApertura the horaApertura to set
     */
    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * @return the horaCierre
     */
    public Date getHoraCierre() {
        return horaCierre;
    }

    /**
     * @param horaCierre the horaCierre to set
     */
    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }
}
