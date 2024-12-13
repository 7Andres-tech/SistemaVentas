use bd_ventas

select * from tb_Mozo;
ALTER TABLE tb_Mozo MODIFY COLUMN idMozo INT NOT NULL AUTO_INCREMENT;
DESCRIBE tb_Mozo;
DESCRIBE tb_Cliente;
select*from tb_cliente;

select*from tb_producto;

select*from tb_categoria;

select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, 
       c.descripcion as categoria, p.estado
from tb_producto as p, tb_categoria as c
where p.idCategoria = c.idCategoria;

select*from tb_Ventas;

select*from tb_detalleventa;

SELECT fechaVenta, COUNT(fechaVenta) AS Ventas 
FROM tb_Ventas 
WHERE fechaVenta BETWEEN '2024-01-01' AND '2024-12-31' 
GROUP BY fechaVenta;

DESCRIBE tb_Mozo;

ALTER TABLE tb_Mozo MODIFY COLUMN idMozo INT NOT NULL AUTO_INCREMENT;

ALTER TABLE tb_Mozo MODIFY COLUMN idMozo INT AUTO_INCREMENT;
ALTER TABLE tb_Cliente MODIFY COLUMN idCliente INT AUTO_INCREMENT;

INSERT INTO tb_Mozo (nombre, direccion, correo, password, telefono, DNI)
VALUES ('Prueba Mozo', 'Dirección X', 'prueba@correo.com', '12345', '123456789', 98765432);

ALTER TABLE tb_Mozo ADD COLUMN idMozo INT NOT NULL AUTO_INCREMENT PRIMARY KEY;
DESCRIBE tb_Mozo;

ALTER TABLE tb_Mozo 
    ADD COLUMN idMozo INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
    
    ALTER TABLE tb_Mozo DROP COLUMN idMozo;