/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
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
 * @author ja.manrique
 */
@Stateless
public class ComentarioPersistence {
    
    @PersistenceContext( unitName= "puntosfidelidadPU")
    private EntityManager em;
    
    private Logger LOGGER = Logger.getLogger(ComentarioPersistence.class.getName());
    
    public ComentarioEntity create(ComentarioEntity entity) {
        LOGGER.info("Creando un nuevo comentario");
        em.persist(entity);
        LOGGER.info("Comentario creado");
        return entity;
    }

    public ComentarioEntity update(ComentarioEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando comentario con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando comentario con id={0}", id);
        ComentarioEntity entity = em.find(ComentarioEntity.class, id);
        em.remove(entity);
        LOGGER.log(Level.INFO, "Borrado comentario con id={0}", id);
    }
    
    public ComentarioEntity findWithId(Long id) {
        LOGGER.log(Level.INFO, "Consultando comentario con id={0}", id);
        TypedQuery<ComentarioEntity> q = em.createQuery("select p from ComentarioEntity p where (p.id = :comentarioId)", ComentarioEntity.class);
        q.setParameter("comentarioId", id);
        return q.getSingleResult();
    }
    
    /**
     * Devuelve todos los comnetarios de la base de datos. 
     * @return una lista con todas las tarjetas de puntos
     */
    public List<ComentarioEntity> findAll() {
        LOGGER.info("Consultando todos los comentarios");        
        TypedQuery query = em.createQuery("select u from ComentarioEntity u", ComentarioEntity.class);
        return query.getResultList();
    }
    
    public ClienteEntity getCliente(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando cliente del comentario con id={0}", id);
        return findWithId(id).getCliente();
    }
            
    public SucursalEntity getSucursal(Long id)
    {
        LOGGER.log(Level.INFO, "Consultando sucursal del comentario con id={0}", id);
        return findWithId(id).getSucursal();
    }
}
