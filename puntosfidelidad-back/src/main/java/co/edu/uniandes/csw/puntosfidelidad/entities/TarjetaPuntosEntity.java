/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ja.manrique
 */
@Entity
public class TarjetaPuntosEntity implements Serializable{
    
    @Id
    private Long id;
    private Integer montoBasico;
    private Integer montoActual;
    private Integer numPuntos;
    
    @PodamExclude
    @OneToMany(mappedBy = "tarjetaPuntos")
    private List<CompraEntity> compras = new ArrayList<>();
    
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
     * @return the montoBasico
     */
    public Integer getMontoBasico() {
        return montoBasico;
    }

    /**
     * @param montoBasico the montoBasico to set
     */
    public void setMontoBasico(Integer montoBasico) {
        this.montoBasico = montoBasico;
    }

    /**
     * @return the montoActual
     */
    public Integer getMontoActual() {
        return montoActual;
    }

    /**
     * @param montoActual the montoActual to set
     */
    public void setMontoActual(Integer montoActual) {
        this.montoActual = montoActual;
    }

    /**
     * @return the numPuntos
     */
    public Integer getNumPuntos() {
        return numPuntos;
    }

    /**
     * @param numPuntos the numPuntos to set
     */
    public void setNumPuntos(Integer numPuntos) {
        this.numPuntos = numPuntos;
    }

    /**
     * @return the compras
     */
    public List<CompraEntity> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
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