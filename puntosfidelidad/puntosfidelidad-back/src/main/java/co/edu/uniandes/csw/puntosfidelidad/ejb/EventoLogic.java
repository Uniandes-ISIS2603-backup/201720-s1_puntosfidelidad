/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.EventoPersistence;
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
public class EventoLogic {
      
    private static final Logger LOGGER = Logger.getLogger(EventoLogic.class.getName());

    @Inject
    private EventoPersistence persistence;

    public List<EventoEntity> getEventos() {
        LOGGER.info("Inicia proceso de consultar todos los eventos");
        List<EventoEntity> eventos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los eventos");
        return eventos;
    }

    public EventoEntity getEvento(String nombre) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar evento con id={0}", nombre);
        EventoEntity evento = persistence.find(nombre);
        if (evento == null) {
            LOGGER.log(Level.SEVERE, "El evento con el id {0} no existe", nombre);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar evento con id={0}", nombre);
        return evento;
    }

    public EventoEntity createEvento(EventoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de evento");
        if (entity.getNombre()==null) {
            throw new BusinessLogicException("El nombre no es valido");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de evento");
        return entity;
    }

    public EventoEntity updateEvento(String nombre, EventoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar evento con nombre={0}", nombre);
        if (!nombre.equals(entity.getNombre())) {
            throw new BusinessLogicException("No es posible cambiar el usuario");
        }
        EventoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar evento con nombre={0}", entity.getNombre());
        return newEntity;
    }

    public void deleteEvento(String nombre) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar evento con id={0}", nombre);
        if(persistence.find(nombre)==null) {
            throw new BusinessLogicException("El usuario no existe");
        }  
        persistence.delete(nombre);
        LOGGER.log(Level.INFO, "Termina proceso de borrar evento con id={0}", nombre);
    }

    /**
     * Obtiene una colección de instancias de TarjetaDeCredito asociadas a una
     * instancia de evento
     *
     * @param usuario Identificador de la instancia de evento
     * @return Colección de instancias de TarjetaDeCreditoEntity asociadas a la instancia
     * de evento
     * 
     */
    public List<UbicacionEntity> listUbicaciones(String nombre) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las ubicaciones del evento con nombre = {0}", nombre);
        return getEvento(nombre).getUbicaciones();
    }

    /**
     * Obtiene una instancia de TarjetaDeCreditoEntity asociada a una instancia de evento
     *
     * @param nombre Identificador de la instancia de evento
     * @param ubicacionDir Identificador de la instancia de Ubicacion
     * @return Instancia de Ubicacion buscada 
     * 
     */
    public UbicacionEntity getUbicacion(String nombre, String ubicaiconDir) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una Ubicacion del evento con usuario = {0}", nombre);
        List<UbicacionEntity> list = getEvento(nombre).getUbicaciones();
        UbicacionEntity entity = new UbicacionEntity();
        entity.setDireccion(ubicaiconDir);
        int index = list.indexOf(entity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia una Tarjeta de Credito existente a un evento
     *
     * @param nombre Identificador de la instancia de evento
     * @param ubicacionDir Identificador de la instancia de Ubicacion      
     * @return Instancia de UbicacionEntity que fue asociada a evento
     */
    public UbicacionEntity addTarjetaDeCredito (String nombre, String ubicacionDir) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una Ubicacion al evento con nombre = {0}", nombre);
        EventoEntity eventoEntity = getEvento(nombre);
        UbicacionEntity ubicacionEntity = new UbicacionEntity();
        ubicacionEntity.setDireccion(ubicacionDir);
        eventoEntity.getUbicaciones().add(ubicacionEntity);
        return getUbicacion(nombre, ubicacionDir);
    }

    /**
     * Remplaza las instancias de TarjetaDeCredito asociadas a una instancia de evento
     *
     * @param usuario Identificador de la instancia de evento
     * @param list Colección de instancias de TarjetaDeCreditoEntity a asociar a instancia
     * de evento
     * @return Nueva colección de TarjetaDeCreditoEntity asociada a la instancia de evento
     * 
     */
    public List<TarjetaDeCreditoEntity> replaceTarjetasDeCredito (String nombre, List<UbicacionEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar una ubicacion del evento con nombre = {0}", nombre);
        EventoEntity eventoEntity = getEvento(nombre);
        eventoEntity.setUbicaciones(list);
        return eventoEntity.getUbicaciones();
    }

    /**
     * Desasocia un TarjetaDeCredito existente de un cliente existente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito      * 
     */
    public void removeTarjetaDeCredito (String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del cliente con id = {0}", usuario);
        ClienteEntity entity = getCliente(usuario);
        TarjetaDeCreditoEntity tarjetaEntity = new TarjetaDeCreditoEntity();
        tarjetaEntity.setId(tarjetaId);
        entity.getTarjetasDeCredito().remove(tarjetaEntity);
    }
    
     /**
     * Obtiene una colección de instancias de Recarga asociadas a una
     * instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @return Colección de instancias de RecargaEntity asociadas a la instancia
     * de cliente
     * 
     */
    public List<RecargaEntity> listRecargas(String usuario) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los recargas de Credito del usuario con id = {0}", usuario);
        return getCliente(usuario).getRecargas();
    }

    /**
     * Obtiene una instancia de RecargaEntity asociada a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param recargaId Identificador de la instancia de Recarga
     * @return Instancia de RecargaEntity buscada 
     * 
     */
    public RecargaEntity getRecarga(String usuario, Long recargaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un recargas de Credito del cliente con usuario = {0}", usuario);
        List<RecargaEntity> list = getCliente(usuario).getRecargas();
        RecargaEntity entity = new RecargaEntity();
        entity.setId(recargaId);
        int index = list.indexOf(entity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia una recarga de Credito existente a un cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param recargaId Identificador de la instancia de Recarga      * @return Instancia de RecargaEntity que fue asociada a cliente
     * @return Instancia de RecargaEntity buscada 
     */
    public RecargaEntity addRecarga (String usuario, Long recargaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al cliente con id = {0}", usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        RecargaEntity recargaEntity = new RecargaEntity();
        recargaEntity.setId(recargaId);
        clienteEntity.getRecargas().add(recargaEntity);
        return getRecarga(usuario, recargaId);
    }

    /**
     * Remplaza las instancias de Recarga asociadas a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param list Colección de instancias de RecargaEntity a asociar a instancia
     * de cliente
     * @return Nueva colección de RecargaEntity asociada a la instancia de cliente
     * 
     */
    public List<RecargaEntity> replaceRecargas (String usuario, List<RecargaEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del cliente con id = {0}", usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        clienteEntity.setRecargas(list);
        return clienteEntity.getRecargas();
    }

    /**
     * Desasocia un Recarga existente de un cliente existente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param recargaId Identificador de la instancia de Recarga      * 
     */
    public void removeRecarga (String usuario, Long recargaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del cliente con id = {0}", usuario);
        ClienteEntity entity = getCliente(usuario);
        RecargaEntity recargaEntity = new RecargaEntity();
        recargaEntity.setId(recargaId);
        entity.getRecargas().remove(recargaEntity);
    }
}
