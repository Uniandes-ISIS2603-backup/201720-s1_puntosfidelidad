/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cass_
 */
public class RecargaDTO implements Serializable{
       
    private Long id;
    
    private Date fecha;
    
    private Double valor;
    
    public RecargaDTO(){
        //Método vacio obligatorio.    
    }
    
    public RecargaDTO(RecargaEntity entity){
        if(entity != null){
        this.id = entity.getId();
        this.fecha = entity.getFecha();
        this.valor = entity.getValor();
        }
    }
    
    public RecargaEntity toEntity(){
        RecargaEntity entity = new RecargaEntity();
        entity.setId(this.getDTOId());
        entity.setValor(this.getDTOValor());
        entity.setFecha(this.getDTOFecha());
        return entity;
    }  

    /**
     * @return the id
     */
    public Long getDTOId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setDTOId(Long id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getDTOFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setDTOFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the valor
     */
    public Double getDTOValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setDTOValor(Double valor) {
        this.valor = valor;
    }
    
}
