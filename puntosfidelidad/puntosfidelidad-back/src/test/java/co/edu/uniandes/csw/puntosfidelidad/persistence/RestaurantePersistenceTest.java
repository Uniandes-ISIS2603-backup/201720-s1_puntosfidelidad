/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author s.cespedes10
 */
@RunWith(Arquillian.class)
public class RestaurantePersistenceTest {
    
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
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private RestaurantePersistence persistence;

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
    private List<RestauranteEntity> data = new ArrayList<RestauranteEntity>();
    
    
    
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
        for (int i = 0; i < 3; i++) {
            RestauranteEntity entity = factory.manufacturePojo(RestauranteEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    
    public RestaurantePersistenceTest() {
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
     * Test of find method, of class RestaurantePersistence.
     */
    @Test
    public void testFind() throws Exception {
        
    RestauranteEntity entity = data.get(0);
    RestauranteEntity newEntity = persistence.find(entity.getNit());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findByName method, of class RestaurantePersistence.
     */
    @Test
    public void testFindByName() throws Exception {
        
    RestauranteEntity entity = data.get(0);
    RestauranteEntity newEntity = persistence.findByName(entity.getNombre());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class RestaurantePersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        
    List<RestauranteEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (RestauranteEntity ent : list) {
        boolean found = false;
        for (RestauranteEntity entity : data) {
            if (ent.getNit().equals(entity.getNit())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }

    /**
     * Test of create method, of class RestaurantePersistence.
     */
    @Test
    public void testCreate() throws Exception {
        
        PodamFactory factory = new PodamFactoryImpl();
    RestauranteEntity newEntity = factory.manufacturePojo(RestauranteEntity.class);
    RestauranteEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    RestauranteEntity entity = em.find(RestauranteEntity.class, result.getNit());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNit(), entity.getNit());
    }

    /**
     * Test of update method, of class RestaurantePersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        
    RestauranteEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    RestauranteEntity newEntity = factory.manufacturePojo(RestauranteEntity.class);

    newEntity.setNit(entity.getNit());

    persistence.update(newEntity);

    RestauranteEntity resp = em.find(RestauranteEntity.class, entity.getNit());

    Assert.assertEquals(newEntity.getNit(), resp.getNit());
    }

    /**
     * Test of delete method, of class RestaurantePersistence.
     */
    @Test
    public void testDelete() throws Exception {
        
    RestauranteEntity entity = data.get(0);
    persistence.delete(entity.getNit());
    RestauranteEntity deleted = em.find(RestauranteEntity.class, entity.getNit());
    Assert.assertNull(deleted);
    }

   
    
}
