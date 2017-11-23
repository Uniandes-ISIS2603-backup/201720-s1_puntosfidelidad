/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cass_
 */
public class EventoDetailDTO extends EventoDTO{
    
    private List<RestauranteDTO> restaurantes; 
    
    private List<UbicacionDTO> ubicaciones;
    
    public EventoDetailDTO(){     
        super();        
    }
    
        /**
     * Crea un objeto EventoDetailDTO a partir de un objeto EventoEntity
     * incluyendo los atributos de EventoDTO.
     *
     * @param entity Entidad EventoEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public EventoDetailDTO(EventoEntity entity) {
        
        super(entity);
        
        if (entity != null) {
                        
            restaurantes = new ArrayList<>();
            for (RestauranteEntity entityRestaurante : entity.getRestaurantes()) {
                restaurantes.add(new RestauranteDTO(entityRestaurante));
            }
            
            ubicaciones = new ArrayList<>();
            for (UbicacionEntity entityUbicacion : entity.getUbicaciones()) {
                ubicaciones.add(new UbicacionDTO(entityUbicacion));
            }
        }
    }
    
     /**
     * Convierte un objeto EventoDetailDTO a EventoEntity incluyendo los
     * atributos de EventoDTO.
     *
     * @return Nueva objeto EventoEntity.
     *
     */
    @Override
    public EventoEntity toEntity() {
        EventoEntity entity = super.toEntity();
        
        if (getRestaurantes() != null) {
            List<RestauranteEntity> restaurantesEntity = new ArrayList<>();
            for (RestauranteDTO dtoRestaurante : getRestaurantes()) {
                restaurantesEntity.add(dtoRestaurante.toEntity());
            }
            entity.setRestaurantes(restaurantesEntity);
        }
        
        if (getUbicaciones() != null) {
            List<UbicacionEntity> ubicacionesEntity = new ArrayList<>();
            for (UbicacionDTO dtoUbicacion : getUbicaciones()) {
                ubicacionesEntity.add(dtoUbicacion.toEntity());
            }
            entity.setUbicaciones(ubicacionesEntity);
        }

        return entity;
    }

    /**
     * @return the restaurantes
     */
    public List<RestauranteDTO> getRestaurantes() {
        return restaurantes;
    }

    /**
     * @param restaurantes the restaurantes to set
     */
    public void setRestaurantes(List<RestauranteDTO> restaurantes) {
        this.restaurantes = restaurantes;
    }

    /**
     * @return the ubicaciones
     */
    public List<UbicacionDTO> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * @param ubicaciones the ubicaciones to set
     */
    public void setUbicaciones(List<UbicacionDTO> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
    
}
