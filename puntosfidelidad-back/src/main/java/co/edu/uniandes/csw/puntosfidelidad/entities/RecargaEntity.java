/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author lv.vanegas10
 */

@Entity
public class RecargaEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double valor;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @PodamExclude
    @ManyToOne
    private TarjetaDeCreditoEntity tarjetaDeCredito;
    
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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 
    /**
     * @return the tarjetaDeCredito
     */
    public TarjetaDeCreditoEntity getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * @param tarjetaDeCredito the tarjetaDeCredito to set
     */
    public void setTarjetaDeCredito(TarjetaDeCreditoEntity tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
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

    /**
     * @return the tarjetaDePuntos
     */
    public TarjetaPuntosEntity getTarjetaPuntos() {
        return tarjetaPuntos;
    }

    /**
     * @param tarjetaDePuntos the tarjetaDePuntos to set
     */
    public void setTarjetaPuntos(TarjetaPuntosEntity tarjetaDePuntos) {
        this.tarjetaPuntos = tarjetaDePuntos;
    }
    
}
