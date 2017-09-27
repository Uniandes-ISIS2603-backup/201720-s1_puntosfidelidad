/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
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
public class TarjetaPuntosPersistenceTest {

    @Inject
    private TarjetaPuntosPersistence persistence;
    
    @Inject
    private CompraPersistence compraPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<TarjetaPuntosEntity> data = new ArrayList<TarjetaPuntosEntity>();
    
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
                .addPackage(TarjetaPuntosEntity.class.getPackage())
                .addPackage(TarjetaPuntosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public TarjetaPuntosPersistenceTest()
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
     * Test of create method, of class TarjetaPuntosPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaPuntosEntity newEntity = factory.manufacturePojo(TarjetaPuntosEntity.class);
        TarjetaPuntosEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        TarjetaPuntosEntity entity = em.find(TarjetaPuntosEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of update method, of class TarjetaPuntosPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        TarjetaPuntosEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaPuntosEntity newEntity = factory.manufacturePojo(TarjetaPuntosEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        TarjetaPuntosEntity resp = em.find(TarjetaPuntosEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of delete method, of class TarjetaPuntosPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        TarjetaPuntosEntity entity = data.get(0);
        persistence.delete(entity.getId());
        TarjetaPuntosEntity deleted = em.find(TarjetaPuntosEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of findWithId method, of class TarjetaPuntosPersistence.
     */
    @Test
    public void testFindWithId() throws Exception {
        TarjetaPuntosEntity entity = data.get(0);
        TarjetaPuntosEntity newEntity = persistence.findWithId(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class TarjetaPuntosPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<TarjetaPuntosEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaPuntosEntity ent : list) {
        boolean found = false;
        for (TarjetaPuntosEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
            assertTrue(ent.getCliente() != null);
        }
        Assert.assertTrue(found);
    }
    }
    
    @Test
    public void testGetCompras() throws Exception
    {
        for (TarjetaPuntosEntity entity: data)
        {
            List<CompraEntity> compras = persistence.getCompras(entity.getId());
            Assert.assertEquals(3, compras.size());
        }
    }
    
    @Test
    public void testGetCliente() throws Exception
    {
        for (TarjetaPuntosEntity entity: data)
        {
           TarjetaPuntosEntity tarjeta = persistence.findWithId(entity.getId());
            
            Assert.assertNotEquals(null, tarjeta.getCliente());
        }
    }
    
    private void clearData() {
        em.createQuery("delete from TarjetaPuntosEntity").executeUpdate();
    }
    
    private void insertData() {
        
        //Inicializar objetos
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            TarjetaPuntosEntity entity = factory.manufacturePojo(TarjetaPuntosEntity.class);

            List<CompraEntity> compras = new ArrayList<>();
            
            //Agrego 3 compras
            for(int j = 0; j < 3; j++)
            {
                CompraEntity compra = factory.manufacturePojo(CompraEntity.class);
                compraPersistence.create(compra);
                compras.add(compra);
            }
            
            //Agregar compra
            entity.setCompras(compras);
            
            //Agregar un cliente cualquiera
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            entity.setCliente(cliente); 
            em.persist(cliente);  
            
            em.persist(entity);
            data.add(entity);
        }        
    }
}
