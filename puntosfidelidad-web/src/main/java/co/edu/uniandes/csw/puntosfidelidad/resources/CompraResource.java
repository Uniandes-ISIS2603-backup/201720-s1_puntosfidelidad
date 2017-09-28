/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.SucursalDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.CompraLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
 * @author aa.yepes
 */
@Path("compras")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CompraResource {
    
    
    @Inject
    CompraLogic compraLogic;
    
    /**
     * Obtiene todos las compras
     * @return lista de compras
     * @throws BusinessLogicException 
     */
    @GET
    public List<CompraDetailDTO> getCompras() throws BusinessLogicException {
        return listClienteEntity2DetailDTO(compraLogic.getCompras());
    }
    
    private List<CompraDetailDTO> listClienteEntity2DetailDTO(List<CompraEntity> entityList) {
        List<CompraDetailDTO> list = new ArrayList<>();
        for (CompraEntity entity : entityList) {
            list.add(new CompraDetailDTO(entity));
        }
        return list;
    }
    
    
    /**
     * Obtiene un compra segùn el id dado 
     * @param id
     * @return cliente
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id: \\d+}")  
    public CompraDetailDTO getCompra(@PathParam("id") Long id) throws BusinessLogicException {
        CompraEntity entity = compraLogic.getCompra(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /compra/" + id + " no existe.", 404);
        }
        return new CompraDetailDTO(entity);
    }
    /**
     * crea una nueva compra
     * @param dto
     * @return 
     */
    @POST
    public CompraDetailDTO createCompra(CompraDetailDTO dto) {
        return new CompraDetailDTO(compraLogic.createCompra(dto.toEntity()));
    }
    
    /**
     * Actualiza un compra
     * @param id
     * @param dto
     * @return compra actualizado 
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}") 
    public CompraDetailDTO updateCompra(@PathParam("id") Long id, CompraDetailDTO dto) throws BusinessLogicException {
        CompraEntity entity = dto.toEntity();
        entity.setId(id);
        CompraEntity oldEntity = compraLogic.getCompra(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La compra no existe", 404);
        }
        entity.setProductos(oldEntity.getProductos());
        entity.setCliente(oldEntity.getCliente());
        entity.setSucursal(oldEntity.getSucursal());
        entity.setTarjetaPuntos(oldEntity.getTarjetaPuntos());
        return new CompraDetailDTO(compraLogic.updateCompra(entity));
    }
    
    /**
     * Elimina una instancia de Author de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCompra(@PathParam("id") Long id) {
        CompraEntity entity = compraLogic.getCompra(id);
        if (entity == null) {
            throw new WebApplicationException("El compra no existe", 404);
        }
        compraLogic.deleteCompra(id);
    }
    
    @Path("{compraId: \\d+}/productos")
    public Class<CompraProductosResource> getCompraProductosResource(@PathParam("compraId") Long compraId) {
        CompraEntity entity = compraLogic.getCompra(compraId);
        if (entity == null) {
            throw new WebApplicationException("El compra no existe", 404);
        }
        return CompraProductosResource.class;
    }
    
    @GET
    @Path("{id: \\d+}/sucursales")  
    public SucursalDetailDTO getSucursal(@PathParam("id") Long id) throws BusinessLogicException {
        CompraEntity entity = compraLogic.getCompra(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /compra/" + id + " no existe.", 404);
        }
        return new SucursalDetailDTO(entity.getSucursal());
    }
    
    @GET
    @Path("{id: \\d+}/clientes")  
    public ClienteDetailDTO getCliente(@PathParam("id") Long id) throws BusinessLogicException {
        CompraEntity entity = compraLogic.getCompra(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /compra/" + id + " no existe.", 404);
        }
        return new ClienteDetailDTO(entity.getCliente());
    }
    
    @GET
    @Path("{id: \\d+}/tarjetasPuntos")  
    public TarjetaPuntosDetailDTO getTarjetaPuntos(@PathParam("id") Long id) throws BusinessLogicException {
        CompraEntity entity = compraLogic.getCompra(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /compra/" + id + " no existe.", 404);
        }
        return new TarjetaPuntosDetailDTO(entity.getTarjetaPuntos());
    }
}
