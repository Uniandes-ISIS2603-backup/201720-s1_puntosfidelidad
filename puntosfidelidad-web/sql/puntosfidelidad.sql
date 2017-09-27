delete from RecargaEntity;
delete from TarjetaDeCreditoEntity;
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
delete from AdministradorEntity;

insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('CA','CA','CA.jpg','CA');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('CB','CB','CB.jpg','CB');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('CD','CD','CD.jpg','CD');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('CC','CC','CC.jpg','CC');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('CF','CF','CF.jpg','CF');
insert into ClienteEntity (usuario, contrasena, imagen, nombre) values ('CG','CG','CG.jpg','CG');

insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Bancolombia', 4562182, 'CA' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Bancopichincha', 4578236, 'CA' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Piramide', 54126, 'CA' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('Bancolombia', 4562182, 'CB' );
insert into TarjetaDeCreditoEntity (banco, numero, cliente_usuario) values ('BancoLadron', 897521, 'CD' );

insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 5000,5000,10,'CA');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 5000,5000,20,'CB');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 1000,5000,20,'CD');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 8000,5010,20,'CC');
insert into TarjetaPuntosEntity ( montoactual, montobasico, numpuntos, cliente_usuario) values ( 5900,2000,20,'CC');

insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('4/7/1965', 8000, 'CA' ,(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='CA'),(SELECT MAX(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='CA') );
insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('4/7/1965', 8000, 'CA' ,(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='CA'),(SELECT MIN(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='CA') );
insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('4/8/1967', 8000, 'CB' ,(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='CA'),(SELECT MAX(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='CB') );
insert into RecargaEntity (fecha, valor, cliente_usuario,  tarjetaPuntos_id, tarjetaDeCredito_id) values ('10/9/1968', 8000, 'CD',(SELECT MAX(ID) FROM TarjetaPuntosEntity WHERE cliente_usuario='CA'),(SELECT MAX(ID) FROM TarjetaDeCreditoEntity WHERE cliente_usuario='CD') );


