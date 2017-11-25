/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaDeCreditoDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.TarjetaDeCreditoLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
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
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author lv.vanegas10
 */
@Produces("application/json")
@Consumes("application/json")
public class TarjetaDeCreditoResource {

    public static final  String FRASE  = "El recurso /clientes/";
    public static final  String TC_FRASE  = "/tarjetasDeCredito/";
    public static final  String NOEXISTE  = " no existe.";

    @Inject
    TarjetaDeCreditoLogic tarjetaLogic;

    /**
     * Obtiene las tarjetas de un cliente
     * @param usuario
     * @return tarjetas
     * @throws BusinessLogicException
     */
    @GET
    public List<TarjetaDeCreditoDTO> getTarjetasDeCredito(@PathParam("usuario") String usuario) throws BusinessLogicException {
        return listEntity2DTO(tarjetaLogic.getTarjetasDeCredito(usuario));
    }

    /**
     * Obtiene una tarjeta dado un clietne y un id de tarjeta
     * @param usuario
     * @param id
     * @return tarjeta
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public TarjetaDeCreditoDTO getTarjetaDeCredito(@PathParam("usuario") String usuario, @PathParam("id") Long id) throws BusinessLogicException {
        TarjetaDeCreditoEntity entity = tarjetaLogic.getTarjetaDeCredito(usuario, id);
        if (entity == null) {
            throw new WebApplicationException(FRASE + usuario + TC_FRASE + id + NOEXISTE, 404);
        }
        return new TarjetaDeCreditoDTO(entity);
    }

    /**
     * Crea una tarjeta
     * @param usuario
     * @param tarjeta
     * @return tarjeta
     * @throws BusinessLogicException
     */
    @POST
    public TarjetaDeCreditoDTO createTarjetaDeCredito(@PathParam("usuario") String usuario, TarjetaDeCreditoDTO tarjeta) throws BusinessLogicException {
        return new TarjetaDeCreditoDTO(tarjetaLogic.createTarjetaDeCredito(usuario, tarjeta.toEntity()));
    }

    /**
     * Actualiza una tarjeta
     * @param usuario
     * @param id
     * @param tarjeta
     * @return tarjeta
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public TarjetaDeCreditoDTO updateTarjetaDeCredito(@PathParam("usuario") String usuario, @PathParam("id") Long id, TarjetaDeCreditoDTO tarjeta) throws BusinessLogicException {
        tarjeta.setId(id);
        TarjetaDeCreditoEntity entity = tarjetaLogic.getTarjetaDeCredito(usuario, id);
        if (entity == null) {
            throw new WebApplicationException(FRASE + usuario + TC_FRASE + id + NOEXISTE, 404);
        }
        return new TarjetaDeCreditoDTO(tarjetaLogic.updateTarjetaDeCredito(usuario, tarjeta.toEntity()));

    }

    /**
     * Elimina una tarjeta
     * @param usuario
     * @param id
     * @throws BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTarjetaDeCredito(@PathParam("usuario") String usuario, @PathParam("id") Long id) throws BusinessLogicException {
        TarjetaDeCreditoEntity entity = tarjetaLogic.getTarjetaDeCredito(usuario, id);
        if (entity == null) {
            throw new WebApplicationException(FRASE + usuario + TC_FRASE + id + NOEXISTE, 404);
        }
        tarjetaLogic.deleteTarjetaDeCredito(usuario, id);
    }
    
    /**
     * Lista de entidades a DTOS
     * @param entityList
     * @return lista de DTOS
     */
    private List<TarjetaDeCreditoDTO> listEntity2DTO(List<TarjetaDeCreditoEntity> entityList) {
        List<TarjetaDeCreditoDTO> list = new ArrayList<>();
        for (TarjetaDeCreditoEntity entity : entityList) {
            list.add(new TarjetaDeCreditoDTO(entity));
        }
        return list;
    }
}
