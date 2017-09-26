/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ComentarioDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ClienteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
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
 * @author lv.vanegas10
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteComentarioResource {
    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Convierte una lista de ComentarioEntity a una lista de ComentarioDetailDTO.
     *
     * @param entityList Lista de ComentarioEntity a convertir.
     * @return Lista de ComentarioDetailDTO convertida.
     * 
     */
    private List<ComentarioDetailDTO> comentariosListEntity2DTO(List<ComentarioEntity> entityList) {
        List<ComentarioDetailDTO> list = new ArrayList<>();
        for (ComentarioEntity entity : entityList) {
            list.add(new ComentarioDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ComentarioDetailDTO a una lista de ComentarioEntity.
     *
     * @param dtos Lista de ComentarioDetailDTO a convertir.
     * @return Lista de ComentarioEntity convertida.
     * 
     */
    private List<ComentarioEntity> comentariosListDTO2Entity(List<ComentarioDetailDTO> dtos) {
        List<ComentarioEntity> list = new ArrayList<>();
        for (ComentarioDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ComentarioDetailDTO asociadas a una
     * instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @return Colección de instancias de ComentarioDetailDTO asociadas a la
     * instancia de Cliente
     * 
     */
    @GET
    public List<ComentarioDetailDTO> listComentarios(@PathParam("usuario") String usuario) throws BusinessLogicException {
       return comentariosListEntity2DTO(clienteLogic.listComentarios(usuario));
    }

    /**
     * Obtiene una instancia de Comentario asociada a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comentariosId Identificador de la instancia de Comentario
     * @return 
     * 
     */
    @GET
    @Path("{comentariosId: \\d+}")
    public ComentarioDetailDTO getComentarios(@PathParam("usuario") String usuario, @PathParam("comentariosId") Long comentariosId) {
        return new ComentarioDetailDTO(clienteLogic.getComentario(usuario, comentariosId));
    }

    /**
     * Asocia un Comentario existente a un Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comentariosId Identificador de la instancia de Comentario
     * @return Instancia de ComentarioDetailDTO que fue asociada a Cliente
     * 
     */
    @POST
    @Path("{comentariosId: \\d+}")
    public ComentarioDetailDTO addComentarios(@PathParam("usuario") String usuario, @PathParam("comentariosId") Long comentariosId) {
        return new ComentarioDetailDTO(clienteLogic.addComentario(usuario, comentariosId));
    }

    /**
     * Remplaza las instancias de Comentario asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comentarios Colección de instancias de ComentarioDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de ComentarioDTO asociada a la instancia de Cliente
     * 
     */
    @PUT
    public List<ComentarioDetailDTO> replaceComentarios(@PathParam("usuario") String usuario, List<ComentarioDetailDTO> comentarios) {
        return comentariosListEntity2DTO(clienteLogic.replaceComentarios(usuario, comentariosListDTO2Entity(comentarios)));
    }

    /**
     * Desasocia un Comentario existente de un Cliente existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comentariosId Identificador de la instancia de Comentario
     * 
     */
    @DELETE
    @Path("{comentariosId: \\d+}")
    public void removeComentario(@PathParam("usuario") String usuario, @PathParam("comentariosId") Long comentariosId) {
        clienteLogic.removeComentario(usuario, comentariosId);
    }
}
