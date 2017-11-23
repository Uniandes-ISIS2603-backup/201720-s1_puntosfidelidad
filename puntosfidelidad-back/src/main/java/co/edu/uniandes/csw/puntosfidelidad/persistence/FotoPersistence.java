/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.FotoEntity;
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
public class FotoPersistence {
    
    @PersistenceContext( unitName = "puntosfidelidadPU")
    private EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(ComentarioPersistence.class.getName());
    
    public FotoEntity create(FotoEntity entity)
    {
        LOGGER.info("Creando una nueva foto");
        em.persist(entity);
        LOGGER.info("Foto creada");
        return entity;
    }
    
    public FotoEntity update(FotoEntity entity)
    {
        LOGGER.log(Level.INFO, "Actualizando foto con url={0}", entity.getURL());
        return em.merge(entity);
    }
    
    public void delete(String URL)
    {
        LOGGER.log(Level.INFO, "Borrando comentario con url={0}", URL);
        FotoEntity entity = em.find(FotoEntity.class, URL);
        em.remove(entity);
        LOGGER.log(Level.INFO, "Borrado comentario con url={0}", URL);
    }
    
    public List<FotoEntity> findAll()
    {
        LOGGER.info("Consultando todos los comentarios");
        TypedQuery query = em.createQuery("Select u from FotoEntity u", FotoEntity.class);
        return query.getResultList();
    }
    
    public FotoEntity findWithURL( String uRL)
    {       
        TypedQuery<FotoEntity> q = em.createQuery("select p from FotoEntity p where (p.URL = :fotoURL)", FotoEntity.class);
        q.setParameter("fotoURL", uRL);
        return q.getSingleResult();
    }
    
}
