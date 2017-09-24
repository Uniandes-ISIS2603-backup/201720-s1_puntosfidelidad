/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
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
public class ClientePersistenceTest {
    
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
                .addPackage(TarjetaDeCreditoEntity.class.getPackage()) 
                .addPackage(TarjetaPuntosEntity.class.getPackage()) 
                .addPackage(CompraEntity.class.getPackage()) 
                .addPackage(ComentarioEntity.class.getPackage())
                .addPackage(RecargaEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase TarjetaDeCredito cuyos métodos
     * se van a probar.
     */
    @Inject
    private ClientePersistence persistence;
    
    @Inject
    private TarjetaPuntosPersistence puntosPersistence;
    
    @Inject
    private TarjetaDeCreditoPersistence tarjetaCreditoPersistence;
    
    @Inject
    private CompraPersistence compraPersistence;
    
    @Inject
    private ComentarioPersistence comentarioPersistence;
    
    @Inject
    private RecargaPersistence recargaPersistence;
    
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
       // em.createQuery("delete from TarjetaDeCreditoEntity").executeUpdate(); 
      //  em.createQuery("delete from RecargaEntity").executeUpdate(); 
       // em.createQuery("delete from CompraEntity").executeUpdate(); 
      //  em.createQuery("delete from TarjetaPuntosEntity").executeUpdate();         
      //  em.createQuery("delete from ComentarioEntity").executeUpdate();         
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }


    private void insertData() {
        
        //Inicializar objetos
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            List<TarjetaDeCreditoEntity> tarjetasDeCredito = new ArrayList<>();
            List<TarjetaPuntosEntity> tarjetasPuntos = new ArrayList<>();
            List<RecargaEntity> recargas = new ArrayList<>();
            List<CompraEntity> compras = new ArrayList<>();
            List<ComentarioEntity> comentarios = new ArrayList<>();

            //Agrego 3 compras
            for(int j = 0; j < 3; j++)
            {
                CompraEntity compra = factory.manufacturePojo(CompraEntity.class);
                compraPersistence.create(compra);
                compras.add(compra);
                
                TarjetaDeCreditoEntity tc = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
                tarjetaCreditoPersistence.create(tc);
                tarjetasDeCredito.add(tc);
                
                TarjetaPuntosEntity puntos = factory.manufacturePojo(TarjetaPuntosEntity.class);
                puntosPersistence.create(puntos);
                tarjetasPuntos.add(puntos);
                
                RecargaEntity recarga = factory.manufacturePojo(RecargaEntity.class);
                recargaPersistence.create(recarga);
                recargas.add(recarga);
                
                ComentarioEntity comentario = factory.manufacturePojo(ComentarioEntity.class);
                comentarioPersistence.create(comentario);
                comentarios.add(comentario);
            }
            
            //Agregar elementos
            entity.setCompras(compras);
            entity.setTarjetasDeCredito(tarjetasDeCredito);
            entity.setTarjetasPuntos(tarjetasPuntos);
            entity.setRecargas(recargas);
            entity.setComentarios(comentarios);  
                        
            em.merge(entity);
            data.add(entity);
        } 
    }
    
    public ClientePersistenceTest() {
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
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        
               
        ClienteEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getUsuario());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getUsuario(), entity.getUsuario());     
    }

    /**
     * Test of update method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        ClienteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);

        newEntity.setUsuario(entity.getUsuario());

        persistence.update(newEntity);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getUsuario());

        Assert.assertEquals(newEntity.getUsuario(), resp.getUsuario());
    }

    /**
     * Test of delete method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        ClienteEntity entity = data.get(0);
        persistence.delete(entity.getUsuario());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getUsuario());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class RecargaPersistance.
     * @throws java.lang.Exception
     */
    @Test
    public void testFind() throws Exception {
        ClienteEntity entity = data.get(0);
        ClienteEntity newEntity = persistence.find(entity.getUsuario());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
    }        
    /**
     * Test of findAll method, of class ClientePersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        List<ClienteEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        
        for (ClienteEntity ent : list) {
             boolean found = false;
            for (ClienteEntity entity : data) {
                 if (ent.getUsuario().equals(entity.getUsuario())) {
                       found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}
