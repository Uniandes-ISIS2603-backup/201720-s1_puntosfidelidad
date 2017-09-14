/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RestaurantePersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.cespedes10
 */

@Stateless
public class RestauranteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(RestauranteLogic.class.getName());
    
    @Inject
     private RestaurantePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    
    
    public RestauranteEntity createRestaurante(RestauranteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de restaurante");
        // Verifica la regla de negocio que dice que no puede haber dos restaurantes con el mismo NIT
        if (persistence.findByName(entity.getNit()) != null) {
            throw new BusinessLogicException("Ya existe un restaurante con ese NIT \"" + entity.getNit()+ "\"");
        }
        // Invoca la persistencia para crear la bodega
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Restaurante");
        return entity;
    }
    /**
     * 
     * Obtener todos los restaurantes existentes en la base de datos.
     *
     * @return una lista de restaurantes.
     */
    public List<RestauranteEntity> getRestaurantes() {
        LOGGER.info("Inicia proceso de consultar todos los restaurantes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<RestauranteEntity> restaurantes = persistence.findAll();
        
        return restaurantes;
    
    }

    public RestauranteEntity getRestaurante(String usuario) {
       
      return  persistence.find(usuario);
        
    }
    
    public void removeRestaurante(String nit){
        
         persistence.delete(nit);
    }
    
    
    
    public RestauranteEntity actualizarRestaurante(String nit, RestauranteEntity entity  ){
            
            return persistence.update(entity);
            
    }

    
}
