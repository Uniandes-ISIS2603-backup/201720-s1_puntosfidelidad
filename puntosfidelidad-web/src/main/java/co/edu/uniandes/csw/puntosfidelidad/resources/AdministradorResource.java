/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.AdministradorDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.AdministradorDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.AdministradorLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
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
    
    
    
    //Métodos REST de la clase (GET, POST, PUT, DELETE)
    
    /**
     * Obtiene todos los restaurantes
     * @return lista de lcientes 
     * @throws BusinessLogicException 
     */
    @GET
    public List<AdministradorDetailDTO> getAdministradores()throws BusinessLogicException
    {
        return ListEntityToDetailDTO(logic.getAdministradores());
    }
    
    
    /**
     * Obtiene un administrador segùn el usuario dado 
     * @param usuario
     * @return administrador
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     */
    @GET
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}")
    public AdministradorDetailDTO getAdministrador(@PathParam("usuario") String usuario)throws BusinessLogicException
    {
        AdministradorEntity entity = logic.getAdministrador(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /administradores/" + usuario + " no existe.", 404);
        }
        return new AdministradorDetailDTO(entity);
    }
    
     /**
     * Crea un cliente 
     * @param admin
     * @return Cliente creado
     * @throws BusinessLogicException
     */
    @POST
    public AdministradorDTO createAdministrador(AdministradorDTO admin) throws BusinessLogicException
    {
        return new AdministradorDetailDTO(logic.createAdministrador(admin.toEntity()));
    }
    
    
    /**
     * Actualiza un administrador
     * @param usuario
     * @param admin
     * @return cliente actualizado 
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}") 
    public AdministradorDetailDTO updateCliente(@PathParam("usuario") String usuario, AdministradorDetailDTO admin) throws BusinessLogicException {
        admin.setUsuario(usuario);
        AdministradorEntity entity = logic.getAdministrador(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /administrador/" + usuario + " no existe.", 404);
        }
        return new AdministradorDetailDTO(logic.actualizarAdministrador(usuario, admin.toEntity()));
    }
    
    
    /**
     * Borra un administrador
     * @param usuario
     * @throws BusinessLogicException
     */
    @DELETE
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}")
    public void deleteAdministrador(@PathParam("usuario") String usuario) throws BusinessLogicException
    {
        AdministradorEntity entity = logic.getAdministrador(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /administrador/" + usuario + " no existe.", 404);
        }
        logic.removeAdministrador(usuario);
    }
      
    
    
    /**
     * Consulta de restaurante
     * @param usuario
     * @return RestauranteResource
     */
    @Path("{usuario: [a-zA-Z0-9][a-zA-Z0-9]*}/restaurantes")
    public Class<AdminRestauranteResource> getAdminRestauranteResource(@PathParam("usuario") String usuario) {
        AdministradorEntity entity = logic.getAdministrador(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + usuario + "/restaurante no existe.", 404);
        }
        return AdminRestauranteResource.class;
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
    
 
  
}