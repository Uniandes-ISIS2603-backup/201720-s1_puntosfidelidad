/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ComentarioPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import java.util.List;
import java.util.logging.Logger;
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
    
    private static final Logger LOGGER = Logger.getLogger(CompraLogic.class.getName());
    
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
    public CompraEntity updateComentario(CompraEntity nuevoEntity)
    {
        return persistence.update(nuevoEntity);
    }
}
