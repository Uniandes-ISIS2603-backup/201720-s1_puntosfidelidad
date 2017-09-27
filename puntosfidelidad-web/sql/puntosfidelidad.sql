delete from RecargaEntity;
delete from TarjetaDeCreditoEntity;
delete from AdministradorEntity;
delete from ComentarioEntity;
delete from CompraEntity;
delete from EventoEntity;
delete from FotoEntity;
delete from ProductoEntity;
delete from RestauranteEntity;
delete from SucursalEntity;
delete from TarjetaPuntosEntity;
delete from UbicacionEntity;
delete from ClienteEntity;

insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('C1','C1','C1.jpg','C1');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('C2','C2','C2.jpg','C2');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('C3','C3','C3.jpg','C3');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('C4','C4','C4.jpg','C4');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('C5','C5','C5.jpg','C5');

insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Bancolombia', 4562182, 'C1' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Bancopichincha', 4578236, 'C1' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Piramide', 54126, 'C1' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Bancolombia', 4562182, 'C2' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('BancoLadron', 897521, 'C3' );

insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 5000,5000,10,'C1');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 5000,5000,20,'C2');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 1000,5000,20,'C3');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 8000,5010,20,'C4');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 5900,2000,20,'C4');

insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('4/7/1965', 8000, 'C1' ,(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C1'),(SELECT MAX(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='C1') );
insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('4/7/1965', 8000, 'C1' ,(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C1'),(SELECT MIN(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='C1') );
insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('4/8/1967', 8000, 'C2' ,(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C1'),(SELECT MAX(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='C2') );
insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('10/9/1968', 8000, 'C3',(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='C1'),(SELECT MAX(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='C3') );


