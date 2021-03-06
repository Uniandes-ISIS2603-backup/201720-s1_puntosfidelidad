/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author s.cespedes10
 */
@Stateless
public class RestaurantePersistence {
    private static final Logger LOGGER = Logger.getLogger(RestauranteEntity.class.getName());

    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;
    
   
    
      /**
     * Busca si hay algun Restaurante con el usuario que se envía de argumento
     *
     * @param nit: Nombre del restaurante que se está buscando
     * @return null si no existe ningun cliente con el nombre del argumento.
     * Si existe alguno devuelve la primera.
     */
    public RestauranteEntity find(String nit) {
        
        return em.find(RestauranteEntity.class, nit);
    }
    
     /**
     * Busca si hay algun Restaurante con el nombre que se envía de argumento
     *
     * @param nombre: Nombre del restaurante que se está buscando
     * @return null si no existe ningun cliente con el nombre del argumento.
     * Si existe alguno devuelve la primera.
     */
    public RestauranteEntity findByName(String nombre) {
        
        TypedQuery<RestauranteEntity> q
                = em.createQuery("select u from RestauranteEntity u where u.nombre = :nombre", RestauranteEntity.class);
        q = q.setParameter("nombre", nombre);
        RestauranteEntity restaurante;
        try{
            restaurante= q.getSingleResult();}
        catch(Exception e)
        {
            //no encontró restaurante
            restaurante= null;
            LOGGER.log(Level.INFO, "{0}", e);
        }
        return restaurante;
    }
    
    
    /**
     * Devuelve todos los restaurantes de la base de datos.
     *
     * @return una lista con todas las authores que encuentre en la base de
     * datos, "select u from AuthorEntity u" es como un "select * from
     * AuthorEntity;" - "SELECT * FROM table_name" en SQL.
     */
    
    public List<RestauranteEntity> findAll() {
        
        Query q = em.createQuery("select u from RestauranteEntity u");
        return q.getResultList();
    }

    public RestauranteEntity create(RestauranteEntity entity) {
        
        em.persist(entity);
        return entity;
    }

    public RestauranteEntity update(RestauranteEntity entity) {
        
        return em.merge(entity);
    }

    public void delete(String nit) {
       
        RestauranteEntity entity = em.find(RestauranteEntity.class, nit);
        em.remove(entity);
    }
    
}