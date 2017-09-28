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

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto compra que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CompraEntity create(CompraEntity entity) {
        LOGGER.info("Creando un compra nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la compra en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un compra nuevo");
        return entity;
    }
    
     /**
     * Actualiza una compra.
     *
     * @param entity: la compra que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un compra con los cambios aplicados.
     */
    public CompraEntity update(CompraEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando compra con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la compra con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra una compra de la base de datos recibiendo como argumento el id
     * de la CompraEntity
     *
     * @param id: id correspondiente a la compra a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando CompraEntity con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public CompraEntity find(Long id) para obtener la CompraEntity a borrar.
        CompraEntity entity = em.find(CompraEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from CompraEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun CompraEntity con el id que se envía de argumento
     *
     * @param id: id correspondiente a la CompraEntity buscada.
     * @return un CompraEntity.
     */
    public CompraEntity find(Long id) {
       
        
        return em.find(CompraEntity.class, id);
    }

    /**
     * Devuelve todas las CompraEntity de la base de datos.
     *
     * @return una lista con todas las CompraEntity que encuentre en la base de
     * datos, "select u from CompraEntity u" es como un "select * from
     * CompraEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<CompraEntity> findAll() {
        LOGGER.info("Consultando todas las CompraEntity");
        // Se crea un query para buscar todas las CompraEntity en la base de datos.
        TypedQuery query = em.createQuery("select u from CompraEntity u", CompraEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de CompraEntity.
        return query.getResultList();
    }

    public List<ProductoEntity> gerProductos(Long id)
    {
        CompraEntity compra = em.find(CompraEntity.class, id);
        return compra.getProductos();
    }
    
    public SucursalEntity getSucursal(Long id)
    {
      CompraEntity compra = em.find(CompraEntity.class, id);
      return compra.getSucursal();
    }
    
    public TarjetaPuntosEntity getTarjetaPuntos(Long id)
    {
      CompraEntity compra = em.find(CompraEntity.class, id);  
      return compra.getTarjetaPuntos();
    }
    
    public ClienteEntity getCliente(Long id)
    {
      CompraEntity compra = em.find(CompraEntity.class, id);  
      return compra.getCliente();
    }
}