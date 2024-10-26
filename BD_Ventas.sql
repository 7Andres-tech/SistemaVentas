CREATE DATABASE bd_ventas;
use bd_ventas

CREATE TABLE tb_Mozo (
    idMozo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(70),
    dni INT(8) NOT NULL,
    correo VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    telefono VARCHAR(9)
);

CREATE TABLE tb_Cliente (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    direccion VARCHAR(70),
    dni INT(8) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    estado TINYINT(1) DEFAULT 1
);

CREATE TABLE tb_Categoria (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100) NOT NULL,
    estado TINYINT(1) DEFAULT 1 
);

CREATE TABLE tb_Ventas (
    idVentas INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    ValorPagar DECIMAL(10, 2) NOT NULL,
    fechaVenta DATE NOT NULL,
    estado TINYINT(1) DEFAULT 1,
    FOREIGN KEY (idCliente) REFERENCES tb_Cliente(idCliente)
);


CREATE TABLE tb_Producto (
    idProducto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion VARCHAR(100),
    idCategoria INT NOT NULL,
    estado TINYINT(1) DEFAULT 1, 
    FOREIGN KEY (idCategoria) REFERENCES tb_Categoria(idCategoria)
);


CREATE TABLE tb_DetalleVenta (
    idDetalleVenta INT PRIMARY KEY AUTO_INCREMENT,
    idVenta INT NOT NULL,
    idProducto INT NOT NULL,
    cantidad INT NOT NULL,
    precioUnitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(10, 2) DEFAULT 0,
    totalPagar DECIMAL(10, 2) NOT NULL,
    estado TINYINT(1) DEFAULT 1,
    FOREIGN KEY (idVenta) REFERENCES tb_Ventas(idVentas),
    FOREIGN KEY (idProducto) REFERENCES tb_Producto(idProducto)
);
