/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import java.util.Calendar;

/**
 *
 * @author cass_
 */
public class ClienteDTO {
    
    private String usuario;
    
    private String nombre;
    
    private String contrasena;
    
    private String imagen;
    
    public ClienteDTO(){
    
    }
    
    public ClienteDTO(ClienteEntity entity){
        this.usuario = entity.getUsuario();
        this.nombre = entity.getNombre();
        this.contrasena = entity.getContrasena();
        this.imagen = entity.getImagen();
    }
    
    public ClienteEntity toEntity(){
        ClienteEntity entity = new ClienteEntity();
        entity.setContrasena(this.getContrasena());
        entity.setNombre(this.getNombre());
        entity.setImagen(this.getImagen());
        entity.setUsuario(this.getUsuario());
        return entity;
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
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
