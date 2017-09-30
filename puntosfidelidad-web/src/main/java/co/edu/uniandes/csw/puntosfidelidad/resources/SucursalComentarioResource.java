/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ComentarioDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.SucursalLogic;
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
 * @author cass_
 */

@Produces("application/json")
@Consumes("application/json")
public class SucursalComentarioResource {
    @Inject
    private SucursalLogic sucursalLogic;

    /**
     * Convierte una lista de ComentarioEntity a una lista de ComentarioDetailDTO.
     *
     * @param entityList Lista de ComentarioEntity a convertir.
     * @return Lista de ComentarioDetailDTO convertida.
     * 
     */
    private List<ComentarioDetailDTO> comprasListEntity2DTO(List<ComentarioEntity> entityList) {
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
    private List<ComentarioEntity> comprasListDTO2Entity(List<ComentarioDetailDTO> dtos) {
        List<ComentarioEntity> list = new ArrayList<>();
        for (ComentarioDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ComentarioDetailDTO asociadas a una
     * instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @return Colección de instancias de ComentarioDetailDTO asociadas a la
     * instancia de Sucursal
     * 
     */
    @GET
    public List<ComentarioDetailDTO> listComentarios(@PathParam("id") Long id) throws BusinessLogicException {  
            return comprasListEntity2DTO(sucursalLogic.listComentarios(id)); 
    }

    /**
     * Obtiene una instancia de Comentario asociada a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comprasId Identificador de la instancia de Comentario
     * @return 
     * 
     */
    @GET
    @Path("{comentarioId: \\d+}")
    public ComentarioDetailDTO getComentarios(@PathParam("id") Long id, @PathParam("comentarioId") Long comprasId) {
        return new ComentarioDetailDTO(sucursalLogic.getComentario(id, comprasId));
    }

    /**
     * Asocia un Comentario existente a un Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comprasId Identificador de la instancia de Comentario
     * @return Instancia de ComentarioDetailDTO que fue asociada a Sucursal
     * 
     */
    @POST
    @Path("{comentarioId: \\d+}")
    public ComentarioDetailDTO addComentarios(@PathParam("id") Long id , @PathParam("comentarioId") Long comentarioId) {
        return new ComentarioDetailDTO(sucursalLogic.addComentario(id, comentarioId));
    }

    /**
     * Remplaza las instancias de Comentario asociadas a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param compras Colección de instancias de ComentarioDTO a asociar a instancia
     * de Sucursal
     * @return Nueva colección de ComentarioDTO asociada a la instancia de Sucursal
     * 
     */
    @PUT
    public List<ComentarioDetailDTO> replaceComentarios(@PathParam("id") Long id, List<ComentarioDetailDTO> compras) {
        return comprasListEntity2DTO(sucursalLogic.replaceComentarios(id, comprasListDTO2Entity(compras)));
    }

    /**
     * Desasocia un Comentario existente de un Sucursal existente
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comprasId Identificador de la instancia de Comentario
     * 
     */
    @DELETE
    @Path("{comentarioId: \\d+}")
    public void removeComentarios(@PathParam("id") Long id, @PathParam("comentarioId") Long comprasId) {
        sucursalLogic.removeComentario(id, comprasId);
    }
}