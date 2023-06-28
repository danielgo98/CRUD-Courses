create database java_curso;
use java_curso;

create table cursos(
id int not null primary key auto_increment,
nombre varchar(60) default null,
descripcion varchar(120) default null,
instructor varchar(45) default null,
duracion decimal(5,2) default null
) engine=InnoDB;

-- inserts a la base de datos
INSERT INTO cursos(nombre, descripcion, instructor, duracion) VALUES('Máster Completo en Java de cero a experto con IntelliJ', 'Aprende Java SE, Jakarta EE, Hibernate y mas', 'Daniel Andrés', 98.53);
INSERT INTO cursos(nombre, descripcion, instructor, duracion) VALUES('Spring Framework 5: Creando webapp de cero a experto', 'Construye aplicaciones web con Spring Framework 5 & Spring Boot', 'Mario Marugan', 41.51);
INSERT INTO cursos(nombre, descripcion, instructor, duracion) VALUES('Angular & Spring Boot: Creando web app full stack', 'Desarrollo frontend con Angular y backend Spring Boot 2', 'Miguel Angel Durán', 23.54);
INSERT INTO cursos(nombre, descripcion, instructor, duracion) VALUES('Microservicios con Spring Boot y Spring Cloud Netflix Eureka', 'Construye Microservicios Spring Boot 2, Eureka, Spring Cloud', 'Victor Robles', 19.55);
INSERT INTO cursos(nombre, descripcion, instructor, duracion) VALUES('Guía Completa JUnit y Mockito incluye Spring Boot Test', 'Aprende desde cero JUnit 5 y Mockito en Spring Boot 2', 'Brais Moure', 15.12);