/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lv.vanegas10
 */
@Entity
public class ClienteEntity implements Serializable{
    
    @Id
    private String usuario;
    
    private String nombre;
    
    private String contrasena;
    
    private String imagen;
    
    @OneToMany
    private List<RecargaEntity> recargas = new ArrayList<RecargaEntity>();
    
    @OneToMany
    private List<TarjetaDeCreditoEntity> tarjetasDeCredito = new ArrayList<TarjetaDeCreditoEntity>();

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
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    /**
     * @return the recargas
     */
    public List<RecargaEntity> getRecargas() {
        return recargas;
    }

    /**
     * @param recargas the recargas to set
     */
    public void setRecargas(List<RecargaEntity> recargas) {
        this.recargas = recargas;
    }

    /**
     * @return the tarjetasDeCredito
     */
    public List<TarjetaDeCreditoEntity> getTarjetasDeCredito() {
        return tarjetasDeCredito;
    }

    /**
     * @param tarjetasDeCredito the tarjetasDeCredito to set
     */
    public void setTarjetasDeCredito(List<TarjetaDeCreditoEntity> tarjetasDeCredito) {
        this.tarjetasDeCredito = tarjetasDeCredito;
    }     
          
}
