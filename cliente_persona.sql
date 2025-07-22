USE cliente_persona_db;

DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(20),
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

CREATE TABLE cliente (
    id BIGINT PRIMARY KEY,
    cliente_id VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    estado BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE
);

INSERT INTO persona (nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('Juan Pérez', 'M', 30, '12345678', 'Calle 1', '555-1234');

INSERT INTO cliente (id, cliente_id, contrasena, estado)
VALUES (1, 'cliente001', 'pass123', true);
