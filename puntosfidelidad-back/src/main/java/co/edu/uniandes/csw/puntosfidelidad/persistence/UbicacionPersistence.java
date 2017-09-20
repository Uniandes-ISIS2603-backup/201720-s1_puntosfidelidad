/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
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
public class UbicacionPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(UbicacionPersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;

    public UbicacionEntity create(UbicacionEntity entity) {
        LOGGER.info("Creando una ubicaciom nueva");
        em.persist(entity);
        LOGGER.info("Ubicacion creada");
        return entity;
    }

    public UbicacionEntity update(UbicacionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando ubicaion con direccion={0}", entity.getDireccion());
        return em.merge(entity);
    }

    public void delete(String direccion) {
        LOGGER.log(Level.INFO, "Borrando ubicacion con direccion={0}", direccion);
        UbicacionEntity entity = em.find(UbicacionEntity.class, direccion);
        em.remove(entity);
    }

     public UbicacionEntity find(String direccion) {
        LOGGER.log(Level.INFO, "Consultando ubicacion con nombre={0}", direccion);
        return em.find(UbicacionEntity.class, direccion);
    }  
     
     /**
     * Devuelve todos las ubicaciones de la base de datos.
     *
     * @return una lista con todas las ubicaciones que encuentre en la base de
     * datos, "select u from AuthorEntity u" es como un "select * from
     * AuthorEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<UbicacionEntity> findAll() {
        LOGGER.info("Consultando todas las ubicaciones");
        // Se crea un query para buscar todas las authores en la base de datos.
        TypedQuery query = em.createQuery("select u from UbicacionEntity u", UbicacionEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de authores.
        return query.getResultList();
    }
    
     /**
     * Busca si hay alguna ubicacion con el nombre que se envía de argumento
     * @param name: Nombre de la editorial que se está buscando
     * @return null si no existe ninguna ubicacion con el nombre del argumento.
     * Si existe alguna devuelve la primera.
     */
    public UbicacionEntity findByAddress(String direccion) {
        LOGGER.log(Level.INFO, "Consultando ubicaciones por direccion ", direccion);

        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From UbicacionEntity e where e.direccion = :direccion", UbicacionEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("direccion", direccion);
        // Se invoca el query se obtiene la lista resultado
        List<UbicacionEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

}
