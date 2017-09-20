/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
    
    private Long horaApertura;
    
    private Long horaCierre;
    
    private String descripcion;
    
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
    public Long getHoraApertura() {
        return horaApertura;
    }

    /**
     * @param horaApertura the horaApertura to set
     */
    public void setHoraApertura(Long horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * @return the horaCierre
     */
    public Long getHoraCierre() {
        return horaCierre;
    }

    /**
     * @param horaCierre the horaCierre to set
     */
    public void setHoraCierre(Long horaCierre) {
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
