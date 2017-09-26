/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import java.util.Date;

/**
 *
 * @author cass_
 */
public class TarjetaDeCreditoDTO {
    
    private Long id;
    
    private String banco;
    
    private Long numero;
    
    public TarjetaDeCreditoDTO(){
        //Método vacio obligatorio.   
    }
    
    public TarjetaDeCreditoDTO(TarjetaDeCreditoEntity entity){
        this.banco = entity.getBanco();
        this.id = entity.getId();
        this.numero = entity.getNumero();
    }
    
    public TarjetaDeCreditoEntity toEntity(){
        TarjetaDeCreditoEntity entity = new TarjetaDeCreditoEntity();
        entity.setBanco(this.getBanco());
        entity.setId(this.getId());
        entity.setNumero(this.getNumero());        
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
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the numero
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    
    
}
