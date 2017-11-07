/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.RecargaDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RecargaDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RecargaLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
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
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author lv.vanegas10
 */
@Produces("application/json")
@Consumes("application/json")
public class RecargaResource {

    @Inject
    RecargaLogic recargaLogic;

    /**
     * Obtiene las recargas de un cliente
     * @param usuario
     * @return recarga
     * @throws BusinessLogicException
     */
    @GET
    public List<RecargaDetailDTO> getRecargas(@PathParam("usuario") String usuario) throws BusinessLogicException {
        return listEntity2DTO(recargaLogic.getRecargas(usuario));
    }

    /**
     * Obtiene las recargas de un cliente, dado un id. 
     * @param usuario
     * @return recarga
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public RecargaDTO getRecarga(@PathParam("usuario") String usuario, @PathParam("id") Long id) throws BusinessLogicException {
        RecargaEntity entity = recargaLogic.getRecarga(usuario, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + usuario + "/recargas/" + id + " no existe.", 404);
        }
        return new RecargaDTO(entity);
    }

    /**
     * Crea una recarga
     * @param usuario
     * @param recarga
     * @return RecargaDTO
     * @throws BusinessLogicException
     */
    @POST
    public RecargaDTO createRecarga(@PathParam("usuario") String usuario, RecargaDTO recarga) throws BusinessLogicException {
        return new RecargaDTO(recargaLogic.createRecarga(usuario, recarga.toEntity()));
    }
    
    /**
     * Actualiza una recarga
     * @param usuario
     * @param id
     * @param recarga
     * @return recarga
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public RecargaDTO updateRecarga(@PathParam("usuario") String usuario, @PathParam("id") Long id, RecargaDTO recarga) throws BusinessLogicException {
        recarga.setId(id);
        RecargaEntity entity = recargaLogic.getRecarga(usuario, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + usuario + "/recargas/" + id + " no existe.", 404);
        }
        return new RecargaDTO(recargaLogic.updateRecarga(usuario, recarga.toEntity()));

    }

    /**
     * Elimina una recarga
     * @param usuario
     * @param id
     * @throws BusinessLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteRecarga(@PathParam("usuario") String usuario, @PathParam("id") Long id) throws BusinessLogicException {
        RecargaEntity entity = recargaLogic.getRecarga(usuario, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + usuario + "/recargas/" + id + " no existe.", 404);
        }
        recargaLogic.deleteRecarga(usuario, id);
    }
    /**
     * Lista de entidades a DTOS
     * @param entityList
     * @return lista DTOS
     */
    private List<RecargaDetailDTO> listEntity2DTO(List<RecargaEntity> entityList) {
        List<RecargaDetailDTO> list = new ArrayList<>();
        for (RecargaEntity entity : entityList) {
            list.add(new RecargaDetailDTO(entity));
        }
        return list;
    }
}
