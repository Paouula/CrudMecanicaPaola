CREATE TABLE tb_Usuario (
    UUID_Usuario NUMBER PRIMARY KEY,
    nombre_usuario VARCHAR2(50) NOT NULL,
    apellido_usuario VARCHAR2(50) NOT NULL,
    correo_usuario VARCHAR2(50) NOT NULL,
    contra_usuario VARCHAR2(50) NOT NULL,
    edad_usuario NUMBER NOT NULL
);

CREATE TABLE tb_Cliente (
    UUID_Cliente NUMBER PRIMARY KEY,
    nombre_cliente VARCHAR2(50) NOT NULL,
    apellido_cliente VARCHAR2(50) NOT NULL,
    telefono_cliente VARCHAR2(15) NOT NULL 
);

CREATE TABLE tb_infoVehiculo (
    UUID_VEHICULO NUMBER PRIMARY KEY,
    marca VARCHAR2(50) NOT NULL,
    modelo VARCHAR2(50) NOT NULL,
    ano_vehiculo NUMBER 
);

CREATE TABLE tb_repaVehiculo (
    uuid_repaVehiculo VARCHAR2(50) PRIMARY KEY,
    problemas_vehiculos VARCHAR2(500) NOT NULL,
    estado_prob_vehiculo VARCHAR2(50),
    uuid_cliente NUMBER, 
    UUID_VEHICULO NUMBER, 
    CONSTRAINT fk_tb_Cliente FOREIGN KEY (uuid_cliente)
    REFERENCES tb_Cliente(UUID_Cliente),
    CONSTRAINT fk_tb_infoVehiculo FOREIGN KEY (UUID_VEHICULO)
    REFERENCES tb_infoVehiculo(UUID_VEHICULO)
);
