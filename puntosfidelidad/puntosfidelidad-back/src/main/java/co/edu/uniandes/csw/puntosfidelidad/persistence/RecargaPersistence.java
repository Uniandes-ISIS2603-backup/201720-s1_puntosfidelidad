/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
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
        LOGGER.info("recarga creada");
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

   public RecargaEntity findWithUser(String clienteusuario, Long reviewid) {
        TypedQuery<RecargaEntity> q = em.createQuery("select p from RecargaEntity p where (p.cliente.usuario = :clienteusuario) and (p.id = :reviewid)", RecargaEntity.class);
        q.setParameter("clienteusuario", clienteusuario);
        q.setParameter("reviewid", reviewid);
        return q.getSingleResult();
    }
   
    public RecargaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando recarga con id={0}", id);
        return em.find(RecargaEntity.class, id);
    } 
   /**
     * Devuelve todos los clientes de la base de datos.
     *
     * @return una lista con todas las authores que encuentre en la base de
     * datos, "select u from AuthorEntity u" es como un "select * from
     * AuthorEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<RecargaEntity> findAll() {
        LOGGER.info("Consultando todas las recargas");
        // Se crea un query para buscar todas las authores en la base de datos.
        TypedQuery query = em.createQuery("select u from RecargaEntity u", RecargaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de authores.
        return query.getResultList();
    }
}
