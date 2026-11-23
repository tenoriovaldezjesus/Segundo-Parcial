CREATE DATABASE IF NOT EXISTS db_ferreteria;
USE db_ferreteria;

CREATE TABLE IF NOT EXISTS articulos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_articulo VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    existencia INT NOT NULL
);

INSERT INTO articulos (nombre_articulo, precio, existencia) VALUES
('Martillo', 12.50, 50),
('Desarmador Phillips', 4.75, 120),
('Taladro Inalambrico', 89.99, 15),
('Pinzas de Punta', 8.40, 65),
('Llave Inglesa', 15.00, 40),
('Cinta Metrica 5m', 6.25, 90),
('Sierra Manual', 18.60, 30),
('Caja de Clavos 2in', 3.50, 200),
('Nivel de Burbuja', 11.80, 35),
('Broca para Concreto', 5.90, 80);

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(30) NOT NULL
);

INSERT INTO usuarios (usuario, password, rol) VALUES
('user1', '$2a$10$exrpi1C2G090Nr0NlKgAf.4s5IQzqP9gt3uvz/epsPruVimf.UvAy', 'ADMIN');
