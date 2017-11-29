/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author aa.yepes
 */
@Entity
public class ProductoEntity implements Serializable {

    @Id
    private Long id;
    private String nombre;
    private String imagen;
    private int valorDinero;
    private int valorPuntos;
    
    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorDinero() {
        return valorDinero;
    }

    public void setValorDinero(int valorDinero) {
        this.valorDinero = valorDinero;
    }

    public int getValorPuntos() {
        return valorPuntos;
    }

    public void setValorPuntos(int valorPuntos) {
        this.valorPuntos = valorPuntos;
    }
}