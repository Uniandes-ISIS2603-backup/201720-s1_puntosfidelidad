/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.persistence.*;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
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
public class TarjetaDeCreditoLogicTest {

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaDeCreditoEntity.class.getPackage())
                .addPackage(TarjetaDeCreditoPersistence.class.getPackage())
                .addPackage(TarjetaDeCreditoLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos se
     * van a probar.
     */

    @Inject
    private ClientePersistence clientePersistence;
    
    @Inject
    private TarjetaDeCreditoLogic logic;
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
        cliente = factory.manufacturePojo(ClienteEntity.class);
        clientePersistence.create(cliente);
        for (int i = 0; i < 3; i++) {
            TarjetaDeCreditoEntity entity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
            entity.setCliente(cliente);
            em.persist(entity);
            data.add(entity);
        }
    }

    public TarjetaDeCreditoLogicTest() {
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
     * Test of getTarjetasDeCredito method, of class TarjetaDeCreditoLogic.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTarjetasDeCredito() throws Exception {
        List<TarjetaDeCreditoEntity> lista = logic.getTarjetasDeCredito(cliente.getUsuario());
        Assert.assertTrue(!lista.isEmpty());
        Assert.assertTrue(lista.size() == data.size());
    }
    
    /**
     * Test of getTarjetaDeCredito method, of class TarjetaDeCreditoLogic.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTarjetaDeCredito() throws Exception {
        TarjetaDeCreditoEntity entity = data.get(0);
        TarjetaDeCreditoEntity newEntity = logic.getTarjetaDeCredito(cliente.getUsuario(), entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of createTarjetaDeCredito method, of class TarjetaDeCreditoLogic.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateTarjetaDeCredito() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
        newEntity.setCliente(cliente);
        TarjetaDeCreditoEntity result = logic.createTarjetaDeCredito(cliente.getUsuario(), newEntity);

        Assert.assertNotNull(result);
        TarjetaDeCreditoEntity entity = em.find(TarjetaDeCreditoEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of updateTarjetaDeCredito method, of class TarjetaDeCreditoLogic.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateTarjetaDeCredito() throws Exception {
        TarjetaDeCreditoEntity entity = data.get(2);
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);

        newEntity.setId(entity.getId());

        logic.updateTarjetaDeCredito(cliente.getUsuario(), newEntity);

        TarjetaDeCreditoEntity resp = em.find(TarjetaDeCreditoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of deleteTarjetaDeCredito method, of class TarjetaDeCreditoLogic.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteTarjetaDeCredito() throws Exception {
        TarjetaDeCreditoEntity entity = data.get(0);
        logic.deleteTarjetaDeCredito(cliente.getUsuario(), entity.getId());
        TarjetaDeCreditoEntity deleted = em.find(TarjetaDeCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
