/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import java.io.Serializable;

/**
 *
 * @author ja.manrique
 */
public class TarjetaPuntosDTO implements Serializable{
    
    private Long id;
    private Integer montoBasico;
    private Integer montoActual;
    private Integer numPuntos;
    
    
    public TarjetaPuntosDTO()
    {
        //Método vacio obligatorio.        
    }
    
    /**
     * Conviertir Entity a DTO
     * Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     */
    public TarjetaPuntosDTO(TarjetaPuntosEntity entity)
    {
        this.id = entity.getId();
        this.montoActual = entity.getMontoActual();
        this.montoBasico = entity.getMontoBasico();
        this.numPuntos = entity.getNumPuntos();
    }

    /**
     * Conviertir DTO a Entity
     * Crea un nuevo Entity con los valores que contiene el DTO.
     */
    public TarjetaPuntosEntity toEntity()
    {
        TarjetaPuntosEntity entity = new TarjetaPuntosEntity();
        
        entity.setId(this.id);
        entity.setMontoActual(this.montoActual);
        entity.setMontoBasico(this.montoBasico);
        entity.setNumPuntos(this.numPuntos);
        
        return entity;
    }
    
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
