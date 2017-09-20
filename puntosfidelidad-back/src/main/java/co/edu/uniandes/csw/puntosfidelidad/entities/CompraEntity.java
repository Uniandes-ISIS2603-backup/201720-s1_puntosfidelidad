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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author aa.yepes
 */
@Entity
public class CompraEntity implements Serializable {

    @Id
    private Long id;
    private boolean pagoConpuntos;

    @PodamExclude
    @OneToMany(mappedBy = "compra")
    private List<ProductoEntity> employees = new ArrayList<>();
    
    @PodamExclude
    @ManyToOne
    private SucursalEntity sucursal;
    
    @PodamExclude
    @ManyToOne
    private TarjetaPuntosEntity tarjetaPuntos;
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public TarjetaPuntosEntity getTarjetaPuntos() {
        return tarjetaPuntos;
    }

    public void setTarjetaPuntos(TarjetaPuntosEntity tarjetaPuntos) {
        this.tarjetaPuntos = tarjetaPuntos;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductoEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<ProductoEntity> employees) {
        this.employees = employees;
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
    