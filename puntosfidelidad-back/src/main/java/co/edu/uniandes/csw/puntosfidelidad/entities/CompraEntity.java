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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author aa.yepes
 */
@Entity
public class CompraEntity implements Serializable {

    @Id
    private Long id;
    private boolean pagoConpuntos;

    @PodamExclude
    @OneToMany
    private List<ProductoEntity> productos = new ArrayList<>();
    
    @PodamExclude
    @ManyToOne
    private SucursalEntity sucursal;
    
    @PodamExclude
    @ManyToOne
    private TarjetaPuntosEntity tarjetaPuntos;
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

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
     * @return the pagoConpuntos
     */
    public boolean isPagoConpuntos() {
        return pagoConpuntos;
    }

    /**
     * @param pagoConpuntos the pagoConpuntos to set
     */
    public void setPagoConpuntos(boolean pagoConpuntos) {
        this.pagoConpuntos = pagoConpuntos;
    }

    /**
     * @return the employees
     */
    public List<ProductoEntity> getProductos() {
        return productos;
    }

    /**
     * @param employees the employees to set
     */
    public void setProductos(List<ProductoEntity> employees) {
        this.productos = employees;
    }

    /**
     * @return the sucursal
     */
    public SucursalEntity getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the tarjetaPuntos
     */
    public TarjetaPuntosEntity getTarjetaPuntos() {
        return tarjetaPuntos;
    }

    /**
     * @param tarjetaPuntos the tarjetaPuntos to set
     */
    public void setTarjetaPuntos(TarjetaPuntosEntity tarjetaPuntos) {
        this.tarjetaPuntos = tarjetaPuntos;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
  
}
    