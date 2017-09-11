/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
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
public class ClientePersistence {
    private static final Logger LOGGER = Logger.getLogger(ClientePersistence.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;

    public ClienteEntity create(ClienteEntity entity) {
        LOGGER.info("Creando un cliente nuevo");
        em.persist(entity);
        LOGGER.info("Cliente creado");
        return entity;
    }

    public ClienteEntity update(ClienteEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando cliente con usuario={0}", entity.getUsuario());
        return em.merge(entity);
    }

    public void delete(String usuario) {
        LOGGER.log(Level.INFO, "Borrando cliente con usuario={0}", usuario);
        ClienteEntity entity = em.find(ClienteEntity.class, usuario);
        em.remove(entity);
    }

     public ClienteEntity find(String usuario) {
        LOGGER.log(Level.INFO, "Consultando cliente con usuario={0}", usuario);
        return em.find(ClienteEntity.class, usuario);
    }  
     
     /**
     * Devuelve todos los clientes de la base de datos.
     *
     * @return una lista con todas las authores que encuentre en la base de
     * datos, "select u from AuthorEntity u" es como un "select * from
     * AuthorEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<ClienteEntity> findAll() {
        LOGGER.info("Consultando todos los clientes");
        // Se crea un query para buscar todas las authores en la base de datos.
        TypedQuery query = em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de authores.
        return query.getResultList();
    }
    
     /**
     * Busca si hay algun cliente con el nombre que se envía de argumento
     *
     * @param name: Nombre del cliente que se está buscando
     * @return null si no existe ninguna editorial con el nombre del argumento.
     * Si existe alguna devuelve la primera.
     */
    public ClienteEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando cliente por nombre ", name);

        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ClienteEntity e where e.name = :name", ClienteEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<ClienteEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
}
