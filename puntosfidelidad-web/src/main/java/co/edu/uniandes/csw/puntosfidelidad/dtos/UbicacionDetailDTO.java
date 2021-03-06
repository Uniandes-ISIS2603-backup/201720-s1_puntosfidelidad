/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;




/**
 *
 * @author cass_
 */
public class UbicacionDetailDTO extends UbicacionDTO{
    
    private EventoDTO evento;
    
    private SucursalDTO sucursal;    
    
    public UbicacionDetailDTO(){     
        super();
    }
    
        /**
     * Crea un objeto UbicacionDetailDTO a partir de un objeto UbicacionEntity
     * incluyendo los atributos de UbicacionDTO.
     *
     * @param entity Entidad UbicacionEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public UbicacionDetailDTO(UbicacionEntity entity) {
        
        super(entity);
    }
    
     /**
     * Convierte un objeto UbicacionDetailDTO a UbicacionEntity incluyendo los
     * atributos de UbicacionDTO.
     *
     * @return Nueva objeto UbicacionEntity.
     *
     */
    @Override
    public UbicacionEntity toEntity() {
        return super.toEntity();
    }

    /**
     * @return the evento
     */
    public EventoDTO getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(EventoDTO evento) {
        this.evento = evento;
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
    
    
}
