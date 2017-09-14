/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author aa.yepes
 */
@Entity
public class CompraEntity implements Serializable {

    @Id
    private Long id;
    private boolean pagoConpuntos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPagoConpuntos() {
        return pagoConpuntos;
    }

    public void setPagoConpuntos(boolean pagoConpuntos) {
        this.pagoConpuntos = pagoConpuntos;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this.getId() != null && ((CompraEntity) obj).getId() != null) {
            return this.getId().equals(((CompraEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
    
}
    