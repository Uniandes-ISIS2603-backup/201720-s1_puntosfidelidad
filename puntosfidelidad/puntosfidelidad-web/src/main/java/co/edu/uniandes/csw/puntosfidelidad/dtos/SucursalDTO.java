/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import java.sql.Date;

/**
 *
 * @author cass_
 */
public class SucursalDTO {

    private String descripcion;
    private String nombre;
    private Long id;
    private Date horaApertura;
    private Date horaCierre;
    
    public SucursalDTO() {
    }
    
    public SucursalDTO(SucursalEntity entity) {
        this.descripcion = entity.getDescripcion();
        this.nombre = entity.getNombre();
        this.id = entity.getId();
        this.horaApertura = entity.getHoraApertura();
        this.horaCierre = entity.getHoraCierre();
    }
    
    public SucursalEntity toEntity(){
        SucursalEntity entity = new SucursalEntity();
        entity.setDescripcion(this.descripcion);
        entity.setNombre(this.nombre);
        entity.setId(this.id);
        entity.setHoraApertura(this.horaApertura);
        entity.setHoraCierre(this.horaCierre);
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
