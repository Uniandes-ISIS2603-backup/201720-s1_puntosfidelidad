/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
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

/**
 *
 * @author cass_
 */
@RunWith(Arquillian.class)
public class SucursalPersistenceTest {

    @Inject
    private SucursalPersistence persistence;
    @PersistenceContext(unitName = "puntosfidelidadPU")
    private EntityManager em;
    @Inject
    UserTransaction utx;
    private List<SucursalEntity> data = new ArrayList<SucursalEntity>();

    public SucursalPersistenceTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(SucursalEntity.class.getPackage())
                .addPackage(SucursalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    private void clearData() {
        em.createQuery("delete from SucursalEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SucursalEntity entity = factory.manufacturePojo(SucursalEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createSucursalEntityTest() {
        PodamFactory factory = new PodamFactoryImpl();
        SucursalEntity newEntity = factory.manufacturePojo(SucursalEntity.class);
        SucursalEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        SucursalEntity entity = em.find(SucursalEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
    }

    @Test
    public void getSucursalsTest() {
        List<SucursalEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (SucursalEntity ent : list) {
            boolean found = false;
            for (SucursalEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getSucursalTest() {
        SucursalEntity entity = data.get(0);
        SucursalEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
    }

    @Test
    public void updateSucursalTest() {
        SucursalEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        SucursalEntity newEntity = factory.manufacturePojo(SucursalEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        SucursalEntity resp = em.find(SucursalEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
    }

    @Test
    public void deleteSucursalTest() {
        SucursalEntity entity = data.get(0);
        persistence.delete(entity.getId());
        SucursalEntity deleted = em.find(SucursalEntity.class, entity.getId());
        Assert.assertNull(deleted);
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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }
}
