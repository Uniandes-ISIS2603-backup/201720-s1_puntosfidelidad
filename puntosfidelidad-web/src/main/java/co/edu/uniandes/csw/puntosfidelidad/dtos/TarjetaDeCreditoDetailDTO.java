/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;

/**
 *
 * @author cass_
 */
public class TarjetaDeCreditoDetailDTO extends TarjetaDeCreditoDTO{
    
    private ClienteDTO cliente; 
    
    public TarjetaDeCreditoDetailDTO(){     
        super(); 
    }
    
        /**
     * Crea un objeto TarjetaDeCreditoDetailDTO a partir de un objeto TarjetaDeCreditoEntity
     * incluyendo los atributos de TarjetaDeCreditoDTO.
     *
     * @param entity Entidad TarjetaDeCreditoEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public TarjetaDeCreditoDetailDTO(TarjetaDeCreditoEntity entity) {
        super(entity);
    }
    

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
}
