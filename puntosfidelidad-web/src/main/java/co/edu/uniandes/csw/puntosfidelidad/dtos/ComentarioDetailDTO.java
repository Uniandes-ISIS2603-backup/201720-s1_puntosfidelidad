/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.FotoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cass_
 */
public class ComentarioDetailDTO extends ComentarioDTO{
    
    private ClienteDTO cliente; 
    
    private SucursalDTO sucursal;
    
    private List<FotoDTO> fotos;
    
    public ComentarioDetailDTO(){     
        super();
    }
    
        /**
     * Crea un objeto ComentarioDetailDTO a partir de un objeto ComentarioEntity
     * incluyendo los atributos de ComentarioDTO.
     *
     * @param entity Entidad ComentarioEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public ComentarioDetailDTO(ComentarioEntity entity) {
        super(entity);
        
        if (entity != null) {
            
            cliente = new ClienteDTO(entity.getCliente());
            
            sucursal = new SucursalDTO(entity.getSucursal());
            
            fotos = new ArrayList<>();
            for (FotoEntity entityFoto : entity.getFotos()) {
                fotos.add(new FotoDTO(entityFoto));
            }
        }
    }
    
     /**
     * Convierte un objeto ComentarioDetailDTO a ComentarioEntity incluyendo los
     * atributos de ComentarioDTO.
     *
     * @return Nueva objeto ComentarioEntity.
     *
     */
    @Override
    public ComentarioEntity toEntity() {
        ComentarioEntity entity = super.toEntity();
        
        if (getCliente() != null) {            
            entity.setCliente(getCliente().toEntity());
        }
        
        if (getSucursal() != null) {            
            entity.setSucursal(getSucursal().toEntity());
        }
        
        if (getFotos() != null) {
            List<FotoEntity> fotosEntity = new ArrayList<>();
            for (FotoDTO dtoFoto : getFotos()) {
                fotosEntity.add(dtoFoto.toEntity());
            }
            entity.setFotos(fotosEntity);
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
     * @return the sucursal
     */
    public SucursalDTO getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the fotos
     */
    public List<FotoDTO> getFotos() {
        return fotos;
    }

    /**
     * @param fotos the fotos to set
     */
    public void setFotos(List<FotoDTO> fotos) {
        this.fotos = fotos;
    }
    
    
}
