package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RecargaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lv.vanegas10
 */
@Stateless
public class RecargaLogic {
    private static final Logger LOGGER = Logger.getLogger(RecargaLogic.class.getName());

    @Inject
    private RecargaPersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Obtiene la lista de los registros de Recarga.   
     * @return Colección de objetos de RecargaEntity.
     */
    public List<RecargaEntity> getRecargas() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los autores");
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de Recarga a partir de su ID.   
     * @param id Identificador de la instancia a consultar
     * @return Instancia de RecargaEntity con los datos del Recarga consultado.
     */
    public RecargaEntity getRecarga(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor con id = {0}", id);
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un Recarga en la base de datos.
     * @param entity Objeto de RecargaEntity con los datos nuevos
     * @return Objeto de RecargaEntity con los datos nuevos y su ID.
     */
    public RecargaEntity createRecarga(RecargaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un autor ");        
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de Recarga.     
     * @param entity Instancia de RecargaEntity con los nuevos datos.
     * @return Instancia de RecargaEntity con los datos actualizados.
     */
    public RecargaEntity updateRecarga(RecargaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un autor ");
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Recarga de la base de datos.     
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteRecarga(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor ");
        persistence.delete(id);
    }

    /**
     * Obtiene una instancia de ClienteEntity asociada a una instancia de Recarga    
     * @param recargaId Id de la recarga sobre la cual se quiere obtener el cliente
     * @return cliente asignado a la recarga con recargaId
     */
    public ClienteEntity getCliente(Long recargaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una recarga con id = {0}", recargaId);
        return getRecarga(recargaId).getCliente();      
    }

    /**
     * Asocia un Cliente existente a un Recarga    
     * @param recargaId Id de la recarga sobre la cual se quiere obtener el cliente
     * @param clienteId Id del cliente sobre el cual se quiere obtener la recarga
     * @return Instancia de ClienteEntity que fue asociada a Recarga
     * @generated
     */
    public ClienteEntity addCliente(Long recargaId, String clienteId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar un libro al author con id = {0}", recargaId);
        clienteLogic.addRecarga(clienteId, recargaId);
        return clienteLogic.getCliente(clienteId);
    }

    /**
     * Remplaza la instancia de Cliente asociada a una instancia de Recarga   
     * @param recargaId Id de la recarga sobre la cual se quiere obtener el cliente
     * @param clienteEntity entidad con la cual se quiere reeemplazar el cliente
     * @return Nueva colección de ClienteEntity asociada a la instancia de Recarga
     * @throws BusinessLogicException  si la entidad cliente no existe
     */
    public ClienteEntity replaceCliente(Long recargaId, ClienteEntity clienteEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar el cliente asociado a la recarga con id = {0}", recargaId);
        RecargaEntity recargaEntity = getRecarga(recargaId);
        if(clienteLogic.getCliente(clienteEntity.getUsuario()).equals(clienteEntity)){
            throw new BusinessLogicException ("El cliente no existe");
        }
        recargaEntity.setCliente(clienteEntity);
        return recargaEntity.getCliente();
    }

    /**
     * Desasocia un Cliente existente de un Recarga existente     
     * @param recargaId Identificador de la instancia de Recarga
     * @param usuario Usuario del cliente
     */
    public void removeCliente(Long recargaId, String usuario) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un libro del author con id = {0}", recargaId);
        clienteLogic.removeRecarga(usuario, recargaId);
    }
}
