CREATE TABLE cliente(
	codigo INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	telefono VARCHAR(100) NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    localidad VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
	PRIMARY KEY (codigo)
);
