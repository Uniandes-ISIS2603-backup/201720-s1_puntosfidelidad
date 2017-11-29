/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoCompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cass_
 */
public class CompraDetailDTO extends CompraDTO{
    
    private ClienteDTO cliente; 
    
    private SucursalDTO sucursal;
    
    private TarjetaPuntosDTO tarjetaPuntos;
    
    private List<ProductoCompraDTO> productos;
    
    public CompraDetailDTO(){     
        super();
    }
    
        /**
     * Crea un objeto CompraDetailDTO a partir de un objeto CompraEntity
     * incluyendo los atributos de CompraDTO.
     *
     * @param entity Entidad CompraEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public CompraDetailDTO(CompraEntity entity) {
        
        super(entity);
        
        if (entity != null) {
            
            cliente = new ClienteDTO(entity.getCliente());
            
            sucursal = new SucursalDTO(entity.getSucursal());
            
            tarjetaPuntos = new TarjetaPuntosDTO(entity.getTarjetaPuntos());
            
            productos = new ArrayList<>();
            for (ProductoCompraEntity entityProducto : entity.getProductos()) {
                productos.add(new ProductoCompraDTO(entityProducto));
            }
        }
    }
    
     /**
     * Convierte un objeto CompraDetailDTO a CompraEntity incluyendo los
     * atributos de CompraDTO.
     *
     * @return Nueva objeto CompraEntity.
     *
     */
    @Override
    public CompraEntity toEntity() {
        CompraEntity entity = super.toEntity();
        
        if (getCliente() != null) {            
            entity.setCliente(getCliente().toEntity());
        }
        
        if (getSucursal() != null) {            
            entity.setSucursal(getSucursal().toEntity());
        }
        
        if (getProductos() != null) {
            List<ProductoCompraEntity> productosEntity = new ArrayList<>();
            for (ProductoCompraDTO dtoProducto : getProductos()) {
                productosEntity.add(dtoProducto.toEntity());
            }
            entity.setProductos(productosEntity);
        }

        return entity;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the sucursal
     */
    public SucursalDTO getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the tarjetaPuntos
     */
    public TarjetaPuntosDTO getTarjetaPuntos() {
        return tarjetaPuntos;
    }

    /**
     * @param tarjetaPuntos the tarjetaPuntos to set
     */
    public void setTarjetaPuntos(TarjetaPuntosDTO tarjetaPuntos) {
        this.tarjetaPuntos = tarjetaPuntos;
    }

    /**
     * @return the productos
     */
    public List<ProductoCompraDTO> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<ProductoCompraDTO> productos) {
        this.productos = productos;
    }
    
    
}
