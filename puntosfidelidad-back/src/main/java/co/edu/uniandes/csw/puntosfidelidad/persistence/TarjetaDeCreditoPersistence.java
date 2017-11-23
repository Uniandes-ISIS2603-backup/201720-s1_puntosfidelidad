package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
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
public class TarjetaDeCreditoPersistence {
    private static final Logger LOGGER = Logger.getLogger(TarjetaDeCreditoPersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;

    public TarjetaDeCreditoEntity create(TarjetaDeCreditoEntity entity) {
        LOGGER.info("Creando un tarjeta nuevo");
        em.persist(entity);
        LOGGER.info("Review creado");
        return entity;
    }

    public TarjetaDeCreditoEntity update(TarjetaDeCreditoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando tarjeta con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando tarjeta con id={0}", id);
        TarjetaDeCreditoEntity entity = em.find(TarjetaDeCreditoEntity.class, id);
        em.remove(entity);
    }

    public TarjetaDeCreditoEntity find(String usuario, Long tarjetaid) {
        TypedQuery<TarjetaDeCreditoEntity> q = em.createQuery("select p from TarjetaDeCreditoEntity p where (p.cliente.usuario = :usuario) and (p.id = :tarjetaid)", TarjetaDeCreditoEntity.class);
        q.setParameter("usuario", usuario);
        q.setParameter("tarjetaid", tarjetaid);
        List<TarjetaDeCreditoEntity> results = q.getResultList();
        TarjetaDeCreditoEntity tarjeta = null;
        if (results == null) {
            tarjeta = null;
        } else if (results.isEmpty()) {
            tarjeta = null;
        } else {
            tarjeta = results.get(0);
        }
        return tarjeta;
    }
}
