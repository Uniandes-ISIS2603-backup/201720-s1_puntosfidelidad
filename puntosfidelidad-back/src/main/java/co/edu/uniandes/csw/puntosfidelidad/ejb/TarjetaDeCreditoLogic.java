package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.TarjetaDeCreditoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @TarjetaDeCredito lv.vanegas10
 */
@Stateless
public class TarjetaDeCreditoLogic {
    
   private static final Logger LOGGER = Logger.getLogger(TarjetaDeCreditoLogic.class.getName());

    @Inject
    private TarjetaDeCreditoPersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Obtiene la lista de los registros de TarjetaDeCredito que pertenecen a un Cliente.
     *
     * @param usuario id del Cliente el cual es padre de los TarjetaDeCreditos.
     * @return Colección de objetos de TarjetaDeCreditoEntity.
     * @throws BusinessLogicException
     */
    public List<TarjetaDeCreditoEntity> getTarjetasDeCredito(String usuario) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todos las tarjetas");
        ClienteEntity cliente = clienteLogic.getCliente(usuario);
        if (cliente.getTarjetasDeCredito() == null || cliente.getTarjetasDeCredito().isEmpty() ) {
            throw new BusinessLogicException("El cliente que consulta aún no tiene tarjetas de credito");
        }
        return cliente.getTarjetasDeCredito();
    }

    /**
     * Obtiene los datos de una instancia de TarjetaDeCredito a partir de su ID.
     *
     * @param usuario
     * @pre La existencia del elemento padre Cliente se debe garantizar.
     * @param reviewid) Identificador del TarjetaDeCredito a consultar
     * @return Instancia de TarjetaDeCreditoEntity con los datos del TarjetaDeCredito consultado.
     * 
     */
    public TarjetaDeCreditoEntity getTarjetaDeCredito(String usuario, Long reviewid) {
        return persistence.find(usuario, reviewid);
    }

    /**
     * Se encarga de crear un TarjetaDeCredito en la base de datos.
     *
     * @param entity Objeto de TarjetaDeCreditoEntity con los datos nuevos
     * @param usuario id del Cliente el cual sera padre del nuevo TarjetaDeCredito.
     * @return Objeto de TarjetaDeCreditoEntity con los datos nuevos y su ID.
     * 
     */
    public TarjetaDeCreditoEntity createTarjetaDeCredito(String usuario, TarjetaDeCreditoEntity entity) {
        LOGGER.info("Inicia proceso de crear review");
        ClienteEntity cliente = clienteLogic.getCliente(usuario);
        entity.setCliente(cliente);
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de TarjetaDeCredito.
     *
     * @param entity Instancia de TarjetaDeCreditoEntity con los nuevos datos.
     * @param usuario id del Cliente el cual sera padre del TarjetaDeCredito actualizado.
     * @return Instancia de TarjetaDeCreditoEntity con los datos actualizados.
     * 
     */
    public TarjetaDeCreditoEntity updateTarjetaDeCredito(String usuario, TarjetaDeCreditoEntity entity) {
        LOGGER.info("Inicia proceso de actualizar review");
        ClienteEntity cliente = clienteLogic.getCliente(usuario);
        entity.setCliente(cliente);
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de TarjetaDeCredito de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param usuario id del Cliente el cual es padre del TarjetaDeCredito.
     * 
     */
    public void deleteTarjetaDeCredito(String usuario, Long id) {
        LOGGER.info("Inicia proceso de borrar review");
        TarjetaDeCreditoEntity old = getTarjetaDeCredito(usuario, id);
        persistence.delete(old.getId());
    }
}
