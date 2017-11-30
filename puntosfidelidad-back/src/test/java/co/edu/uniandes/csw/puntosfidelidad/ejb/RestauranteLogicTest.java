/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.persistence.*;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.fail;

/**
 *
 * @author s.cespedes10
 */
@RunWith(Arquillian.class)
public class RestauranteLogicTest {
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RestauranteEntity.class.getPackage())
                .addPackage(RestaurantePersistence.class.getPackage()) 
                .addPackage(RestauranteLogic.class.getPackage())  
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos
     * se van a probar.
     */  
    
    @Inject
    private RestauranteLogic logic;
    
    
    List<ProductoEntity> productos = new ArrayList<>();
     List<SucursalEntity> sucursales = new ArrayList<>();
      List<EventoEntity> eventos = new ArrayList<>();
   
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
        
     /**
     *
     */
    private List<RestauranteEntity> data = new ArrayList<>();
    
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData() {  
        em.createQuery("delete from RestauranteEntity").executeUpdate();
    }


    private void insertData() {
        
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            RestauranteEntity entity = factory.manufacturePojo(RestauranteEntity.class);
            
            entity.setEventos(eventos);
            entity.setProductos(productos);
            entity.setSucursales(sucursales);            
            em.persist(entity);
            data.add(entity);
        } 
    }
    
    public RestauranteLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
       
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        
        
        

        
        PodamFactory factory = new PodamFactoryImpl();
        RestauranteEntity newEntity = factory.manufacturePojo(RestauranteEntity.class);
        newEntity.setNombre("*");
            newEntity.setTipoComida("Pasta");
        RestauranteEntity result = logic.createRestaurante(newEntity);

        Assert.assertNotNull(result);
        RestauranteEntity entity = em.find(RestauranteEntity.class, result.getNit());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNit(), entity.getNit());     
    }

     /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRestaurante() throws Exception {
        RestauranteEntity dato = data.get(0);
        RestauranteEntity entity = logic.getRestaurante(dato.getNit());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getNit(), dato.getNit());
    }

    /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRestaurantes() throws Exception {
        List<RestauranteEntity> lista = logic.getRestaurantes();
        Assert.assertNotNull(lista);
        Assert.assertEquals(lista.size(), data.size());
    }
    
    /**
     * Test of update method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateRestaurante() throws Exception {
        try{
            RestauranteEntity newEntity = new RestauranteEntity();
            newEntity.setNit("NoExistente");
            logic.actualizarRestaurante(data.get(0).getNit(), newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
         
        RestauranteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        RestauranteEntity newEntity = factory.manufacturePojo(RestauranteEntity.class);

        newEntity.setNit(entity.getNit());
         newEntity.setNombre("*");
           newEntity.setTipoComida("Pasta");

        logic.actualizarRestaurante(entity.getNit(), newEntity);

        RestauranteEntity resp = em.find(RestauranteEntity.class, entity.getNit());

        Assert.assertEquals(newEntity.getNit(), resp.getNit());
    }

    /**
     * Test of delete method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        
        RestauranteEntity entity = data.get(0);
        logic.removeRestaurante(entity.getNit());
        RestauranteEntity deleted = em.find(RestauranteEntity.class, entity.getNit());
        Assert.assertNull(deleted);
    }
}