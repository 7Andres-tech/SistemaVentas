-- crear nuestra base de datos
create database sistema_ventasbd;
-- usamos la base de datos
use sistema_ventasbd;

-- crear tabla usuarios(Mozos)
create table tb_Mozo(
idMozo int (11) auto_increment primary key,
nombre varchar(30) not null,
password varchar(15) not null,
telefono varchar(15) not null,
correo varchar(45) not null,
dirección text not null,
DNI int(8) not null
);



-- crear tabla cliente
create table tb_Cliente(
idCliente int (11) auto_increment primary key,
nombre varchar(30) not null,
telefono varchar(15) not null,
direccion varchar(100) not null,
DNI int(8) not null,
correo varchar(45) not null
);

-- crear tabla categoria
create table tb_Categoria(
idCategoria int (11) auto_increment primary key,
descripcion varchar(200) not null,
estado int(1) not null
);




-- crear tabla producto
create table tb_Producto(
idProducto int (11) auto_increment primary key,
nombre varchar(100) not null,
cantidad int(11) not null,
precio double(10,2) not null,
descripcion varchar(200) not null,
idCategoria int(11) not null,
estado int(1) not null
);

-- crear tabla de venta
create table tb_Venta(
idVenta int (11) auto_increment primary key,
idCliente int(11) not null,
valorPagar double(10,2) not null,
fechaVenta date not null,
estado int(1) not null
);

-- crear tabla detalle de venta
create table tb_detalle_venta(
idDetalleVenta int (11) auto_increment primary key,
idVenta int (11) not null,
idProducto int (11) not null,
cantidad int(11) not null,
precioUnitario double(10,2) not null,
subtotal double(10,2) not null,
descuento double(10,2) not null,
totalPagar double(10,2) not null,
estado int(1) not null
);
