
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.SucursalPersistence;
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
public class SucursalLogicTest {
    
    public SucursalLogicTest() {
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
                .addPackage(SucursalEntity.class.getPackage())
                .addPackage(SucursalPersistence.class.getPackage())
                .addPackage(SucursalLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private SucursalLogic logic;

    @Inject
    private CompraLogic logicCompra;

    @Inject
    private ComentarioLogic logicComentario;
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

    private List<SucursalEntity> data = new ArrayList<SucursalEntity>();

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
        em.createQuery("delete from SucursalEntity").executeUpdate();
    }

    private void insertData() throws BusinessLogicException {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SucursalEntity entity = factory.manufacturePojo(SucursalEntity.class);
            ArrayList<CompraEntity> compras = new ArrayList<CompraEntity>();
            ArrayList<ComentarioEntity> comentarios = new ArrayList<ComentarioEntity>();

            em.persist(entity);
            data.add(entity);
        }
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of getSucursals method, of class SucursalLogic.
     */
    @Test
    public void testGetSucursals() throws Exception {
        List<SucursalEntity> list = logic.getSucursals();
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

    /**
     * Test of getSucursal method, of class SucursalLogic.
     */
    @Test
    public void testGetSucursal() throws Exception {
        System.out.println("getSucursal");
        SucursalEntity entity = data.get(0);

        SucursalEntity newEntity = logic.getSucursal(entity.getId());

        Assert.assertNotNull(newEntity);

        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of createSucursal method, of class SucursalLogic.
     */
    @Test
    public void testCreateSucursal() throws Exception {

        PodamFactory factory = new PodamFactoryImpl();
        SucursalEntity newEntity = factory.manufacturePojo(SucursalEntity.class);

        SucursalEntity result = logic.createSucursal(newEntity);

        Assert.assertNotNull(result);
        SucursalEntity entity = em.find(SucursalEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());

    }

    /**
     * Test of updateSucursal method, of class SucursalLogic.
     */
    @Test    
    public void testUpdateSucursal() throws Exception {
     SucursalEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        SucursalEntity newEntity = factory.manufacturePojo(SucursalEntity.class);

        newEntity.setId(entity.getId());

        logic.updateSucursal(entity.getId(), entity);

        SucursalEntity resp = em.find(SucursalEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of deleteSucursal method, of class SucursalLogic.
     */
    @Test
    public void testDeleteSucursal() throws Exception {
       SucursalEntity entity = data.get(0);
        logic.deleteSucursal(entity.getId());
        SucursalEntity deleted = em.find(SucursalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }


}