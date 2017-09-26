/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.AdministradorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

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
        LOGGER.info("Inicia proceso de creación de Administrador");
        // Verifica la regla de negocio que dice que no puede haber dos bodegas con la misma dirección
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("Ya existe un Administrador con ese usuario o la contraseña no es valida \"" + entity.getUsuario()+ "\"");
        }
        // Invoca la persistencia para crear la bodega
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Administrador");
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

    
}
