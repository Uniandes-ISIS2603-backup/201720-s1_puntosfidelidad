/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

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
}