/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.cespedes10
 */

@Entity
public class RestauranteEntity implements Serializable{
    @Id
    private String nit;
    private String nombre;
    private String tipoComida;
    

    @PodamExclude
    @OneToMany(mappedBy = "restaurante")
    private List<ProductoEntity> productos = new ArrayList<>();
    
    
    @PodamExclude
    @OneToMany(mappedBy = "restaurante")
    private List<AdministradorEntity> administradores = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "restaurante")
    private List<SucursalEntity> sucursales = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "restaurante")
    private List<EventoEntity> eventos = new ArrayList<>();

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos) {
        this.productos = productos;
    }

    public List<AdministradorEntity> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<AdministradorEntity> administradores) {
        this.administradores = administradores;
    }

    public List<SucursalEntity> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalEntity> sucursales) {
        this.sucursales = sucursales;
    }

    public List<EventoEntity> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoEntity> eventos) {
        this.eventos = eventos;
    }
    
    
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}
