/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author s.cespedes10
 */

@Path("restaurantes")
@Produces("application/json")
@Consumes("application/json")
public class RestauranteResource {
    
   @Inject
    RestauranteLogic logic;
    
     /**
     * Obtiene una colección de instancias de restauranteDetailDTO 
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
     @GET
    public List<RestauranteDetailDTO> getRestaurantes()throws BusinessLogicException{
        return restauranteListEntity2DTO(logic.getRestaurantes());
    }
    
     /**
     * Obtiene una colección de instanciaa de RestauranteDetailDTO asociadas a una
     *
     * @param id Identificador de la instancia de Restaurante
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    @GET
    @Path("{id: [a-zA-Z0-9][a-zA-Z0-9]*}")
    public RestauranteDetailDTO getRestaurante(@PathParam("id") String id) throws BusinessLogicException {
        RestauranteEntity entity = logic.getRestaurante(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /restaurante/" + id + " no existe.", 404);
        }
        return new RestauranteDetailDTO(entity);
    }
    
    
    /**
     * Cra un restaurante
     * @param resta
     * @return Restaurante creado
     * @throws BusinessLogicException
     */
    @POST
    public RestauranteDTO createRestaurante(RestauranteDTO resta) throws BusinessLogicException {        
         return new RestauranteDTO(logic.createRestaurante(resta.toEntity()));
    }

    /**
     * Actualiza un Restaurante
     * @param usuario
     * @param cliente
     * @return cliente actualizado 
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}") 
    public RestauranteDetailDTO updateRestaurante(@PathParam("usuario") String usuario, RestauranteDTO cliente) throws BusinessLogicException {
        cliente.setNit(usuario);
        RestauranteEntity entity = logic.getRestaurante(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /restaurante/" + usuario + " no existe.", 404);
        }
        return new RestauranteDetailDTO(logic.actualizarRestaurante(usuario, cliente.toEntity()));
    }

    /**
     * Borra un restaurante
     * @param usuario
     * @throws BusinessLogicException
     */
    @DELETE
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}")
    public void deleteRestaurante(@PathParam("usuario") String usuario) throws BusinessLogicException {
        RestauranteEntity entity = logic.getRestaurante(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /restaurante/" + usuario + " no existe.", 404);
        }
        logic.removeRestaurante(usuario);
    }
    
    
    /**
     * Consulta de Sucursal
     * @param usuario
     * @return SucursalResource
     */
    @GET
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*/sucursales}")
    public Class<RestauranteSucursalResource> getRestauranteSucursalResource(@PathParam("usuario") String usuario) {
        RestauranteEntity entity = logic.getRestaurante(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /restaurantes/" + usuario + "/Sucursal no existe.", 404);
        }
        return RestauranteSucursalResource.class;
    }
    
   /**
     * Consulta de Producto
     * @param usuario
     * @return SucursalResource
     */
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}/productos")
    public Class<RestauranteProductoResource> getRestauranteProductoResource(@PathParam("usuario") String usuario) {
        RestauranteEntity entity = logic.getRestaurante(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /restaurantes/" + usuario + "/Producto no existe.", 404);
        }
        return RestauranteProductoResource.class;
    }
    
    /**
     * Consulta de Producto
     * @param usuario
     * @return SucursalResource
     */
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}/eventos")
    public Class<RestauranteEventoResource> getRestauranteEventoResource(@PathParam("usuario") String usuario) {
        RestauranteEntity entity = logic.getRestaurante(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /restaurantes/" + usuario + "/evento no existe.", 404);
        }
        return RestauranteEventoResource.class;
    } 
    
    
       
    
    /**
     * Convierte una lista de RestauranteEntity a una lista de SucursalDetailDTO.
     *
     * @param entityList Lista de SucursalEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     */
    private List<RestauranteDetailDTO> restauranteListEntity2DTO(List<RestauranteEntity> entityList){
        List<RestauranteDetailDTO> list = new ArrayList<>();
        for (RestauranteEntity entity : entityList) {
            list.add(new RestauranteDetailDTO(entity));
        }
        return list;
    } 
    
    /**
     * Convierte una lista de RestauranteDetailDTO a una lista de RestauranteEntity.
     *
     * @param dtos Lista de SucursalDetailDTO a convertir.
     * @return Lista de SucursalEntity convertida.    
     */
    private List<RestauranteEntity> restaurantesListDTO2Entity(List<RestauranteDetailDTO> dtos){
        List<RestauranteEntity> list = new ArrayList<>();
        for (RestauranteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    
    
    
}
    