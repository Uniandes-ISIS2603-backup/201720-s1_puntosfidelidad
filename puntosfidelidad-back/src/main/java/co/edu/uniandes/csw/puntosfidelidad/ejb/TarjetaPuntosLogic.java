/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RecargaPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.TarjetaPuntosPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ja.manrique
 */
@Stateless
public class TarjetaPuntosLogic {

    @Inject
    private TarjetaPuntosPersistence persistence;

    @Inject
    private CompraLogic compraLogic;

    @Inject
    private RecargaLogic recargaLogic;

    private static final Logger LOGGER = Logger.getLogger(TarjetaDeCreditoLogic.class.getName());

    //CRUD
    public List<TarjetaPuntosEntity> getTarjetasPuntos() {
        return persistence.findAll();
    }

    public TarjetaPuntosEntity getTarjetaPuntos(Long id) {
        return persistence.findWithId(id);
    }

    public TarjetaPuntosEntity updateTarjetaPuntos(TarjetaPuntosEntity nuevoEntity) {
        return persistence.update(nuevoEntity);
    }

    public void deleteTarjetaPuntos(Long id) {
        TarjetaPuntosEntity actual = getTarjetaPuntos(id);
        try {
            List<CompraEntity> compras = actual.getCompras();
            for(CompraEntity compra:compras){
                compraLogic.deleteCompra(compra.getId());
            }
            
            List<RecargaEntity> listaRecargas = recargaLogic.getRecargas(actual.getCliente().getUsuario());
            if (listaRecargas != null) {
                for (RecargaEntity recarga : listaRecargas) {
                    recargaLogic.deleteRecarga(actual.getCliente().getUsuario(), recarga.getId());
                }
            }
        } catch (Exception e) {
        }

        persistence.delete(id);
    }

    public TarjetaPuntosEntity createTarjetaPuntos(TarjetaPuntosEntity nuevoEntity) {
        return persistence.create(nuevoEntity);
    }

    public List<CompraEntity> getCompras(Long id) {
        return persistence.getCompras(id);
    }
}
