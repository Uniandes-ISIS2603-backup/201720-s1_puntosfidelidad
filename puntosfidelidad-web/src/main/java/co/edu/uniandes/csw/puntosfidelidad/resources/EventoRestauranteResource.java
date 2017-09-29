/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.EventoLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.EventoLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author cass_
 */
@Produces("application/json")
@Consumes("application/json")
public class EventoRestauranteResource {
        @Inject
    private EventoLogic eventoLogic;

    /**
     * Convierte una lista de RestauranteEntity a una lista de RestauranteDetailDTO.
     *
     * @param entityList Lista de RestauranteEntity a convertir.
     * @return Lista de RestauranteDetailDTO convertida.
     * 
     */
    private List<RestauranteDetailDTO> restaurantesListEntity2DTO(List<RestauranteEntity> entityList) {
        List<RestauranteDetailDTO> list = new ArrayList<>();
        for (RestauranteEntity entity : entityList) {
            list.add(new RestauranteDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de RestauranteDetailDTO a una lista de RestauranteEntity.
     *
     * @param dtos Lista de RestauranteDetailDTO a convertir.
     * @return Lista de RestauranteEntity convertida.
     * 
     */
    private List<RestauranteEntity> restaurantesListDTO2Entity(List<RestauranteDetailDTO> dtos) {
        List<RestauranteEntity> list = new ArrayList<>();
        for (RestauranteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de RestauranteDetailDTO asociadas a una
     * instancia de Evento
     *
     * @param id Identificador de la instancia de Evento
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * instancia de Evento
     * 
     */
    @GET
    public List<RestauranteDetailDTO> listRestaurantes(@PathParam("nombre") String nombre) throws BusinessLogicException {  
            return restaurantesListEntity2DTO(eventoLogic.listRestaurantes(nombre)); 
    }

    /**
     * Obtiene una instancia de Restaurante asociada a una instancia de Evento
     *
     * @param id Identificador de la instancia de Evento
     * @param comprasId Identificador de la instancia de Restaurante
     * @return 
     * 
     */
    @GET
    @Path("{comprasId: \\d+}")
    public RestauranteDetailDTO getRestaurantes(@PathParam("nombre") String nombre, @PathParam("nit") String nit) {
        return new RestauranteDetailDTO(eventoLogic.getRestaurante(nombre, nit));
    }

    /**
     * Asocia un Restaurante existente a un Evento
     *
     * @param id Identificador de la instancia de Evento
     * @param comprasId Identificador de la instancia de Restaurante
     * @return Instancia de RestauranteDetailDTO que fue asociada a Evento
     * 
     */
    @POST
    @Path("{comprasId: \\d+}")
    public RestauranteDetailDTO addRestaurantes(@PathParam("nombre") String nombre, @PathParam("nit") String nit) {
        return new RestauranteDetailDTO(eventoLogic.addRestaurante(nombre, nit));
    }

    /**
     * Remplaza las instancias de Restaurante asociadas a una instancia de Evento
     *
     * @param id Identificador de la instancia de Evento
     * @param compras Colección de instancias de RestauranteDTO a asociar a instancia
     * de Evento
     * @return Nueva colección de RestauranteDTO asociada a la instancia de Evento
     * 
     */
    @PUT
    public List<RestauranteDetailDTO> replaceRestaurantes(@PathParam("nombre") String nombre, List<RestauranteDetailDTO> compras) {
        return restaurantesListEntity2DTO(eventoLogic.replaceRestaurantes(nombre, restaurantesListDTO2Entity(compras)));
    }

    /**
     * Desasocia un Restaurante existente de un Evento existente
     *
     * @param id Identificador de la instancia de Evento
     * @param comprasId Identificador de la instancia de Restaurante
     * 
     */
    @DELETE
    @Path("{comprasId: \\d+}")
    public void removeRestaurantes(@PathParam("nombre") String nombre, @PathParam("nit") String nit) {
        eventoLogic.removeRestaurante(nombre, nit);
    }
}