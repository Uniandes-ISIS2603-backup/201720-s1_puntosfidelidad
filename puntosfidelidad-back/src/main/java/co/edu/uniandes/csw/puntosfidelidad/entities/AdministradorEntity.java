/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.cespedes10
 */
@Entity
public class AdministradorEntity implements Serializable {
    
    @Id
    private String usuario; 
    
    private String contrasena; 
    
    @PodamExclude
    @OneToMany(mappedBy = "administrador")
    private List<RestauranteEntity> restaurantes = new ArrayList<>();

   

    public List<RestauranteEntity> getRestaurantes() {
        return restaurantes;
    }

     public RestauranteEntity getRestaurante(String nit) {
         
       for(int i=0;i<restaurantes.size();i++){
           RestauranteEntity res=restaurantes.get(i);
         if(res.getNit()==nit)
           return res;
       }
        return null;
    }
    
    
    public void setRestaurantes(List<RestauranteEntity> restaurantes) {
        this.restaurantes = restaurantes;
    }

    

    
    
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }   

   
}