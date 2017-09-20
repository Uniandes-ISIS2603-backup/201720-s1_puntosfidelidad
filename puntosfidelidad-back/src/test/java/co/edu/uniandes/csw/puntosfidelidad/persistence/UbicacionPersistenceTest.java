/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
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
public class UbicacionPersistenceTest {
    
    @Inject
    private UbicacionPersistence persistence;
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserTransaction utx;
    private List<UbicacionEntity> data = new ArrayList<UbicacionEntity>();

    public UbicacionPersistenceTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UbicacionEntity.class.getPackage())
                .addPackage(UbicacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    private void clearData() {
        em.createQuery("delete from UbicacionEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UbicacionEntity entity = factory.manufacturePojo(UbicacionEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createUbicacionEntityTest() {
        PodamFactory factory = new PodamFactoryImpl();
        UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);
        UbicacionEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        UbicacionEntity entity = em.find(UbicacionEntity.class, result.getDireccion());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getLatitud(), entity.getLatitud());
    }

    @Test
    public void getUbicacionsTest() {
        List<UbicacionEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (UbicacionEntity ent : list) {
            boolean found = false;
            for (UbicacionEntity entity : data) {
                if (ent.getDireccion().equals(entity.getDireccion())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getUbicacionTest() {
        UbicacionEntity entity = data.get(0);
        UbicacionEntity newEntity = persistence.find(entity.getDireccion());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getLatitud(), newEntity.getLatitud());
    }

    @Test
    public void updateUbicacionTest() {
        UbicacionEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);

        newEntity.setDireccion(entity.getDireccion());

        persistence.update(newEntity);

        UbicacionEntity resp = em.find(UbicacionEntity.class, entity.getDireccion());

        Assert.assertEquals(newEntity.getLatitud(), resp.getLatitud());
    }

    @Test
    public void deleteUbicacionTest() {
        UbicacionEntity entity = data.get(0);
        persistence.delete(entity.getDireccion());
        UbicacionEntity deleted = em.find(UbicacionEntity.class, entity.getDireccion());
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
