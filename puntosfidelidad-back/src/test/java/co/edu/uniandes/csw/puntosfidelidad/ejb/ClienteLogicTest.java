/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.persistence.*;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
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
import static org.junit.Assert.fail;

/**
 *
 * @author lv.vanegas10
 */
@RunWith(Arquillian.class)
public class ClienteLogicTest {
    
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
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage()) 
                .addPackage(ClienteLogic.class.getPackage())  
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos
     * se van a probar.
     */  
    
    @Inject
    private ClienteLogic logic;
    
    
    List<TarjetaDeCreditoEntity> tarjetasDeCredito = new ArrayList<>();
    List<TarjetaPuntosEntity> tarjetasPuntos = new ArrayList<>();
    List<RecargaEntity> recargas = new ArrayList<>();
    List<CompraEntity> compras = new ArrayList<>();
    List<ComentarioEntity> comentarios = new ArrayList<>();
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
    private List<ClienteEntity> data = new ArrayList<>();
    
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }


    private void insertData() {
        
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            
            entity.setCompras(compras);
            entity.setTarjetasDeCredito(tarjetasDeCredito);
            entity.setTarjetasPuntos(tarjetasPuntos);
            entity.setRecargas(recargas);
            entity.setComentarios(comentarios);  
                        
            em.persist(entity);
            data.add(entity);
        } 
    }
    
    public ClienteLogicTest() {
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
     * Test of create method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        try{
            ClienteEntity newEntity = new ClienteEntity();
            newEntity.setUsuario(null);
            newEntity.setContrasena("*");
            logic.createcliente(newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        try{
            ClienteEntity newEntity = new ClienteEntity();
            newEntity.setUsuario(data.get(0).getUsuario());
            newEntity.setContrasena("*");
            logic.createcliente(newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        try{
            ClienteEntity newEntity = new ClienteEntity();
            newEntity.setUsuario(data.get(0).getUsuario());
            newEntity.setContrasena(". ");
            logic.createcliente(newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        newEntity.setContrasena("*");
        ClienteEntity result = logic.createcliente(newEntity);

        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getUsuario());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getUsuario(), entity.getUsuario());     
    }

     /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCliente() throws Exception {
        ClienteEntity dato = data.get(0);
        ClienteEntity entity = logic.getCliente(dato.getUsuario());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getUsuario(), dato.getUsuario());
    }

    /**
     * Test of find method, of class RecargaPersistence.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetClientes() throws Exception {
        List<ClienteEntity> lista = logic.getClientes();
        Assert.assertNotNull(lista);
        Assert.assertEquals(lista.size(), data.size());
    }
    
    /**
     * Test of update method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateCliente() throws Exception {
        try{
            ClienteEntity newEntity = new ClienteEntity();
            newEntity.setUsuario("NoExistente");
            logic.updateCliente(data.get(0).getUsuario(), newEntity);
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
         
        ClienteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);

        newEntity.setUsuario(entity.getUsuario());
        newEntity.setContrasena("abc");

        logic.updateCliente(entity.getUsuario(), newEntity);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getUsuario());

        Assert.assertEquals(newEntity.getUsuario(), resp.getUsuario());
    }

    /**
     * Test of delete method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        try{
            ClienteEntity newEntity = new ClienteEntity();
            newEntity.setUsuario("NoExistente");
            logic.deleteCliente("NoExistente");
            fail("Debio fallar");
        }catch(BusinessLogicException e){Assert.assertTrue(!e.getMessage().isEmpty());}
        
        ClienteEntity entity = data.get(0);
        logic.deleteCliente(entity.getUsuario());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getUsuario());
        Assert.assertNull(deleted);
    }
}