/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author aa.yepes
 */
@Stateless
public class CompraLogic {
    
    
    @Inject
    private CompraPersistence persistence;
    
    @Inject
    private ProductoLogic prodLogic;
    
    /*
     * CRUD
     */
    /**
     * crea el objeto de la entidad
     * @param nuevoEntity
     * @return 
     */
    public CompraEntity createCompra(CompraEntity nuevoEntity)
    {
        return persistence.create(nuevoEntity);
    }
    /**
     * obtiene el objeto de la entidad especifico
     * @param id
     * @return 
     */
    public CompraEntity getCompra(Long id)
    {
        return persistence.find(id);
    }
    /**
     * obtiene la lista de todos los objetos de la entidad
     * @return 
     */
    public List<CompraEntity> getCompras()
    {
        return persistence.findAll();
    }
    /**
     *  borra el objeto de la entidad 
     * @param nuevoEntity
     * @return 
     */
    public void deleteCompra(Long id)   
    {
        persistence.delete(id);
    }
    /**
     *  actualiza el objeto de la entidad 
     * @param nuevoEntity
     * @return 
     */
    public CompraEntity updateCompra(CompraEntity nuevoEntity)
    {
        return persistence.update(nuevoEntity);
    }
    
      
    /**
     * Obtiene una colección de instancias de ProductoEntity asociadas a una
     * instancia de Compra
     *
     * @param compraId
     * @return Colección de instancias de ProductoEntity asociadas a la instancia de
     * Compra
     * @generated
     */
    public List<ProductoEntity> listProductos(Long compraId) {
        
        return getCompra(compraId).getProductos();
    }
    
    /**
     * Obtiene una instancia de ProductoEntity asociada a una instancia de Compra
     *
     * @param compraId Identificador de la instancia de Compra
     * @param productoId Identificador de la instancia de Producto
     * @return
     * @generated
     */
    public ProductoEntity getProducto(Long compraId, Long productoId) {
        List<ProductoEntity> list = getCompra(compraId).getProductos();
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(productoId);
        for(ProductoEntity producto : list)
        {
            if (producto.getId() == productoEntity.getId())
            {
                return producto;
            }
        }
        return null;
    }
    
    /**
     * Asocia un Producto existente a un Compra
     *
     * @param compraId Identificador de la instancia de Compra
     * @param productoId Identificador de la instancia de Producto
     * @return Instancia de ProductoEntity que fue asociada a COmpra
     * @generated
     */
    public ProductoEntity addProducto(Long compraId, Long productoId) {
        ProductoEntity prod = prodLogic.getProducto(productoId);
        
        if (prod != null)
        {
            getCompra(compraId).getProductos().add(prod);
        }
        
        return prod;
    }
    
    
    /**
     * Desasocia un Producto existente a un Compra existente
     *
     * @param compraId Identificador de la instancia de Compra
     * @param productoId Identificador de la instancia de Producto
     * @generated
     */
    public void removeProducto(Long compraId, Long productoId) {
       
        ProductoEntity prod = prodLogic.getProducto(productoId);
        
        if (prod != null)
        {           
            int index = getCompra(compraId).getProductos().indexOf(prod);    
            if (index >= 0)
            {
                getCompra(compraId).getProductos().remove(index); 
            }
             
        }
    }
    
    /**
     * retorna el restaurante asociado al producto con ese id
     * @param compraid
     * @return 
     */
    public SucursalEntity getSucursal(Long compraid)
    {
        return persistence.getSucursal(compraid);
    }
    
    /**
     * retorna el restaurante asociado al producto con ese id
     * @param compraid
     * @return 
     */
    public ClienteEntity getCliente(Long compraid)
    {
        return persistence.getCliente(compraid);
    }
    
    /**
     * retorna el restaurante asociado al producto con ese id
     * @param compraid
     * @return 
     */
    public TarjetaPuntosEntity getTarjetaPuntos(Long compraid)
    {
        return persistence.getTarjetaPuntos(compraid);
    }
}
