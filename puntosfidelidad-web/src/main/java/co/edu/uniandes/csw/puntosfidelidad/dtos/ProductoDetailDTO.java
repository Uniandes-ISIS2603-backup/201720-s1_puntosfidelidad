/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;

/**
 *
 * @author cass_
 */
public class ProductoDetailDTO extends ProductoDTO{
    
    private RestauranteDTO restaurante;
    
    public ProductoDetailDTO(){     
        super();        
    }
    
        /**
     * Crea un objeto ProductoDetailDTO a partir de un objeto ProductoEntity
     * incluyendo los atributos de ProductoDTO.
     *
     * @param entity Entidad ProductoEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public ProductoDetailDTO(ProductoEntity entity) {
        
        super(entity);
        
        if (entity != null) {
            restaurante = new RestauranteDTO(entity.getRestaurante());
        }
        
    }
    
     /**
     * Convierte un objeto ProductoDetailDTO a ProductoEntity incluyendo los
     * atributos de ProductoDTO.
     *
     * @return Nueva objeto ProductoEntity.
     *
     */
    @Override
    public ProductoEntity toEntity() {
        ProductoEntity entity = super.toEntity();
        
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
     * @param restaurante the restaurante to set
     */
    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }
    
}
