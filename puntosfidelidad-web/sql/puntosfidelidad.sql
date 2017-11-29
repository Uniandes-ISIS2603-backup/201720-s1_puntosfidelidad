delete from RecargaEntity;
delete from TarjetaDeCreditoEntity;
delete from FotoEntity;
delete from ComentarioEntity;
delete from ProductoCompraEntity;
delete from ProductoEntity;
delete from CompraEntity;
delete from EventoEntity;
delete from TarjetaPuntosEntity;
delete from SucursalEntity;
delete from UbicacionEntity;
delete from ClienteEntity;
delete from RestauranteEntity;
delete from AdministradorEntity;
-- delete from EventoEntity_RestauranteEntity;
-- delete from EventoEntity_UbicacionEntity;

insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('Anonimo','Anónimo','','');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C1','Cliente1','media/cliente2.jpg','*');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C2','Cliente2','media/cliente3.jpg','**');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C3','Cliente3','media/cliente4.jpg','***');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C4','Cliente4','media/cliente2.jpg','****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C5','Cliente5','media/cliente1.jpg','*****');

insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10000,'Bancolombia', 4562182, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10010,'Bancopichincha', 4578236, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10030,'Piramide', 54126, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10040,'Bancolombia', 4562182, 'C2' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10050,'BancoLadron', 897521, 'C3' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10060,'BancoLadron', 8497521, 'C3' );

insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (100000, 5000,5000,10,'C1');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (200000, 5000,5000,20,'C2');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (300000, 1000,5000,20,'C3');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (400000, 8000,5010,20,'C4');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (500000, 5900,2000,20,'C4');

insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (10000,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (20000,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (30000,'4/8/1967', 8000, 'C2' ,200000,10040);
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (40000,'10/9/1968', 8000, 'C3',300000,10050 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (50000,'10/9/1968', 84000, 'C3',300000,10050 );

insert into AdministradorEntity (USUARIO, CONTRASENA) values ('Valeria','a');
insert into AdministradorEntity (USUARIO, CONTRASENA) values ('Andres','meencantalapizza');
insert into AdministradorEntity (USUARIO, CONTRASENA) values ('Camilo','programing');
insert into AdministradorEntity (USUARIO, CONTRASENA) values ('Julian','cacamolida');
insert into AdministradorEntity (USUARIO, CONTRASENA) values ('S','s');

insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO) values ('187956f','Mc Donalds','Hamburguesas','Valeria');
insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO) values ('597356c','Randys','Hamburguesas','Andres');
insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO) values ('357484u','Subway','Sanduches','Camilo');
insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO) values ('257687a','Archies','Italiana','Julian');

insert into UbicacionEntity (direccion, latitud, longitud) values ('Randys_Ubicacion',13548948,15322120);
insert into UbicacionEntity (direccion, latitud, longitud) values ('McDonalds_Ubicacion',14867031,12084653);
insert into UbicacionEntity (direccion, latitud, longitud) values ('Archies_Ubicacion',10544662,18468435);
insert into UbicacionEntity (direccion, latitud, longitud) values ('Subway_Ubicacion',18645132,15488620);

insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion) values (88, 'Sucursal de Randys', '4/7/1965', '4/8/1965', 'Randys','597356c', 'Randys_Ubicacion');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion) values (89, 'Sucursal de Mc Donals', '7/8/1965', '7/9/1965', 'Mc Donals','187956f', 'McDonalds_Ubicacion');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion) values (90, 'Sucursal de Archies', '9/4/1965', '9/5/1965', 'Archies','257687a', 'Archies_Ubicacion');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion) values (91, 'Sucursal de Subway', '3/1/1965', '3/2/1965', 'Subway','357484u', 'Subway_Ubicacion');

insert into ProductoEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE_NIT) values (1,'BigMac','media/BigMac.jpg',16000,20, '187956f');
insert into ProductoEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE_NIT) values (10,'Pizza','media/pizza.jpeg',22000,50, '257687a');
insert into ProductoEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE_NIT) values (20,'Baratisimo','media/baratisimo.jpg',5000,10, '357484u');
insert into ProductoEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE_NIT) values (30,'Hamburguesa Res','media/BigMac.jpg',5000,20, '597356c');

