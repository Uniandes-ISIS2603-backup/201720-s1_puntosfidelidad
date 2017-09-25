/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja.manrique
 */
public class TarjetaPuntosDetailDTO extends TarjetaPuntosDTO{
    
    private List<CompraDTO> compras;
    
    private ClienteDTO cliente;  
    
    public TarjetaPuntosDetailDTO(){     
        super();
    }
    
        /**
     * Crea un objeto TarjetaPuntosDetailDTO a partir de un objeto TarjetaPuntosEntity
     * incluyendo los atributos de TarjetaPuntosDTO.
     *
     * @param entity Entidad TarjetaPuntosEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public TarjetaPuntosDetailDTO(TarjetaPuntosEntity entity) {
        
        super(entity);
        
        if (entity != null) {
            
            cliente = new ClienteDTO(entity.getCliente());
            
            compras = new ArrayList<>();
            for (CompraEntity entityCompra : entity.getCompras()) {
                compras.add(new CompraDTO(entityCompra));
            }
        }
    }
    
     /**
     * Convierte un objeto TarjetaPuntosDetailDTO a TarjetaPuntosEntity incluyendo los
     * atributos de TarjetaPuntosDTO.
     *
     * @return Nueva objeto TarjetaPuntosEntity.
     *
     */
    @Override
    public TarjetaPuntosEntity toEntity() {
        TarjetaPuntosEntity entity = super.toEntity();
        
        if (getCliente() != null) {
            entity.setCliente(getCliente().toEntity());
        }
        
        if (getCompras() != null) {
            List<CompraEntity> comprasEntity = new ArrayList<>();
            for (CompraDTO dtoCompra : getCompras()) {
                comprasEntity.add(dtoCompra.toEntity());
            }
            entity.setCompras(comprasEntity);
        }

        return entity;
    }

    /**
     * @return the compras
     */
    public List<CompraDTO> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraDTO> compras) {
        this.compras = compras;
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
    
    
    
}
