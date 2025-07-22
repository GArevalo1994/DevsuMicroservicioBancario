USE cuenta_movimiento_db;

DROP TABLE IF EXISTS movimiento;
DROP TABLE IF EXISTS cuenta;

CREATE TABLE cuenta (
    numero_cuenta BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL,
    saldo_inicial DECIMAL(15,2) DEFAULT 0.00,
    estado BOOLEAN DEFAULT TRUE,
    cliente_id VARCHAR(50) NOT NULL
);

CREATE TABLE movimiento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    valor DECIMAL(15,2) NOT NULL,
    saldo DECIMAL(15,2) NOT NULL,
    cuenta_id BIGINT NOT NULL,
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(numero_cuenta) ON DELETE CASCADE
);

INSERT INTO cuenta (tipo, saldo_inicial, estado, cliente_id)
VALUES ('ahorro', 1000.00, true, 'cliente001');

INSERT INTO movimiento (fecha, tipo, valor, saldo, cuenta_id)
VALUES (CURDATE(), 'deposito', 500.00, 1500.00, 1);
