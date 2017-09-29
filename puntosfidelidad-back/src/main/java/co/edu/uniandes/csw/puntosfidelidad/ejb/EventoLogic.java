/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.EventoPersistence;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;

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
    public UbicacionEntity addUbicacion (String nombre, String ubicacionDir) {
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
    public List<UbicacionEntity> replaceUbiciaciones (String nombre, List<UbicacionEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar una ubicacion del evento con nombre = {0}", nombre);
        EventoEntity eventoEntity = getEvento(nombre);
        eventoEntity.setUbicaciones(list);
        return eventoEntity.getUbicaciones();
    }

    /**
     * Desasocia un TarjetaDeCredito existente de un Evento existente
     *
     * @param usuario Identificador de la instancia de Evento
     * @param ubicacionDir Identificador de la instancia de TarjetaDeCredito      * 
     */
    public void removeUbicacion (String nombre, String ubicacionDir) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una ubicacion del evento con id = {0}", nombre);
        EventoEntity entity = getEvento(nombre);
        UbicacionEntity ubicacionEntity = new UbicacionEntity();
        ubicacionEntity.setDireccion(ubicacionDir);
        entity.getUbicaciones().remove(ubicacionEntity);
    }
    
     /**
     * Obtiene una colección de instancias d Restaurante asociadas a una
     * instancia de Evento
     *
     * @param usuario Identificador de la instancia de Evento
     * @return Colección de instancias d RestauranteEntity asociadas a la instancia
     * de Evento
     * 
     */
    public List<RestauranteEntity> listRestaurantes(String nombre) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los restaurantes del evento con nombre = {0}", nombre);
        return getEvento(nombre).getRestaurantes();
    }

    /**
     * Obtiene una instancia d RestauranteEntity asociada a una instancia de Evento
     *
     * @param usuario Identificador de la instancia de Evento
     * @para nit Identificador de la instancia de Restaurante
     * @return Instancia d RestauranteEntity buscada 
     * 
     */
    public RestauranteEntity getRestaurante(String nombre, String nit) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un restaurante del evento con nombre = {0}", nombre);
        List<RestauranteEntity> list = getEvento(nombre).getRestaurantes();
        RestauranteEntity entity = new RestauranteEntity();
        entity.setNit(nit);
        int index = list.indexOf(entity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Restaurante de Credito existente a un Evento
     * @param usuario Identificador de la instancia de Evento
     * @para nit Identificador de la instancia de Restaurante      
     * @return Instancia d RestauranteEntity que fue asociada a Evento
     * @return Instancia de RestauranteEntity buscadao
     */
    public RestauranteEntity addRestaurante (String nombre, String nit) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al evento con nombre = {0}", nombre);
        EventoEntity eventoEntity = getEvento(nombre);
        RestauranteEntity restauranteEntity = new RestauranteEntity();
        restauranteEntity.setNit(nit);
        eventoEntity.getRestaurantes().add(restauranteEntity);
        return getRestaurante(nombre, nit);
    }

    /**
     * Remplaza las instancias de Restaurante asociadas a una instancia de Evento
     * @param nombre Identificador de la instancia de Evento
     * @param list Colección de instancias d RestauranteEntity a asociar a instancia
     * de Evento
     * @return Nueva colección d RestauranteEntity asociada a la instancia de evento 
     */
    public List<RestauranteEntity> replaceRestaurantes (String nombre, List<RestauranteEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del evento con nombre = {0}", nombre);
        EventoEntity eventoEntity = getEvento(nombre);
        eventoEntity.setRestaurantes(list);
        return eventoEntity.getRestaurantes();
    }

    /**
     * Desasocia un Restaurante existente de un Evento existente
     * @param usuario Identificador de la instancia de Evento
     * @para nit Identificador de la instancia d Restaurante      * 
     */
    public void removeRestaurante (String nombre, String nit) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un restaurante del evento con nombre = {0}", nombre);
        EventoEntity entity = getEvento(nombre);
        RestauranteEntity restauranteEntity = new RestauranteEntity();
        restauranteEntity.setNit(nit);
        entity.getRestaurantes().remove(restauranteEntity);
    }
}