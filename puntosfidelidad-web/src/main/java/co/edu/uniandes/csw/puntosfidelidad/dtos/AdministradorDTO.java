/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import java.io.Serializable;

/**
 * DTO = Objeto de transferencia de datos. 
 * Los DTO contienen las represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * 
 * Por esta razón solamente contienen atributos, getters, setters
 * y métodos para convertirlos en Entities/Crearlos a partir de Entities
 * (Seguir el UML/Entity y la documentación para la creación de los DTO's)
 */
public class AdministradorDTO implements Serializable{
    
    //Atributo de usuario 
    private String usuario;
    
    //Atributo de la contrsaeña del administrador
    private String contrasena;

    //Constructor vacío (¡¡¡OLBIGATORIO!!!)
    public AdministradorDTO()
    {
        
    }
    
    /**
     * Conviertir Entity a DTO
     * Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param administrador
     */
    public AdministradorDTO(AdministradorEntity administrador) {
        if(administrador != null){
        this.usuario = administrador.getUsuario();
        this.contrasena = administrador.getContrasena();
        }
    }
    
    /**
     * Conviertir DTO a Entity
     * Crea un nuevo Entity con los valores que contiene el DTO.
     * @return 
     */
    public AdministradorEntity toEntity() {
        AdministradorEntity entity = new AdministradorEntity();
        entity.setUsuario(this.usuario);
        entity.setContrasena(this.contrasena);
        return entity;
    }
    
    
    /**
     * Devuelve el atributo usuario
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Modifica el atributo usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve el atributo contrasena
     * @return 
     */
    public String getContrasena() {
        return contrasena;
    }

    
    /**
     * Modifica el atributo contrasena
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}