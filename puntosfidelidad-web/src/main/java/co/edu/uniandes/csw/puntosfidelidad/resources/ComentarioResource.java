/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ComentarioDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.ComentarioDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ComentarioLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ja.manrique
 */
@Path("comentarios")
@Produces("application/json")
public class ComentarioResource {
    
    @Inject
    ComentarioLogic logic;
    
    @GET
    public List<ComentarioDetailDTO> getComentarios()
    {
        return ListEntityToDetailDTO(logic.getComentarios());
    }
    
    @GET
    @Path("{id: \\d+}")
    public ComentarioDetailDTO getComentario(@PathParam("id") Long id) throws BusinessLogicException
    {
        try
        {
            ComentarioDetailDTO busq = new ComentarioDetailDTO (logic.getComentario(id));
            return busq;
        }
        catch (Exception e)
        {
            throw new BusinessLogicException("El comentario con el id " + id + " no existe");
        }       
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ComentarioDetailDTO putComentario(@PathParam("id") Long id, ComentarioDTO nuevo)
    {
        return new ComentarioDetailDTO(logic.updateComentario(nuevo.toEntity()));
    }
    
    
    private List<ComentarioDetailDTO> ListEntityToDetailDTO(List<ComentarioEntity> entities)
    {
        List<ComentarioDetailDTO> DTOList = new ArrayList<>();
        
        for(ComentarioEntity entity: entities)
        {
            //Convierto el entity con el constructor del DTO
            DTOList.add(new ComentarioDetailDTO(entity));
        }
        
        return DTOList;
    }
}
