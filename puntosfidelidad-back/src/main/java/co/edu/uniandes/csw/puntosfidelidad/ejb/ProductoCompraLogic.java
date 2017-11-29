/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoCompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoCompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RestaurantePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author aa.yepes
 */
@Stateless
public class ProductoCompraLogic {
    
    @Inject
    private ProductoCompraPersistence persistence;
    
  
     
    /*
     * CRUD
     */
    /**
     * crea el objeto de la entidad
     * @param nuevoEntity
     * @return 
     */
    public ProductoCompraEntity createProducto(ProductoCompraEntity nuevoEntity)
    {
        return persistence.create(nuevoEntity);
    }
    /**
     * obtiene el objeto de la entidad especifico
     * @param id
     * @return 
     */
    public ProductoCompraEntity getProducto(Long id)
    {
        return persistence.find(id);
    }
    /**
     * obtiene la lista de todos los objetos de la entidad
     * @return 
     */
    public List<ProductoCompraEntity> getProductos()
    {
        return persistence.findAll();
    }
    /**
     *  borra el objeto de la entidad 
     * @param id
     * @param nuevoEntity 
     */
    public void deleteProducto(Long id)   
    {
        persistence.delete(id);
    }
    /**
     *  actualiza el objeto de la entidad 
     * @param nuevoEntity
     * @return 
     */
    public ProductoCompraEntity updateProducto(ProductoCompraEntity nuevoEntity)
    {
        return persistence.update(nuevoEntity);
    }
    
    /**
     * retorna el restaurante asociado al producto con ese id
     * @param productoid
     * @return 
     */
    public String getRestaurante(Long productoid)
    {
        return persistence.getRestaurante(productoid);
    }
    
}
