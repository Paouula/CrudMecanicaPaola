create table tb_Usuario(
    UUID_Usuario int PRIMARY KEY,
    nombre_usuario VARCHAR2(50) not null,
    apellido_usuario VARCHAR2(50) not null,
    correo_usuario VARCHAR2(50) not null,
    contra_usuario VARCHAR2(50) not null,
    edad_usuario int not null
);

create table tb_Cliente(
    UUID_Cliente int PRIMARY KEY,
    nombre_cliente VARCHAR2(50) not null,
    apellido_cliente VARCHAR2(50) not null,
    telefono_cliente int not null
);

create table tb_infoVehiculo(
    UUID_VEHICULO int PRIMARY KEY,
    marca VARCHAR2(50) not null,
    modelo VARCHAR2(50) not null,
    ano_vehiculo int
);

create table tb_repaVehiculo(
    uuid_repaVehiculo varchar2(50) primary key,
    problemas_vehiculos VARCHAR2(500) not null,
    estado_prob_vehiculo VARCHAR2(50),
    uuid_cliente INT,
    CONSTRAINT fk_tb_Cliente
    FOREIGN KEY (uuid_cliente)
    REFERENCES tb_cliente(uuid_cliente),
    UUID_VEHICULO INT,
    CONSTRAINT fk_tb_infoVehiculos
    foreign key (UUID_VEHICULO)
    REFERENCES tb_infoVehiculo
);
