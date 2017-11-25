/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
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
public class ProductoLogic {
    
    private ProductoPersistence persistence;
     
    private RestaurantePersistence restaurane;
    
     
    @Inject
    public ProductoLogic(ProductoPersistence injectPersistence, RestaurantePersistence injectRestaurante){
        this.persistence = injectPersistence;
        this.restaurane = injectRestaurante;
    }
     
    /*
     * CRUD
     */
    /**
     * crea el objeto de la entidad
     * @param nuevoEntity
     * @return 
     */
    public ProductoEntity createProducto(ProductoEntity nuevoEntity)
    {
        RestauranteEntity rest = restaurane.find(nuevoEntity.getRestaurante().getNit());
        rest.getProductos().add(nuevoEntity);
        return persistence.create(nuevoEntity);
    }
    /**
     * obtiene el objeto de la entidad especifico
     * @param id
     * @return 
     */
    public ProductoEntity getProducto(Long id)
    {
        return persistence.find(id);
    }
    /**
     * obtiene la lista de todos los objetos de la entidad
     * @return 
     */
    public List<ProductoEntity> getProductos()
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
    public ProductoEntity updateProducto(ProductoEntity nuevoEntity)
    {
        return persistence.update(nuevoEntity);
    }
    
    /**
     * retorna el restaurante asociado al producto con ese id
     * @param productoid
     * @return 
     */
    public RestauranteEntity getRestaurante(Long productoid)
    {
        return persistence.getRestaurante(productoid);
    }
    
    
}
