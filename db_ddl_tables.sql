-- Cliente persona DB
CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255)
);

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    estado BOOLEAN DEFAULT TRUE,
    nombre VARCHAR(255),
    persona_id BIGINT UNIQUE,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);

-- Cuenta movimiento DB
CREATE TABLE cliente_cache (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE cuenta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(255) NOT NULL UNIQUE,
    tipo ENUM('AHORRO', 'CORRIENTE') NOT NULL,
    saldo_inicial DECIMAL(15, 2) NOT NULL,
    estado BOOLEAN DEFAULT TRUE,
    cliente_id BIGINT NOT NULL
);

CREATE TABLE movimiento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tipo_movimiento ENUM('DEPOSITO', 'RETIRO') NOT NULL,
    valor DECIMAL(15, 2) NOT NULL,
    saldo DECIMAL(15, 2) NOT NULL,
    cuenta_id BIGINT NOT NULL,
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(id)
);


INSERT INTO persona (nombre, direccion) VALUES
('Juan Pérez', 'Av. Central #123'),
('Ana Gómez', 'Calle Falsa 123');

INSERT INTO cliente (cliente_id, contrasena, estado, nombre, persona_id) VALUES
('CLI123', 'password123', TRUE, 'Juan Pérez', 1),
('CLI456', 'password456', TRUE, 'Ana Gómez', 2);

INSERT INTO cuenta (numero_cuenta, tipo, saldo_inicial, estado, cliente_id) VALUES
('10000001', 'AHORRO', 1000.00, TRUE, 1),
('20000001', 'CORRIENTE', 2500.50, TRUE, 2);

INSERT INTO movimiento (fecha, tipo_movimiento, valor, saldo, cuenta_id) VALUES
('2025-07-24 08:30:00', 'DEPOSITO', 500.00, 1500.00, 1),
('2025-07-24 10:00:00', 'RETIRO', 200.00, 1300.00, 1),
('2025-07-24 11:15:00', 'DEPOSITO', 1000.00, 3500.50, 2),
('2025-07-24 13:45:00', 'RETIRO', 500.50, 3000.00, 2);
