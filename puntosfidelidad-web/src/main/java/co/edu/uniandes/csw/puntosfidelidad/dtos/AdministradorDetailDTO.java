/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja.manrique
 */
public class AdministradorDetailDTO extends AdministradorDTO{
    
   
    private List<RestauranteDTO> restaurantes;
   
    
    public AdministradorDetailDTO() {
    super();
   
    }
            
    /**
     * Conviertir Entity a DetailDTO
     * Crea un nuevo DetailDTO con los valores que recibe en la entidad que viene de argumento.
     */
    public AdministradorDetailDTO(AdministradorEntity entity)
    {
       
        super(entity);
        if (entity != null)
        {
            restaurantes = new ArrayList<>();
            
            for(RestauranteEntity entityRestaurante: entity.getRestaurantes())
            {
                restaurantes.add(new RestauranteDTO(entityRestaurante));
            }
        }
       
    }
    
    @Override
    public AdministradorEntity toEntity()
    {
        
        AdministradorEntity entity = super.toEntity();
        
        if(restaurantes != null)
        {
            List<RestauranteEntity> restaurantesEntity = new ArrayList<>();
            for(RestauranteDTO dtoRestaurante: restaurantes)
            {
                restaurantesEntity.add(dtoRestaurante.toEntity());
            }
            entity.setRestaurantes(restaurantesEntity);
        }
        
        return entity;
    }

    public List<RestauranteDTO> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<RestauranteDTO> restaurantes) {
        this.restaurantes = restaurantes;
    }
    
}