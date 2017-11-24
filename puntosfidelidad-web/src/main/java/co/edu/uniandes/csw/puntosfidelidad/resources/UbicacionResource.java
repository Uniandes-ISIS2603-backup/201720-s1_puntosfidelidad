/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.UbicacionLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
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
@Path("ubicaciones")
@Produces("aplication/json")
public class UbicacionResource {
    
    @Inject
    UbicacionLogic logic;
    
     /**
     * Convierte una lista de UbicacionEntity a una lista de UbicacionDetailDTO.
     *
     * @param entityList Lista de UbicacionEntity a convertir.
     * @return Lista de UbicacionDetailDTO convertida.
     */
    private List<UbicacionDetailDTO> ubicacionListEntity2DTO(List<UbicacionEntity> entityList){
        List<UbicacionDetailDTO> list = new ArrayList<>();
        for (UbicacionEntity entity : entityList) {
            list.add(new UbicacionDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de UbicacionDetailDTO a una lista de UbicacionEntity.
     *
     * @param dtos Lista de UbicacionDetailDTO a convertir.
     * @return Lista de UbicacionEntity convertida.    
     */
    private List<UbicacionEntity> ubicacionesListDTO2Entity(List<UbicacionDetailDTO> dtos){
        List<UbicacionEntity> list = new ArrayList<>();
        for (UbicacionDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    @GET
    public List<UbicacionDetailDTO> getUbicaciones(){
        return ubicacionListEntity2DTO(logic.getUbicacions());        
    }
    
    @GET
    @Path("{direccionSucursal}")
    public UbicacionDetailDTO getUbicacion(@PathParam("direccionSucursal") String direccion){
        return new UbicacionDetailDTO(logic.getUbicacion(direccion));
    }
    
    @PUT
    @Path("{direccionSucursal}")
    public UbicacionDetailDTO putUbicacion(@PathParam("direccionSucursal") String direccion, UbicacionDetailDTO ubicacion) throws BusinessLogicException{
        ubicacion.setDTODireccion(direccion);
        UbicacionEntity entity = logic.getUbicacion(direccion);
        if (entity == null) {
            throw new WebApplicationException("El recurso /ubicacion/" + direccion + " no existe.", 404);
        }
        return new UbicacionDetailDTO(logic.updateUbicacion(direccion, ubicacion.toEntity()));
    }
    
    @POST
    public UbicacionDetailDTO postUbicacion( UbicacionDetailDTO ubicacion) throws BusinessLogicException{      
            return new UbicacionDetailDTO(logic.createUbicacion(ubicacion.toEntity()));      
    }
    
    @DELETE
    @Path("{direccionSucursal}")
    public void deleteUbicacion(@PathParam("direccionSucursal") String direccion) throws BusinessLogicException{
        
        UbicacionEntity ubi = logic.getUbicacion(direccion);
        if(ubi == null){
            throw new WebApplicationException("El recurso /ubicaciones/" + direccion + " no existe.", 404);
        }        
        logic.deleteUbicacion(direccion);            
    }
}
