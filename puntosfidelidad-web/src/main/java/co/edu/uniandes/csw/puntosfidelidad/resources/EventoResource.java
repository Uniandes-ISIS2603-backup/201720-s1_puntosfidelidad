/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.EventoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.EventoLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author cass_
 */
@Path("eventos")
@Produces("aplication/json")
public class EventoResource {
    
    @Inject
    EventoLogic logic;
    
     /**
     * Convierte una lista de EventoEntity a una lista de EventoDetailDTO.
     *
     * @param entityList Lista de EventoEntity a convertir.
     * @return Lista de EventoDetailDTO convertida.
     */
    private List<EventoDetailDTO> eventoListEntity2DTO(List<EventoEntity> entityList){
        List<EventoDetailDTO> list = new ArrayList<>();
        for (EventoEntity entity : entityList) {
            list.add(new EventoDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de EventoDetailDTO a una lista de EventoEntity.
     *
     * @param dtos Lista de EventoDetailDTO a convertir.
     * @return Lista de EventoEntity convertida.    
     */
    private List<EventoEntity> eventosListDTO2Entity(List<EventoDetailDTO> dtos){
        List<EventoEntity> list = new ArrayList<>();
        for (EventoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    @GET
    public List<EventoDetailDTO> getEventos(){
        return eventoListEntity2DTO(logic.getEventos());
    }
    
    @GET
    @Path("{nombre}")
    public EventoDetailDTO getEvento(@PathParam("nombre") String nombre){
        return new EventoDetailDTO(logic.getEvento(nombre));
    }
    
    @PUT
    @Path("{nombre}")
    public EventoDetailDTO putEvento(@PathParam("nombre") String nombre, EventoDetailDTO evento) throws BusinessLogicException{
        evento.setDTONombre(nombre);
        EventoEntity entity = logic.getEvento(nombre);
        if (entity == null) {
            throw new WebApplicationException("El recurso /evento/" + nombre + " no existe.", 404);
        }
        return new EventoDetailDTO(logic.updateEvento(nombre, evento.toEntity()));
    }
    
    @POST
    public EventoDetailDTO postEvento( EventoDetailDTO evento) throws BusinessLogicException{      
            return new EventoDetailDTO(logic.createEvento(evento.toEntity()));      
    }
    
    @DELETE
    @Path("{nombre}")
    public void deleteEvento(@PathParam("nombre") String nombre) throws BusinessLogicException{
        
        EventoEntity ubi = logic.getEvento(nombre);
        if(ubi == null){
            throw new WebApplicationException("El recurso /eventos/" + nombre + " no existe.", 404);
        }
        
        logic.deleteEvento(nombre);            
    }
    
    /**
     * Consulta de Restaurantes
     * @param usuario
     * @return RecargaResource
     */
    @Path("{nombre}/restaurantes")
    public Class<EventoRestauranteResource> getComprasResource(@PathParam("nombre") String nombre) {
        EventoEntity entity = logic.getEvento(nombre);
        if (entity == null) {
            throw new WebApplicationException("El recurso /evento/" + nombre + "/restaurantesno existe.", 404);
        }
        return EventoRestauranteResource.class;
    }
    
    /**
     * Consulta de Ubicaciones
     * @param usuario
     * @return RecargaResource
     */
    @Path("{nombre}/ubicaciones")
    public Class<EventoUbicacionResource> getComentariosResource(@PathParam("nombre") String nombre) {
        EventoEntity entity = logic.getEvento(nombre);
        if (entity == null) {
            throw new WebApplicationException("El recurso /evento/" + nombre + "/ubicacaciones no existe.", 404);
        }
        return EventoUbicacionResource.class;
    }

}
