/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import java.io.Serializable;

/**
 *
 * @author cass_
 */
public class TarjetaDeCreditoDTO implements Serializable{
    
    private Long id;
    
    private String banco;
    
    private Long numero;
    
    public TarjetaDeCreditoDTO(){
        //Método vacio obligatorio.   
    }
    
    public TarjetaDeCreditoDTO(TarjetaDeCreditoEntity entity){
        if(entity != null){
        this.banco = entity.getBanco();
        this.id = entity.getId();
        this.numero = entity.getNumero();
        }
    }
    
    public TarjetaDeCreditoEntity toEntity(){
        TarjetaDeCreditoEntity entity = new TarjetaDeCreditoEntity();
        entity.setBanco(this.getDTOBanco());
        entity.setId(this.getDTOId());
        entity.setNumero(this.getDTONumero());        
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
     * @return the banco
     */
    public String getDTOBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setDTOBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the numero
     */
    public Long getDTONumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setDTONumero(Long numero) {
        this.numero = numero;
    }
    
    
}
