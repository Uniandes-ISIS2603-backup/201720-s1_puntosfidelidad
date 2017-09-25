/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
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

/**
 *
 * @author lv.vanegas10
 */
@RunWith(Arquillian.class)
public class TarjetaDeCreditoPersistenceTest {
    
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
                .addPackage(TarjetaDeCreditoEntity.class.getPackage())
                .addPackage(TarjetaDeCreditoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos
     * se van a probar.
     */
    @Inject
    private TarjetaDeCreditoPersistence persistence;
    
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
    private List<TarjetaDeCreditoEntity> data = new ArrayList<TarjetaDeCreditoEntity>();
    
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
        em.createQuery("delete from TarjetaDeCreditoEntity").executeUpdate();
    }


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TarjetaDeCreditoEntity entity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    public TarjetaDeCreditoPersistenceTest() {
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
     * Test of create method, of class TarjetaDeCreditoPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
        TarjetaDeCreditoEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        TarjetaDeCreditoEntity entity = em.find(TarjetaDeCreditoEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of update method, of class TarjetaDeCreditoPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        TarjetaDeCreditoEntity entity = data.get(2);
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        TarjetaDeCreditoEntity resp = em.find(TarjetaDeCreditoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of delete method, of class TarjetaDeCreditoPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        TarjetaDeCreditoEntity entity = data.get(0);
        persistence.delete(entity.getId());
        TarjetaDeCreditoEntity deleted = em.find(TarjetaDeCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class TarjetaDeCreditoPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFind() throws Exception {
        TarjetaDeCreditoEntity entity = data.get(0);
        TarjetaDeCreditoEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findByNumber method, of class TarjetaDeCreditoPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindByNumber() throws Exception {        
        TarjetaDeCreditoEntity entity = data.get(0);
        TarjetaDeCreditoEntity newEntity = persistence.findByNumber(entity.getNumero());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
    }
    
}