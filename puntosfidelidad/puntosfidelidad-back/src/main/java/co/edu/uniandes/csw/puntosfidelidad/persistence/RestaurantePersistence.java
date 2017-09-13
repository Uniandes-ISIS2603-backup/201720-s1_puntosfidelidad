/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import java.util.List;
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
    
    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;
    
    /*
    Otro commit
    */
    
    /*
    Otro add
    */
    
    public RestauranteEntity find(String usuario) {
        
        return em.find(RestauranteEntity.class, usuario);
    }
    
    public RestauranteEntity findByName(String nombre) {
        
        TypedQuery<RestauranteEntity> q
                = em.createQuery("select u from RestauranteEntity u where u.nombre = :nombre", RestauranteEntity.class);
        q = q.setParameter("nombre", nombre);
        return q.getSingleResult();
    }
    
    
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