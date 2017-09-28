/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
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
 * @author aa.yepes
 */
@RunWith(Arquillian.class)
public class ProductoPersistenceTest {
    
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
                .addPackage(ProductoEntity.class.getPackage())
                .addPackage(ProductoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
        
    }
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ProductoPersistence persistence;
    
    @Inject
    private RestaurantePersistence restPersist;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private RestaurantePersistence logicRest;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

     /**
     *
     */
    private List<ProductoEntity> data = new ArrayList<ProductoEntity>();
    public ProductoPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
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
        em.createQuery("delete from CompraEntity").executeUpdate();
    }


 private void insertData() throws BusinessLogicException {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ProductoEntity entity = factory.manufacturePojo(ProductoEntity.class);
            RestauranteEntity restaurante = factory.manufacturePojo(RestauranteEntity.class);

            logicRest.create(restaurante);
            entity.setRestaurante(restaurante);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProductoPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
    ProductoEntity newEntity = factory.manufacturePojo(ProductoEntity.class);
    ProductoEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    ProductoEntity entity = em.find(ProductoEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Test of update method, of class ProductoPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ProductoEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    ProductoEntity newEntity = factory.manufacturePojo(ProductoEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    ProductoEntity resp = em.find(ProductoEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        
    }

    /**
     * Test of delete method, of class ProductoPersistence.
     */
    @Test
    public void testDelete() throws Exception {
         ProductoEntity entity = data.get(0);
    persistence.delete(entity.getId());
    ProductoEntity deleted = em.find(ProductoEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ProductoPersistence.
     */
    @Test
    public void testFind() throws Exception {
        ProductoEntity entity = data.get(0);
    
        ProductoEntity newEntity = persistence.find( entity.getId());
    
        Assert.assertNotNull(newEntity);
    
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class ProductoPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ProductoEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (ProductoEntity ent : list) {
        boolean found = false;
        for (ProductoEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    
    }
    /**
     * Test of findAll method, of class ProductoPersistence.
     */
    @Test
    public void testGetRestaurante() throws Exception 
    {
       ProductoEntity entity = data.get(0);  
       RestauranteEntity restaurante = data.get(0).getRestaurante();
       RestauranteEntity rest = persistence.getRestaurante(entity.getId());
       Assert.assertEquals(restaurante.getNombre(), rest.getNombre());   
    }
    

    }
    
    