/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import java.io.Serializable;

/**
 *
 * @author ja.manrique
 */
public class CompraDTO implements Serializable{
    
    private Long id;
    private boolean pagoConpuntos;
    
   
    public CompraDTO()
    {
        //Método vacio obligatorio.
    }
    
    /**
     * Conviertir Entity a DTO
     * Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     */
    public CompraDTO(CompraEntity entity)       
    {
        if(entity != null){
        this.id = entity.getId();
        this.pagoConpuntos = entity.isPagoConpuntos();
        }
    }
    
    /**
     * Conviertir DTO a Entity
     * Crea un nuevo Entity con los valores que contiene el DTO.
     */
    public CompraEntity toEntity()
    {
        CompraEntity entity = new CompraEntity();
        
        entity.setId(this.id);
        entity.setPagoConpuntos(this.pagoConpuntos);
        
        return entity;
    }

    public Long getDTOId() {
        return id;
    }

    public void setDTOId(Long id) {
        this.id = id;
    }

    public boolean isDTOPagoConpuntos() {
        return pagoConpuntos;
    }

    public void setDTOPagoConpuntos(boolean pagoConpuntos) {
        this.pagoConpuntos = pagoConpuntos;
    }
    
    
}
