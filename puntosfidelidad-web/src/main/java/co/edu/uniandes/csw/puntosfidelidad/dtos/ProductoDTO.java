/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import java.io.Serializable;

/**
 *
 * @author cass_
 */
public class ProductoDTO implements Serializable{
    
       
    private String nombre;
    
    private Long id;
    
    private Integer valorDinero;
    
    private Integer valorPuntos;
    
    public ProductoDTO(){
    
    }
    
    public ProductoDTO(ProductoEntity entity){
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.valorDinero = entity.getValorDinero();
        this.valorPuntos = entity.getValorPuntos();
    }
    
    public ProductoEntity toEntity(){
        ProductoEntity entity = new ProductoEntity();
        entity.setId(this.getId());
        entity.setNombre(this.getNombre());
        entity.setValorDinero(this.getValorDinero());
        entity.setValorPuntos(this.getValorPuntos());
        return entity;
    }  

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the valorDinero
     */
    public Integer getValorDinero() {
        return valorDinero;
    }

    /**
     * @param valorDinero the valorDinero to set
     */
    public void setValorDinero(Integer valorDinero) {
        this.valorDinero = valorDinero;
    }

    /**
     * @return the valorPuntos
     */
    public Integer getValorPuntos() {
        return valorPuntos;
    }

    /**
     * @param valorPuntos the valorPuntos to set
     */
    public void setValorPuntos(Integer valorPuntos) {
        this.valorPuntos = valorPuntos;
    }

}
