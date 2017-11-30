/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.persistence.*;
import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
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
 * @author lv.vanegas10
 */
@RunWith(Arquillian.class)
public class AdministradorLogicTest {
    
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
                .addPackage(AdministradorEntity.class.getPackage())
                .addPackage(AdministradorPersistence.class.getPackage()) 
                .addPackage(AdministradorLogic.class.getPackage())  
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos
     * se van a probar.
     */  
    
    @Inject
    private AdministradorLogic logic;
    
    
    List<RestauranteEntity> restaurantes = new ArrayList<>();
   
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
    private List<AdministradorEntity> data = new ArrayList<>();
    
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
        em.createQuery("delete from AdministradorEntity").executeUpdate();
    }


    private void insertData() {
        
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            AdministradorEntity entity = factory.manufacturePojo(AdministradorEntity.class);
            
            entity.setRestaurantes(restaurantes);
           
                        
            em.persist(entity);
            data.add(entity);
        } 
    }
    
    public AdministradorLogicTest() {
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
        try{
            AdministradorEntity newEntity = new AdministradorEntity();
            newEntity.setUsuario(null);
            newEntity.setContrasena("*");
            logic.createAdministrador(newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        try{
            AdministradorEntity newEntity = new AdministradorEntity();
            newEntity.setUsuario(data.get(0).getUsuario());
            newEntity.setContrasena("*");
            logic.createAdministrador(newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        try{
            AdministradorEntity newEntity = new AdministradorEntity();
            newEntity.setUsuario(data.get(0).getUsuario());
            newEntity.setContrasena(". ");
            logic.createAdministrador(newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        PodamFactory factory = new PodamFactoryImpl();
        AdministradorEntity newEntity = factory.manufacturePojo(AdministradorEntity.class);
        newEntity.setContrasena("*");
        AdministradorEntity result = logic.createAdministrador(newEntity);

        Assert.assertNotNull(result);
        AdministradorEntity entity = em.find(AdministradorEntity.class, result.getUsuario());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getUsuario(), entity.getUsuario());     
    }

     /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAdministrador() throws Exception {
        AdministradorEntity dato = data.get(0);
        AdministradorEntity entity = logic.getAdministrador(dato.getUsuario());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getUsuario(), dato.getUsuario());
    }

    /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAdministradors() throws Exception {
        List<AdministradorEntity> lista = logic.getAdministradores();
        Assert.assertNotNull(lista);
        Assert.assertEquals(lista.size(), data.size());
    }
    
    /**
     * Test of update method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateAdministrador() throws Exception {
        try{
            AdministradorEntity newEntity = new AdministradorEntity();
            newEntity.setUsuario("NoExistente");
            logic.actualizarAdministrador(data.get(0).getUsuario(), newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
         
        AdministradorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AdministradorEntity newEntity = factory.manufacturePojo(AdministradorEntity.class);

        newEntity.setUsuario(entity.getUsuario());
        newEntity.setContrasena("abc");

        logic.actualizarAdministrador(entity.getUsuario(), newEntity);

        AdministradorEntity resp = em.find(AdministradorEntity.class, entity.getUsuario());

        Assert.assertEquals(newEntity.getUsuario(), resp.getUsuario());
    }

    /**
     * Test of delete method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        
        AdministradorEntity entity = data.get(0);
        logic.removeAdministrador(entity.getUsuario());
        AdministradorEntity deleted = em.find(AdministradorEntity.class, entity.getUsuario());
        Assert.assertNull(deleted);
    }
}