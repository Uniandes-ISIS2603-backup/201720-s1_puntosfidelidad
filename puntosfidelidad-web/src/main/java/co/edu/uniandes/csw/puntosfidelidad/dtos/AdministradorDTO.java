/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;

/**
 * DTO = Objeto de transferencia de datos. 
 * Los DTO contienen las represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * 
 * Por esta razón solamente contienen atributos, getters, setters
 * y métodos para convertirlos en Entities/Crearlos a partir de Entities
 * (Seguir el UML/Entity y la documentación para la creación de los DTO's)
 * @author ja.manrique
 */
public class AdministradorDTO {
    
    private String usuario;
    private String contrasena;

    //Constructor vacío (¡¡¡OLBIGATORIO!!!)
    public AdministradorDTO()
    {
        
    }
    
    /**
     * Conviertir Entity a DTO
     * Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     */
    public AdministradorDTO(AdministradorEntity administrador) {
        
        this.usuario = administrador.getUsuario();
        this.contrasena = administrador.getContrasena();
    }
    
    /**
     * Conviertir DTO a Entity
     * Crea un nuevo Entity con los valores que contiene el DTO.
     */
    public AdministradorEntity toEntity() {
        AdministradorEntity entity = new AdministradorEntity();
        entity.setUsuario(this.usuario);
        entity.setContrasena(this.contrasena);
        return entity;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
