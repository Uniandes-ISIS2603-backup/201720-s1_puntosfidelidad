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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author s.cespedes10
 */
@RunWith(Arquillian.class)
public class AdministradorPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AdministradorEntity.class.getPackage())
                .addPackage(AdministradorPersistence.class.getPackage())
                .addPackage(RestaurantePersistence.class.getPackage())
                .addPackage(RestauranteEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase AdministradorPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private AdministradorPersistence persistence;
    
     /**
     * Inyección de la dependencia a la clase RestaurantePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private RestaurantePersistence persistenceRes;

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
    private List<AdministradorEntity> data = new ArrayList<AdministradorEntity>();
    
    
    
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
        }}
    
    
    private void clearData() {
        em.createQuery("delete from RestauranteEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AdministradorEntity entity = factory.manufacturePojo(AdministradorEntity.class);
                                  
            List<RestauranteEntity> restaurantes = new ArrayList<>();
            
            for(int j = 0; j < 3; j++)
            {
                RestauranteEntity restaurante = factory.manufacturePojo(RestauranteEntity.class);
                persistenceRes.create(restaurante);
                restaurantes.add(restaurante);
            }   
            entity.setRestaurantes(restaurantes);  
                        
            em.merge(entity);
            data.add(entity);
        }
    
}
    
    
    public AdministradorPersistenceTest() {
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
     * Test of find method, of class AdministradorPersistence.
     */
    @Test
    public void testFind() throws Exception {
    AdministradorEntity entity = data.get(0);
    AdministradorEntity newEntity = persistence.find(entity.getUsuario());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    }

    /**
     * Test of findByName method, of class AdministradorPersistence.
     */
    @Test
    public void testFindByName() throws Exception {
    AdministradorEntity entity = data.get(0);
    AdministradorEntity newEntity = persistence.findByName(entity.getUsuario());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    }

    /**
     * Test of findAll method, of class AdministradorPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<AdministradorEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (AdministradorEntity ent : list) {
        boolean found = false;
        for (AdministradorEntity entity : data) {
            if (ent.getUsuario().equals(entity.getUsuario())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }

    /**
     * Test of create method, of class AdministradorPersistence.
     */
    @Test
    public void testCreate() throws Exception {
    PodamFactory factory = new PodamFactoryImpl();
    AdministradorEntity newEntity = factory.manufacturePojo(AdministradorEntity.class);
    AdministradorEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    AdministradorEntity entity = em.find(AdministradorEntity.class, result.getUsuario());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getUsuario(), entity.getUsuario());
        
    }

    /**
     * Test of update method, of class AdministradorPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        
    AdministradorEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    AdministradorEntity newEntity = factory.manufacturePojo(AdministradorEntity.class);

    newEntity.setUsuario(entity.getUsuario());

    persistence.update(newEntity);

    AdministradorEntity resp = em.find(AdministradorEntity.class, entity.getUsuario());

    Assert.assertEquals(newEntity.getUsuario(), resp.getUsuario());
    }

    /**
     * Test of delete method, of class AdministradorPersistence.
     */
    @Test
    public void testDelete() throws Exception {
    AdministradorEntity entity = data.get(0);
    persistence.delete(entity.getUsuario());
    AdministradorEntity deleted = em.find(AdministradorEntity.class, entity.getUsuario());
    Assert.assertNull(deleted);
    }

    
}