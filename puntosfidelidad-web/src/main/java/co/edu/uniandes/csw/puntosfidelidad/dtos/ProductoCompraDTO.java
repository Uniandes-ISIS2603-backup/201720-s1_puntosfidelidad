/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoCompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;

/**
 *
 * @author aa.yepes
 */
public class ProductoCompraDTO {
    
    private String nombre;
    
    private Long id;
    
    private String imagen;
    
    private Integer valorDinero;
    
    private Integer valorPuntos;
    
    private String restaurante;
    
    public ProductoCompraDTO(){
        //Método vacio obligatorio.   
    }
    
    public ProductoCompraDTO(ProductoCompraEntity entity){
        if(entity != null){
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.imagen = entity.getImagen();
        this.valorDinero = entity.getValorDinero();
        this.valorPuntos = entity.getValorPuntos();
        this.restaurante = entity.getRestaurante();
        }
    }
    
    public ProductoCompraEntity toEntity(){
        ProductoCompraEntity entity = new ProductoCompraEntity();
        entity.setId(this.getId());
        entity.setNombre(this.getNombre());
        entity.setImagen(this.getImagen());
        entity.setValorDinero(this.getValorDinero());
        entity.setValorPuntos(this.getValorPuntos());
        entity.setRestaurante(this.getRestaurante());
        return entity;
    }  

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }
    
    
    

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
