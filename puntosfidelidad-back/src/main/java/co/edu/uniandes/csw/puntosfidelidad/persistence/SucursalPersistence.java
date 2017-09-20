/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cass_
 */
@Stateless
public class SucursalPersistence {

    private static final Logger LOGGER = Logger.getLogger(SucursalPersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;

    public SucursalEntity create(SucursalEntity entity) {
        LOGGER.info("Creando una sucursal nueva");
        em.persist(entity);
        LOGGER.info("Sucursal creada");
        return entity;
    }

    public SucursalEntity update(SucursalEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando sucursal con nombre={0}", entity.getNombre());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando sucursal con id={0}", id);
        SucursalEntity entity = em.find(SucursalEntity.class, id);
        em.remove(entity);
    }

     public SucursalEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando sucursal con nombre={0}", id);
        return em.find(SucursalEntity.class, id);
    }  
     
     /**
     * Devuelve todos los sucursales de la base de datos.
     *
     * @return una lista con todas las sucursales que encuentre en la base de
     * datos, "select u from AuthorEntity u" es como un "select * from
     * AuthorEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<SucursalEntity> findAll() {
        LOGGER.info("Consultando todas las sucursales");
        // Se crea un query para buscar todas las authores en la base de datos.
        TypedQuery query = em.createQuery("select u from SucursalEntity u", SucursalEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de authores.
        return query.getResultList();
    }
    
     /**
     * Busca si hay alguna sucursal con el nombre que se envía de argumento
     * @param name: Nombre de la editorial que se está buscando
     * @return null si no existe ninguna sucursal con el nombre del argumento.
     * Si existe alguna devuelve la primera.
     */
    public SucursalEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando sucursales por nombre ", name);

        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From SucursalEntity e where e.name = :name", SucursalEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<SucursalEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
}

