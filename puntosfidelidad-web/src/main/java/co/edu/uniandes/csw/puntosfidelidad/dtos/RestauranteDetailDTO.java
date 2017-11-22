/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import java.util.ArrayList;
import java.util.List;


public class RestauranteDetailDTO extends RestauranteDTO{
    
    //Lista de sucursales
    private List<SucursalDTO> sucursales; 
    //Lista de eventos
    private List<EventoDTO> eventos;
    //Lista de productos
    private List<ProductoDTO> productos;

    // Contructor 'vacío'
    public RestauranteDetailDTO()
    {
        super();
    }

    /**
     * Crea un objeto RestaureanteDetailDTO a partir de un objetoRestauranteEntity
     * incluyendo los atributos de ClienteDTO.
     *
     * @param entity Entidad RestauranteEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public RestauranteDetailDTO(RestauranteEntity entity)
    {
        super(entity);
        
         if (entity != null) {
            sucursales = new ArrayList<>();
            for (SucursalEntity entitySucursal : entity.getSucursales()) {
                sucursales.add(new SucursalDTO(entitySucursal));
            }
            
            productos = new ArrayList<>();
            for (ProductoEntity entityProductos : entity.getProductos()) {
                productos.add(new ProductoDTO(entityProductos));
            }
            
            eventos = new ArrayList<>();
            for (EventoEntity entityEvento : entity.getEventos()) {
                eventos.add(new EventoDTO(entityEvento));
            }
            
         }    
    }

     /**
     *Obtiene la lista de sucursales
     *
     * @return 
     */
    public List<SucursalDTO> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalDTO> sucursales) {
        this.sucursales = sucursales;
    }
     /**
     *Obtiene la lista de eventos
     *
     * @return 
     */
    public List<EventoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDTO> eventos) {
        this.eventos = eventos;
    }

    /**
     *Obtiene la lista de productos
     *
     * @return 
     */    
    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
    
    /**
     * Convierte un objeto ClienteDetailDTO a ClienteEntity incluyendo los
     * atributos de ClienteDTO.
     *
     * @return Nueva objeto RestauranteEntity.
     *
     */
     @Override
    public RestauranteEntity toEntity()
    {
        RestauranteEntity entity= super.toEntity();
        
         if (getSucursales() != null) {
            List<SucursalEntity> sucursalesEntity = new ArrayList<>();
            for(SucursalDTO dtoSucursal : getSucursales()) {
                sucursalesEntity.add(dtoSucursal.toEntity());
            }
            entity.setSucursales(sucursalesEntity);
        }
        
        if (getProductos() != null) {
            List<ProductoEntity> comentariosEntity = new ArrayList<>();
            for (ProductoDTO dtoComentario : getProductos()) {
                comentariosEntity.add(dtoComentario.toEntity());
            }
            entity.setProductos(comentariosEntity);
        }
        
        if (getEventos() != null) {
            List<EventoEntity> eventosEntity = new ArrayList<>();
            for (EventoDTO dtoEvento : getEventos()) {
                eventosEntity.add(dtoEvento.toEntity());
            }
            entity.setEventos(eventosEntity);
        }
        
        
        return entity;                
    }
   
}