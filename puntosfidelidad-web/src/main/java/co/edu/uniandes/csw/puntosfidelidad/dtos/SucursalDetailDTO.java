/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cass_
 */
public class SucursalDetailDTO extends SucursalDTO{
    
    private RestauranteDTO restaurante; 
    
    private UbicacionDTO ubicacion;
    
    private List<ComentarioDTO> comentarios;
    
    private List<CompraDTO> compras;
    
    public SucursalDetailDTO(){     
        super();        
    }
    
        /**
     * Crea un objeto SucursalDetailDTO a partir de un objeto SucursalEntity
     * incluyendo los atributos de SucursalDTO.
     *
     * @param entity Entidad SucursalEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public SucursalDetailDTO(SucursalEntity entity) {
        
        super(entity);
        
        if (entity != null) {
            
            restaurante = new RestauranteDTO(entity.getRestaurante());
            
            ubicacion = new UbicacionDTO(entity.getUbicacion());
            
            compras = new ArrayList<>();
            for (CompraEntity entityCompra : entity.getCompras()) {
                compras.add(new CompraDTO(entityCompra));
            }
            
            comentarios = new ArrayList<>();
            for (ComentarioEntity entityComentario : entity.getComentarios()) {
                comentarios.add(new ComentarioDTO(entityComentario));
            }
        }
    }
    
     /**
     * Convierte un objeto SucursalDetailDTO a SucursalEntity incluyendo los
     * atributos de SucursalDTO.
     *
     * @return Nueva objeto SucursalEntity.
     *
     */
    @Override
    public SucursalEntity toEntity() {
        SucursalEntity entity = super.toEntity();
        
        if (getRestaurante() != null) {
            entity.setRestaurante(getRestaurante().toEntity());
        }
        
        if (getUbicacion() != null) {
            entity.setUbicacion(getUbicacion().toEntity());
        }
        
        if (getComentarios() != null) {
            List<ComentarioEntity> comentariosEntity = new ArrayList<>();
            for (ComentarioDTO dtoComentario : getComentarios()) {
                comentariosEntity.add(dtoComentario.toEntity());
            }
            entity.setComentarios(comentariosEntity);
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
     * @return the restaurante
     */
    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    /**
     * @param restaurante the restaurante to set
     */
    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * @return the ubicacion
     */
    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the comentarios
     */
    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
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
    
    
}
