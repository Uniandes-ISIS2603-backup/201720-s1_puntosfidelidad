/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
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
public class EventoPersistence {
   
    private static final Logger LOGGER = Logger.getLogger(EventoPersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;

    public EventoEntity create(EventoEntity entity) {
        LOGGER.info("Creando un evento nuevo");
        em.persist(entity);
        LOGGER.info("Evento creado");
        return entity;
    }

    public EventoEntity update(EventoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando evento con nombre={0}", entity.getNombre());
        return em.merge(entity);
    }

    public void delete(String nombre) {
        LOGGER.log(Level.INFO, "Borrando evento con nombre={0}", nombre);
        EventoEntity entity = em.find(EventoEntity.class, nombre);
        em.remove(entity);
    }

     public EventoEntity find(String nombre) {
        LOGGER.log(Level.INFO, "Consultando evento con nombre={0}", nombre);
        return em.find(EventoEntity.class, nombre);
    }  
     
     /**
     * Devuelve todos los eventos de la base de datos.
     *
     * @return una lista con todos los eventos que encuentre en la base de
     * datos, "select u from AuthorEntity u" es como un "select * from
     * AuthorEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<EventoEntity> findAll() {
        LOGGER.info("Consultando todas los eventos");
        // Se crea un query para buscar todas las authores en la base de datos.
        TypedQuery query = em.createQuery("select u from EventoEntity u", EventoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de authores.
        return query.getResultList();
    }
    
     /**
     * Busca si hay algun evento con el nombre que se envía de argumento
     * @param name: Nombre de la editorial que se está buscando
     * @return null si no existe ninguna evento con el nombre del argumento.
     * Si existe alguna devuelve la primera.
     */
    public EventoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando evento por nombre ", name);

        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From EventoEntity e where e.name = :name", EventoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<EventoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
}
