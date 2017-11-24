package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import java.io.Serializable;

/**
 *
 * @author lv.vanegas10
 */
public class ClienteDTO implements Serializable{
    
    private String usuario;
    
    private String nombre;
    
    private String contrasena;
    
    private String imagen;
    
    public ClienteDTO(){
        //Método vacio obligatorio.
    }
    
    public ClienteDTO(ClienteEntity entity){
        if(entity != null){
        this.usuario = entity.getUsuario();
        this.nombre = entity.getNombre();
        this.contrasena = entity.getContrasena();
        this.imagen = entity.getImagen();
        }
    }
    
    public ClienteEntity toEntity(){
        ClienteEntity entity = new ClienteEntity();
        entity.setContrasena(this.getDTOContrasena());
        entity.setNombre(this.getDTONombre());
        entity.setImagen(this.getDTOImagen());
        entity.setUsuario(this.getDTOUsuario());
        return entity;
    }  

    /**
     * @return the usuario
     */
    public String getDTOUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setDTOUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the contrasena
     */
    public String getDTOContrasena() {
        return contrasena;
    }

    /**
     * @return the imagen
     */
    public String getDTOImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setDTOImagen(String imagen) {
        this.imagen = imagen;
    }    

    /**
     * @param contrasena the contrasena to set
     */
    public void setDTOContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
