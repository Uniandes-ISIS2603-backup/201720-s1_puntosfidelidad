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
import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

/**
 * Clase que 'escucha'las URL's correspondientes a Administrador.
 * Se debe seguir lo estipulado en el API (métodos, parámetros y errores)
 * @author ja.manrique
 */
//URL
@Path("administradores")
//Todos los métodos de esta clase 'retornan' un JSON al navegador (o a postman)
@Produces("application/json")
public class AdministradorResource {
    
    /*   ---------PLANTILLA ADMINISTRADOR---------
    ANTECIÓN: LO QUE HAY EN ESTE BLOQUESOTE DE COMENTARIO ES TRBAJO EN PROGRESO DE ADMINISTRADOR.
    SE COMENTÓ PARA CONSERVARLO PERO QUE IGUAL LA APLICACIÓN MANTUVIERA SU INTEGRIDAD (NO COMPILABA PORQUE FALTAN COSAS DE LOGIC Y DTO'S)
    NO ELIMINARLO Y *SOLO* DESCOMENTARLO PARA TERMINAR EL TRABAJO INICIADO
    
    AL COMPLETAR LA CLASE SE PEUDE BORRAR ESTE MENSAJE
    
    //Para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    AdministradorLogic logic;
    
    //Métodos REST de la clase (GET, POST, PUT, DELETE)
    
    @GET
    public List<AdministradorDetailDTO> getAdministradores()
    {
        return ListEntityToDetailDTO(logic.getAdministradores());
    }
    
    @GET
    @Path("{usuario}")
    public AdministradorDetailDTO getAdministrador(@PathParam("usuario") String usuario)
    {
        return new AdministradorDetailDTO(logic.getAdministrador(usuario));
    }
    
    @POST
    public AdministradorDTO createAdministrador(AdministradorDTO admDTO) throws BusinessLogicException
    {
        return new AdministradorDetailDTO(logic.createAdministrador(admDTO.toEntity()));
    }
    
    @DELETE
    @Path("{usuario}")
    public void deleteAdministrador(@PathParam("usuario") String usuario)
    {
        logic.removeAdministrador(usuario);
    }
    
    @GET
    @Path("{usuario}/restaurantes")
    public List<RestauranteDTO> getAdministradorRestaurantes(@PathParam("usuario") String usuario)
    {
        return restauranteListEntityToDTO(logic.getRestaurantes(usuario));
    }
    
    @GET
    @Path("{usuario}/restaurantes/{nit}")
    public RestauranteDetailDTO getAdministradorRestaurante(@PathParam("usuario") String usuario, @PathParam("nit") String nit)
    {
        return new RestauranteDetailDTO(logic.getRestaurante(usuario, nit));
    }
    
    @POST
    @Path("{usuario}/restaurantes")
    public RestauranteDTO createAdministradorRestaurante(RestauranteDTO dto)
    {
        return new RestauranteDetailDTO(logic.createRestaurante(dto.toEntity()));
    }
    
    @PUT
    @Path("{usuario}/restaurantes/{nit}")
    public RestauranteDetailDTO updateAdministradorRestaurante(@PathParam("nit") String nit, RestauranteDetailDTO dto)
    {
        //Se convierte a entity
        RestauranteEntity entity = dto.toEntity();
        entity.setNit(nit);
        
        //Busco el entity a actualizar
        RestauranteEntity oldEntity = logic.getRestaurante(usuario, nit);
        if (oldEntity == null)
        {
            //Si no lo encuentro, mando una excepción porque no existe
            throw new WebApplicationException("El restaurante no existe");
        }
        //Si si existe hago que conserve sus sub-recursos (relaciones)
        
        
         //Acá van asignaciones de todas las relaciones que tengael objeto a actualizar
         //Por ejemplo:
         //entity.setSucursales(oldEntity.getSucursales());
        
        
        return new RestauranteDetailDTO(logic.actualizarRestaurante(dto.toEntity()));
    }
    
    @DELETE
    @Path("{usuario}/restaurantes/{nit}")
    public void deleteRestauranteAdministrador(@PathParam("usuario") String usuario, @PathParam("nit") String nit)
    {
        logic.removeRestaurante(usuario, nit);
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
  
    ---------FIN PLANTILLA ADMINISTRADOR---------
*/
}
