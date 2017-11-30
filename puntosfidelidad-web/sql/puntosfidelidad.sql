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

insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('Anonimo','Anónimo','','');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C1','Cliente1','media/perfil/1.png','*');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C2','Cliente2','media/perfil/2.png','**');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C3','Cliente3','media/perfil/9.png','***');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C4','Cliente4','media/perfil/4.png','****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C5','Cliente5','media/perfil/5.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C6','Cliente1','media/perfil/12.png','*');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C7','Cliente2','media/perfil/12.png','**');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C8','Cliente3','media/perfil/9.png','***');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C9','Cliente4','media/perfil/4.png','****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C10','Cliente5','media/perfil/5.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C11','Cliente5','media/perfil/5.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C12','Cliente5','media/perfil/11.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C13','Cliente5','media/perfil/10.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C14','Cliente5','media/perfil/9.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C15','Cliente5','media/perfil/8.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C16','Cliente5','media/perfil/7.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C17','Cliente5','media/perfil/12.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C18','Cliente5','media/perfil/4.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C19','Cliente5','media/perfil/1.png','*****');
insert into ClienteEntity (usuario, nombre, imagen, contrasena) values ('C20','Cliente5','media/perfil/3.png','*****');

insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10000,'Bancolombia', 4562182, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10010,'Bancopichincha', 4578236, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10030,'Piramide', 54126, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10040,'Bancolombia', 4562182, 'C2' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10050,'BancoLadron', 897521, 'C3' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10060,'BancoLadron', 8497521, 'C3' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10080,'Bancopichincha', 14562182, 'C12' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10090,'Bancolombia', 54562182, 'C13' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10100,'Piramide', 74562182, 'C20' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10110,'Bancolombia', 64562182, 'C9' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10120,'Bancopichincha', 94562182, 'C17' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10324,'Bancolombia', 554562182, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10222,'Bancopichincha', 43578236, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10333,'Piramide', 454126, 'C1' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10444,'Bancolombia', 24562182, 'C2' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10550,'BancoLadron', 8497521, 'C3' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10555,'BancoLadron', 18497521, 'C3' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10666,'Bancopichincha', 453462182, 'C12' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10777,'Bancolombia', 45621982, 'C13' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (14430,'Piramide', 45621282, 'C20' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (16730,'Bancolombia', 45621682, 'C9' );
insert into TarjetaDeCreditoEntity (id,banco, numero, cliente_usuario) values (10249,'Bancopichincha', 456342182, 'C17' );


insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (100000, 5000,5000,10,'C1');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (456546, 6900,3469,50,'C1');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (200000, 5000,5000,20,'C2');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (300000, 1000,5000,20,'C3');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (400000, 8000,5010,20,'C4');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (500000, 5900,2000,20,'C4');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (1, 5000,5000,10,'C5');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (2, 5000,5000,20,'C6');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (3, 1000,5000,20,'C7');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (4, 8000,5010,20,'C8');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (5, 5900,2000,20,'C8');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (6, 5000,5000,10,'C9');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (7, 5000,5000,20,'C10');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (8, 1000,5000,20,'C11');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (9, 8000,5010,20,'C12');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (10, 5900,2000,20,'C13');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (11, 5000,5000,10,'C14');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (12, 5000,5000,20,'C15');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (13, 1000,5000,20,'C16');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (14, 8000,5010,20,'C16');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (15, 5900,2000,20,'C17');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (16, 5000,5000,10,'C18');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (17, 5000,5000,20,'C19');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (18, 1000,5000,20,'C1');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (19, 8000,5010,20,'C20');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (20, 5900,2000,20,'C20');
insert into TarjetaPuntosEntity (id, montoactual, montobasico, numpuntos, cliente_usuario) values (21, 5900,2000,40,'C1');

insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (105000,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (2015000,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (301000,'4/8/1967', 8000, 'C2' ,200000,10040);
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (40000,'10/9/1968', 8000, 'C3',300000,10050 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (5034000,'10/9/1968', 84000, 'C3',300000,10050 );
--
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (10001,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (20002,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (30003,'4/8/1967', 8000, 'C2' ,200000,10040);
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (40004,'10/9/1968', 8000, 'C3',300000,10050 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (50005,'10/9/1968', 84000, 'C3',300000,10050 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (32000,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (22100,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (325691,'4/8/1967', 8000, 'C2' ,200000,10040);
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (405000,'10/9/1968', 8000, 'C3',300000,10050 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (5005600,'10/9/1968', 84000, 'C3',300000,10050 );
--
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (10324011,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (203022,'4/7/1965', 8000, 'C1' ,100000,10030 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (300533,'4/8/1967', 8000, 'C2' ,200000,10040);
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (400444,'10/9/1968', 8000, 'C3',300000,10050 );
insert into RecargaEntity (id,fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values (506055,'10/9/1968', 84000, 'C3',300000,10050 );


insert into AdministradorEntity (USUARIO, CONTRASENA,IMAGEN) values ('Valeria','123', 'media/cliente5.jpg');
insert into AdministradorEntity (USUARIO, CONTRASENA,IMAGEN) values ('Andres','meencantalapizza', 'media/cliente1.jpg');
insert into AdministradorEntity (USUARIO, CONTRASENA,IMAGEN) values ('Camilo','programing', 'media/cliente2.jpg');
insert into AdministradorEntity (USUARIO, CONTRASENA,IMAGEN) values ('Julian','123', 'media/cliente3.jpg');
insert into AdministradorEntity (USUARIO, CONTRASENA, IMAGEN) values ('S','s', 'media/cliente4.jpg');


insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO, IMAGEN) values ('187956f','Mc Donalds','Hamburguesas','Valeria', 'media/restaurante.jpg');
insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO, IMAGEN) values ('597356c','Randys','Hamburguesas','Andres', 'media/restaurante1.jpg');
insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO, IMAGEN) values ('357484u','Subway','Sanduches','Camilo', 'media/restaurante2.jpg');
insert into RestauranteEntity (NIT, NOMBRE, TIPOCOMIDA,ADMINISTRADOR_USUARIO, IMAGEN) values ('257687a','Archies','Italiana','Julian', 'media/restaurante3.jpg');

insert into UbicacionEntity (direccion, latitud, longitud) values ('Randys_Ubicacion',13548948,15322120);
insert into UbicacionEntity (direccion, latitud, longitud) values ('McDonalds_Ubicacion',14867031,12084653);
insert into UbicacionEntity (direccion, latitud, longitud) values ('Archies_Ubicacion',10544662,18468435);
insert into UbicacionEntity (direccion, latitud, longitud) values ('Subway_Ubicacion',18645132,15488620);

insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (88, 'Pasadena', '4/7/1965', '4/8/1965', 'Randys','597356c', 'Randys_Ubicacion', 'media/restaurante4.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (89, 'Salitre', '7/8/1965', '7/9/1965', 'Mc Donals','597356c', 'McDonalds_Ubicacion','media/restaurante1.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (90, 'Suba', '9/4/1965', '9/5/1965', 'Archies','597356c', 'Archies_Ubicacion', 'media/restaurante2.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (91, 'Centro', '3/1/1965', '3/2/1965', 'Subway','597356c', 'Subway_Ubicacion', 'media/restaurante3.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (92, 'chia', '4/7/1965', '4/8/1965', 'Randys','187956f', 'Randys_Ubicacion', 'media/restaurante4.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (93, 'Bosa', '7/8/1965', '7/9/1965', 'Mc Donals','187956f', 'McDonalds_Ubicacion','media/restaurante1.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (94, 'Suba', '9/4/1965', '9/5/1965', 'Archies','257687a', 'Archies_Ubicacion', 'media/restaurante2.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (95, 'Camerun', '3/1/1965', '3/2/1965', 'Subway','187956f', 'Subway_Ubicacion', 'media/restaurante3.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (96, 'normandía', '4/7/1965', '4/8/1965', 'Randys','597356c', 'Randys_Ubicacion', 'media/restaurante4.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (97, 'Modelia', '7/8/1965', '7/9/1965', 'Mc Donals','187956f', 'McDonalds_Ubicacion','media/restaurante1.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (98, 'ayuelos', '9/4/1965', '9/5/1965', 'Archies','257687a', 'Archies_Ubicacion', 'media/restaurante2.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (99, 'Chico', '3/1/1965', '3/2/1965', 'Subway','257687a', 'Subway_Ubicacion', 'media/restaurante3.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (100, 'Chapinero', '4/7/1965', '4/8/1965', 'Randys','257687a', 'Randys_Ubicacion', 'media/restaurante4.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (1, 'Andino', '7/8/1965', '7/9/1965', 'Mc Donals','187956f', 'McDonalds_Ubicacion','media/restaurante1.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (2, 'Geran estacion', '9/4/1965', '9/5/1965', 'Archies','257687a', 'Archies_Ubicacion', 'media/restaurante2.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (3, 'Aguas', '3/1/1965', '3/2/1965', 'Subway','357484u', 'Subway_Ubicacion', 'media/restaurante3.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (4, 'Metropolis', '4/7/1965', '4/8/1965', 'Randys','597356c', 'Randys_Ubicacion', 'media/restaurante4.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (5, 'Cafam', '7/8/1965', '7/9/1965', 'Mc Donals','187956f', 'McDonalds_Ubicacion','media/restaurante1.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (6, 'bulevar', '9/4/1965', '9/5/1965', 'Archies','597356c', 'Archies_Ubicacion', 'media/restaurante2.jpg');
insert into SucursalEntity (id, descripcion, horaApertura, horaCierre, nombre, restaurante_nit, ubicacion_direccion, IMAGEN) values (7, 'usaquen', '3/1/1965', '3/2/1965', 'Subway','357484u', 'Subway_Ubicacion', 'media/restaurante3.jpg');

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
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (4, 'Delicioso, muy rico', 10, 92, 'C20');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (5, 'Què delicia!', 10, 93, 'C5');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (6, 'Felicitaciones', 10, 94, 'C6');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (7, 'buien mmomo', 10, 95, 'C7');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (8, 're culo', 1, 96, 'C8');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (9, 'pesimo', 0, 97, 'C9');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (10, 'malo', 3, 98, 'C10');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (11, 'riquisimoooo', 9, 99, 'C11');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (12, 'uyyyy puede mejorar', 5, 100, 'C20');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (13, 'que fea atencion péro la comida rica', 7, 1, 'C14');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (14, 'muy demorado peor rico', 6, 2, 'C15');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (15, 'Demasioado caro', 3, 3, 'C16');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (16, 'muy frio', 2, 4, 'C17');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (17, 'le falta sabor pero atienden bein', 6, 5, 'C18');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (18, 'muy muy muy re pesimo clean and build', 8, 6, 'C19');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (19, 'Santafecito del alma', 10, 7, 'C2');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (20, 'que fea atencion péro la comida rica', 7, 89, 'C14');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (21, 'muy demorado peor rico', 6, 100, 'C15');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (22, 'Demasioado caro', 3, 98, 'C16');
insert into ComentarioEntity (id, comentario, calificacion, sucursal_id, cliente_usuario) values (23, 'muy frio', 2, 1, 'C17');


insert into FotoEntity (COMENTARIO_ID, url) values (1, 'media/restaurante.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (1, 'media/restaurante1.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (1, 'media/restaurante3.jpg');
insert into FotoEntity (COMENTARIO_ID, url) values (2, 'media/restaurante2.jpg');

insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Taquitos gratis','4/7/1965' , '6/6/2010' , 'Se regalaran tacos gratis.', 'media/taquitos.jpg' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Super Hamburguesas','4/7/1965' , '5/8/2010' , 'Se bajaran de precio las mejores hamburguesas de cada restaurante.', 'media/hamburguesas.png' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Festival Super Picante','2/16/1965' , '3/6/2010' , 'Se realizara un festival con los platos mas picantes de cada restaurante.', 'media/picante.jpg' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('La Cocina Italiana','8/10/1965' , '9/6/2010' , 'Un festival con promociones en platos y restaurantes italianos.', 'media/comidaItaliana.jpg' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Enchiladas para todos','8/10/1965' , '9/6/2010' , 'Las enchiladas mas ricas disponibles para todos a mitad de precio!!', 'media/login.jpeg' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Beef para todos','8/10/1965' , '9/6/2010' , 'Un festival con promociones en platos y restaurantes parrilleros.', 'media/Img2.jpg' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Hamburguesa master','8/10/1965' , '9/6/2010' , 'Un festival con promociones en platos y restaurantes hamburgueseros.', 'media/Img1.jpg' );
insert into EventoEntity(nombre, fechaInicio, fechaFin, descripcion, imagen) values ('Pizza master bogotpas','8/10/1965' , '9/6/2010' , 'Un festival con promociones en platos y restaurantes pizzeros.', 'media/pizza.jpeg' );

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