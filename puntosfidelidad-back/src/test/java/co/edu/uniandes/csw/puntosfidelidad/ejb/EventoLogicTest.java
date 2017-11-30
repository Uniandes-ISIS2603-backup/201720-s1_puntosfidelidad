
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;


import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.EventoPersistence;
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
 * @author Camilo
 */

@RunWith(Arquillian.class)
public class EventoLogicTest {
    
    public EventoLogicTest() {
    }
    
        /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EventoEntity.class.getPackage())
                .addPackage(EventoPersistence.class.getPackage())
                .addPackage(EventoLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private EventoLogic logic;

    @Inject
    private UbicacionLogic logicUbicacion;

    @Inject
    private RestauranteLogic logicRestaurante;
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

    private List<EventoEntity> data = new ArrayList<EventoEntity>();

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
        em.createQuery("delete from EventoEntity").executeUpdate();
    }

    private void insertData() throws BusinessLogicException {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EventoEntity entity = factory.manufacturePojo(EventoEntity.class);
            ArrayList<UbicacionEntity> ubicacions = new ArrayList<UbicacionEntity>();
            ArrayList<RestauranteEntity> restaurantes = new ArrayList<RestauranteEntity>();
            
            em.persist(entity);
            data.add(entity);
        }
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of getEventos method, of class EventoLogic.
     */
    @Test
    public void testGetEventos() throws Exception {
        List<EventoEntity> list = logic.getEventos();
        Assert.assertEquals(data.size(), list.size());
        for (EventoEntity ent : list) {
            boolean found = false;
            for (EventoEntity entity : data) {
                if (ent.getNombre().equals(entity.getNombre())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of getEvento method, of class EventoLogic.
     */
    @Test
    public void testGetEvento() throws Exception {
        System.out.println("getEvento");
        EventoEntity entity = data.get(0);

        EventoEntity newEntity = logic.getEvento(entity.getNombre());

        Assert.assertNotNull(newEntity);

        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of createEvento method, of class EventoLogic.
     */
    @Test
    public void testCreateEvento() throws Exception {

        PodamFactory factory = new PodamFactoryImpl();
        EventoEntity newEntity = factory.manufacturePojo(EventoEntity.class);

        EventoEntity result = logic.createEvento(newEntity);

        Assert.assertNotNull(result);
        EventoEntity entity = em.find(EventoEntity.class, result.getNombre());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());

    }

    /**
     * Test of updateEvento method, of class EventoLogic.
     */
    @Test
    public void testUpdateEvento() throws Exception {
     EventoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EventoEntity newEntity = factory.manufacturePojo(EventoEntity.class);

        newEntity.setNombre(entity.getNombre());

        logic.updateEvento(entity.getNombre(), entity);

        EventoEntity resp = em.find(EventoEntity.class, entity.getNombre());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Test of deleteEvento method, of class EventoLogic.
     */
    @Test
    public void testDeleteEvento() throws Exception {
       EventoEntity entity = data.get(0);
        logic.deleteEvento(entity.getNombre());
        EventoEntity deleted = em.find(EventoEntity.class, entity.getNombre());
        Assert.assertNull(deleted);
    }
   
}
