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
        LOGGER.info("Creando un recarga nuevo");
        em.persist(entity);
        LOGGER.info("Review creado");
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

    public RecargaEntity find(String usuario, Long recargaid) {
        TypedQuery<RecargaEntity> q = em.createQuery("select p from RecargaEntity p where (p.cliente.usuario = :usuario) and (p.id = :recargaid)", RecargaEntity.class);
        q.setParameter("usuario", usuario);
        q.setParameter("recargaid", recargaid);
        List<RecargaEntity> results = q.getResultList();
        RecargaEntity recarga;
        if (results == null || results.isEmpty()) {
            recarga = null;        
        } else {
            recarga = results.get(0);
        }
        return recarga;
    }
}
