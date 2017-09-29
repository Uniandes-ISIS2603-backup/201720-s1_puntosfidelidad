/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.AdministradorDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.AdministradorDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.AdministradorLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

/**
 * Clase que 'escucha'las URL's correspondientes a Administrador.
 * Se debe seguir lo estipulado en el API (métodos, parámetros y errores)
 */
//URL
@Path("administradores")
//Todos los métodos de esta clase 'retornan' un JSON al navegador (o a postman)
@Produces("application/json")
@Consumes("application/json")
public class AdministradorResource {
    
   
    //Para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    AdministradorLogic logic;
    
    // Inyecciòn de dependencia de la clase restaurante
    @Inject
    RestauranteLogic restaurantelogic;
    
    
    //Métodos REST de la clase (GET, POST, PUT, DELETE)
    
    /**
     * Obtiene todos los restaurantes
     * @return lista de lcientes 
     */
    @GET
    public List<AdministradorDetailDTO> getAdministradores()
    {
        return ListEntityToDetailDTO(logic.getAdministradores());
    }
    
    
    /**
     * Obtiene un administrador segùn el usuario dado 
     * @param usuario
     * @return administrador
     */
    @GET
    @Path("{usuario}")
    public AdministradorDetailDTO getAdministrador(@PathParam("usuario") String usuario)
    {
        AdministradorEntity entity = logic.getAdministrador(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /administradores/" + usuario + " no existe.", 404);
        }
        return new AdministradorDetailDTO(entity);
    }
    
    /**
     * Obtiene los restuarantes de un administrador segùn el usuario dado 
     * @param usuario
     * @return administrador
     */  
    @GET
    @Path("{usuario}/restaurantes")
    public List<RestauranteDTO> getAdministradorRestaurantes(@PathParam("usuario") String usuario)
    {
        return restauranteListEntityToDTO(logic.getAdministrador(usuario).getRestaurantes());
        
        
    }
    
        
    @GET
    @Path("{usuario}/restaurantes/{nit}")
    public RestauranteDetailDTO getAdministradorRestaurante(@PathParam("usuario") String usuario, @PathParam("nit") String nit)
    {
        RestauranteEntity restaurante = logic.getAdministrador(usuario).getRestaurante(nit);
       
        return new RestauranteDetailDTO(restaurante);
    }
    
    @POST
    public AdministradorDTO createAdministrador(AdministradorDTO admDTO) throws BusinessLogicException
    {
        return new AdministradorDetailDTO(logic.createAdministrador(admDTO.toEntity()));
    }
    
    @POST
    @Path("{usuario}")
    public RestauranteDTO createRestaurante(@PathParam("usuario") String usuario, RestauranteDTO resDTO) throws BusinessLogicException
    {
        return new RestauranteDetailDTO(restaurantelogic.createRestaurante(resDTO.toEntity()));
    }
    
    @POST
    @Path("{usuario}/restaurantes")
    public RestauranteDTO createAdministradorRestaurante(RestauranteDTO dto)throws BusinessLogicException
    {
        return new RestauranteDetailDTO(restaurantelogic.createRestaurante(dto.toEntity()));
    }
    
    
    @DELETE
    @Path("{usuario}")
    public void deleteAdministrador(@PathParam("usuario") String usuario) throws BusinessLogicException
    {
        logic.removeAdministrador(usuario);
    }
    
    
    @DELETE
    @Path("{usuario}/restaurantes/{nit}")
    public void deleteRestauranteAdministrador(@PathParam("usuario") String usuario, @PathParam("nit") String nit)
    {
      RestauranteEntity resEliminar= logic.getAdministrador(usuario).getRestaurante(nit);
      
      if(resEliminar==null)
      throw new WebApplicationException("El restaurante no existe");
          
      
        restaurantelogic.removeRestaurante(nit);
    }
    
    @PUT
    @Path("{usuario}/restaurantes/{nit}")
    public RestauranteDetailDTO updateAdministradorRestaurante(@PathParam("nit") String nit, @PathParam("usuario") String usuario, RestauranteDetailDTO dto)
    {
        //Se convierte a entity
        RestauranteEntity entity = dto.toEntity();
        entity.setNit(nit);
        
        //Busco el entity a actualizar
        RestauranteEntity oldEntity = logic.getAdministrador(usuario).getRestaurante(nit);
        if (oldEntity == null)
        {
            //Si no lo encuentro, mando una excepción porque no existe
            throw new WebApplicationException("El restaurante no existe");
        }
        //Si si existe hago que conserve sus sub-recursos (relaciones)
        
        
         //Acá van asignaciones de todas las relaciones que tengael objeto a actualizar
         //Por ejemplo:
         entity.setSucursales(oldEntity.getSucursales());
         entity.setEventos(oldEntity.getEventos());
         entity.setProductos(oldEntity.getProductos());
        
        
        return new RestauranteDetailDTO(restaurantelogic.actualizarRestaurante(nit,dto.toEntity()));
    }
    
    
    //Métodos privados de la clase. La idea es que los métodos de arriba solo llamen a la lógica
    //Si es necesario convertir de Lista de DTOS a Lista de Entities (o al revés) se hace en un método privado
    //Cualquier otra cosa que se requiera, también se mete como método privado
    
    private List<AdministradorDetailDTO> ListEntityToDetailDTO(List<AdministradorEntity> entities)
    {
        List<AdministradorDetailDTO> DTOList = new ArrayList<>();
        
        for(AdministradorEntity entity: entities)
        {
            //Convierto el entity con el constructor del DTO
            DTOList.add(new AdministradorDetailDTO(entity));
        }
        
        return DTOList;
    }
    
    private List<RestauranteDTO> restauranteListEntityToDTO(List<RestauranteEntity> entities)
    {
        List<RestauranteDTO> DTOList = new ArrayList<>();
        
        for(RestauranteEntity entity : entities)
        {
            DTOList.add(new RestauranteDTO(entity));
        }      
        return DTOList;
    }
  
}