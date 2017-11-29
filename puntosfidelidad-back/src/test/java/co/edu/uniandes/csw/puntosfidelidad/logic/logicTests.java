/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.puntosfidelidad.logic;

import co.edu.uniandes.csw.puntosfidelidad.ejb.AdministradorLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ClienteLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ComentarioLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.CompraLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.EventoLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.ProductoLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RecargaLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.RestauranteLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.SucursalLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.TarjetaDeCreditoLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.TarjetaPuntosLogic;
import co.edu.uniandes.csw.puntosfidelidad.ejb.UbicacionLogic;
import co.edu.uniandes.csw.puntosfidelidad.entities.AdministradorEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ClienteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.CompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.EventoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.FotoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoCompraEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.ProductoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RecargaEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.RestauranteEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.SucursalEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.TarjetaPuntosEntity;
import co.edu.uniandes.csw.puntosfidelidad.entities.UbicacionEntity;
import co.edu.uniandes.csw.puntosfidelidad.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.puntosfidelidad.persistence.AdministradorPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ClientePersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ComentarioPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.CompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.EventoPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.FotoPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoCompraPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ProductoPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RecargaPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RecargaPersistenceTest;
import co.edu.uniandes.csw.puntosfidelidad.persistence.RestaurantePersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.SucursalPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.TarjetaPuntosPersistence;
import co.edu.uniandes.csw.puntosfidelidad.persistence.UbicacionPersistence;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLSyntaxErrorException;
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
 * @author JuliànManrique
 */
@RunWith(Arquillian.class)
public class logicTests {

    @Inject
    TarjetaPuntosLogic TPlogic;

    @Inject
    UbicacionLogic UBIlogic;

    @Inject
    TarjetaDeCreditoLogic TClogic;

    @Inject
    SucursalLogic SUClogic;

    @Inject
    RestauranteLogic RESTAlogic;

    @Inject
    RecargaLogic REClogic;

    @Inject
    ProductoLogic PRODlogic;

    @Inject
    EventoLogic EVElogic;

    @Inject
    CompraLogic COMPlogic;

    @Inject
    ComentarioLogic COMlogic;

    @Inject
    ClienteLogic CLIlogic;

    @Inject
    AdministradorLogic ADMlogic;

    @Inject
    TarjetaPuntosPersistence tarjetaPuntosPersistence;

    @Inject
    private CompraPersistence compraPersistence;

    @Inject
    private ClientePersistence clientePersistence;

    @Inject
    private SucursalPersistence sucursalPersistence;

    @Inject
    private RestaurantePersistence restaurantePersistence;

    @Inject
    private ProductoPersistence productoPersistence;

    @Inject
    private ProductoCompraPersistence productoCompraPersistence;
            
            
            @Inject
    
