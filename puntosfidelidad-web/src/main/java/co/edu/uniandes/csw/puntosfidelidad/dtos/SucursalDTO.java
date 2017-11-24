/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cass_
 */
public class SucursalDTO implements Serializable{

    private Long id;
    
    private String nombre;
    
    private Date horaApertura;
    
    private Date horaCierre;
    
    private String descripcion;
    
    public SucursalDTO(){
        //Método vacio obligatorio.    
    }
    
    public SucursalDTO(SucursalEntity entity){
        if(entity != null){
        this.descripcion = entity.getDescripcion();
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.horaApertura = entity.getHoraApertura();
        this.horaCierre = entity.getHoraCierre();
        }
    }
    
    public SucursalEntity toEntity(){
        SucursalEntity entity = new SucursalEntity();
        entity.setDescripcion(this.getDTODescripcion());
        entity.setId(this.getDTOId());
        entity.setNombre(this.getDTONombre());
        entity.setHoraApertura(this.getDTOHoraApertura());
        entity.setHoraCierre(this.getDTOHoraCierre());
        return entity;
    }

    /**
     * @return the id
     */
    public Long getDTOId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setDTOId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getDTONombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setDTONombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the horaApertura
     */
    public Date getDTOHoraApertura() {
        return horaApertura;
    }

    /**
     * @param horaApertura the horaApertura to set
     */
    public void setDTOHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * @return the horaCierre
     */
    public Date getDTOHoraCierre() {
        return horaCierre;
    }

    /**
     * @param horaCierre the horaCierre to set
     */
    public void setDTOHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * @return the descripcion
     */
    public String getDTODescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDTODescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
