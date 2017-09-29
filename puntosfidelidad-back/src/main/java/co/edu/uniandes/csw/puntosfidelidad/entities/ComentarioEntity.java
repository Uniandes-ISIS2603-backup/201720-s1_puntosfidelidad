/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author ja.manrique
 */
@Entity
public class ComentarioEntity implements Serializable{
    
    /**
     * Identificador único del comentario
     */
    @Id
    private Long id;
    /**
     * Contenido del comentario
     */
    private String comentario;
    
    /**
     * calificaciòn del usuario sobre el restaurante
     */
    private Integer calificacion;

    
    /**
     * Relacion con la sucural. Una sucursal puede tener varios comentarios
     */
    @PodamExclude
    @ManyToOne
    private SucursalEntity sucursal;
    
    /**
     * Relación con el cliente. Un cliente puede realizar múltiples comentarios
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    
    /**
     * Relacion con fotos. Cada comentario puede tener una o más fotos
     */
    @PodamExclude
    @OneToMany(mappedBy = "comentario")
    private List<FotoEntity> fotos = new ArrayList<>();

    /**
     * getter de las fotos de un comentario
     * @return colección de fotos del comentario
     */
    public List<FotoEntity> getFotos() {
        return fotos;
    }

    /**
     * Setter de las fotos de un comentario
     * @param fotos nuevas fotos
     */
    public void setFotos(List<FotoEntity> fotos) {
        this.fotos = fotos;
    }

    /**
     * getter de las sucursal
     * @return sucursal del comentario
     */
    public SucursalEntity getSucursal() {
        return sucursal;
    }

    /**
     * setter de Sucursal
     * @param sucursal nueva sucursal
     */
    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * Getter del cliente
     * @return cliente que realizó el comentario
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Setter del cliente
     * @param cliente nuevo cliente
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Getter del ID
     * @return Id asociado al comentario
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter del ID
     * @param id nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter del contenido
     * @return contenido del comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Setter del contenido
     * @param comentario nuevo contenido
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Getter de la puntuación
     * @return puntuación asociada al comentario
     */
    public Integer getCalificacion() {
        return calificacion;
    }
    
    /**
     * Setter de clasificación
     * @param calificacion nueva puntuación
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
    
}
