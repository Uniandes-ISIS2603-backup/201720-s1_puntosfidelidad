/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.persistence;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.FotoEntity;
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
public class FotoPersistenceTest {

    @Inject
    private FotoPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<FotoEntity> data = new ArrayList<FotoEntity>();
    
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
                .addPackage(FotoEntity.class.getPackage())
                .addPackage(FotoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public FotoPersistenceTest()
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
     * Test of create method, of class FotoPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        FotoEntity newEntity = new FotoEntity();            
        newEntity.setURL("url.com/"+"nani?");
        FotoEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        FotoEntity entity = em.find(FotoEntity.class, result.getURL());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getURL(), entity.getURL());
    }

    /**
     * Test of update method, of class FotoPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        FotoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        FotoEntity newEntity = factory.manufacturePojo(FotoEntity.class);

        newEntity.setURL(entity.getURL());

        persistence.update(newEntity);

        FotoEntity resp = em.find(FotoEntity.class, entity.getURL());

        Assert.assertEquals(newEntity.getURL(), resp.getURL());
    }

    /**
     * Test of delete method, of class FotoPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        FotoEntity entity = data.get(0);
        persistence.delete(entity.getURL());
        FotoEntity deleted = em.find(FotoEntity.class, entity.getURL());
        Assert.assertNull(deleted);
    }

    /**
     * Test of findWithId method, of class FotoPersistence.
     */
    @Test
    public void testFindWithURL() throws Exception {
        FotoEntity entity = data.get(0);
        FotoEntity newEntity = persistence.findWithURL(entity.getURL());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getURL(), newEntity.getURL());
    }

    /**
     * Test of findAll method, of class FotoPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<FotoEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (FotoEntity ent : list) {
        boolean found = false;
        for (FotoEntity entity : data) {
            if (ent.getURL().equals(entity.getURL())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
        }
    }
    
    /**
     * Test of getComentario method, of class FotoPersistence.
     */
    @Test
    public void getComentarioTest(String url)
    {
        List<FotoEntity> fotos = persistence.findAll();
        
        for(FotoEntity foto: fotos)
        {
            //Si ningún comentario es null, significa que se guardan correctamente
            Assert.assertNotNull(foto.getComentario());
        }
    }
    
    private void clearData() {
        em.createQuery("delete from FotoEntity").executeUpdate();
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            FotoEntity entity = new FotoEntity();            
            entity.setURL("url.com/"+i);
            em.persist(entity);
            data.add(entity);
        }
        
        ComentarioEntity comentario1 = factory.manufacturePojo(ComentarioEntity.class);
        ComentarioEntity comentario2 = factory.manufacturePojo(ComentarioEntity.class);
        //Un comentario con 2 fotos
        List<FotoEntity> fotos1 = new ArrayList<>();
        fotos1.add(data.get(0));
        fotos1.add(data.get(1));
        comentario1.setFotos(fotos1);
        for (FotoEntity foto : fotos1)
        {
            foto.setComentario(comentario1);
            em.merge(foto);
        }
        
        //Un comentario con 1 fotos
        List<FotoEntity> fotos2 = new ArrayList<>();
        fotos2.add(data.get(2));
        for (FotoEntity foto : fotos2)
        {
            foto.setComentario(comentario2);
            em.merge(foto);
        }
        comentario2.setFotos(fotos2);
        
        em.persist(comentario1);
        em.persist(comentario2);
    }
}
