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
        //Método vacio obligatorio.   
    }
    
    public ProductoDTO(ProductoEntity entity){
        if(entity != null){
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.valorDinero = entity.getValorDinero();
        this.valorPuntos = entity.getValorPuntos();
        }
    }
    
    public ProductoEntity toEntity(){
        ProductoEntity entity = new ProductoEntity();
        entity.setId(this.getDTOId());
        entity.setNombre(this.getDTONombre());
        entity.setValorDinero(this.getDTOValorDinero());
        entity.setValorPuntos(this.getDTOValorPuntos());
        return entity;
    }  

    /**
     * @return the nombre
     */
    public String getDTONombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setDTONombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public Long getDTOId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setDTOId(Long id) {
        this.id = id;
    }

    /**
     * @return the valorDinero
     */
    public Integer getDTOValorDinero() {
        return valorDinero;
    }

    /**
     * @param valorDinero the valorDinero to set
     */
    public void setDTOValorDinero(Integer valorDinero) {
        this.valorDinero = valorDinero;
    }

    /**
     * @return the valorPuntos
     */
    public Integer getDTOValorPuntos() {
        return valorPuntos;
    }

    /**
     * @param valorPuntos the valorPuntos to set
     */
    public void setDTOValorPuntos(Integer valorPuntos) {
        this.valorPuntos = valorPuntos;
    }

}
