package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ClientePersistence;
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
public class ClienteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private ClientePersistence persistence;

    public List<ClienteEntity> getClientes() {
        LOGGER.info("Inicia proceso de consultar todos los clientes");
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los clientes");
        return clientes;
    }

    public ClienteEntity getCliente(String usuario) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar cliente con id={0}", usuario);
        ClienteEntity cliente = persistence.find(usuario);
        if (cliente == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", usuario);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar cliente con id={0}", usuario);
        return cliente;
    }

    public ClienteEntity createcliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de cliente");
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("La contraseña no es valida");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de cliente");
        return entity;
    }

    public ClienteEntity updateCliente(String usuario, ClienteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente con id={0}", usuario);
        if (!usuario.equals(entity.getUsuario())) {
            throw new BusinessLogicException("No es posible cambiar el usuario");
        }
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("La contraseña no es valida");
        }       
        ClienteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar cliente con id={0}", entity.getUsuario());
        return newEntity;
    }

    public void deleteCliente(String usuario) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente con id={0}", usuario);
        if(persistence.find(usuario)==null) {
            throw new BusinessLogicException("El usuario no existe");
        }  
        persistence.delete(usuario);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente con id={0}", usuario);
    }

    private boolean validateContrasena(String contrasena) {
        return !(contrasena == null || contrasena.isEmpty());
    }

//    /**
//     * Obtiene una colección de instancias de TarjetaDeCredito asociadas a una
//     * instancia de cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @return Colección de instancias de TarjetaDeCreditoEntity asociadas a la instancia
//     * de cliente
//     * 
//     */
//    public List<TarjetaDeCreditoEntity> listTarjetaDeCredito(String usuario) {
//        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los Tarjetas de Credito del usuario con id = {0}", usuario);
//        return getCliente(usuario).getTarjetasDeCredito();
//    }
//
//    /**
//     * Obtiene una instancia de TarjetaDeCreditoEntity asociada a una instancia de cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito
//     * @return Instancia de TarjetaDeCreditoEntity buscada 
//     * 
//     */
//    public TarjetaDeCreditoEntity getTarjetaDeCredito(String usuario, Long tarjetaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de consultar un Tarjetas de Credito del cliente con usuario = {0}", usuario);
//        List<TarjetaDeCreditoEntity> list = getCliente(usuario).getTarjetasDeCredito();
//        TarjetaDeCreditoEntity entity = new TarjetaDeCreditoEntity();
//        entity.setId(tarjetaId);
//        int index = list.indexOf(entity);
//        if (index >= 0) {
//            return list.get(index);
//        }
//        return null;
//    }
//
//    /**
//     * Asocia una Tarjeta de Credito existente a un cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito      * @return Instancia de TarjetaDeCreditoEntity que fue asociada a cliente
//     * @return Instancia de TarjetaDeCreditoEntity buscada 
//     */
//    public TarjetaDeCreditoEntity addTarjetaDeCredito (String usuario, Long tarjetaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al cliente con id = {0}", usuario);
//        ClienteEntity clienteEntity = getCliente(usuario);
//        TarjetaDeCreditoEntity tarjetaEntity = new TarjetaDeCreditoEntity();
//        tarjetaEntity.setId(tarjetaId);
//        clienteEntity.getTarjetasDeCredito().add(tarjetaEntity);
//        return getTarjetaDeCredito(usuario, tarjetaId);
//    }
//
//    /**
//     * Remplaza las instancias de TarjetaDeCredito asociadas a una instancia de cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param list Colección de instancias de TarjetaDeCreditoEntity a asociar a instancia
//     * de cliente
//     * @return Nueva colección de TarjetaDeCreditoEntity asociada a la instancia de cliente
//     * 
//     */
//    public List<TarjetaDeCreditoEntity> replaceTarjetasDeCredito (String usuario, List<TarjetaDeCreditoEntity> list) {
//        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del cliente con id = {0}", usuario);
//        ClienteEntity clienteEntity = getCliente(usuario);
//        clienteEntity.setTarjetasDeCredito(list);
//        return clienteEntity.getTarjetasDeCredito();
//    }
//
//    /**
//     * Desasocia un TarjetaDeCredito existente de un cliente existente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito      * 
//     */
//    public void removeTarjetaDeCredito (String usuario, Long tarjetaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del cliente con id = {0}", usuario);
//        ClienteEntity entity = getCliente(usuario);
//        TarjetaDeCreditoEntity tarjetaEntity = new TarjetaDeCreditoEntity();
//        tarjetaEntity.setId(tarjetaId);
//        entity.getTarjetasDeCredito().remove(tarjetaEntity);
//    }
//    
//     /**
//     * Obtiene una colección de instancias de Recarga asociadas a una
//     * instancia de cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @return Colección de instancias de RecargaEntity asociadas a la instancia
//     * de cliente
//     * 
//     */
//    public List<RecargaEntity> listRecargas(String usuario) {
//        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los recargas de Credito del usuario con id = {0}", usuario);
//        return getCliente(usuario).getRecargas();
//    }
//
//    /**
//     * Obtiene una instancia de RecargaEntity asociada a una instancia de cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param recargaId Identificador de la instancia de Recarga
//     * @return Instancia de RecargaEntity buscada 
//     * 
//     */
//    public RecargaEntity getRecarga(String usuario, Long recargaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de consultar un recargas de Credito del cliente con usuario = {0}", usuario);
//        List<RecargaEntity> list = getCliente(usuario).getRecargas();
//        RecargaEntity entity = new RecargaEntity();
//        entity.setId(recargaId);
//        int index = list.indexOf(entity);
//        if (index >= 0) {
//            return list.get(index);
//        }
//        return null;
//    }
//
//    /**
//     * Asocia una recarga de Credito existente a un cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param recargaId Identificador de la instancia de Recarga      * @return Instancia de RecargaEntity que fue asociada a cliente
//     * @return Instancia de RecargaEntity buscada 
//     */
//    public RecargaEntity addRecarga (String usuario, Long recargaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al cliente con id = {0}", usuario);
//        ClienteEntity clienteEntity = getCliente(usuario);
//        RecargaEntity recargaEntity = new RecargaEntity();
//        recargaEntity.setId(recargaId);
//        clienteEntity.getRecargas().add(recargaEntity);
//        return getRecarga(usuario, recargaId);
//    }
//
//    /**
//     * Remplaza las instancias de Recarga asociadas a una instancia de cliente
//     *
//     * @param usuario Identificador de la instancia de cliente
//     * @param list Colección de instancias de RecargaEntity a asociar a instancia
//     * de cliente
//     * @return Nueva colección de RecargaEntity asociada a la instancia de cliente
//     * 
//     */
//    public List<RecargaEntity> replaceRecargas (String usuario, List<RecargaEntity> list) {
//        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del cliente con id = {0}", usuario);
//        ClienteEntity clienteEntity = getCliente(usuario);
//        clienteEntity.setRecargas(list);
//        return clienteEntity.getRecargas();
//    }
//
//    /**
//     * Desasocia un Recarga existente de un cliente existente
//     * @param usuario Identificador de la instancia de cliente
//     * @param recargaId Identificador de la instancia de Recarga      * 
//     */
//    public void removeRecarga (String usuario, Long recargaId) {
//        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del cliente con id = {0}", usuario);
//        ClienteEntity entity = getCliente(usuario);
//        RecargaEntity recargaEntity = new RecargaEntity();
//        recargaEntity.setId(recargaId);
//        entity.getRecargas().remove(recargaEntity);
//    }
}
