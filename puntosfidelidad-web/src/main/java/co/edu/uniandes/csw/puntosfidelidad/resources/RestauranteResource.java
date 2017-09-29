/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.resources;

import co.edu.uniandes.csw.puntosfidelidad.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.EventoDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.EventoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.ProductoDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.ProductoDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.RestauranteDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.SucursalDTO;
import co.edu.uniandes.csw.puntosfidelidad.dtos.SucursalDetailDTO;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
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
 * @author s.cespedes10
 */

@Path("restaurantes")
@Produces("application/json")
@Consumes("application/json")
public class RestauranteResource {
    
   @Inject
    RestauranteLogic logic;
    
     
    
     /**
     * Obtiene una colección de instancias de restauranteDetailDTO 
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * 
     */
     @GET
    public List<RestauranteDetailDTO> getRestaurantes(){
        return restauranteListEntity2DTO(logic.getRestaurantes());
    }
    
     /**
     * Obtiene una colección de instanciaa de RestauranteDetailDTO asociadas a una
     *
     * @param id Identificador de la instancia de Cliente
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * 
     */
    @GET
    @Path("{id}")
    public RestauranteDetailDTO getRestaurante(@PathParam("id") String id){
        return new RestauranteDetailDTO(logic.getRestaurante(id));
    }
    
    
    /**
     * Obtiene una colección de instancia de SucursaleslDTO asociadas a un Restaurante
     *
     * @param usuario Identificador de la instancia de Restaurante
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * 
     */
    @GET
    @Path("{usuario}/sucursales")
    public List<SucursalDTO> getRestauranteSucursales(@PathParam("usuario") String usuario)
    {
        return sucursalListEntityToDTO(logic.getRestaurante(usuario).getSucursales());
   
    
    }
   
    
    /**
     * Obtiene una colección de instancia de RestauranteDetailDTO asociadas a una
     *
     * @param nit
     * @param sucursalId
     * @return Colección de instancias de RestauranteDetailDTO asociadas a la
     * 
     */
    
     @GET
    @Path("{nit}/sucursales/{sucursalId: \\d+}")
    public SucursalDetailDTO getRestauranteSucursal(@PathParam("nit") String nit, @PathParam("sucursalId") Long sucursalId) {
        return new SucursalDetailDTO(logic.getSucursal(nit, sucursalId));
    }
    
    
     /**
     * Asocia un Evento existente a un Restaurante
     *
     * @param nit Identificador de la instancia de Cliente
     * @param SucursalId Identificador de la instancia de Compra
     * @return Instancia de CompraDetailDTO que fue asociada a Cliente
     * 
     */
    
    @POST
    @Path("{nit}/{SucursalId: \\d+}/sucursales")
    public SucursalDetailDTO addSucursal(@PathParam("nit") String nit, @PathParam("SucursalId") Long SucursalId) {
        return new SucursalDetailDTO(logic.addSucursales(nit, SucursalId));
    }
    
      /**
     * Remplaza las instancias de Sucursales asociadas a una instancia de Restaurante
     * @return Nueva colección de CompraDTO asociada a la instancia de Cliente
     * 
     */
   
     @PUT
     @Path("{nit}/sucursales")
    public List<SucursalDTO> replaceSucursales(@PathParam("nit") String nit, List<SucursalDetailDTO> sucursal) {
        return sucursalListEntityToDTO(logic.replaceSucursales(nit, sucursalListDTO2Entity(sucursal)));
    }
    
    
    /**
     * Desasocia una Sucursal existente de un Restaurante existente
     *
     * @param nit Identificador de la instancia de Restaurante
     * @param SucursalId Identificador de la instancia de Sucursal
     * 
     */
    @DELETE
    @Path("{nit}/{SucursalId: \\d+}")
    public void removeSucursal(@PathParam("nit") String usuario, @PathParam("SucursalId") Long SucursalId) {
        logic.removeSucursales(usuario, SucursalId);
    }
    
    
  
