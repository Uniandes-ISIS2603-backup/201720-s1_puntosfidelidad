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
        LOGGER.info("Creando una tarjeta de crédito nueva");
        em.persist(entity);
        LOGGER.info("Tarjeta de crédito creada");
        return entity;
    }

    public TarjetaDeCreditoEntity update(TarjetaDeCreditoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando tarjeta de crédito con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando tarjeta de crédito con id={0}", id);
        TarjetaDeCreditoEntity entity = em.find(TarjetaDeCreditoEntity.class, id);
        em.remove(entity);
    }

     public TarjetaDeCreditoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando tarjeta de crédito con id={0}", id);
        return em.find(TarjetaDeCreditoEntity.class, id);
    }
     
     /**
     * Busca si hay alguna tarjeta con el número que se envía de argumento
     *
     * @param numero: Nombre de la tarjeta de crédito que se está buscando
     * @return null si no existe ninguna tarjeta de crédito con el nombre del argumento.
     * Si existe alguna devuelve la primera.
     */
    public TarjetaDeCreditoEntity findByNumber(Long numero) {
        LOGGER.log(Level.INFO, "Consultando tarjeta de crédito por numero ", numero);

        TypedQuery query = em.createQuery("Select e From TarjetaDeCreditoEntity e where e.numero = :numero", TarjetaDeCreditoEntity.class);
        query = query.setParameter("numero", numero);
        List<TarjetaDeCreditoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }  
    
}
