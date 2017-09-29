/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author cass_
 */
@Entity
public class EventoEntity implements Serializable{
    
    @Id
    private String nombre;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    private String descripcion;
    
    @PodamExclude
    @ManyToMany //[Ja.manrique] Cambio de ManyToOne a ManyToMany para dejar acorde al UML
                //Tristemente los test's se putean por esto, hay que corregirlos
    private List<RestauranteEntity> restaurante;
    
    @PodamExclude
    @ManyToMany //[Ja.manrique] Cambio de ManyToOne a ManyToMany para dejar acorde al UML
                //Tristemente los test's se putean por esto, hay que corregirlos
    private List<UbicacionEntity> ubicaciones;    
    
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

    /**
     * @return the restaurante
     */
    public List<RestauranteEntity> getRestaurantes() {
        return restaurante;
    }

    /**
     * @param restaurante the restaurante to set
     */
    public void setRestaurantes(List<RestauranteEntity> restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * @return the ubicaciones
     */
    public List<UbicacionEntity> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * @param ubicaciones the ubicaciones to set
     */
    public void setUbicaciones(List<UbicacionEntity> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
