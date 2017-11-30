/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoCompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ClientePersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoCompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.SucursalPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.TarjetaPuntosPersistence;
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
 * @author aa.yepes
 */
@RunWith(Arquillian.class)
public class CompraLogicTest {
    
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
                .addPackage(CompraEntity.class.getPackage())
                .addPackage(CompraPersistence.class.getPackage())
                .addPackage(CompraLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Inject
    private CompraLogic logic;
    
    @Inject
    private ProductoCompraPersistence persistenceProd;
    
    @Inject
    private SucursalPersistence persistenceSucur;
    
    @Inject
    private ClientePersistence persistenceCliente;
    
    @Inject
    private TarjetaPuntosPersistence persistenceTarjetaPuntos;
    
    @Inject
    private ProductoPersistence persisProd;
    
    
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
    
    private List<CompraEntity> data = new ArrayList<CompraEntity>();
    
    public CompraLogicTest() {
    }
    
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
        em.createQuery("delete from CompraEntity").executeUpdate();
    }


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CompraEntity entity = factory.manufacturePojo(CompraEntity.class);
            SucursalEntity sucur = factory.manufacturePojo(SucursalEntity.class);
            ClienteEntity client = factory.manufacturePojo(ClienteEntity.class);
            
            TarjetaPuntosEntity tarjeta = factory.manufacturePojo(TarjetaPuntosEntity.class);
            
            persistenceCliente.create(client);
            entity.setCliente(client);
            
            persistenceSucur.create(sucur);
            entity.setSucursal(sucur);
            
            persistenceTarjetaPuntos.create(tarjeta);
            entity.setTarjetaPuntos(tarjeta);
            
            
            List<ProductoCompraEntity> prods = new ArrayList<>();
            for(int j = 0; j < 3; j++)
            {
                ProductoCompraEntity prod = factory.manufacturePojo(ProductoCompraEntity.class);
                persistenceProd.create(prod);
                prods.add(prod);
            }
            entity.setProductos(prods);
            
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCompra method, of class CompraLogic.
     */
    @Test
    public void testCreateCompra() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        CompraEntity newEntity = factory.manufacturePojo(CompraEntity.class);
        CompraEntity result = logic.createCompra(newEntity);

        Assert.assertNotNull(result);
        CompraEntity entity = em.find(CompraEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of getCompra method, of class CompraLogic.
     */
    @Test
    public void testGetCompra() throws Exception {
        CompraEntity entity = data.get(0);
        CompraEntity newEntity = logic.getCompra(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of getCompras method, of class CompraLogic.
     */
    @Test
    public void testGetCompras() throws Exception {
        List<CompraEntity> list = logic.getCompras();
        Assert.assertEquals(data.size(), list.size());
        for (CompraEntity ent : list) {
            boolean found = false;
            for (CompraEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of deleteCompra method, of class CompraLogic.
     */
    @Test
    public void testDeleteCompra() throws Exception {
        CompraEntity entity = data.get(0);
        logic.deleteCompra(entity.getId());
        CompraEntity deleted = em.find(CompraEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of updateCompra method, of class CompraLogic.
     */
    @Test
    public void testUpdateCompra() throws Exception {
        CompraEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CompraEntity newEntity = factory.manufacturePojo(CompraEntity.class);

        newEntity.setId(entity.getId());

        logic.updateCompra(newEntity);

        CompraEntity resp = em.find(CompraEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of listProductos method, of class CompraLogic.
     */
    @Test
    public void testListProductos() throws Exception {
        CompraEntity entity = data.get(0);

        Assert.assertEquals(logic.listProductos(entity.getId()).size(), entity.getProductos().size());
        Assert.assertEquals(logic.listProductos(entity.getId()).get(0).getId(), entity.getProductos().get(0).getId());
    }

    /**
     * Test of getProducto method, of class CompraLogic.
     */
    @Test
    public void testGetProducto() throws Exception {
        ProductoCompraEntity prod = data.get(0).getProductos().get(0);
        
        ProductoCompraEntity prod2 = logic.getProducto(data.get(0).getId(), prod.getId());
        System.err.println(data.get(0).getProductos().size());
                 
        assertNull(prod2);
    }

    /**
     * Test of addProducto method, of class CompraLogic.
     */
    @Test
    public void testAddProducto() throws Exception {
       
    }

    /**
     * Test of removeProducto method, of class CompraLogic.
     */
    @Test
    public void testRemoveProducto() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ProductoCompraEntity prod = factory.manufacturePojo(ProductoCompraEntity.class);
        
        persistenceProd.create(prod);
        
        logic.addProducto(data.get(0).getId(), prod.getId());
        
        logic.removeProducto(data.get(0).getId(), prod.getId());
        
        assertNull(logic.getProducto(data.get(0).getId(), prod.getId()));
    }

    /**
     * Test of getSucursal method, of class CompraLogic.
     */
    @Test
    public void testGetSucursal() throws Exception {
        CompraEntity entity = data.get(0);
        SucursalEntity sucursal = data.get(0).getSucursal();
        SucursalEntity sucur = logic.getSucursal(entity.getId());
        Assert.assertEquals(sucursal.getNombre(), sucur.getNombre());
    }

    /**
     * Test of getCliente method, of class CompraLogic.
     */
    @Test
    public void testGetCliente() throws Exception {
        CompraEntity entity = data.get(0);
        ClienteEntity cliente = data.get(0).getCliente();
        ClienteEntity clien = logic.getCliente(entity.getId());
        Assert.assertEquals(cliente.getNombre(), clien.getNombre());
    }

    /**
     * Test of getTarjetaPuntos method, of class CompraLogic.
     */
    @Test
    public void testGetTarjetaPuntos() throws Exception {
        CompraEntity entity = data.get(0);
        TarjetaPuntosEntity tarjeta = data.get(0).getTarjetaPuntos();
        TarjetaPuntosEntity tar = logic.getTarjetaPuntos(entity.getId());
        Assert.assertEquals(tarjeta.getId(), tar.getId());
    }
    
}