    /**
     * Obtiene una colección de instancias de ProductolDTO asociadas a una
     * instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Cliente
     * @return Colección de instancias de CompraDetailDTO asociadas a la
     * instancia de Cliente
     * 
     */
    @GET
    @Path("{usuario}/productos")
    public List<ProductoDTO> listProducto(@PathParam("usuario") String usuario) throws BusinessLogicException {  
            return productoListEntityToDTO(logic.listProductos(usuario)); 
    }
   
    
    /**
     * Obtiene una instancia de Producto asociada a una instancia de Restaurante
     *
     * @param nit Identificador de la instancia de Cliente
     * @param productosId Identificador de la instancia de Compra
     * @return 
     * 
     */
    @GET
    @Path("{nit}/productos/{productoId: \\d+}")
    public ProductoDetailDTO getProducto(@PathParam("nit") String nit, @PathParam("productosId") Long productosId) {
        return new ProductoDetailDTO(logic.getProducto(nit, productosId));
    }
    
    
     /**
     * Asocia un Evento existente a un Restaurante
     *
     * @param nit Identificador de la instancia de Cliente
     * @param productoId Identificador de la instancia de Compra
     * @return Instancia de CompraDetailDTO que fue asociada a Cliente
     * 
     */
     @POST
    @Path("{nit}/{productoId: \\d+}")
    public ProductoDetailDTO addProducto(@PathParam("nit") String nit, @PathParam("productoId") Long productoId) {
        return new ProductoDetailDTO(logic.addProducto(nit, productoId));
    }

    /**
     * Remplaza las instancias de Compra asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param compras Colección de instancias de CompraDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de CompraDTO asociada a la instancia de Cliente
     * 
     */
    @PUT
    @Path("{nit}/productos")
    public List<ProductoDTO> replaceProducto(@PathParam("nit") String nit, List<ProductoDetailDTO> productos) {
        return productoListEntityToDTO(logic.replaceProductos(nit, productosListDTO2Entity(productos)));
    }

    /**
     * Desasocia un Compra existente de un Cliente existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comprasId Identificador de la instancia de Compra
     * 
     */
    @DELETE
    @Path("{nit}/productos/{productosId: \\d+}")
    public void removeProducto(@PathParam("nit") String nit, @PathParam("productosId") Long comprasId) {
        logic.removeProductos(nit, comprasId);
    }
    
    
    /**
     * Obtiene una colección de instancias de ProductolDTO asociadas a una
     * instancia de Restaurante
     *
     * @param usuario Identificador de la instancia de Cliente
     * @return Colección de instancias de CompraDetailDTO asociadas a la
     * instancia de Cliente
     * 
     */
    @GET
    @Path("{nit}/eventos")
    public List<EventoDTO> listEvento(@PathParam("nit") String nit) throws BusinessLogicException {  
            return eventoListEntityToDTO(logic.listEventos(nit)); 
    }
   
    
    /**
     * Obtiene una instancia de Producto asociada a una instancia de Restaurante
     *
     * @param nit Identificador de la instancia de Cliente
     * @param eventoId Identificador de la instancia de Compra
     * @return 
     * 
     */
    @GET
    @Path("{nit}/eventos/{eventoId: \\d+}")
    public EventoDetailDTO getEvento(@PathParam("nit") String nit, @PathParam("eventoId") String eventoId) {
        return new EventoDetailDTO(logic.getEvento(nit, eventoId));
    }
    
    /**
     * Asocia un Evento existente a un Restaurante
     *
     * @param nit Identificador de la instancia de Cliente
     * @param eventoId Identificador de la instancia de Compra
     * @return Instancia de CompraDetailDTO que fue asociada a Cliente
     * 
     */
     @POST
    @Path("{eventoId: \\d+}")
    public EventoDetailDTO addEvento(@PathParam("nit") String nit, @PathParam("eventoId") String eventoId) {
        return new EventoDetailDTO(logic.addEvento(nit, eventoId));
    }

    /**
     * Remplaza las instancias de Compra asociadas a una instancia de Cliente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param compras Colección de instancias de CompraDTO a asociar a instancia
     * de Cliente
     * @return Nueva colección de CompraDTO asociada a la instancia de Cliente
     * 
     */
    @PUT
    public List<EventoDTO> replaceEvento(@PathParam("nit") String nit, List<EventoDetailDTO> eventos) {
        return eventoListEntityToDTO(logic.replaceEventos(nit, eventoListDTO2Entity(eventos)));
    }

    /**
     * Desasocia un Evento existente de un Restaurante existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param EventosId Identificador de la instancia de Compra
     * 
     */
    @DELETE
    @Path("{nit}/eventos/{eventosId: \\d+}")
    public void removeEvento(@PathParam("nit") String nit, @PathParam("eventosId") String eventosId) {
        logic.removeEventos(nit, eventosId);
    }
    
    
    
    
  @PUT
    @Path("{id: //d+}")
    public RestauranteDetailDTO putRestaurante(@PathParam("id") String id){
        return new RestauranteDetailDTO(logic.getRestaurante(id));
    }
      
   
    
