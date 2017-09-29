
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.SucursalLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.CompraLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.SucursalLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
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
 * @author cass_
 */

@Produces("application/json")
@Consumes("application/json")
public class SucursalCompraResource {
    @Inject
    private SucursalLogic sucursalLogic;

    /**
     * Convierte una lista de CompraEntity a una lista de CompraDetailDTO.
     *
     * @param entityList Lista de CompraEntity a convertir.
     * @return Lista de CompraDetailDTO convertida.
     * 
     */
    private List<CompraDetailDTO> comprasListEntity2DTO(List<CompraEntity> entityList) {
        List<CompraDetailDTO> list = new ArrayList<>();
        for (CompraEntity entity : entityList) {
            list.add(new CompraDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de CompraDetailDTO a una lista de CompraEntity.
     *
     * @param dtos Lista de CompraDetailDTO a convertir.
     * @return Lista de CompraEntity convertida.
     * 
     */
    private List<CompraEntity> comprasListDTO2Entity(List<CompraDetailDTO> dtos) {
        List<CompraEntity> list = new ArrayList<>();
        for (CompraDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de CompraDetailDTO asociadas a una
     * instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @return Colección de instancias de CompraDetailDTO asociadas a la
     * instancia de Sucursal
     * 
     */
    @GET
    public List<CompraDetailDTO> listCompras(@PathParam("id") Long id) throws BusinessLogicException {  
            return comprasListEntity2DTO(sucursalLogic.listCompras(id)); 
    }

    /**
     * Obtiene una instancia de Compra asociada a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comprasId Identificador de la instancia de Compra
     * @return 
     * 
     */
    @GET
    @Path("{comprasId: \\d+}")
    public CompraDetailDTO getCompras(@PathParam("id") Long id, @PathParam("comprasId") Long comprasId) {
        return new CompraDetailDTO(sucursalLogic.getCompra(id, comprasId));
    }

    /**
     * Asocia un Compra existente a un Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comprasId Identificador de la instancia de Compra
     * @return Instancia de CompraDetailDTO que fue asociada a Sucursal
     * 
     */
    @POST
    @Path("{comprasId: \\d+}")
    public CompraDetailDTO addCompras(@PathParam("id") Long id, @PathParam("comprasId") Long comprasId) {
        return new CompraDetailDTO(sucursalLogic.addCompra(id, comprasId));
    }

    /**
     * Remplaza las instancias de Compra asociadas a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param compras Colección de instancias de CompraDTO a asociar a instancia
     * de Sucursal
     * @return Nueva colección de CompraDTO asociada a la instancia de Sucursal
     * 
     */
    @PUT
    public List<CompraDetailDTO> replaceCompras(@PathParam("id") Long id, List<CompraDetailDTO> compras) {
        return comprasListEntity2DTO(sucursalLogic.replaceCompras(id, comprasListDTO2Entity(compras)));
    }

    /**
     * Desasocia un Compra existente de un Sucursal existente
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comprasId Identificador de la instancia de Compra
     * 
     */
    @DELETE
    @Path("{comprasId: \\d+}")
    public void removeCompras(@PathParam("id") Long id, @PathParam("comprasId") Long comprasId) {
        sucursalLogic.removeCompra(id, comprasId);
    }
}