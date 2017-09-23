/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.ArrayList;
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
=======
import java.util.Date;
import java.util.List;
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
=======
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java

/**
 *
 * @author cass_
 */
@Entity
public class SucursalEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
    private Long horaApertura;
    
    private Long horaCierre;
    
    private String descripcion;
    
=======
    private Date horaApertura;
    
    private Date horaCierre;
    
    private String descripcion;
    
    
    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;
    
    @PodamExclude
    @OneToOne
    private UbicacionEntity ubicacion;
    
    @PodamExclude
    @OneToMany(mappedBy = "sucursal")
    private List<ComentarioEntity> comentarios = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "sucursal")
    private List<CompraEntity> compras = new ArrayList<>();

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

    public List<ComentarioEntity> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioEntity> comentarios) {
        this.comentarios = comentarios;
    }

    public List<CompraEntity> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }




    
    
    
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
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
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
    public Long getHoraApertura() {
=======
    public Date getHoraApertura() {
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
        return horaApertura;
    }

    /**
     * @param horaApertura the horaApertura to set
     */
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
    public void setHoraApertura(Long horaApertura) {
=======
    public void setHoraApertura(Date horaApertura) {
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
        this.horaApertura = horaApertura;
    }

    /**
     * @return the horaCierre
     */
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
    public Long getHoraCierre() {
=======
    public Date getHoraCierre() {
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
        return horaCierre;
    }

    /**
     * @param horaCierre the horaCierre to set
     */
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
    public void setHoraCierre(Long horaCierre) {
=======
    public void setHoraCierre(Date horaCierre) {
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/SucursalEntity.java
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

//    /**
//     * @return the ubicacion
//     */
//    public UbicacionEntity getUbicacion() {
//        return ubicacion;
//    }
//
//    /**
//     * @param ubicacion the ubicacion to set
//     */
//    public void setUbicacion(UbicacionEntity ubicacion) {
//        this.ubicacion = ubicacion;
//    }

//    /**
//     * @return the comentarios
//     */
//    public ArrayList<ComentarioENtity> getComentarios() {
//        return comentarios;
//    }
//
//    /**
//     * @param comentarios the comentarios to set
//     */
//    public void setComentarios(ArrayList<ComentarioENtity> comentarios) {
//        this.comentarios = comentarios;
//    }
//
//    /**
//     * @return the compras
//     */
//    public ArrayList<CompraEntity> getCompras() {
//        return compras;
//    }
//
//    /**
//     * @param compras the compras to set
//     */
//    public void setCompras(ArrayList<CompraEntity> compras) {
//        this.compras = compras;
//    }
}
