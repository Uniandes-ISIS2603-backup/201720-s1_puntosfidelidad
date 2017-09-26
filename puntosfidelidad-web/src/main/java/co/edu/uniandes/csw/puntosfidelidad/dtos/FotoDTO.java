/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.FotoEntity;
import java.util.Calendar;

/**
 *
 * @author cass_
 */
public class FotoDTO {
    
    private String url;
    
    /**
     * Constructor vaacío obligatorio para la inicialuzacón con Jax RS 
     */
    public FotoDTO(){
        //Método vacio obligatorio.    
    }
    
    /**
     * Constructor de un FotoDTO a paritir de un FotoEntity
     * @param entity 
     */
       
    public FotoDTO(FotoEntity entity){
        this.url = entity.getURL();
    }
    
    /**
     * Método wue convierte un entity en un DTO 
     */
    public FotoEntity toEntity(){
        FotoEntity entity = new FotoEntity();
        entity.setURL(this.url);;
        return entity;
    }  

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
}
