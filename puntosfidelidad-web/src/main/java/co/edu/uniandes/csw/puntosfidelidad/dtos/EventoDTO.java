/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author cass_
 */
public class EventoDTO implements Serializable{
    
    private String nombre;
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    private String descripcion;
    
    public EventoDTO(){
        //Método vacio obligatorio.
    }
    
    public EventoDTO(EventoEntity entity){
        this.descripcion = entity.getDescripcion();
        this.nombre = entity.getNombre();
        this.fechaInicio = entity.getFechaInicio();
        this.fechaFin = entity.getFechaFin();
    }
    
    public EventoEntity toEntity(){
        EventoEntity entity = new EventoEntity();
        entity.setDescripcion(this.getDescripcion());
        entity.setNombre(this.getNombre());
        entity.setFechaInicio(this.getFechaInicio());
        entity.setFechaFin(this.getFechaFin());
        return entity;
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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
