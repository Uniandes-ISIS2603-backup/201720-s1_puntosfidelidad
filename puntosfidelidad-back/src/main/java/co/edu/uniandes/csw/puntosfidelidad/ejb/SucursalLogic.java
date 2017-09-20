/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.SucursalPersistence;
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
public class SucursalLogic {
          
    private static final Logger LOGGER = Logger.getLogger(SucursalLogic.class.getName());

    @Inject
    private SucursalPersistence persistence;

    public List<SucursalEntity> getSucursals() {
        LOGGER.info("Inicia proceso de consultar todos los eventos");
        List<SucursalEntity> eventos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los eventos");
        return eventos;
    }

    public SucursalEntity getSucursal(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar evento con id={0}", id);
        SucursalEntity evento = persistence.find(id);
        if (evento == null) {
            LOGGER.log(Level.SEVERE, "El evento con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar evento con id={0}", id);
        return evento;
    }

    public SucursalEntity createSucursal(SucursalEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de evento");
        if (entity.getId()==null) {
            throw new BusinessLogicException("El id no es valido");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de evento");
        return entity;
    }

    public SucursalEntity updateSucursal(Long id, SucursalEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar evento con id={0}", id);
        if (!id.equals(entity.getId())) {
            throw new BusinessLogicException("No es posible cambiar el usuario");
        }
        SucursalEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar evento con id={0}", entity.getId());
        return newEntity;
    }

    public void deleteSucursal(Long id) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar evento con id={0}", id);
        if(persistence.find(id)==null) {
            throw new BusinessLogicException("El usuario no existe");
        }  
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar evento con id={0}", id);
    }
    
}
