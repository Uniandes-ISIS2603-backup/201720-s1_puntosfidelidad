/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Cliente cass_
 */
public class ClienteDetailDTO extends ClienteDTO{
    
    private List<RecargaDTO> recargas; 
    
    private List<ComentarioDTO> comentarios;
    
    private List<CompraDTO> compras;
    
    private List<TarjetaDeCreditoDTO> tarjetasDeCredito;
    
    private List<TarjetaPuntosDTO> tarjetasPuntos;
    
    public ClienteDetailDTO(){     
        super();
    }
    
        /**
     * Crea un objeto ClienteDetailDTO a partir de un objeto ClienteEntity
     * incluyendo los atributos de ClienteDTO.
     *
     * @param entity Entidad ClienteEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public ClienteDetailDTO(ClienteEntity entity) {
        super(entity);
        if (entity != null) {
            recargas = new ArrayList<>();
            for (RecargaEntity entityRecarga : entity.getRecargas()) {
                recargas.add(new RecargaDTO(entityRecarga));
            }
            
            comentarios = new ArrayList<>();
            for (ComentarioEntity entityComentarios : entity.getComentarios()) {
                comentarios.add(new ComentarioDTO(entityComentarios));
            }
            
            compras = new ArrayList<>();
            for (CompraEntity entityCompras : entity.getCompras()) {
                compras.add(new CompraDTO(entityCompras));
            }
            
            tarjetasPuntos = new ArrayList<>();
            for (TarjetaPuntosEntity entityTarjetaPuntoss : entity.getTarjetasPuntos()) {
                tarjetasPuntos.add(new TarjetaPuntosDTO(entityTarjetaPuntoss));
            }
            
            tarjetasDeCredito = new ArrayList<>();
            for (TarjetaDeCreditoEntity entityTarjetaDeCredito : entity.getTarjetasDeCredito()) {
                tarjetasDeCredito.add(new TarjetaDeCreditoDTO(entityTarjetaDeCredito));
            }
        }
    }
    
     /**
     * Convierte un objeto ClienteDetailDTO a ClienteEntity incluyendo los
     * atributos de ClienteDTO.
     *
     * @return Nueva objeto ClienteEntity.
     *
     */
    @Override
    public ClienteEntity toEntity() {
        ClienteEntity entity = super.toEntity();
        
        if (getRecargas() != null) {
            List<RecargaEntity> recargasEntity = new ArrayList<>();
            for (RecargaDTO dtoRecarga : getRecargas()) {
                recargasEntity.add(dtoRecarga.toEntity());
            }
            entity.setRecargas(recargasEntity);
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
        
        if (getTarjetasPuntos() != null) {
            List<TarjetaPuntosEntity> tarjetasPuntosEntity = new ArrayList<>();
            for (TarjetaPuntosDTO dtoTarjetaPuntos : getTarjetasPuntos()) {
                tarjetasPuntosEntity.add(dtoTarjetaPuntos.toEntity());
            }
            entity.setTarjetasPuntos(tarjetasPuntosEntity);
        }
        
        if (getTarjetasDeCredito() != null) {
            List<TarjetaDeCreditoEntity> tarjetasDeCreditoEntity = new ArrayList<>();
            for (TarjetaDeCreditoDTO dtoBook : getTarjetasDeCredito()) {
                tarjetasDeCreditoEntity.add(dtoBook.toEntity());
            }
            entity.setTarjetasDeCredito(tarjetasDeCreditoEntity);
        }

        return entity;
    }

    /**
     * @return the recargas
     */
    public List<RecargaDTO> getRecargas() {
        return recargas;
    }

    /**
     * @param recargas the recargas to set
     */
    public void setRecargas(List<RecargaDTO> recargas) {
        this.recargas = recargas;
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

    /**
     * @return the tarjetasDeCredito
     */
    public List<TarjetaDeCreditoDTO> getTarjetasDeCredito() {
        return tarjetasDeCredito;
    }

    /**
     * @param tarjetasDeCredito the tarjetasDeCredito to set
     */
    public void setTarjetasDeCredito(List<TarjetaDeCreditoDTO> tarjetasDeCredito) {
        this.tarjetasDeCredito = tarjetasDeCredito;
    }

    /**
     * @return the tarjetasPuntos
     */
    public List<TarjetaPuntosDTO> getTarjetasPuntos() {
        return tarjetasPuntos;
    }

    /**
     * @param tarjetasPuntos the tarjetasPuntos to set
     */
    public void setTarjetasPuntos(List<TarjetaPuntosDTO> tarjetasPuntos) {
        this.tarjetasPuntos = tarjetasPuntos;
    }

    
}
