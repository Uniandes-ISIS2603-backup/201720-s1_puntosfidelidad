/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.EventoLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.SucursalLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
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

/**
 *
 * @author cass_
 */

@Produces("application/json")
@Consumes("application/json")
public class EventoUbicacionResource {
    @Inject
    private EventoLogic eventoLogic;

    /**
     * Convierte una lista de UbicacionEntity a una lista de UbicacionDetailDTO.
     *
     * @param entityList Lista de UbicacionEntity a convertir.
     * @return Lista de UbicacionDetailDTO convertida.
     * 
     */
    private List<UbicacionDetailDTO> ubicacionesListEntity2DTO(List<UbicacionEntity> entityList) {
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
     * 
     */
    private List<UbicacionEntity> ubicacionesListDTO2Entity(List<UbicacionDetailDTO> dtos) {
        List<UbicacionEntity> list = new ArrayList<>();
        for (UbicacionDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de UbicacionDetailDTO asociadas a una
     * instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @return Colección de instancias de UbicacionDetailDTO asociadas a la
     * instancia de Sucursal
     * 
     */
    @GET
    public List<UbicacionDetailDTO> listUbicaciones(@PathParam("nombre") String nombre) throws BusinessLogicException {  
            return ubicacionesListEntity2DTO(eventoLogic.listUbicaciones(nombre)); 
    }

    /**
     * Obtiene una instancia de Ubicacion asociada a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param dir Identificador de la instancia de Ubicacion
     * @return 
     * 
     */
    @GET
    @Path("{ubicacionesId: \\d+}")
    public UbicacionDetailDTO getUbicaciones(@PathParam("nombre") String nombre, @PathParam("dir") String dir) {
        return new UbicacionDetailDTO(eventoLogic.getUbicacion(nombre, dir));
    }

    /**
     * Asocia un Ubicacion existente a un Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param ubicacionesId Identificador de la instancia de Ubicacion
     * @return Instancia de UbicacionDetailDTO que fue asociada a Sucursal
     * 
     */
    @POST
    @Path("{ubicacionesId: \\d+}")
    public UbicacionDetailDTO addUbicaciones(@PathParam("nombre") String nombre, @PathParam("dir") String dir) {
        return new UbicacionDetailDTO(eventoLogic.addUbicacion(nombre, dir));
    }

    /**
     * Remplaza las instancias de Ubicacion asociadas a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param ubicaciones Colección de instancias de UbicacionDTO a asociar a instancia
     * de Sucursal
     * @return Nueva colección de UbicacionDTO asociada a la instancia de Sucursal
     * 
     */
    @PUT
    public List<UbicacionDetailDTO> replaceUbicaciones(@PathParam("nombre") String nombre, List<UbicacionDetailDTO> ubicaciones) {
        return ubicacionesListEntity2DTO(eventoLogic.replaceUbiciaciones(nombre, ubicacionesListDTO2Entity(ubicaciones)));
    }

    /**
     * Desasocia un Ubicacion existente de un Sucursal existente
     *
     * @param id Identificador de la instancia de Sucursal
     * @param ubicacionesId Identificador de la instancia de Ubicacion
     * 
     */
    @DELETE
    @Path("{ubicacionesId: \\d+}")
    public void removeUbicaciones(@PathParam("nombre") String nombre, @PathParam("dir") String dir) {
        eventoLogic.removeUbicacion(nombre, dir);
    }
}