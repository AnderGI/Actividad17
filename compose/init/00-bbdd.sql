DROP TABLE IF EXISTS alumnos;
DROP TABLE IF EXISTS modulos;
DROP TABLE IF EXISTS notas;

CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255)
);

INSERT INTO alumnos (nombre, apellidos) VALUES('Juan', 'Pérez');
INSERT INTO alumnos (nombre, apellidos) VALUES('María', 'López');
INSERT INTO alumnos (nombre, apellidos) VALUES('Ana','De Miguel');
INSERT INTO alumnos (nombre, apellidos) VALUES('Luis', 'Sanz');

CREATE TABLE modulos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    profesor VARCHAR(255)
);

INSERT INTO modulos (nombre, profesor) VALUES('DWEC', 'Iñigo Chueca');
INSERT INTO modulos (nombre, profesor) VALUES('DAW', 'Itziar Bilbao');
INSERT INTO modulos (nombre, profesor) VALUES('DIW', 'Marta Torre');

CREATE TABLE notas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT,
    id_modulo INT,
    evaluacion INT,
    nota FLOAT,
    UNIQUE(id_alumno, id_modulo, evaluacion),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
    FOREIGN KEY (id_modulo) REFERENCES modulos(id)
);

INSERT INTO notas (id_alumno, id_modulo, evaluacion, nota) VALUES(1, 1, 1, 7);
INSERT INTO notas (id_alumno, id_modulo, evaluacion, nota) VALUES(1, 2, 1, 8);
INSERT INTO notas (id_alumno, id_modulo, evaluacion, nota) VALUES(2, 1, 1, 6);
INSERT INTO notas (id_alumno, id_modulo, evaluacion, nota) VALUES(2, 2, 1, 5);
