/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ja.manrique
 */
@Stateless
public class TarjetaPuntosLogic {
    
    private static final Logger LOGGER = Logger.getLogger(TarjetaPuntosLogic.class.getName());
    
    @Inject
    private TarjetaPuntosLogic persistence;
    
    
}
