/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;

/**
 *
 * @author cass_
 */
public class ComentarioDTO {
    
    private Long id;
    
    private String comentario;
    
    private Integer calificacion;
    
    /**
     * Constructir de comentarioDTO a partir de un Entity 
     */
    public ComentarioDTO(ComentarioEntity entity){
        this.id = entity.getId();
        this.comentario = entity.getComentario();
        this.calificacion = entity.getCalificacion();
    }
    
    /**
     * Constructor vacío para inicialización de JaxRS
     */
    public ComentarioDTO()
    {
        //Método vacio obligatorio.
    }
    
    /**
     * Método que convierte un ComentarioDTO en un entityDTO 
     */
    public ComentarioEntity toEntity(){
        ComentarioEntity entity = new ComentarioEntity();
        entity.setComentario(this.getComentario());
        entity.setId(this.getId());
        entity.setCalificacion(this.getCalificacion());
        return entity;
    }  

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
    
    
}
