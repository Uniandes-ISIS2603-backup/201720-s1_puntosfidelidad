/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
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
            throw new BusinessLogicException("No es posible cambiar el id");
        }
        SucursalEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar evento con id={0}", entity.getId());
        return newEntity;
    }

    public void deleteSucursal(Long id) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar evento con id={0}", id);
        if(persistence.find(id)==null) {
            throw new BusinessLogicException("El id no existe");
        }  
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar evento con id={0}", id);
    }
    
         /**
     * Obtiene una colección de instancias de CompraEntity asociadas a una
     * instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @return Colección de instancias de SucursalEntity asociadas a la instancia
     * de Compra
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    public List<CompraEntity> listCompras(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las compras de la sucursal con id = {0}", id);
        List<CompraEntity> lista= getSucursal(id).getCompras();
        if(lista.isEmpty()) throw new BusinessLogicException("La Sucursal que consulta aún no tiene compras");
        return lista;
    }

    /**
     * Obtiene una instancia de CompraEntity asociada a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param compraId Identificador de la instancia de Compra
     * @return      * 
     */
    public CompraEntity getCompra(Long id, Long compraId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una compra de la sucursal con id = {0}", id);
        List<CompraEntity> list = getSucursal(id).getCompras();
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setId(compraId);
        int index = list.indexOf(compraEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia una Compra existente a una Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param compraId Identificador de la instancia de Compra
     * @return Instancia de CompraEntity que fue asociada a Sucursal
     * 
     */
    public CompraEntity addCompra(Long id, Long compraId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una compra a la sucursal con id = {0}", id);
        SucursalEntity sucursalEntity = getSucursal(id);
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setId(compraId);
        sucursalEntity.getCompras().add(compraEntity);
        return getCompra(id, compraId);
    }

     /**
     * Remplaza las instancias de Compra asociadas a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param list Colección de instancias de CompraEntity a asociar a instancia
     * de Sucursal
     * @return Nueva colección de CompraEntity asociada a la instancia de Sucursal
     * 
     */
    public List<CompraEntity> replaceCompras(Long id, List<CompraEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del libro con id = {0}", id);
        SucursalEntity bookEntity = getSucursal(id);
        bookEntity.setCompras(list);
        return bookEntity.getCompras();
    }

    /**
     * Desasocia un Compra existente de un Sucursal existente
     *
     * @param id Identificador de la instancia de Sucursal
     * @param compraId Identificador de la instancia de Compra
     * 
     */
    public void removeCompra(Long id, Long compraId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del libro con id = {0}", id);
        SucursalEntity entity = getSucursal(id);
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setId(compraId);
        entity.getCompras().remove(compraEntity);
    }
    
    /**
     * Obtiene una colección de instancias de ComentarioEntity asociadas a una
     * instancia de Sucursal
     * @param id Identificador de la instancia de Sucursal
     * @return Colección de instancias de ComentarioEntity asociadas a la instancia
     * de Sucursal
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
    */
    public List<ComentarioEntity> listComentarios(Long id) throws BusinessLogicException {
        List<ComentarioEntity> lista= getSucursal(id).getComentarios();
        if(lista.isEmpty()) throw new BusinessLogicException("El cliente que consulta aún no tiene comentarios");
        return lista;
    }

    /**
     * Obtiene una instancia de ComentarioEntity asociada a una instancia de Sucursal
     * @param id Identificador de la instancia de Sucursal
     * @param comentarioId Identificador de la instancia de Comentario
     * @return entity 
     */
    public ComentarioEntity getComentario(Long id, Long comentarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor del libro con id = {0}", id);
        List<ComentarioEntity> list = getSucursal(id).getComentarios();
        ComentarioEntity comentariosEntity = new ComentarioEntity();
        comentariosEntity.setId(comentarioId);
        int index = list.indexOf(comentariosEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Comentario existente a un Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comentarioId Identificador de la instancia de Comentario
     * @return Instancia de ComentarioEntity que fue asociada a Sucursal
     * 
     */
    public ComentarioEntity addComentario(Long id, Long comentarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al libro con id = {0}", id);
        SucursalEntity bookEntity = getSucursal(id);
        ComentarioEntity comentariosEntity = new ComentarioEntity();
        comentariosEntity.setId(comentarioId);
        bookEntity.getComentarios().add(comentariosEntity);
        return getComentario(id, comentarioId);
    }

    /**
     * Remplaza las instancias de Comentario asociadas a una instancia de Sucursal
     *
     * @param id Identificador de la instancia de Sucursal
     * @param list Colección de instancias de ComentarioEntity a asociar a instancia
     * de Sucursal
     * @return Nueva colección de ComentarioEntity asociada a la instancia de Sucursal
     * 
     */
    public List<ComentarioEntity> replaceComentarios(Long id, List<ComentarioEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del libro con id = {0}", id);
        SucursalEntity bookEntity = getSucursal(id);
        bookEntity.setComentarios(list);
        return bookEntity.getComentarios();
    }

    /**
     * Desasocia un Comentario existente de un Sucursal existente
     *
     * @param id Identificador de la instancia de Sucursal
     * @param comentarioId Identificador de la instancia de Comentario
     * 
     */
    public void removeComentario(Long id, Long comentarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del libro con id = {0}", id);
        SucursalEntity entity = getSucursal(id);
        ComentarioEntity comentariosEntity = new ComentarioEntity();
        comentariosEntity.setId(comentarioId);
        entity.getComentarios().remove(comentariosEntity);
    }
}