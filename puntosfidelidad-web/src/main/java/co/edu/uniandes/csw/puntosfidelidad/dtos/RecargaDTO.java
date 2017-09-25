/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import java.util.Date;

/**
 *
 * @author cass_
 */
public class RecargaDTO {
       
    private Long id;
    
    private Date fecha;
    
    private Double valor;
    
    public RecargaDTO(){
    
    }
    
    public RecargaDTO(RecargaEntity entity){
        this.id = entity.getId();
        this.fecha = entity.getFecha();
        this.valor = entity.getValor();
    }
    
    public RecargaEntity toEntity(){
        RecargaEntity entity = new RecargaEntity();
        entity.setId(this.getId());
        entity.setValor(this.getValor());
        entity.setFecha(this.getFecha());
        return entity;
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
