package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lv.vanegas10
 */
@Stateless
public class RecargaPersistence {
    private static final Logger LOGGER = Logger.getLogger(RecargaPersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;

    public RecargaEntity create(RecargaEntity entity) {
        LOGGER.info("Creando una recarga nueva");
        em.persist(entity);
        LOGGER.info("Recarga creada");
        return entity;
    }

    public RecargaEntity update(RecargaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando recarga con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando recarga con id={0}", id);
        RecargaEntity entity = em.find(RecargaEntity.class, id);
        em.remove(entity);
    }

   public RecargaEntity findWithUser(String usuarioCliente, Long reviewid) {
        TypedQuery<RecargaEntity> q = em.createQuery("select p from RecargaEntity p where (p.cliente.usuario = :clienteusuario) and (p.id = :reviewid)", RecargaEntity.class);
        q.setParameter("clienteusuario", usuarioCliente);
        q.setParameter("reviewid", reviewid);
        return q.getSingleResult();
    }
   
    public RecargaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando recarga con id={0}", id);
        return em.find(RecargaEntity.class, id);
    } 
   /**
     * Devuelve todos las recargas de la base de datos. 
     * @return una lista con todas las recargas
     */
    public List<RecargaEntity> findAll() {
        LOGGER.info("Consultando todas las recargas");        
        TypedQuery query = em.createQuery("select u from RecargaEntity u", RecargaEntity.class);
        return query.getResultList();
    }
}
