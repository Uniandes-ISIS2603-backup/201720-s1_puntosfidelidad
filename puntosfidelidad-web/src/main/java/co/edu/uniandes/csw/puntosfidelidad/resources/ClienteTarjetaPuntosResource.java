/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.ClienteDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ClienteLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.TarjetaPuntosLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author lv.vanegas10
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteTarjetaPuntosResource {
    @Inject
    private ClienteLogic clienteLogic;
    
    @Inject
    private TarjetaPuntosLogic logic;

    /**
     * Convierte una lista de TarjetaPuntosEntity a una lista de TarjetaPuntosDetailDTO.
     *
     * @param entityList Lista de TarjetaPuntosEntity a convertir.
     * @return Lista de TarjetaPuntosDetailDTO convertida.
     * 
     */
    private List<TarjetaPuntosDetailDTO> tarjetasPuntosListEntity2DTO(List<TarjetaPuntosEntity> entityList) {
        List<TarjetaPuntosDetailDTO> list = new ArrayList<>();
        for (TarjetaPuntosEntity entity : entityList) {
            list.add(new TarjetaPuntosDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de TarjetaPuntosDetailDTO a una lista de TarjetaPuntosEntity.
     *
     * @param dtos Lista de TarjetaPuntosDetailDTO a convertir.
     * @return Lista de TarjetaPuntosEntity convertida.
     * 
     */
    private List<TarjetaPuntosEntity> tarjetasPuntosListDTO2Entity(List<TarjetaPuntosDetailDTO> dtos) {
        List<TarjetaPuntosEntity> list = new ArrayList<>();
        for (TarjetaPuntosDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de TarjetaPuntosDetailDTO asociadas a una
     * instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @return Colección de instancias de TarjetaPuntosDetailDTO asociadas a la
     * instancia de Cliente
     * 
     */
    @GET
    public List<TarjetaPuntosDetailDTO> listTarjetasPuntos(@PathParam("usuario") String usuario) throws BusinessLogicException {
        return tarjetasPuntosListEntity2DTO(clienteLogic.listTarjetasPuntos(usuario));
    }

    /**
     * Obtiene una instancia de TarjetaPuntos asociada a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param tarjetasPuntosId Identificador de la instancia de TarjetaPuntos
     * @return 
     * 
     */
    @GET
    @Path("{tarjetasPuntosId: \\d+}")
    public TarjetaPuntosDetailDTO getTarjetasPuntos(@PathParam("usuario") String usuario, @PathParam("tarjetasPuntosId") Long tarjetasPuntosId) {        
        return new TarjetaPuntosDetailDTO(clienteLogic.getTarjetaPuntos(usuario, tarjetasPuntosId));
    }

    /**
     * Asocia un TarjetaPuntos existente a un Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param tarjetaNueva GG
     * @return Instancia de TarjetaPuntosDetailDTO que fue asociada a Cliente
     * 
     */
//    @POST
//    @Path("{tarjetasPuntosId: \\d+}")
//    public TarjetaPuntosDetailDTO addTarjetasPuntos(@PathParam("usuario") String usuario, @PathParam("tarjetasPuntosId") Long tarjetasPuntosId) {        
//        return new TarjetaPuntosDetailDTO(clienteLogic.addTarjetaPuntos(usuario, tarjetasPuntosId));
//    }

    @POST    
    public TarjetaPuntosDTO createTarjetaPuntos(@PathParam("usuario") String usuario,TarjetaPuntosDTO tarjetaNueva )
    {
        ClienteEntity cliente= clienteLogic.getCliente(usuario);
        TarjetaPuntosEntity tarjeta= tarjetaNueva.toEntity();
        tarjeta.setCliente(cliente);        
        List lista= cliente.getTarjetasPuntos();
        lista.add(tarjeta);
        cliente.setTarjetasPuntos(lista);
        return new TarjetaPuntosDTO(logic.createTarjetaPuntos(tarjeta));
    }    
    
    
    /**
     * Remplaza las instancias de TarjetaPuntos asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param tarjetasPuntos Colección de instancias de TarjetaPuntosDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de TarjetaPuntosDTO asociada a la instancia de Cliente
     * 
     */
//    @PUT
//    public List<TarjetaPuntosDetailDTO> replaceTarjetasPuntos(@PathParam("usuario") String usuario, List<TarjetaPuntosDetailDTO> tarjetasPuntos) {
//        return tarjetasPuntosListEntity2DTO(clienteLogic.replaceTarjetasPuntos(usuario, tarjetasPuntosListDTO2Entity(tarjetasPuntos)));
//    }

    /**
     * Desasocia un TarjetaPuntos existente de un Cliente existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param tarjetasPuntosId Identificador de la instancia de TarjetaPuntos
     * 
     */
    @DELETE
    @Path("{tarjetasPuntosId: \\d+}")
    public void removeTarjetaPuntos(@PathParam("usuario") String usuario, @PathParam("tarjetasPuntosId") Long tarjetasPuntosId) {
        logic.deleteTarjetaPuntos(tarjetasPuntosId);
        clienteLogic.removeTarjetaPuntos(usuario, tarjetasPuntosId);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TarjetaPuntosDetailDTO updateTarjetaPuntos(@PathParam("usuario") String usuario, @PathParam("id") Long id, TarjetaPuntosDetailDTO tarjeta) throws BusinessLogicException {
        tarjeta.setId(id);   
        ClienteEntity cliente= clienteLogic.getCliente(usuario);
        tarjeta.setCliente(new ClienteDTO(cliente));
        TarjetaPuntosEntity entity = logic.getTarjetaPuntos(id);
        cliente.getTarjetasPuntos().remove(entity);
        cliente.getTarjetasPuntos().add(tarjeta.toEntity());
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + usuario + "/tarjetas/" + id + " no existe.", 404);
        }        
        return new TarjetaPuntosDetailDTO(logic.updateTarjetaPuntos(tarjeta.toEntity()));
    }
}

