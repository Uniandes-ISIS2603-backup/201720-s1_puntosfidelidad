/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/UbicacionEntity.java
=======
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/UbicacionEntity.java

/**
 *
 * @author cass_
 */
@Entity
public class UbicacionEntity implements Serializable {
    
    
    @Id
    private String direccion;
    
    private Long latitud;
    
    private Long longitud;

<<<<<<< HEAD:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/UbicacionEntity.java
=======
    @PodamExclude
    @ManyToOne
    private SucursalEntity sucursal;
    
    @PodamExclude
    @ManyToOne
    private EventoEntity evento;
>>>>>>> BaseRest:puntosfidelidad-back/src/main/java/co/edu/uniandes/csw/puntosfidelidad/entities/UbicacionEntity.java
    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the latitud
     */
    public Long getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Long getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
}
