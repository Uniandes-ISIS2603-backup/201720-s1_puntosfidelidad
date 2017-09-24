/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
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
 * @author ja.manrique
 */
@RunWith(Arquillian.class)
public class ComentarioPersistenceTest {

    @Inject
    private ComentarioPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<ComentarioEntity> data = new ArrayList<ComentarioEntity>();
    
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
                .addPackage(ComentarioEntity.class.getPackage())
                .addPackage(ComentarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ComentarioPersistenceTest()
    {
        
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }

    @Before
    public void setUp() throws Exception {
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

    @After
    public void tearDown() throws Exception {
        
    }

    /**
     * Test of create method, of class ComentarioPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ComentarioEntity newEntity = factory.manufacturePojo(ComentarioEntity.class);
        ComentarioEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        ComentarioEntity entity = em.find(ComentarioEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of update method, of class ComentarioPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ComentarioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ComentarioEntity newEntity = factory.manufacturePojo(ComentarioEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        ComentarioEntity resp = em.find(ComentarioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of delete method, of class ComentarioPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ComentarioEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ComentarioEntity deleted = em.find(ComentarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of findWithId method, of class ComentarioPersistence.
     */
    @Test
    public void testFindWithId() throws Exception {
        ComentarioEntity entity = data.get(0);
        ComentarioEntity newEntity = persistence.findWithId(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class ComentarioPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ComentarioEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ComentarioEntity ent : list) {
        boolean found = false;
        for (ComentarioEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
        }
    }
    
    /**
     * Test of getCliente method, of class ComentarioPersistence.
     */
    @Test
    public void testGetCliente()
    {
        for (ComentarioEntity entity: data)
        {
            //Cada comentario DEBE tener un cliente
            Assert.assertNotNull(entity.getCliente());
        }
    }
    
    
    /**
     * Test of getSucursal method, of class ComentarioPersistence.
     */
    @Test
    public void testGetSucursal()
    {
        for (ComentarioEntity entity: data)
        {
            //Cada comentario DEBE tener una sucursal
            Assert.assertNotNull(entity.getSucursal());
        }
    }
    
    
    private void clearData() {
        em.createQuery("delete from ComentarioEntity").executeUpdate();
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ComentarioEntity entity = factory.manufacturePojo(ComentarioEntity.class);
            
            insertDataToEntity(entity, factory);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    private void insertDataToEntity(ComentarioEntity entity, PodamFactory factory)
    {
        //Crea y se persisten de una vez, luego se linkean al comentario y se actualiza
        
        SucursalEntity sucursal = factory.manufacturePojo(SucursalEntity.class);
        em.persist(sucursal);
        
        ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
        em.persist(cliente);
        
        entity.setCliente(cliente);
        entity.setSucursal(sucursal);
        
        em.merge(entity);
    }
}
