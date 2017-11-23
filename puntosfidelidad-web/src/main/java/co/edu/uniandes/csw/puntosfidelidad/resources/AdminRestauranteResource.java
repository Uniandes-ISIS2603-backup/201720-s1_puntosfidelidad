/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.AdministradorLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
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
public class AdminRestauranteResource {
    @Inject
    private AdministradorLogic adminLogic;

    @Inject
    private RestauranteLogic logic;
    /**
     * Convierte una lista de RestauranteEntity a una lista de ComentarioDetailDTO.
     *
     * @param entityList Lista de RestauranteEntity a convertir.
     * @return Lista de RestauranteDetailDTO convertida.
     * 
     */
    private List<RestauranteDetailDTO> restaurantesListEntity2DTO(List<RestauranteEntity> entityList) {
        List<RestauranteDetailDTO> list = new ArrayList<>();
        for (RestauranteEntity entity : entityList) {
            list.add(new RestauranteDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de RestauranteDetailDTO a una lista de ComentarioEntity.
     *
     * @param dtos Lista de RestauranteDetailDTO a convertir.
     * @return Lista de RestauranteEntity convertida.
     * 
     */
    private List<RestauranteEntity> restaurantesListDTO2Entity(List<RestauranteDetailDTO> dtos) {
        List<RestauranteEntity> list = new ArrayList<>();
        for (RestauranteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de RestauranteDetailDTO asociadas a una
     * instancia de Administrador
     *
     * @param usuario Identificador de la instancia de administrador
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * instancia de Administrador
     * @throws BusinessLogicException
     * 
     */
    @GET
    public List<RestauranteDetailDTO> listRestaurantes(@PathParam("usuario") String usuario) throws BusinessLogicException {
       return restaurantesListEntity2DTO(adminLogic.listRestaurantes(usuario));
    }

    /**
     * Obtiene una instancia de Restaurante asociada a una instancia de Admnistrador
     *
     * @param usuario Identificador de la instancia de Administrador
     * @param nit Identificador de la instancia de Restaurante
     * @return 
     * 
     */
    @GET
    @Path("{restaurantesId: \\d+}")
    public RestauranteDetailDTO getRestaurantes(@PathParam("usuario") String usuario, @PathParam("restaurantesId") String nit) {
        return new RestauranteDetailDTO(adminLogic.getRestaurante(usuario, nit));
    }

    /**
     * Asocia un Restaurante existente a un Administrador
     *
     * @param nombre Identificador de la instancia de Cliente
     * @param nit Identificador de la instancia de Comentario
     * @return Instancia de ComentarioDetailDTO que fue asociada a Cliente
     * 
     */
     @POST    
    public RestauranteDTO createRestaurante(@PathParam("usuario") String usuario,RestauranteDTO res ) throws BusinessLogicException
    {
        AdministradorEntity admin= adminLogic.getAdministrador(usuario);
        RestauranteEntity restaurant= res.toEntity();
        restaurant.setAdministrador(admin);        
        List lista= admin.getRestaurantes();
        lista.add(restaurant);
        admin.setRestaurantes(lista);
        return new RestauranteDTO(logic.createRestaurante(restaurant));
    }  

    /**
     * Remplaza las instancias de Restaurante asociadas a una instancia de Administrador
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param restaurantes Colección de instancias de ComentarioDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de ComentarioDTO asociada a la instancia de Cliente
     * 
     */
    @PUT
    @Path("{restaurantesId: \\d+}")
    public List<RestauranteDetailDTO> replaceRestaurantes(@PathParam("usuario") String usuario, List<RestauranteDetailDTO> restaurantes) {
        return restaurantesListEntity2DTO(adminLogic.replaceRestaurantes(usuario, restaurantesListDTO2Entity(restaurantes)));
    }

    /**
     * Desasocia un Restaurante existente de un Administrador existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param nit Identificador de la instancia de Comentario
     * 
     */
    @DELETE
    @Path("{restaurantesId: \\d+}")
    public void removeRestaurantes(@PathParam("usuario") String usuario, @PathParam("restaurantesId") String nit) {
        adminLogic.removeRestaurantes(usuario, nit);
    }
}
