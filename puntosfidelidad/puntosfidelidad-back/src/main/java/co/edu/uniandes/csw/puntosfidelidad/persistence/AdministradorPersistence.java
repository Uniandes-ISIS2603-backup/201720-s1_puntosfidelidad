/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import java.util.List;
import java.util.logging.Level;
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
public class AdministradorPersistence {
    
    @PersistenceContext(unitName = "puntosfidelidadPU")
    protected EntityManager em;
    
    
    public AdministradorEntity find(String usuario) {
        
        return em.find(AdministradorEntity.class, usuario);
    }
    
    public AdministradorEntity findByName(String usuario) {
        
        TypedQuery<AdministradorEntity> q
                = em.createQuery("select u from AdministradorEntity u where u.usuario = :usuario", AdministradorEntity.class);
        q = q.setParameter("usuario", usuario);
        return q.getSingleResult();
    }
    
    
    public List<AdministradorEntity> findAll() {
        
        Query q = em.createQuery("select u from AdministradorEntity u");
        return q.getResultList();
    }

    public AdministradorEntity create(AdministradorEntity entity) {
        
        em.persist(entity);
        return entity;
    }

    public AdministradorEntity update(AdministradorEntity entity) {
        
        return em.merge(entity);
    }

    public void delete(Long id) {
       
        AdministradorEntity entity = em.find(AdministradorEntity.class, id);
        em.remove(entity);
    }
    
    
}
