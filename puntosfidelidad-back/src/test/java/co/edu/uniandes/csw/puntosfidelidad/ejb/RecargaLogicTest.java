/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.persistence.*;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
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
public class RecargaLogicTest {

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RecargaEntity.class.getPackage())
                .addPackage(RecargaPersistence.class.getPackage())
                .addPackage(RecargaLogic.class.getPackage())
                .addPackage(TarjetaPuntosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos se
     * van a probar.
     */
    @Inject
    private RecargaLogic logic;

    @Inject
    private ClientePersistence clientePersistence;
    
    @Inject
    private TarjetaPuntosPersistence tarjetaPersistence;
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

    ClienteEntity cliente;
    /**
     *
     */
    private List<RecargaEntity> data = new ArrayList<RecargaEntity>();

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
        em.createQuery("delete from RecargaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        cliente = factory.manufacturePojo(ClienteEntity.class);
        clientePersistence.create(cliente);
        for (int i = 0; i < 3; i++) {
            RecargaEntity entity = factory.manufacturePojo(RecargaEntity.class);
            entity.setCliente(cliente);
            em.persist(entity);
            data.add(entity);
        }
    }

    public RecargaLogicTest() {
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
     * Test of create method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        RecargaEntity newEntity = factory.manufacturePojo(RecargaEntity.class);
        TarjetaPuntosEntity newTarjeta = factory.manufacturePojo(TarjetaPuntosEntity.class);
        newTarjeta.setCliente(cliente);
        tarjetaPersistence.create(newTarjeta);
        newEntity.setCliente(cliente);
        newEntity.setTarjetaPuntos(newTarjeta);
             
        RecargaEntity result = logic.createRecarga(cliente.getUsuario(), newEntity);

        Assert.assertNotNull(result);
        RecargaEntity entity = em.find(RecargaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of update method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateRecarga() throws Exception {
        RecargaEntity entity = data.get(2);
        PodamFactory factory = new PodamFactoryImpl();
        RecargaEntity newEntity = factory.manufacturePojo(RecargaEntity.class);

        newEntity.setId(entity.getId());

        logic.updateRecarga(cliente.getUsuario(), newEntity);

        RecargaEntity resp = em.find(RecargaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of delete method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteRecarga() throws Exception {
        RecargaEntity entity = data.get(0);
        logic.deleteRecarga(cliente.getUsuario(), entity.getId());
        RecargaEntity deleted = em.find(RecargaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRecarga() throws Exception {
        RecargaEntity dato = data.get(0);
        RecargaEntity entity = logic.getRecarga(cliente.getUsuario(), dato.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), dato.getId());
    }

    /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRecargas() throws Exception {
        List<RecargaEntity> lista = logic.getRecargas(cliente.getUsuario());
        Assert.assertNotNull(lista);
        Assert.assertEquals(lista.size(), data.size());
    }
}
