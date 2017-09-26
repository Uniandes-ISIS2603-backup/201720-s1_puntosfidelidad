/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;


import co.edu.uniandes.csw.puntosfidelidad.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ClienteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author lv.vanegas10
 */
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteResource {
    @Inject
    ClienteLogic clienteLogic;
    
    /**
     * Obtiene todos los clientes
     * @return lista de lcientes
     * @throws BusinessLogicException 
     */
    @GET
    public List<ClienteDetailDTO> getClientes() throws BusinessLogicException {
        return listClienteEntity2DetailDTO(clienteLogic.getClientes());
    }
    /**
     * Obtiene un cliente segùn el usuario dado 
     * @param usuario
     * @return cliente
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{usuario: [a-zA-Z][a-zA-Z]*}}")   
    public ClienteDetailDTO getBook(@PathParam("usuario") String usuario) throws BusinessLogicException {
        ClienteEntity entity = clienteLogic.getCliente(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /cliente/" + usuario + " no existe.", 404);
        }
        return new ClienteDetailDTO(entity);
    }

    /**
     * Cra un cliente 
     * @param cliente
     * @return Cliente creado
     * @throws BusinessLogicException
     */
    @POST
    public ClienteDetailDTO createBook(ClienteDetailDTO cliente) throws BusinessLogicException {        
         return new ClienteDetailDTO(clienteLogic.createcliente(cliente.toEntity()));
    }

    /**
     * Actualiza un cliente
     * @param usuario
     * @param cliente
     * @return cliente actualizado 
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{usuario: [a-zA-Z][a-zA-Z]*}}") 
    public ClienteDetailDTO updateBook(@PathParam("usuario") String usuario, ClienteDetailDTO cliente) throws BusinessLogicException {
        cliente.setUsuario(usuario);
        ClienteEntity entity = clienteLogic.getCliente(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /cliente/" + usuario + " no existe.", 404);
        }
        return new ClienteDetailDTO(clienteLogic.updateCliente(usuario, cliente.toEntity()));
    }

    @DELETE
    @Path("{usuario: [a-zA-Z][a-zA-Z]*}}")
    public void deleteBook(@PathParam("usuario") String usuario) throws BusinessLogicException {
        ClienteEntity entity = clienteLogic.getCliente(usuario);
        if (entity == null) {
            throw new WebApplicationException("El recurso /cliente/" + usuario + " no existe.", 404);
        }
        clienteLogic.deleteCliente(usuario);
    }
    
    private List<ClienteDetailDTO> listClienteEntity2DetailDTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList<>();
        for (ClienteEntity entity : entityList) {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }
}
