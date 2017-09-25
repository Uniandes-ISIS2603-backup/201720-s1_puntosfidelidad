/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;

/**
 *
 * @author ja.manrique
 */
public class RestauranteDetailDTO extends RestauranteDTO{
    
    public RestauranteDetailDTO()
    {
        
    }
    
    public RestauranteEntity toEntity()
    {
        //Completar conr elaciones
        return new RestauranteEntity();                
    }
    /*
    
        Relaciones como atributos. Getters/setters
    
    */
}