    private EventoPersistence eventoPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    //???
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UbicacionPersistence.class.getPackage())
                .addPackage(ComentarioPersistence.class.getPackage())
                .addPackage(TarjetaPuntosPersistence.class.getPackage())
                .addPackage(SucursalPersistence.class.getPackage())
                .addPackage(RestaurantePersistence.class.getPackage())
                .addPackage(RecargaPersistence.class.getPackage())
                .addPackage(ProductoPersistence.class.getPackage())
                .addPackage(FotoPersistence.class.getPackage())
                .addPackage(EventoPersistence.class.getPackage())
                .addPackage(CompraPersistence.class.getPackage())
                .addPackage(ComentarioPersistence.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addPackage(AdministradorPersistence.class.getPackage())
                .addPackage(TarjetaPuntosLogic.class.getPackage())
                .addPackage(UbicacionLogic.class.getPackage())
                .addPackage(TarjetaDeCreditoLogic.class.getPackage())
                .addPackage(SucursalLogic.class.getPackage())
                .addPackage(RestauranteLogic.class.getPackage())
                .addPackage(RecargaLogic.class.getPackage())
                .addPackage(ProductoLogic.class.getPackage())
                .addPackage(EventoLogic.class.getPackage())
                .addPackage(CompraLogic.class.getPackage())
                .addPackage(ComentarioLogic.class.getPackage())
                .addPackage(CompraLogic.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(AdministradorLogic.class.getPackage())
                .addPackage(AdministradorEntity.class.getPackage())
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ComentarioEntity.class.getPackage())
                .addPackage(CompraEntity.class.getPackage())
                .addPackage(EventoEntity.class.getPackage())
                .addPackage(FotoEntity.class.getPackage())
                .addPackage(ProductoEntity.class.getPackage())
                .addPackage(RecargaEntity.class.getPackage())
                .addPackage(RestauranteEntity.class.getPackage())
                .addPackage(SucursalEntity.class.getPackage())
                .addPackage(TarjetaDeCreditoEntity.class.getPackage())
                .addPackage(TarjetaPuntosEntity.class.getPackage())
                .addPackage(UbicacionEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public logicTests() {

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

    private void insertData() {
        TPinsertData();
        UBIinsertData();
        TCinsertData();
        SUCCinsertData();
        RESTAinsertData();
        RECAinsertData();
        try {
            PRODinsertData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        FOTOinsertData();

    }

    private void TPinsertData() {

        //Inicializar objetos
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            TarjetaPuntosEntity entity = factory.manufacturePojo(TarjetaPuntosEntity.class);
            em.persist(entity);

            List<CompraEntity> compras = new ArrayList<>();

            //Agrego 3 compras
            for (int j = 0; j < 3; j++) {
                CompraEntity compra = factory.manufacturePojo(CompraEntity.class);
                compraPersistence.create(compra);
                compras.add(compra);
            }

            //Agregar compra
            entity.setCompras(compras);

            //Agregar un cliente cualquiera
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            entity.setCliente(cliente);
            em.persist(cliente);

            em.merge(entity);
        }
    }

    private void UBIinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UbicacionEntity entity = factory.manufacturePojo(UbicacionEntity.class);
            em.persist(entity);
        }
    }

    private void TCinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
        clientePersistence.create(cliente);
        for (int i = 0; i < 3; i++) {
            TarjetaDeCreditoEntity entity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
            entity.setCliente(cliente);
            em.persist(entity);
        }
    }

    private void SUCCinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SucursalEntity entity = factory.manufacturePojo(SucursalEntity.class);

            em.persist(entity);
        }
    }

    private void RESTAinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            RestauranteEntity entity = factory.manufacturePojo(RestauranteEntity.class);

            List<SucursalEntity> sucursales = new ArrayList<>();
            List<ProductoEntity> productos = new ArrayList<>();
            List<EventoEntity> eventos = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                ProductoEntity producto = factory.manufacturePojo(ProductoEntity.class);
                productoPersistence.create(producto);
                productos.add(producto);

                SucursalEntity sucursal = factory.manufacturePojo(SucursalEntity.class);
                sucursalPersistence.create(sucursal);
                sucursales.add(sucursal);

                EventoEntity evento = factory.manufacturePojo(EventoEntity.class);
                eventoPersistence.create(evento);
                eventos.add(evento);
            }
            entity.setSucursales(sucursales);
            entity.setProductos(productos);
            entity.setEventos(eventos);
            em.persist(entity);
        }
    }

    private void RECAinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
        clientePersistence.create(cliente);
        for (int i = 0; i < 3; i++) {
            RecargaEntity entity = factory.manufacturePojo(RecargaEntity.class);
            entity.setCliente(cliente);
            em.persist(entity);
        }
    }

    private void PRODinsertData() throws BusinessLogicException {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ProductoEntity entity = factory.manufacturePojo(ProductoEntity.class);
            RestauranteEntity restaurante = factory.manufacturePojo(RestauranteEntity.class);

            restaurantePersistence.create(restaurante);
            entity.setRestaurante(restaurante);
            em.persist(entity);
        }
    }

    private void FOTOinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            FotoEntity entity = new FotoEntity();
            entity.setURL("url.com/" + i);
            em.persist(entity);
        }

        ComentarioEntity comentario1 = factory.manufacturePojo(ComentarioEntity.class);
        ComentarioEntity comentario2 = factory.manufacturePojo(ComentarioEntity.class);
        //Un comentario con 2 fotos
        List<FotoEntity> fotos1 = new ArrayList<>();
        comentario1.setFotos(fotos1);
        for (FotoEntity foto : fotos1) {
            foto.setComentario(comentario1);
            em.merge(foto);
        }

        //Un comentario con 1 fotos
        List<FotoEntity> fotos2 = new ArrayList<>();
        for (FotoEntity foto : fotos2) {
            foto.setComentario(comentario2);
            em.merge(foto);
        }
        comentario2.setFotos(fotos2);

        em.persist(comentario1);
        em.persist(comentario2);
    }

    private void EVENTOinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EventoEntity entity = factory.manufacturePojo(EventoEntity.class);

            em.persist(entity);
        }
    }

    private void COMPRAinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CompraEntity entity = factory.manufacturePojo(CompraEntity.class);
            SucursalEntity sucur = factory.manufacturePojo(SucursalEntity.class);
            ClienteEntity client = factory.manufacturePojo(ClienteEntity.class);

            TarjetaPuntosEntity tarjeta = factory.manufacturePojo(TarjetaPuntosEntity.class);

            clientePersistence.create(client);
            entity.setCliente(client);

            sucursalPersistence.create(sucur);
            entity.setSucursal(sucur);

            tarjetaPuntosPersistence.create(tarjeta);
            entity.setTarjetaPuntos(tarjeta);

            List<ProductoCompraEntity> prods = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                ProductoCompraEntity prod = factory.manufacturePojo(ProductoCompraEntity.class);
                productoCompraPersistence.create(prod);
                prods.add(prod);
            }
            entity.setProductos(prods);

            em.persist(entity);
        }
    }

    private void COMENTARIOinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ComentarioEntity entity = factory.manufacturePojo(ComentarioEntity.class);

            COMENinsertDataToEntity(entity, factory);

            em.persist(entity);
        }
    }

    private void COMENinsertDataToEntity(ComentarioEntity entity, PodamFactory factory) {
        //Crea y se persisten de una vez, luego se linkean al comentario y se actualiza

        SucursalEntity sucursal = factory.manufacturePojo(SucursalEntity.class);
        em.persist(sucursal);

        ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
        em.persist(cliente);

        entity.setCliente(cliente);
        entity.setSucursal(sucursal);

        em.merge(entity);
    }

    private void CLIENTEinsertData() {

        List<TarjetaDeCreditoEntity> tarjetasDeCredito = new ArrayList<>();
        List<TarjetaPuntosEntity> tarjetasPuntos = new ArrayList<>();
        List<RecargaEntity> recargas = new ArrayList<>();
        List<CompraEntity> compras = new ArrayList<>();
        List<ComentarioEntity> comentarios = new ArrayList<>();

        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 8; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            entity.setCompras(compras);
            entity.setTarjetasDeCredito(tarjetasDeCredito);
            entity.setTarjetasPuntos(tarjetasPuntos);
            entity.setRecargas(recargas);
            entity.setComentarios(comentarios);

            em.persist(entity);
        }
    }

    private void ADMINinsertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AdministradorEntity entity = factory.manufacturePojo(AdministradorEntity.class);

            List<RestauranteEntity> restaurantes = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                RestauranteEntity restaurante = factory.manufacturePojo(RestauranteEntity.class);
                restaurantePersistence.create(restaurante);
                restaurantes.add(restaurante);
            }
            entity.setRestaurantes(restaurantes);

            em.merge(entity);
        }
    }

    //TEST
    @Test
    public void testLogic() {
        try {
            List<TarjetaPuntosEntity> tps = TPlogic.getTarjetasPuntos();
            for (TarjetaPuntosEntity tp : tps) {
                TPlogic.deleteTarjetaPuntos(tp.getId());
                TPlogic.createTarjetaPuntos(tp);
                TPlogic.getCompras(tp.getId());
                TPlogic.getTarjetaPuntos(tp.getId());
                TPlogic.updateTarjetaPuntos(tp);
            }

            List<ClienteEntity> clis = CLIlogic.getClientes();

            for (ClienteEntity cli : clis) {
                try {
                    CLIlogic.deleteCliente(cli.getUsuario());
                    CLIlogic.createcliente(cli);
                    CLIlogic.getCliente(cli.getUsuario());
                    CLIlogic.listComentarios(cli.getUsuario());
                    CLIlogic.listCompras(cli.getUsuario());
                    CLIlogic.listRecargas(cli.getUsuario());
                    CLIlogic.listTarjetaDeCredito(cli.getUsuario());
                    CLIlogic.listTarjetasPuntos(cli.getUsuario());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("RIP: " + e.getMessage());
            e.printStackTrace();
            fail();
        }
    }
}
