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
    
    // imagen
    private String imagen;
    
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
        this.imagen = entity.getImagen();
        }
    }
    
    public SucursalEntity toEntity(){
        SucursalEntity entity = new SucursalEntity();
        entity.setDescripcion(this.getDescripcion());
        entity.setId(this.getId());
        entity.setNombre(this.getNombre());
        entity.setHoraApertura(this.getHoraApertura());
        entity.setHoraCierre(this.getHoraCierre());
        entity.setImagen(this.imagen);
        return entity;
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
    
    
}
