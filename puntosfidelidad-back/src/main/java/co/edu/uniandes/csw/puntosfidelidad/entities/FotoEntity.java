/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ja.manrique
 */
@Entity
public class FotoEntity implements Serializable{
 
    @Id
    private String uRL;

    
    @PodamExclude
    @ManyToOne
    private ComentarioEntity comentario;

    public ComentarioEntity getComentario() {
        return comentario;
    }

    public void setComentario(ComentarioEntity comentario) {
        this.comentario = comentario;
    }
    
    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }
    
}
