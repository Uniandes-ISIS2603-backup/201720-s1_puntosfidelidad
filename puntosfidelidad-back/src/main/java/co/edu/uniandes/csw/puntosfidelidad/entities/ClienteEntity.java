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
 * @author lv.vanegas10
 */
@Entity
public class ClienteEntity implements Serializable{
    
    @Id
    private String usuario;
    
    private String nombre;
    
    private String contrasena;
    
    private String imagen;
       
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<CompraEntity> compras = new ArrayList<>();
        
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<ComentarioEntity> comentarios = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<TarjetaPuntosEntity> tarjetasPuntos = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecargaEntity> recargas = new ArrayList<>();

    @PodamExclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)   
    private List<TarjetaDeCreditoEntity> tarjetasDeCredito = new ArrayList<>();
    
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
     * @return the compras
     */
    public List<CompraEntity> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    /**
     * @return the comentario
     */
    public List<ComentarioEntity> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentarios(List<ComentarioEntity> comentario) {
        this.comentarios = comentario;
    }

    /**
     * @return the tarjetasPuntos
     */
    public List<TarjetaPuntosEntity> getTarjetasPuntos() {
        return tarjetasPuntos;
    }

    /**
     * @param tarjetasPuntos the tarjetasPuntos to set
     */
    public void setTarjetasPuntos(List<TarjetaPuntosEntity> tarjetasPuntos) {
        this.tarjetasPuntos = tarjetasPuntos;
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
