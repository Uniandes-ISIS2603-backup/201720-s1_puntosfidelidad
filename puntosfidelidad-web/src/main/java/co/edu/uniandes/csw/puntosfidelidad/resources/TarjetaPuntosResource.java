/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ClienteLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.TarjetaPuntosLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ja.manrique
 */
@Path("tarjetasPuntos")
@Produces("application/json")
public class TarjetaPuntosResource {
    
    /**
     * Inyeccion de dependencias de la lógica
     */
    @Inject
    TarjetaPuntosLogic logic;
    
    @Inject
    ClienteLogic clienteLogic;
    
    /**
     * Método que retorna todas las tarjetas depuntos del sistema
     * @return coleacción de tarjetaPuntosDetailDTO 
     */
    @GET
    public List<TarjetaPuntosDetailDTO> getTarjetas()
    {
        return ListEntityToDetailDTO(logic.getTarjetasPuntos());
    }
    
    /**
     * Endpoint encargado de retornar una tarjeta de puntos específica
     * @param id identificador de la tarjeta de puntos a consultar
     * @return error 404 si no exitse una tarjeta con el id, retorna la información de la tarjeta de lo contrario
     */
    @GET
    @Path("{id: \\d+}")
    public TarjetaPuntosDetailDTO getTarjeta(@PathParam("id") Long id)
    {        
        TarjetaPuntosEntity ent = logic.getTarjetaPuntos(id);
        if(ent == null)
              throw new WebApplicationException("no existe ningúna tarjeta puntos con el id " + id, 404);
        else
            return new TarjetaPuntosDetailDTO(logic.getTarjetaPuntos(id));
    }
    
    /**
     * Método encargado de retornar las compras de una tarjetaPuntos especìfica
     * @param id identificador de la tarjeta puntos a consultar
     * @return colección de las compras hechas con una tarjeta puntos. Si la tarjeta no existe retorna un mensaje de error con el estado 404
     */
    @GET
    @Path("{id: \\d+}/compras")
    public List<CompraDetailDTO> getCompras(@PathParam("id") Long id)
    {
        return compraListEntityToDetailDTO(logic.getCompras(id));
    }
    
    //Los demás métodos rest están desde la clase que las contiene (toca crearlas desde allá)
    //Cliente resource [ver API]    
    @POST    
    public TarjetaPuntosDetailDTO createTarjetaPuntos(@PathParam("usuario") String usuario,TarjetaPuntosDetailDTO tarjetaNueva )
    {
        ClienteEntity cliente= clienteLogic.getCliente(usuario);
        TarjetaPuntosEntity tarjeta= tarjetaNueva.toEntity();
        tarjeta.setCliente(cliente);        
        List lista= cliente.getTarjetasPuntos();
        lista.add(tarjeta);
        cliente.setTarjetasPuntos(lista);
        return new TarjetaPuntosDetailDTO(logic.createTarjetaPuntos(tarjeta));
    }    
    
    /**
     * Método privado que convierte de una lista de entities de TarjetasPuntos a su representación DetailDTO
     * @param entities colección de entities a convertir a DetailDTO
     * @return colección de DetailDTOS generados
     */
    private List<TarjetaPuntosDetailDTO> ListEntityToDetailDTO(List<TarjetaPuntosEntity> entities)
    {
        List<TarjetaPuntosDetailDTO> DTOList = new ArrayList<>();
        
        for(TarjetaPuntosEntity entity: entities)
        {
            //Convierto el entity con el constructor del DTO
            DTOList.add(new TarjetaPuntosDetailDTO(entity));
        }
        
        return DTOList;
    }
    
    /**
     * Método privado que convierte de una lista de entities de Compra a su representación DetailDTO
     * @param entities colección de entities a convertir a DetailDTO
     * @return colección de DetailDTOS generados
     */
    private List<CompraDetailDTO> compraListEntityToDetailDTO(List<CompraEntity> entities)
    {
        List<CompraDetailDTO> DTOList = new ArrayList<>();
        
        for(CompraEntity entity: entities)
        {
            //Convierto el entity con el constructor del DTO
            DTOList.add(new CompraDetailDTO(entity));
        }
        
        return DTOList;
    }
}