    /**
     * Crea un Restaurante
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param comprasId Identificador de la instancia de Compra
     * @return Instancia de CompraDetailDTO que fue asociada a Cliente
     * 
     */
    
    @POST
    public RestauranteDetailDTO postRestaurante( RestauranteDetailDTO restaurante) throws BusinessLogicException{      
            return new RestauranteDetailDTO(logic.createRestaurante(restaurante.toEntity()));      
    }
    
    /**
     * Desasocia un Evento existente de un Restaurante existente
     *
     * @param usuario Identificador de la instancia de Cliente
     * @param EventosId Identificador de la instancia de Compra
     * 
     */
    @DELETE
    @Path("{id: //d+}")
    public void deleteRestaurante(@PathParam("id") String id) throws BusinessLogicException{
        
       RestauranteEntity ubi = logic.getRestaurante(id);
        if(ubi == null){
            throw new WebApplicationException("El recurso /sucursales/" + id + " no existe.", 404);
        }
        
        logic.removeRestaurante(id);            
    }
    
    /**
     * Convierte una lista de Entity a una lista de DetailDTO.
     *
     * @param entityList Lista de SucursalEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     */
    private List<SucursalDTO> sucursalListEntityToDTO(List<SucursalEntity> entities)
    {
        List<SucursalDTO> DTOList = new ArrayList<>();
        
        for(SucursalEntity entity : entities)
        {
            DTOList.add(new SucursalDTO(entity));
        }      
        return DTOList;
    }
    
     /**
     * Convierte una lista de DetailDTO a una lista de Entity.
     *
     * @param dtos Lista de SucursalDetailDTO a convertir.
     * @return Lista de SucursalEntity convertida.    
     */
    private List<SucursalEntity> sucursalListDTO2Entity(List<SucursalDetailDTO> dtos) {
        List<SucursalEntity> list = new ArrayList<>();
        for (SucursalDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    
    /**
     * Convierte una lista de Entity a una lista de DetailDTO.
     *
     * @param entityList Lista de SucursalEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     */
    private List<ProductoDTO> productoListEntityToDTO(List<ProductoEntity> entities)
    {
        List<ProductoDTO> DTOList = new ArrayList<>();
        
        for(ProductoEntity entity : entities)
        {
            DTOList.add(new ProductoDTO(entity));
        }      
        return DTOList;
    }
    
     /**
     * Convierte una lista de DetailDTO a una lista de Entity.
     *
     * @param dtos Lista de SucursalDetailDTO a convertir.
     * @return Lista de SucursalEntity convertida.    
     */
    private List<ProductoEntity> productosListDTO2Entity(List<ProductoDetailDTO> dtos) {
        List<ProductoEntity> list = new ArrayList<>();
        for (ProductoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    
    /**
     * Convierte una lista de Entity a una lista de DetailDTO.
     *
     * @param entityList Lista de SucursalEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     */
     private List<EventoDTO> eventoListEntityToDTO(List<EventoEntity> entities)
    {
        List<EventoDTO> DTOList = new ArrayList<>();
        
        for(EventoEntity entity : entities)
        {
            DTOList.add(new EventoDTO(entity));
        }      
        return DTOList;
    }
    
     /**
     * Convierte una lista de DetailDTO a una lista de Entity.
     *
     * @param dtos Lista de SucursalDetailDTO a convertir.
     * @return Lista de SucursalEntity convertida.    
     */
    private List<EventoEntity> eventoListDTO2Entity(List<EventoDetailDTO> dtos) {
        List<EventoEntity> list = new ArrayList<>();
        for (EventoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Convierte una lista de RestauranteEntity a una lista de SucursalDetailDTO.
     *
     * @param entityList Lista de SucursalEntity a convertir.
     * @return Lista de SucursalDetailDTO convertida.
     */
    private List<RestauranteDetailDTO> restauranteListEntity2DTO(List<RestauranteEntity> entityList){
        List<RestauranteDetailDTO> list = new ArrayList<>();
        for (RestauranteEntity entity : entityList) {
            list.add(new RestauranteDetailDTO(entity));
        }
        return list;
    } 
    
    /**
     * Convierte una lista de RestauranteDetailDTO a una lista de RestauranteEntity.
     *
     * @param dtos Lista de SucursalDetailDTO a convertir.
     * @return Lista de SucursalEntity convertida.    
     */
    private List<RestauranteEntity> restaurantesListDTO2Entity(List<RestauranteDetailDTO> dtos){
        List<RestauranteEntity> list = new ArrayList<>();
        for (RestauranteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    
    
    
}
    