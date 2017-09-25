/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import java.util.List;

/**
 *
 * @author ja.manrique
 */
public class AdministradorDetailDTO extends AdministradorDTO{    
    
    private RestauranteDTO restaurante;   
    
    public AdministradorDetailDTO(){     
        super();
    }
    
        /**
     * Crea un objeto AdministradorDetailDTO a partir de un objeto AdministradorEntity
     * incluyendo los atributos de AdministradorDTO.
     *
     * @param entity Entidad AdministradorEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public AdministradorDetailDTO(AdministradorEntity entity) {
        
        super(entity);
        
        if (entity != null) {            
            restaurante = new RestauranteDTO(entity.getRestaurante());
        }
    }
    
     /**
     * Convierte un objeto AdministradorDetailDTO a AdministradorEntity incluyendo los
     * atributos de AdministradorDTO.
     *
     * @return Nueva objeto AdministradorEntity.
     *
     */
    @Override
    public AdministradorEntity toEntity() {
        AdministradorEntity entity = super.toEntity();
        
        if (getRestaurante() != null) {
            entity.setRestaurante(getRestaurante().toEntity());
        }
        return entity;
    }

    /**
     * @return the restaurante
     */
    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    /**
     * @param restaurantes the restaurantes to set
     */
    public void setRestaurante(List<RestauranteDTO> restaurantes) {
        this.restaurante = restaurante;
    }

    
}
