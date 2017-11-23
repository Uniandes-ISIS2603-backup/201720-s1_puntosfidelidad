/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

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
    
    @Temporal(TemporalType.DATE)
    private Date horaApertura;
    
    @Temporal(TemporalType.DATE)
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
