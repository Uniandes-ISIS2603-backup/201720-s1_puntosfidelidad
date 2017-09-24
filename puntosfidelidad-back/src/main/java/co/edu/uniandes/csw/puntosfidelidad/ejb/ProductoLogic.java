/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author aa.yepes
 */
@Stateless
public class ProductoLogic {
    
     @Inject
    private ProductoPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(ProductoLogic.class.getName());
    
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
    public ProductoEntity updateProducto(ProductoEntity nuevoEntity)
    {
        return persistence.update(nuevoEntity);
    }
}