insert into ProductoCompraEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE) values (1,'BigMac','media/BigMac.jpg',16000,20, '187956f');
insert into ProductoCompraEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE) values (10,'Pizza','media/pizza.jpeg',22000,50, '257687a');
insert into ProductoCompraEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE) values (20,'Baratisimo','media/baratisimo.jpg',5000,10, '357484u');
insert into ProductoCompraEntity (id, nombre,imagen, valorDinero, valorpuntos, RESTAURANTE) values (30,'Hamburguesa Res','media/BigMac.jpg',5000,20, '597356c');

insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (1, 'Que buen servicio +10', 10, 88, 'C1');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (2, 'Muy buen ambiente', 8, 89, 'C2');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (3, 'Comida fria, mal servicio', 2, 91, 'C3');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (4, 'Delicioso, muy recomendado', 10, 90, 'C2');

insert into FotoEntity (COMENTARIO_ID, url) values (1, 'media/restaurante.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (1, 'media/restaurante1.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (1, 'media/restaurante3.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (2, 'media/restaurante2.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (3, 'media/restaurante1.jpg');

insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion) values ('Taquitos gratis','4/7/1965' , '6/6/2010' , 'Se regalaran tacos gratis.' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion) values ('Super Hamburguesas','4/7/1965' , '5/8/2010' , 'Se bajaran de precio las mejores hamburguesas de cada restaurante.' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion) values ('Festival Super Picante','2/16/1965' , '3/6/2010' , 'Se realizara un festival con los platos mas picantes de cada restaurante.' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion) values ('La Cocina Italiana','8/10/1965' , '9/6/2010' , 'Un festival con promociones en platos y restaurantes italianos.' );

insert into CompraEntity (ID, PAGOCONPUNTOS, CLIENTE_USUARIO, SUCURSAL_ID, TARJETAPUNTOS_ID) values (20, 1, 'C1', 91, (SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C2'));
insert into CompraEntity (ID, PAGOCONPUNTOS, CLIENTE_USUARIO, SUCURSAL_ID, TARJETAPUNTOS_ID) values (30, 0, 'C2', 89, (SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C1'));
insert into CompraEntity (ID, PAGOCONPUNTOS, CLIENTE_USUARIO, SUCURSAL_ID, TARJETAPUNTOS_ID) values (40, 0, 'C3', 90, (SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C4'));
insert into CompraEntity (ID, PAGOCONPUNTOS, CLIENTE_USUARIO, SUCURSAL_ID, TARJETAPUNTOS_ID) values (50, 0, 'C4', 88, (SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C3'));

-- insert into EventoEntity_RestauranteEntity (Eventos_Nombre, Restaurante_Nit) values ('Super Hamburguesas', '187956f');
-- insert into EventoEntity_RestauranteEntity (Eventos_Nombre, Restaurante_Nit) values ('La Cocina Italiana', '257687a');
-- insert into EventoEntity_RestauranteEntity (Eventos_Nombre, Restaurante_Nit) values ('Festival Super Picante', '357484u');

-- insert into EventoEntity_UbicacionEntity (EventoEntity_Nombre, Ubicaciones_Direccion) values ('Super Hamburguesas', 'McDonalds_Ubicacion');
-- insert into EventoEntity_UbicacionEntity (EventoEntity_Nombre, Ubicaciones_Direccion) values ('Festival Super Picante', 'Subway_Ubicacion');
-- insert into EventoEntity_UbicacionEntity (EventoEntity_Nombre, Ubicaciones_Direccion) values ('La Cocina Italiana', 'Archies_Ubicacion');

insert into CompraEntity_ProductoCompraEntity (COMPRAENTITY_ID, PRODUCTOS_ID) values (20,1);
insert into CompraEntity_ProductoCompraEntity (COMPRAENTITY_ID, PRODUCTOS_ID) values (20,10);
insert into CompraEntity_ProductoCompraEntity (COMPRAENTITY_ID, PRODUCTOS_ID) values (20,20);