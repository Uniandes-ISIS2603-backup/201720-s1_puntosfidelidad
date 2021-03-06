/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ComentarioDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.ComentarioDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ComentarioLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
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
    
    @Inject 
    RestauranteLogic restLogic;

    /**
     * Obtiene una lista de todos los comentarios en representación detailed
     *
     * @return lista
     */
    @GET
    public List<ComentarioDetailDTO> getComentarios() {
        return listEntityToDetailDTO(logic.getComentarios());
    }

    @GET
    @Path("restaurantes/{id: [a-zA-Z0-9][a-zA-Z0-9]*}")
    public List<ComentarioDetailDTO> getComentariosRestaurantes(@PathParam("id") String id) throws BusinessLogicException {
        
        ArrayList<ComentarioEntity> listaComentarios = new ArrayList<ComentarioEntity>();
        RestauranteEntity restaurante = restLogic.getRestaurante(id);
        for(SucursalEntity sucur : restaurante.getSucursales())
        {
            for(ComentarioEntity actual : sucur.getComentarios())
            {
                listaComentarios.add(actual);
            }
        }
        
        return listEntityToDetailDTO(listaComentarios);
    }

    /**
     * Retorna el comentario con el id especificado Si el comentario con el id
     * especificado no existe, se le notifica al usuario
     *
     * @param id
     * @return comentario
     * @throws
     * co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public ComentarioDetailDTO getComentario(@PathParam("id") Long id) throws BusinessLogicException {
        try {
            return new ComentarioDetailDTO(logic.getComentario(id));
        } catch (Exception e) {
            throw new WebApplicationException("El comentario con el id " + id + " no existe" + e, 404);
        }
    }

    /**
     * Actualiza un comentario a partir del DTO dado por parámetro, retorna el
     * nuevo estado del comentario
     *
     * @param id
     * @param nuevo
     * @return comentario
     */
    @PUT
    @Path("{id: \\d+}")
    public ComentarioDetailDTO putComentario(@PathParam("id") Long id, ComentarioDTO nuevo) {
        try {
            logic.getComentario(id);
        } catch (NullPointerException e) {

            throw new WebApplicationException("El comentario con el id " + id + " no existe", 404);
        }
        return new ComentarioDetailDTO(logic.updateComentario(nuevo.toEntity()));
    }

    //Los demás métodos rest están desde clases que las contienen (toca crearlas desde allá)
    //Como cliente y/o sucursal [ver api]
    /**
     * A partir de una lista de entidades, retorna una lista de DTO's con la
     * información de las entidades que entraron por parámetro
     */
    private List<ComentarioDetailDTO> listEntityToDetailDTO(List<ComentarioEntity> entities) {
        List<ComentarioDetailDTO> dTOList = new ArrayList<>();

        for (ComentarioEntity entity : entities) {
            //Convierto el entity con el constructor del DTO
            dTOList.add(new ComentarioDetailDTO(entity));
        }

        return dTOList;
    }
}
