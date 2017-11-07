/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;

/**
 *
 * @author cass_
 */
public class RecargaDetailDTO extends RecargaDTO{
    
    private ClienteDTO cliente; 
    
    private TarjetaDeCreditoDTO tarjetaDeCredito;
    
    private TarjetaPuntosDTO tarjetaPuntos;
    
    public RecargaDetailDTO(){     
        super();        
    }
    
        /**
     * Crea un objeto RecargaDetailDTO a partir de un objeto RecargaEntity
     * incluyendo los atributos de RecargaDTO.
     *
     * @param entity Entidad RecargaEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public RecargaDetailDTO(RecargaEntity entity) {
        
        super(entity);
        
        if (entity != null) {
            
            cliente = new ClienteDTO(entity.getCliente());
            
            tarjetaDeCredito = new TarjetaDeCreditoDTO(entity.getTarjetaDeCredito());
            
            tarjetaPuntos = new TarjetaPuntosDTO(entity.getTarjetaPuntos());            
        }
    }
    
     /**
     * Convierte un objeto RecargaDetailDTO a RecargaEntity incluyendo los
     * atributos de RecargaDTO.
     *
     * @return Nueva objeto RecargaEntity.
     *
     */
    @Override
    public RecargaEntity toEntity() {
        RecargaEntity entity = super.toEntity();
        
        if (getCliente() != null) {
            entity.setCliente(getCliente().toEntity());
        }
        
        if (getTarjetaDeCredito() != null) {
            entity.setTarjetaDeCredito(getTarjetaDeCredito().toEntity());
        }
        
        if (getTarjetaPuntos() != null) {
            entity.setTarjetaPuntos(getTarjetaPuntos().toEntity());
        }

        return entity;
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

    /**
     * @return the tarjetaDeCredito
     */
    public TarjetaDeCreditoDTO getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * @param tarjetaDeCredito the tarjetaDeCredito to set
     */
    public void setTarjetaDeCredito(TarjetaDeCreditoDTO tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    /**
     * @return the tarjetaPuntos
     */
    public TarjetaPuntosDTO getTarjetaPuntos() {
        return tarjetaPuntos;
    }

    /**
     * @param tarjetaPuntos the tarjetaPuntos to set
     */
    public void setTarjetaPuntos(TarjetaPuntosDTO tarjetaPuntos) {
        this.tarjetaPuntos = tarjetaPuntos;
    }  
    
}
