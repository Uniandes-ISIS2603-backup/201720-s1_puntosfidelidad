/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import java.io.Serializable;

/**
 *
 * @author ja.manrique
 */
public class RestauranteDTO implements Serializable{
    
    private String nit;
    private String nombre;
    private String tipoComida;
    
    //Constructor vacío (¡¡¡OLBIGATORIO!!!)
    public RestauranteDTO()
    {
        
    }
    
    /**
     * Conviertir Entity a DTO
     * Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     */
    public RestauranteDTO(RestauranteEntity entity)
    {
        this.nit = entity.getNit();
        this.nombre = entity.getNombre();
        this.tipoComida = entity.getTipoComida();
    }
    
    /**
     * Conviertir DTO a Entity
     * Crea un nuevo Entity con los valores que contiene el DTO.
     */
    public RestauranteEntity toEntity()
    {
        RestauranteEntity entity = new RestauranteEntity();
        
        entity.setNit(nit);
        entity.setNombre(nombre);
        entity.setTipoComida(tipoComida);
        
        return entity;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}