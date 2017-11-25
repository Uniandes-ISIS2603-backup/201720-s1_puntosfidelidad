/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import java.io.Serializable;


public class RestauranteDTO implements Serializable{
    
    //Atributo que modela el nit del restaurante
    private String nit;
     //Atributo que modela el nombre del restaurante
    private String nombre;
     //Atributo que modela el tipo de comida del restaurante
    private String tipoComida;
    
    public RestauranteDTO()
    {
        //Constructor vacío (¡¡¡OLBIGATORIO!!!)    
    }
    
    /**
     * Conviertir Entity a DTO
     * Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param entity
     */
    public RestauranteDTO(RestauranteEntity entity)
    {
        if(entity != null){
        this.nit = entity.getNit();
        this.nombre = entity.getNombre();
        this.tipoComida = entity.getTipoComida();
        }
    }
    
    /**
     * Conviertir DTO a Entity
     * Crea un nuevo Entity con los valores que contiene el DTO.
     * @return 
     */
    public RestauranteEntity toEntity()
    {
        RestauranteEntity entity = new RestauranteEntity();
        
        entity.setNit(nit);
        entity.setNombre(nombre);
        entity.setTipoComida(tipoComida);
        
        return entity;
    }

    /**
     * Obtiene el nit del restaurante
     * @return nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * modifica el nit del restaurante
     * @param nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Obtiene el nombre del restaurante
     * @return nit
     */
    public String getNombre() {
        return nombre;
    }
/**
     * modifica el nombre del restaurante
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de comida del restaurante
     * @return nit
     */
    public String getTipoComida() {
        return tipoComida;
    }
/**
     * modifica el ripo de comida del restaurante
     * @param tipoComida
     */
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}