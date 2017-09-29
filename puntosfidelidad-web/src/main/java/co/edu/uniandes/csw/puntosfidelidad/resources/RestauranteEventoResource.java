/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.EventoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
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
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
/**
 *
 * @author s.cespedes10
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestauranteEventoResource {
    @Inject
    private RestauranteLogic restauranteLogic;

    /**
     * Convierte una lista de eventosEntity a una lista de EventosDetailDTO.
     *
     * @param entityList Lista de EventoEntity a convertir.
     * @return Lista de EventoDetailDTO convertida.
     * 
     */
    private List<EventoDetailDTO> eventosListEntity2DTO(List<EventoEntity> entityList) {
        List<EventoDetailDTO> list = new ArrayList<>();
        for (EventoEntity entity : entityList) {
            list.add(new EventoDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de EventoDetailDTO a una lista de SucursalEntity.
     *
     * @param dtos Lista de EventoDetailDTO a convertir.
     * @return Lista de EventoEntity convertida.
     * 
     */
    private List<EventoEntity> eventosListDTO2Entity(List<EventoDetailDTO> dtos) {
        List<EventoEntity> list = new ArrayList<>();
        for (EventoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de EventoDetailDTO asociadas a una
     * instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @return Colección de instancias de EventoDetailDTO asociadas a la
     * instancia de Restaurante
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    @GET
    public List<EventoDetailDTO> listEventos(@PathParam("usuario") String usuario) throws BusinessLogicException {
       return eventosListEntity2DTO(restauranteLogic.listEventos(usuario));
    }

    /**
     * Obtiene una instancia de Evento asociada a una instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param EventoId Identificador de la instancia de Evento
     * @return 
     * 
     */
    @GET
    @Path("{eventosId: \\d+}")
    public EventoDetailDTO getEventos(@PathParam("usuario") String usuario, @PathParam("eventosId") String EventoId) {
        return new EventoDetailDTO(restauranteLogic.getEvento(usuario, EventoId));
    }

    /**
     * Asocia un Evento existente a un Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param EventoId Id del Evento
     * @return Instancia de EventoDetailDTO que fue asociada a Restaurante
     * 
     */
    @POST
    @Path("{eventosId: \\d+}")
    public EventoDetailDTO addEventos(@PathParam("usuario") String usuario, @PathParam("eventosId") String EventoId) {
        return new EventoDetailDTO(restauranteLogic.addEvento(usuario, EventoId));
    }

    /**
     * Remplaza las instancias de Evento asociadas a una instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param eventos Colección de instancias de eventoslDTO a asociar a instancia
     * de CRestaurante
     * @return Nueva colección de EventoDTO asociada a la instancia de Restaurante
     * 
     */
    @PUT
    public List<EventoDetailDTO> replaceEventos(@PathParam("usuario") String usuario, List<EventoDetailDTO> eventos) {
        return eventosListEntity2DTO(restauranteLogic.replaceEventos(usuario, eventosListDTO2Entity(eventos)));
    }

    /**
     * Desasocia un Eventos existente de un Restaurante existente
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param eventosId Identificador de la instancia de evento
     * 
     */
    @DELETE
    @Path("{eventosId: \\d+}")
    public void removeComentario(@PathParam("usuario") String usuario, @PathParam("eventosId") String eventosId) {
        restauranteLogic.removeEventos(usuario, eventosId);
    }
}
