package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.TarjetaDeCreditoPersistence;
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

    /**
     * Obtiene los datos de una instancia de TarjetaDeCredito a partir de su ID.
     * @param id Identificador de la instancia a consultar
     * @return Instancia de TarjetaDeCreditoEntity con los datos del TarjetaDeCredito consultado.
     * @generated
     */
    public TarjetaDeCreditoEntity getTarjetaDeCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor con id = {0}", id);
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un TarjetaDeCredito en la base de datos.
     * @param entity Objeto de TarjetaDeCreditoEntity con los datos nuevos
     * @return Objeto de TarjetaDeCreditoEntity con los datos nuevos y su ID.
     */
    public TarjetaDeCreditoEntity createTarjetaDeCredito(TarjetaDeCreditoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un autor ");        
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de TarjetaDeCredito.
     * @param entity Instancia de TarjetaDeCreditoEntity con los nuevos datos.
     * @return Instancia de TarjetaDeCreditoEntity con los datos actualizados.
     */
    public TarjetaDeCreditoEntity updateTarjetaDeCredito(TarjetaDeCreditoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un autor ");
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de TarjetaDeCredito de la base de datos.
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteTarjetaDeCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor ");
        persistence.delete(id);
    }
}
