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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMontoBasico() {
        return montoBasico;
    }

    public void setMontoBasico(Integer montoBasico) {
        this.montoBasico = montoBasico;
    }

    public Integer getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(Integer montoActual) {
        this.montoActual = montoActual;
    }

    public Integer getNumPuntos() {
        return numPuntos;
    }

    public void setNumPuntos(Integer numPuntos) {
        this.numPuntos = numPuntos;
    }    

    public List<CompraEntity> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }    
}