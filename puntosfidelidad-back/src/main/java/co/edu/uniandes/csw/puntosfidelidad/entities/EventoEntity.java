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
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/EventoEntity.java
import javax.persistence.OneToMany;
=======
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/EventoEntity.java

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
    
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/EventoEntity.java
//    private List<RestauranteEntity> restaurante = new List<RestauranteEntity>(); 
    
//    private List<UbicacionEntity> ubicaciones = new ArrayList<UbicacionEntity>();
=======
    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;
    
    @PodamExclude
    @OneToOne
    private UbicacionEntity ubicacion ;
    
//    private List<RestauranteEntity> restaurante = new List<RestauranteEntity>(); 
    
//    private List<UbicacionEntity> ubicaciones = new ArrayList<UbicacionEntity>();

    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }

    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }


>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/EventoEntity.java
    
    
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

//    /**
//     * @return the restaurante
//     */
//    public List<RestauranteEntity> getRestaurantes() {
//        return restaurante;
//    }
//
//    /**
//     * @param restaurante the restaurante to set
//     */
//    public void setRestaurantes(List<RestauranteEntity> restaurante) {
//        this.restaurante = restaurante;
//    }

//    /**
//     * @return the ubicaciones
//     */
//    public List<UbicacionEntity> getUbicaciones() {
//        return ubicaciones;
//    }
//
//    /**
//     * @param ubicaciones the ubicaciones to set
//     */
//    public void setUbicaciones(List<UbicacionEntity> ubicaciones) {
//        this.ubicaciones = ubicaciones;
//    }
}
