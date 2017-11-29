/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ProductoCompraDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.ProductoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.CompraLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoCompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author aa.yepes
 */
@Produces("application/json")
@Consumes("application/json")
public class CompraProductosResource {
    
     @Inject private CompraLogic compraLogic;
    

    /**
     * Convierte una lista de Producto a una lista de ProductoDetailDTO.
     *
     * @param entityList Lista de BookEntity a convertir.
     * @return Lista de BookDetailDTO convertida.
     * 
     */
    private List<ProductoCompraDTO> booksListEntity2DTO(List<ProductoCompraEntity> entityList){
        List<ProductoCompraDTO> list = new ArrayList<>();
        for (ProductoCompraEntity entity : entityList) {
            list.add(new ProductoCompraDTO(entity));
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ProductoDetailDTO asociadas a una
     * instancia de Compra
     *
     * @param compraId Identificador de la instancia de compra
     * @return Colección de instancias de ProductoDetailDTO asociadas a la instancia de compra
     * 
     */
    @GET
    public List<ProductoCompraDTO> listProductos(@PathParam("compraId") Long compraId) {
        return booksListEntity2DTO(compraLogic.listProductos(compraId));
    }

    /**
     * Obtiene una instancia de producto asociada a una instancia de compra
     *
     * @param compraId Identificador de la instancia de Author
     * @param productoId Identificador de la instancia de Book
     * 
     */
    @GET
    @Path("{productoId: \\d+}")
    public ProductoCompraDTO getProducto(@PathParam("compraId") Long compraId, @PathParam("productoId") Long productoId) {
        return new ProductoCompraDTO(compraLogic.getProducto(compraId, productoId));
    }

    /**
     * Asocia un producto existente a un compra
     *
     * @param compraId Identificador de la instancia de Author
     * @param productoId Identificador de la instancia de Book
     * @return Instancia de BookDetailDTO que fue asociada a Author
     * 
     */
    @POST
    @Path("{productoId: \\d+}")
    public ProductoDetailDTO addProductos(@PathParam("compraId") Long compraId, @PathParam("productoId") Long productoId) {
        return new ProductoDetailDTO(compraLogic.addProducto(compraId, productoId));
    }


    /**
     * Desasocia un Book existente de un Author existente
     *
     * @param compraId Identificador de la instancia de Author
     * @param productoId Identificador de la instancia de Book
     * 
     */
    @DELETE
    @Path("{productoId: \\d+}")
    public void removeProducto(@PathParam("compraId") Long compraId, @PathParam("productoId") Long productoId) {
        compraLogic.removeProducto(compraId, productoId);
    }
}
