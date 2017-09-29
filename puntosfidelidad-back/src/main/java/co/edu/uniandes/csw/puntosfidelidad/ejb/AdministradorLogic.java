/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.AdministradorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author s.cespedes10
 */

@Stateless
public class AdministradorLogic {
    
    private static final Logger LOGGER = Logger.getLogger(AdministradorLogic.class.getName());
    
    
    @Inject
     private AdministradorPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    
    
    public AdministradorEntity createAdministrador(AdministradorEntity entity) throws BusinessLogicException {
         LOGGER.info("Inicia proceso de creación de administrador");
        if(entity.getUsuario()==null){
            throw new BusinessLogicException("El usuario no es valido: " + entity.getUsuario());
        }
        if(persistence.find(entity.getUsuario())!=null){
            throw new BusinessLogicException("El usuario" + entity.getUsuario() + "ya existe");
        } 
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("La contraseña no es valida: " + entity.getContrasena());
        }
        if(entity.getUsuario()==null){
            entity.setUsuario(entity.getUsuario());
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de cliente");
        return entity;
    }
    
    /**
     * 
     * Obtener todos los administradores existentes en la base de datos.
     *
     * @return una lista de administradores.
     */
    public List<AdministradorEntity> getAdministradores() {
        LOGGER.info("Inicia proceso de consultar todos los administradores");
        List<AdministradorEntity> administradores = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los administradores");
        return administradores;
    
    }

    public AdministradorEntity getAdministrador(String usuario) {
       LOGGER.log(Level.INFO, "Inicia proceso de consultar cliente con id={0}", usuario);
       AdministradorEntity admin= persistence.find(usuario);
       
       if(admin==null)
       LOGGER.log(Level.SEVERE, "El administrador con el id {0} no existe", usuario);
       
       
     return admin;
    }
 
    
    private boolean validateContrasena(String contrasena) {
        return !(contrasena == null || contrasena.isEmpty());
    }
    
    
    public void removeAdministrador(String usuario) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente con id={0}", usuario);
        if(persistence.find(usuario)==null) {
            throw new BusinessLogicException("El usuario no existe");
        }  
           persistence.delete(usuario);
    }
    
    
    public AdministradorEntity actualizarAdministrador(String usuario, AdministradorEntity entity  ) throws BusinessLogicException{
            
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente con id={0}", usuario);
        if (!usuario.equals(entity.getUsuario())) {
            throw new BusinessLogicException("No es posible cambiar el administrador");
        }
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("La contraseña no es valida");
        } 
        
            return persistence.update(entity);
            
    }

    
    /**
     * Obtiene una colección de instancias de Restaurantes asociadas a una
     * instancia de Administrador
     *
     * @param usuario Identificador de la instancia de administrador
     * @return Colección de instancias de RestauranteEntity asociadas a la instancia
     * de cliente
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    public List<RestauranteEntity> listRestaurantes(String usuario) {
        
        List<RestauranteEntity> lista= getAdministrador(usuario).getRestaurantes();
        if(lista.isEmpty()) throw new WebApplicationException("El Administrador que consulta aún no tiene restaurantes", 404);
        return lista;
    }
    
    /**
     * Obtiene una instancia de TarjetaDeCreditoEntity asociada a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param nit Identificador de la instancia de TarjetaDeCredito
     * @return Instancia de TarjetaDeCreditoEntity buscada 
     * 
     */
    public RestauranteEntity getRestaurante(String usuario, String nit) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un Restaurantes del cliente con usuario = {0}", usuario);
        List<RestauranteEntity> list = getAdministrador(usuario).getRestaurantes();
        RestauranteEntity entity = new RestauranteEntity();
        entity.setNit(nit);
        int index = list.indexOf(entity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Restaurante existente a un cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito      * @return Instancia de RestauaranteEntity que fue asociada a admin
     * @return Instancia de RestauranteEntity buscada 
     */
    public RestauranteEntity addRestaurantes (String usuario, String tarjetaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al cliente con id = {0}", usuario);
        AdministradorEntity administradorEntity = getAdministrador(usuario);
        RestauranteEntity tarjetaEntity = new RestauranteEntity();
        tarjetaEntity.setNit(tarjetaId);
        administradorEntity.getRestaurantes().add(tarjetaEntity);
        return getRestaurante(usuario, tarjetaId);
    }

    /**
     * Remplaza las instancias de Restaurantes asociadas a una instancia de administrador
     *
     * @param usuario Identificador de la instancia de cliente
     * @param list Colección de instancias de TarjetaDeCreditoEntity a asociar a instancia
     * de cliente
     * @return Nueva colección de TarjetaDeCreditoEntity asociada a la instancia de cliente
     * 
     */
    public List<RestauranteEntity> replaceRestaurantes (String usuario, List<RestauranteEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del cliente con id = {0}", usuario);
        AdministradorEntity clienteEntity = getAdministrador(usuario);
        clienteEntity.setRestaurantes(list);
        return clienteEntity.getRestaurantes();
    }

    /**
     * Desasocia un Restaurante existente de un administrador existente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param nit Identificador de la instancia de Restaurante      * 
     */
    public void removeRestaurantes (String usuario, String nit) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del admin con id = {0}", usuario);
        AdministradorEntity entity = getAdministrador(usuario);
        RestauranteEntity restauranteEntity = new RestauranteEntity();
        restauranteEntity.setNit(nit);
        entity.getRestaurantes().remove(restauranteEntity);
    }
    
    
}
