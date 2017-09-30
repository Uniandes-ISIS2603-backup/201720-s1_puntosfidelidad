/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.dtos;

import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja.manrique
 */
public class TarjetaPuntosDetailDTO extends TarjetaPuntosDTO{
    
    private List<CompraDTO> compras;
    
    private ClienteDTO cliente;
    
    public TarjetaPuntosDetailDTO()
    {
        
    }
    
    public TarjetaPuntosDetailDTO(TarjetaPuntosEntity entity)
    {
        super(entity);
        if(entity != null)
        {
            this.cliente = new ClienteDTO(entity.getCliente());

            List<CompraDTO> comp = new ArrayList<>();

            for(CompraEntity compra : entity.getCompras())
            {
                comp.add(new CompraDTO(compra));
            }
        
        
            this.compras = comp;
        }
    }

    public List<CompraDTO> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraDTO> compras) {
        this.compras = compras;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
    
}
