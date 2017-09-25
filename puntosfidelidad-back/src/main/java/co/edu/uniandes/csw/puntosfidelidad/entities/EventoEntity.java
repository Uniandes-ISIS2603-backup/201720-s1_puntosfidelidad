/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author cass_
 */
@Entity
public class EventoEntity {
    
    @Id
    private String nombre;
    
    private Calendar fechaInicio;
    
    private Calendar fechaFin;
    
    private String descripcion;
    
    @PodamExclude
    @OneToMany
    private List<RestauranteEntity> restaurantes;
    
    @PodamExclude
    @OneToMany
    private List <UbicacionEntity> ubicaciones ;
    
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
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Calendar fechaFin) {
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

    /**
     * @return the restaurantes
     */
    public List<RestauranteEntity> getRestaurantes() {
        return restaurantes;
    }

    /**
     * @param restaurantes the restaurantes to set
     */
    public void setRestaurantes(List<RestauranteEntity> restaurantes) {
        this.restaurantes = restaurantes;
    }

    /**
     * @return the ubicaciones
     */
    public List <UbicacionEntity> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * @param ubicaciones the ubicaciones to set
     */
    public void setUbicaciones(List <UbicacionEntity> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
