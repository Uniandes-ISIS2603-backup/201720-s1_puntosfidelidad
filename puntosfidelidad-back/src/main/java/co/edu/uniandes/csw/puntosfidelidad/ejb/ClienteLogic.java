package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ClientePersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ComentarioPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RecargaPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.TarjetaPuntosPersistence;
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
    @Inject
    private RecargaPersistence recargaPersistence;
    @Inject
    private ComentarioPersistence comentarioPersistence;
    @Inject
    private TarjetaPuntosPersistence tarjetaPuntosPersistence;
    @Inject
    private CompraPersistence compraPersistence;

    
    public ClienteLogic(){
        
    }
    
    private static final String CLIENTE_ANONIMO = "Anonimo";
    private static final String MENSAJE_INICIAR_LOGGER = "Inicia proceso de asociar un autor del cliente con id = {0}";
    private static final String MENSAJE_ASOCIAR_LOGGER = "Inicia proceso de reemplazar un autor del cliente con id = {0}";
    private static final String MENSAJE_BORRAR_LOGGER = "Inicia proceso de borrar un autor del cliente con id = {0}";

    public List<ClienteEntity> getClientes() {
        LOGGER.info(MENSAJE_INICIAR_LOGGER);
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los clientes");
        return clientes;
    }

    public ClienteEntity getCliente(String usuario) {
        LOGGER.log(Level.INFO, MENSAJE_INICIAR_LOGGER, usuario);
        ClienteEntity cliente = persistence.find(usuario);
        if (cliente == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", usuario);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar cliente con id={0}", usuario);
        return cliente;
    }

    public ClienteEntity createcliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de cliente");
        if(entity.getUsuario()==null){
            throw new BusinessLogicException("El usuario no es valido: " + entity.getUsuario());
        }
        if(persistence.find(entity.getUsuario())!=null){
            throw new BusinessLogicException("El usuario" + entity.getUsuario() + "ya existe");
        } 
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("La contraseña no es valida: " + entity.getContrasena());
        }
        if(entity.getNombre()==null || "".equals(entity.getNombre())){
            entity.setNombre(entity.getUsuario());
        }
        if("".equals(entity.getImagen())|| entity.getImagen()==null)
        {
            entity.setImagen("http://estaticos.elmundo.es/social/static/img/avatars/xlarge_default.png");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de cliente");
        return entity;
    }

    public ClienteEntity updateCliente(String usuario, ClienteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia actualización de cliente con id={0}", usuario);
        if (!usuario.equals(entity.getUsuario())) {
            throw new BusinessLogicException("No es posible cambiar el usuario");
        }
        if (!validateContrasena(entity.getContrasena())) {
            throw new BusinessLogicException("La contraseña no es valida: " + entity.getContrasena());
        }  
        if(entity.getNombre()==null || entity.getNombre().isEmpty()){
            entity.setNombre(entity.getUsuario());
        }
        if(entity.getImagen()==null || entity.getImagen().isEmpty()|| entity.getImagen().startsWith("http://")|| entity.getImagen().startsWith("https://") ){
            entity.setImagen("http://estaticos.elmundo.es/social/static/img/avatars/xlarge_default.png");
        }
        return persistence.update(entity);
    }

    public void deleteCliente(String usuario) throws BusinessLogicException{
        LOGGER.log(Level.INFO, MENSAJE_BORRAR_LOGGER, usuario);
        ClienteEntity actual= persistence.find(usuario);
        ClienteEntity anonimo= persistence.find(CLIENTE_ANONIMO);
        if(actual==null) {
            throw new BusinessLogicException("El usuario no existe");
        }  
        if(anonimo==null)
        {
            anonimo= new ClienteEntity();
            anonimo.setUsuario(CLIENTE_ANONIMO);
            anonimo.setNombre(CLIENTE_ANONIMO);
            anonimo.setContrasena(CLIENTE_ANONIMO);
            anonimo=persistence.create(anonimo);
        }        
        
        if(persistence.find(CLIENTE_ANONIMO)!=null)
            LOGGER.log(Level.INFO, "ANONIMO CREADO");
        
        deleteClienteComentarios(actual, anonimo);        
        LOGGER.log(Level.INFO, "Comentarios actualizados");
        
        deleteClienteTP(actual, anonimo);
        LOGGER.log(Level.INFO, "TP actualizados");
        
        deleteClienteCompras(actual, anonimo);
        LOGGER.log(Level.INFO, "Compras actualizados");

        

        persistence.delete(usuario);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente con id={0}", usuario);
    }

    private void deleteClienteComentarios(ClienteEntity cliente, ClienteEntity anonimo){
        
        for(ComentarioEntity comentario: cliente.getComentarios())
        {            
            ComentarioEntity nuevo= new ComentarioEntity();
            nuevo.setId(comentario.getId());
            nuevo.setCliente(anonimo);            
            comentarioPersistence.update(nuevo);           
        }
    }
    
    private void deleteClienteCompras(ClienteEntity cliente, ClienteEntity anonimo){
        for(CompraEntity compra: cliente.getCompras())
        {
            CompraEntity nuevo= new CompraEntity();
            nuevo.setId(compra.getId());
            nuevo.setCliente(anonimo);
            compraPersistence.update(nuevo);
        }
    }
    private void deleteClienteTP(ClienteEntity cliente, ClienteEntity anonimo){
        for(TarjetaPuntosEntity tp: cliente.getTarjetasPuntos())
        {
            TarjetaPuntosEntity nuevo= new TarjetaPuntosEntity();
            nuevo.setId(tp.getId());
            nuevo.setCliente(anonimo);
            tarjetaPuntosPersistence.update(nuevo);
        }
    }
    private boolean validateContrasena(String contrasena) {
        return !(contrasena == null || contrasena.isEmpty());
    }

    /**
     * Obtiene una colección de instancias de TarjetaDeCredito asociadas a una
     * instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @return Colección de instancias de TarjetaDeCreditoEntity asociadas a la instancia
     * de cliente
     * 
     */
    public List<TarjetaDeCreditoEntity> listTarjetaDeCredito(String usuario) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los Tarjetas de Credito del usuario con id = {0}", usuario);
        return getCliente(usuario).getTarjetasDeCredito();
    }

    /**
     * Obtiene una instancia de TarjetaDeCreditoEntity asociada a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito
     * @return Instancia de TarjetaDeCreditoEntity buscada 
     * 
     */
    public TarjetaDeCreditoEntity getTarjetaDeCredito(String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un Tarjetas de Credito del cliente con usuario = {0}", usuario);
        List<TarjetaDeCreditoEntity> list = getCliente(usuario).getTarjetasDeCredito();
        TarjetaDeCreditoEntity entity = new TarjetaDeCreditoEntity();
        entity.setId(tarjetaId);
        int index = list.indexOf(entity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia una Tarjeta de Credito existente a un cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito      * @return Instancia de TarjetaDeCreditoEntity que fue asociada a cliente
     * @return Instancia de TarjetaDeCreditoEntity buscada 
     */
    public TarjetaDeCreditoEntity addTarjetaDeCredito (String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, MENSAJE_ASOCIAR_LOGGER, usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        TarjetaDeCreditoEntity tarjetaEntity = new TarjetaDeCreditoEntity();
        tarjetaEntity.setId(tarjetaId);
        clienteEntity.getTarjetasDeCredito().add(tarjetaEntity);
        return getTarjetaDeCredito(usuario, tarjetaId);
    }

    /**
     * Remplaza las instancias de TarjetaDeCredito asociadas a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param list Colección de instancias de TarjetaDeCreditoEntity a asociar a instancia
     * de cliente
     * @return Nueva colección de TarjetaDeCreditoEntity asociada a la instancia de cliente
     * 
     */
    public List<TarjetaDeCreditoEntity> replaceTarjetasDeCredito (String usuario, List<TarjetaDeCreditoEntity> list) {
        LOGGER.log(Level.INFO, MENSAJE_ASOCIAR_LOGGER, usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        clienteEntity.setTarjetasDeCredito(list);
        return clienteEntity.getTarjetasDeCredito();
    }

    /**
     * Desasocia un TarjetaDeCredito existente de un cliente existente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaDeCredito      * 
     */
    public void removeTarjetaDeCredito (String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, MENSAJE_BORRAR_LOGGER, usuario);
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
        LOGGER.log(Level.INFO, MENSAJE_ASOCIAR_LOGGER, usuario);
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
        LOGGER.log(Level.INFO, MENSAJE_ASOCIAR_LOGGER, usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        clienteEntity.setRecargas(list);
        return clienteEntity.getRecargas();
    }

    /**
     * Desasocia un Recarga existente de un cliente existente
     * @param usuario Identificador de la instancia de cliente
     * @param recargaId Identificador de la instancia de Recarga      * 
     */
    public void removeRecarga (String usuario, Long recargaId) {
        LOGGER.log(Level.INFO, MENSAJE_BORRAR_LOGGER, usuario);
        ClienteEntity entity = getCliente(usuario);
        RecargaEntity recargaEntity = new RecargaEntity();
        recargaEntity.setId(recargaId);
        entity.getRecargas().remove(recargaEntity);
        recargaPersistence.delete(recargaId);
    }
    
    /**
     * Obtiene una colección de instancias de TarjetaPuntos asociadas a una
     * instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @return Colección de instancias de TarjetaPuntosEntity asociadas a la instancia
     * de cliente
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    public List<TarjetaPuntosEntity> listTarjetasPuntos(String usuario) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los Tarjetas de Credito del usuario con id = {0}", usuario);
        List<TarjetaPuntosEntity> lista= getCliente(usuario).getTarjetasPuntos();
        if(lista.isEmpty()) 
            throw new BusinessLogicException("El cliente que consulta aún no tiene tarjetas de puntos");
        return lista;
    }

    /**
     * Obtiene una instancia de TarjetaPuntosEntity asociada a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaPuntos
     * @return Instancia de TarjetaPuntosEntity buscada 
     * 
     */
    public TarjetaPuntosEntity getTarjetaPuntos(String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un Tarjetas de Credito del cliente con usuario = {0}", usuario);
        List<TarjetaPuntosEntity> list = getCliente(usuario).getTarjetasPuntos();
        TarjetaPuntosEntity entity = new TarjetaPuntosEntity();
        entity.setId(tarjetaId);
        int index = list.indexOf(entity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia una Tarjeta de Credito existente a un cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaPuntos      * @return Instancia de TarjetaPuntosEntity que fue asociada a cliente
     * @return Instancia de TarjetaPuntosEntity buscada 
     */
    public TarjetaPuntosEntity addTarjetaPuntos (String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, MENSAJE_ASOCIAR_LOGGER, usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        TarjetaPuntosEntity tarjetaEntity = new TarjetaPuntosEntity();
        tarjetaEntity.setId(tarjetaId);
        clienteEntity.getTarjetasPuntos().add(tarjetaEntity);
        return getTarjetaPuntos(usuario, tarjetaId);
    }

    /**
     * Remplaza las instancias de TarjetaPuntos asociadas a una instancia de cliente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param list Colección de instancias de TarjetaPuntosEntity a asociar a instancia
     * de cliente
     * @return Nueva colección de TarjetaPuntosEntity asociada a la instancia de cliente
     * 
     */
    public List<TarjetaPuntosEntity> replaceTarjetasPuntos (String usuario, List<TarjetaPuntosEntity> list) {
        LOGGER.log(Level.INFO, MENSAJE_ASOCIAR_LOGGER, usuario);
        ClienteEntity clienteEntity = getCliente(usuario);
        clienteEntity.setTarjetasPuntos(list);
        return clienteEntity.getTarjetasPuntos();
    }

    /**
     * Desasocia un TarjetaPuntos existente de un cliente existente
     *
     * @param usuario Identificador de la instancia de cliente
     * @param tarjetaId Identificador de la instancia de TarjetaPuntos      * 
     */
    public void removeTarjetaPuntos (String usuario, Long tarjetaId) {
        LOGGER.log(Level.INFO, MENSAJE_BORRAR_LOGGER, usuario);
        ClienteEntity entity = getCliente(usuario);
        TarjetaPuntosEntity tarjetaEntity = new TarjetaPuntosEntity();
        tarjetaEntity.setId(tarjetaId);
        entity.getTarjetasPuntos().remove(tarjetaEntity);
    }
    
     /**
     * Obtiene una colección de instancias de CompraEntity asociadas a una
     * instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @return Colección de instancias de CompraEntity asociadas a la instancia
     * de Cliente
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
     * 
     */
    public List<CompraEntity> listCompras(String usuario) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los autores del libro con id = {0}", usuario);
        List<CompraEntity> lista= getCliente(usuario).getCompras();
        if(lista.isEmpty()) 
            throw new BusinessLogicException("El cliente que consulta aún no tiene compras");
        return lista;
    }

    /**
     * Obtiene una instancia de CompraEntity asociada a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param compraId Identificador de la instancia de Compra
     * @return      * 
     */
    public CompraEntity getCompra(String usuario, Long compraId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor del libro con id = {0}", usuario);
        List<CompraEntity> list = getCliente(usuario).getCompras();
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setId(compraId);
        int index = list.indexOf(compraEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Compra existente a un Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param compraId Identificador de la instancia de Compra
     * @return Instancia de CompraEntity que fue asociada a Cliente
     * 
     */
    public CompraEntity addCompra(String usuario, Long compraId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al libro con id = {0}", usuario);
        ClienteEntity bookEntity = getCliente(usuario);
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setId(compraId);
        bookEntity.getCompras().add(compraEntity);
        return getCompra(usuario, compraId);
    }

    /**
     * Remplaza las instancias de Compra asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param list Colección de instancias de CompraEntity a asociar a instancia
     * de Cliente
     * @return Nueva colección de CompraEntity asociada a la instancia de Cliente
     * 
     */
    public List<CompraEntity> replaceCompras(String usuario, List<CompraEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del libro con id = {0}", usuario);
        ClienteEntity bookEntity = getCliente(usuario);
        bookEntity.setCompras(list);
        return bookEntity.getCompras();
    }

    /**
     * Desasocia un Compra existente de un Cliente existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param compraId Identificador de la instancia de Compra
     * 
     */
    public void removeCompra(String usuario, Long compraId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del libro con id = {0}", usuario);
        ClienteEntity entity = getCliente(usuario);
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setId(compraId);
        entity.getCompras().remove(compraEntity);
    }
    
    /**
     * Obtiene una colección de instancias de ComentarioEntity asociadas a una
     * instancia de Cliente
     * @param usuario Identificador de la instancia de Cliente
     * @return Colección de instancias de ComentarioEntity asociadas a la instancia
     * de Cliente
     * @throws co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException
    */
    public List<ComentarioEntity> listComentarios(String usuario) throws BusinessLogicException {
        List<ComentarioEntity> lista= getCliente(usuario).getComentarios();
        if(lista.isEmpty()) 
            throw new BusinessLogicException("El cliente que consulta aún no tiene comentarios");
        return lista;
    }

    /**
     * Obtiene una instancia de ComentarioEntity asociada a una instancia de Cliente
     * @param usuario Identificador de la instancia de Cliente
     * @param comentarioId Identificador de la instancia de Comentario
     * @return entity 
     */
    public ComentarioEntity getComentario(String usuario, Long comentarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor del libro con id = {0}", usuario);
        List<ComentarioEntity> list = getCliente(usuario).getComentarios();
        ComentarioEntity comentariosEntity = new ComentarioEntity();
        comentariosEntity.setId(comentarioId);
        int index = list.indexOf(comentariosEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Comentario existente a un Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comentarioId Identificador de la instancia de Comentario
     * @return Instancia de ComentarioEntity que fue asociada a Cliente
     * 
     */
    public ComentarioEntity addComentario(String usuario, Long comentarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al libro con id = {0}", usuario);
        ClienteEntity bookEntity = getCliente(usuario);
        ComentarioEntity comentariosEntity = new ComentarioEntity();
        comentariosEntity.setId(comentarioId);
        bookEntity.getComentarios().add(comentariosEntity);
        return getComentario(usuario, comentarioId);
    }

    /**
     * Remplaza las instancias de Comentario asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param list Colección de instancias de ComentarioEntity a asociar a instancia
     * de Cliente
     * @return Nueva colección de ComentarioEntity asociada a la instancia de Cliente
     * 
     */
    public List<ComentarioEntity> replaceComentarios(String usuario, List<ComentarioEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del libro con id = {0}", usuario);
        ClienteEntity bookEntity = getCliente(usuario);
        bookEntity.setComentarios(list);
        return bookEntity.getComentarios();
    }

    /**
     * Desasocia un Comentario existente de un Cliente existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comentarioId Identificador de la instancia de Comentario
     * 
     */
    public void removeComentario(String usuario, Long comentarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del libro con id = {0}", usuario);
        ClienteEntity entity = getCliente(usuario);
        ComentarioEntity comentariosEntity = new ComentarioEntity();
        comentariosEntity.setId(comentarioId);
        entity.getComentarios().remove(comentariosEntity);
    }
}
