CREATE TABLE IF NOT EXISTS empleados (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(100)    NOT NULL,
    apellido        VARCHAR(100)    NOT NULL,
    rut             VARCHAR(20)     NOT NULL UNIQUE,
    cargo           VARCHAR(100)    NOT NULL,
    salario_base    DOUBLE          NOT NULL,
    bonificaciones  DOUBLE          DEFAULT 0,
    descuentos      DOUBLE          DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
