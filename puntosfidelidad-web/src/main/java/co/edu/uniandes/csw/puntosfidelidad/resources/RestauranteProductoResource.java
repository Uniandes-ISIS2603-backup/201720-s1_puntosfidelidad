/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ProductoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
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
public class RestauranteProductoResource {
    @Inject
    private RestauranteLogic restauranteLogic;

    /**
     * Convierte una lista de productosEntity a una lista de productosDetailDTO.
     *
     * @param entityList Lista de productosEntity a convertir.
     * @return Lista de productosDetailDTO convertida.
     * 
     */
    private List<ProductoDetailDTO> productosListEntity2DTO(List<ProductoEntity> entityList) {
        List<ProductoDetailDTO> list = new ArrayList<>();
        for (ProductoEntity entity : entityList) {
            list.add(new ProductoDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ProductoDetailDTO a una lista de ProductoEntity.
     *
     * @param dtos Lista de ProductoDetailDTO a convertir.
     * @return Lista de ProductoEntity convertida.
     * 
     */
    private List<ProductoEntity> productosListDTO2Entity(List<ProductoDetailDTO> dtos) {
        List<ProductoEntity> list = new ArrayList<>();
        for (ProductoDetailDTO dto : dtos) {
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
    public List<ProductoDetailDTO> listProductos(@PathParam("usuario") String usuario) throws BusinessLogicException {
       return productosListEntity2DTO(restauranteLogic.listProductos(usuario));
    }

    /**
     * Obtiene una instancia de Sucursal asociada a una instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param productosId Identificador de la instancia de Sucursal
     * @return 
     * 
     */
    @GET
    @Path("{productosId: \\d+}")
    public ProductoDetailDTO getProductos(@PathParam("usuario") String usuario, @PathParam("productosId") Long productosId) {
        return new ProductoDetailDTO(restauranteLogic.getProducto(usuario, productosId));
    }

    /**
     * Asocia un Producto existente a un Admistrador
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param productosId
     * @return Instancia de ProductoDetailDTO que fue asociada a Cliente
     * 
     */
    @POST
    @Path("{productosId: \\d+}")
    public ProductoDetailDTO addProductos(@PathParam("usuario") String usuario, @PathParam("sucursalesId") Long productosId) {
        return new ProductoDetailDTO(restauranteLogic.addProducto(usuario, productosId));
    }

    
    /**
     * Remplaza las instancias de Producto asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param productos Colección de instancias de SucursalDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de SucursalDTO asociada a la instancia de Cliente
     * 
     */
    @PUT
    public List<ProductoDetailDTO> replaceProducto(@PathParam("usuario") String usuario, List<ProductoDetailDTO> productos) {
        return productosListEntity2DTO(restauranteLogic.replaceProductos(usuario, productosListDTO2Entity(productos)));
    }

    /**
     * Desasocia un Sucursal existente de un Restaurante existente
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @param productoId Identificador de la instancia de Sucursal
     * 
     */
    @DELETE
    @Path("{productoId: \\d+}")
    public void removeProducto(@PathParam("usuario") String usuario, @PathParam("productoId") Long productoId) {
        restauranteLogic.removeSucursales(usuario, productoId);
    }
}
