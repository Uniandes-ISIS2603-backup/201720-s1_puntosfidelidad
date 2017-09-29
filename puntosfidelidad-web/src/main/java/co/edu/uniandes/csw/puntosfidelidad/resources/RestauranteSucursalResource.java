/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.SucursalDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
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
public class RestauranteSucursalResource {
    @Inject
    private RestauranteLogic restauranteLogic;

    /**
     * Convierte una lista de sucursalesEntity a una lista de SucursalesDetailDTO.
     *
     * @param entityList Lista de ComentarioEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     * 
     */
    private List<SucursalDetailDTO> sucursalesListEntity2DTO(List<SucursalEntity> entityList) {
        List<SucursalDetailDTO> list = new ArrayList<>();
        for (SucursalEntity entity : entityList) {
            list.add(new SucursalDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de SucursalDetailDTO a una lista de SucursalEntity.
     *
     * @param dtos Lista de SucursalDetailDTO a convertir.
     * @return Lista de SucursalEntity convertida.
     * 
     */
    private List<SucursalEntity> sucursalesListDTO2Entity(List<SucursalDetailDTO> dtos) {
        List<SucursalEntity> list = new ArrayList<>();
        for (SucursalDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de SucursalDetailDTO asociadas a una
     * instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @return Colección de instancias de SucursalDetailDTO asociadas a la
     * instancia de Cliente
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    @GET
    public List<SucursalDetailDTO> listSucursales(@PathParam("usuario") String usuario) throws BusinessLogicException {
       return sucursalesListEntity2DTO(restauranteLogic.listSucursales(usuario));
    }

    /**
     * Obtiene una instancia de Sucursal asociada a una instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param sucursalId Identificador de la instancia de Sucursal
     * @return 
     * 
     */
    @GET
    @Path("{sucursalId: \\d+}")
    public SucursalDetailDTO getSucursales(@PathParam("usuario") String usuario, @PathParam("sucursalId") Long sucursalId) {
        return new SucursalDetailDTO(restauranteLogic.getSucursal(usuario, sucursalId));
    }

    /**
     * Asocia una Sucursal o existente a un Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param sucursalId
     * @return Instancia de ComentarioDetailDTO que fue asociada a Cliente
     * 
     */
    @POST
    @Path("{sucursalesId: \\d+}")
    public SucursalDetailDTO addSucursales(@PathParam("usuario") String usuario, @PathParam("sucursalesId") Long sucursalId) {
        return new SucursalDetailDTO(restauranteLogic.addSucursales(usuario, sucursalId));
    }

    /**
     * Remplaza las instancias de Sucursal asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param sucursales Colección de instancias de SucursalDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de SucursalDTO asociada a la instancia de Cliente
     * 
     */
    @PUT
    public List<SucursalDetailDTO> replaceSucursales(@PathParam("usuario") String usuario, List<SucursalDetailDTO> sucursales) {
        return sucursalesListEntity2DTO(restauranteLogic.replaceSucursales(usuario, sucursalesListDTO2Entity(sucursales)));
    }

    /**
     * Desasocia un Sucursal existente de un Restaurante existente
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param sucursalesId Identificador de la instancia de Sucursal
     * 
     */
    @DELETE
    @Path("{sucursalesId: \\d+}")
    public void removeSucursal(@PathParam("usuario") String usuario, @PathParam("sucursalesId") Long sucursalesId) {
        restauranteLogic.removeSucursales(usuario, sucursalesId);
    }
}
