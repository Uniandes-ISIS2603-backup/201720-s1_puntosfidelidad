package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RecargaPersistence;
import java.util.List;
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
     * Obtiene la lista de los registros de Recarga que pertenecen a un Cliente.
     *
     * @param usuario id del Cliente el cual es padre de los Recargas.
     * @return Colección de objetos de RecargaEntity.
     * @throws BusinessLogicException
     */
    public List<RecargaEntity> getRecargas(String usuario) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todos los recargas");
        ClienteEntity cliente = clienteLogic.getCliente(usuario);
        if (cliente.getRecargas() == null || cliente.getRecargas().isEmpty() ) {
            throw new BusinessLogicException("El cliente que consulta aún no tiene recargas");
        }
        return cliente.getRecargas();
    }

    /**
     * Obtiene los datos de una instancia de Recarga a partir de su ID.
     *
     * @param usuario
     * @pre La existencia del elemento padre Cliente se debe garantizar.
     * @param recargaid Identificador del Recarga a consultar
     * @return Instancia de RecargaEntity con los datos del Recarga consultado.
     * 
     */
    public RecargaEntity getRecarga(String usuario, Long recargaid) {
        return persistence.find(usuario, recargaid);
    }

    /**
     * Se encarga de crear un Recarga en la base de datos.
     *
     * @param entity Objeto de RecargaEntity con los datos nuevos
     * @param usuario id del Cliente el cual sera padre del nuevo Recarga.
     * @return Objeto de RecargaEntity con los datos nuevos y su ID.
     * 
     */
    public RecargaEntity createRecarga(String usuario, RecargaEntity entity) {
        LOGGER.info("Inicia proceso de crear recarga");
        ClienteEntity cliente = clienteLogic.getCliente(usuario);
        entity.setCliente(cliente);
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de Recarga.
     *
     * @param entity Instancia de RecargaEntity con los nuevos datos.
     * @param usuario id del Cliente el cual sera padre del Recarga actualizado.
     * @return Instancia de RecargaEntity con los datos actualizados.
     * 
     */
    public RecargaEntity updateRecarga(String usuario, RecargaEntity entity) {
        LOGGER.info("Inicia proceso de actualizar recarga");
        ClienteEntity cliente = clienteLogic.getCliente(usuario);
        entity.setCliente(cliente);
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Recarga de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param usuario id del Cliente el cual es padre del Recarga.
     * 
     */
    public void deleteRecarga(String usuario, Long id) {
        LOGGER.info("Inicia proceso de borrar recarga");
        RecargaEntity old = getRecarga(usuario, id);
        persistence.delete(old.getId());
    }    
}
