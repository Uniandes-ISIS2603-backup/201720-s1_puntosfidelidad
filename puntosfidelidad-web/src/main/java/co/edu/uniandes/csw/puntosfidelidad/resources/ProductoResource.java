/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.ProductoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.SucursalDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.CompraLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ProductoLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
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
@Path("productos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ProductoResource {
    
    @Inject
    ProductoLogic productoLogic;
    
    /**
     * Obtiene todos las productos
     * @return lista de productos
     * @throws BusinessLogicException 
     */
    @GET
    public List<ProductoDetailDTO> getProductos() throws BusinessLogicException {
        return listClienteEntity2DetailDTO(productoLogic.getProductos());
    }
    
    private List<ProductoDetailDTO> listClienteEntity2DetailDTO(List<ProductoEntity> entityList) {
        List<ProductoDetailDTO> list = new ArrayList<>();
        for (ProductoEntity entity : entityList) {
            list.add(new ProductoDetailDTO(entity));
        }
        return list;
    }
    
    
    /**
     * Obtiene un producto segùn el id dado 
     * @param id
     * @return producto
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id: \\d+}")  
    public ProductoDetailDTO getProducto(@PathParam("id") Long id) throws BusinessLogicException {
        ProductoEntity entity = productoLogic.getProducto(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /producto/" + id + " no existe.", 404);
        }
        return new ProductoDetailDTO(entity);
    }
    /**
     * crea una nueva producto
     * @param dto
     * @return 
     */
    @POST
    public ProductoDetailDTO createCompra(ProductoDetailDTO dto) {
        return new ProductoDetailDTO(productoLogic.createProducto(dto.toEntity()));
    }
    
    /**
     * Actualiza un producto
     * @param id
     * @param dto
     * @return producto actualizado 
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}") 
    public ProductoDetailDTO updateCompra(@PathParam("id") Long id, ProductoDetailDTO dto) throws BusinessLogicException {
        ProductoEntity entity = dto.toEntity();
        entity.setId(id);
        ProductoEntity oldEntity = productoLogic.getProducto(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La producto no existe", 404);
        }
        entity.setRestaurante(oldEntity.getRestaurante());
        
        return new ProductoDetailDTO(productoLogic.updateProducto(entity));
    }
    
    /**
     * Elimina una instancia de Author de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") Long id) {
        ProductoEntity entity = productoLogic.getProducto(id);
        if (entity == null) {
            throw new WebApplicationException("El compra no existe", 404);
        }
        productoLogic.deleteProducto(id);
    }
    
    @GET
    @Path("{id: \\d+}/restaurante")  
    public RestauranteDetailDTO getRestaurante(@PathParam("id") Long id) throws BusinessLogicException {
        ProductoEntity entity = productoLogic.getProducto(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /compra/" + id + " no existe.", 404);
        }
        return new RestauranteDetailDTO(entity.getRestaurante());
    }
}
