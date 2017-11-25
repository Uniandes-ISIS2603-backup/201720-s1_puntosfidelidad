/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.UbicacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cass_
 */
@Stateless
public class UbicacionLogic {
          
    private static final Logger LOGGER = Logger.getLogger(UbicacionLogic.class.getName());

    private UbicacionPersistence persistence;
    
    @Inject
    public UbicacionLogic(UbicacionPersistence injectPersistence){
        this.persistence = injectPersistence;
    }

    public List<UbicacionEntity> getUbicacions() {
        LOGGER.info("Inicia proceso de consultar todos los Ubicacions");
        List<UbicacionEntity> ubicacions = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Ubicacions");
        return ubicacions;
    }

    public UbicacionEntity getUbicacion(String dir) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Ubicacion con direccion={0}", dir);
        UbicacionEntity ubicacion = persistence.find(dir);
        if (ubicacion == null) {
            LOGGER.log(Level.SEVERE, "El Ubicacion con el direccion {0} no existe", dir);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Ubicacion con direccion={0}", dir);
        return ubicacion;
    }

    public UbicacionEntity createUbicacion(UbicacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Ubicacion");
        if (entity.getDireccion()==null) {
            throw new BusinessLogicException("El dir no es valido");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Ubicacion");
        return entity;
    }

    public UbicacionEntity updateUbicacion(String dir, UbicacionEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Ubicacion con dir={0}", dir);
        if (!dir.equals(entity.getDireccion())) {
            throw new BusinessLogicException("No es posible cambiar el usuario");
        }
        UbicacionEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Ubicacion con dir={0}", entity.getDireccion());
        return newEntity;
    }

    public void deleteUbicacion(String dir) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Ubicacion con direccion={0}", dir);
        if(persistence.find(dir)==null) {
            throw new BusinessLogicException("El usuario no existe");
        }  
        persistence.delete(dir);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Ubicacion con direccion={0}", dir);
    }

    
}
