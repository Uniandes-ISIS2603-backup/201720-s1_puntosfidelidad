/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import java.util.List;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author ja.manrique
 */
@Stateless
public class TarjetaPuntosPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(TarjetaPuntosPersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;
    
    public TarjetaPuntosEntity create(TarjetaPuntosEntity entity) {
        LOGGER.info("Creando una nueva tarjeta de puntos");
        em.persist(entity);
        LOGGER.info("Recarga creada");
        return entity;
    }

    public TarjetaPuntosEntity update(TarjetaPuntosEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando tarjeta de puntos con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando tarjeta de puntos con id={0}", id);
        TarjetaPuntosEntity entity = em.find(TarjetaPuntosEntity.class, id);
        em.remove(entity);
    }
    
    public TarjetaPuntosEntity findWithId(Long id) {
        TypedQuery<TarjetaPuntosEntity> q = em.createQuery("select p from TarjetaPuntosEntity p where (p.id = :clienteusuario) and (p.id = :reviewid)", TarjetaPuntosEntity.class);
        q.setParameter("queryId", id);
        return q.getSingleResult();
    }
    
    /**
     * Devuelve todos las recargas de la base de datos. 
     * @return una lista con todas las tarjetas de puntos
     */
    public List<TarjetaPuntosEntity> findAll() {
        LOGGER.info("Consultando todas las recargas");        
        TypedQuery query = em.createQuery("select u from TarejetaPuntosEntity u", TarjetaPuntosEntity.class);
        return query.getResultList();
    }
}
