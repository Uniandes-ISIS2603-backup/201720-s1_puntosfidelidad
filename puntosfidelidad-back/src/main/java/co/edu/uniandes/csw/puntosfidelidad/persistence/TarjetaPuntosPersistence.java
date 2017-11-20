package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
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
        TypedQuery<TarjetaPuntosEntity> q = em.createQuery("select p from TarjetaPuntosEntity p where (p.id = :queryId)", TarjetaPuntosEntity.class);
        q.setParameter("queryId", id);
        try {
            return q.getSingleResult();
        } catch (Exception e) {
            //hay excepción cuando el dignle result no encuentra nada
            return null;
        }
    }

    /**
     * Devuelve todos las recargas de la base de datos.
     *
     * @return una lista con todas las tarjetas de puntos
     */
    public List<TarjetaPuntosEntity> findAll() {
        LOGGER.info("Consultando todas las recargas");
        TypedQuery<TarjetaPuntosEntity> query = em.createQuery("select u from TarjetaPuntosEntity u", TarjetaPuntosEntity.class);
        return query.getResultList();
    }

    public List<CompraEntity> getCompras(Long id) {
        TarjetaPuntosEntity entity = findWithId(id);
        return entity.getCompras();
    }
}
