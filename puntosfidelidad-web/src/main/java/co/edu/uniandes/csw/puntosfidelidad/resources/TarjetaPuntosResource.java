/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.TarjetaPuntosDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.TarjetaPuntosLogic;
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
    
    @Inject
    TarjetaPuntosLogic logic;
    
    @GET
    public List<TarjetaPuntosDetailDTO> getTarjetas()
    {
        return ListEntityToDetailDTO(logic.getTarjetasPuntos());
    }
    
    @GET
    @Path("{id: \\d+}")
    public TarjetaPuntosDetailDTO getTarjeta(@PathParam("id") Long id)
    {
        
        return new TarjetaPuntosDetailDTO(logic.getTarjetaPuntos(id));
    }
    
    @GET
    @Path("{id: \\d+}/compras")
    public List<CompraDetailDTO> getCompras(@PathParam("id") Long id)
    {
        return compraListEntityToDetailDTO(logic.getCompras(id));
    }
    
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
