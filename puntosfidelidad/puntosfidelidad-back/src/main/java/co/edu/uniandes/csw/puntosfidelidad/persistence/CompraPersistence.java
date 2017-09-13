/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import co.edu.uniandes.csw.puntosfidelidad.entities.*;
/**
 *
 * @author aa.yepes
 */
@Stateless
public class CompraPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CompraPersistence.class.getName());

    @PersistenceContext(unitName = "bodegaPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto compra que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CompraEntity create(CompraEntity entity) {
        LOGGER.info("Creando un bodega nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la bodega en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un bodega nuevo");
        return entity;
    }
    
     /**
     * Actualiza una compra.
     *
     * @param entity: la compra que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un bodega con los cambios aplicados.
     */
    public CompraEntity update(CompraEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando bodega con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la bodega con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra una compra de la base de datos recibiendo como argumento el id
     * de la bodega
     *
     * @param id: id correspondiente a la compra a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando bodega con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public bodegaEntity find(Long id) para obtener la bodega a borrar.
        CompraEntity entity = em.find(CompraEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from bodegaEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun bodega con el id que se envía de argumento
     *
     * @param id: id correspondiente a la bodega buscada.
     * @return un bodega.
     */
    public CompraEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando bodega con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from bodegaEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(CompraEntity.class, id);
    }

    /**
     * Devuelve todas las bodegaes de la base de datos.
     *
     * @return una lista con todas las bodegas que encuentre en la base de
     * datos, "select u from bodegaEntity u" es como un "select * from
     * bodegaEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<CompraEntity> findAll() {
        LOGGER.info("Consultando todas las bodegas");
        // Se crea un query para buscar todas las bodegas en la base de datos.
        TypedQuery query = em.createQuery("select u from BodegaEntity u", CompraEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de bodegaes.
        return query.getResultList();
    }
}
