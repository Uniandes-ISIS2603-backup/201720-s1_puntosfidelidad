/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.SucursalDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.SucursalLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author cass_
 */
@Path("sucursales")
@Produces("aplication/json")
public class SucursalResource {
    
    @Inject
    SucursalLogic logic;
    
     /**
     * Convierte una lista de SucursalEntity a una lista de SucursalDetailDTO.
     *
     * @param entityList Lista de SucursalEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     */
    private List<SucursalDetailDTO> sucursalListEntity2DTO(List<SucursalEntity> entityList){
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
     */
    private List<SucursalEntity> sucursalesListDTO2Entity(List<SucursalDetailDTO> dtos){
        List<SucursalEntity> list = new ArrayList<>();
        for (SucursalDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    @GET
    public List<SucursalDetailDTO> getSucursales(){
        return sucursalListEntity2DTO(logic.getSucursals());
    }
    
    @GET
    @Path("{id: //d+}")
    public SucursalDetailDTO getSucursal(@PathParam("id") Long id){
        return new SucursalDetailDTO(logic.getSucursal(id));
    }
    
    @PUT
    @Path("{id: //d+}")
    public SucursalDetailDTO putSucursal(@PathParam("id") Long id){
        return new SucursalDetailDTO(logic.getSucursal(id));
    }
    
    @POST
    public SucursalDetailDTO postSucursal( SucursalDetailDTO sucursal) throws BusinessLogicException{      
            return new SucursalDetailDTO(logic.createSucursal(sucursal.toEntity()));      
    }
    
    @DELETE
    @Path("{id: //d+}")
    public void deleteSucursal(@PathParam("id") Long id) throws BusinessLogicException{
        
        SucursalEntity ubi = logic.getSucursal(id);
        if(ubi == null){
            throw new WebApplicationException("El recurso /sucursales/" + id + " no existe.", 404);
        }
        
        logic.deleteSucursal(id);            
    }
}
