use alumnos;
CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255)
);

INSERT INTO alumnos (nombre, apellidos) VALUES
('Juan', 'Pérez'),
('María', 'López'),
('Ana','De Miguel'),
('Luis', 'Sanz');


CREATE TABLE modulos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    profesor VARCHAR(255)
);

INSERT INTO modulos (nombre, profesor) VALUES
('DWEC', 'Iñigo Chueca'),
('DAW', 'Itziar Bilbao'),
('DIW', 'Marta Torre');

CREATE TABLE notas (
    id INT AUTO_INCREMENT primary key,
    id_alumno INT references alumnos,
    id_modulo INT references modulos,
    evaluacion INT,
    nota FLOAT
);

INSERT INTO notas (id_alumno, id_modulo, evaluacion, nota) VALUES
(1, 1, 1, 7),
(1, 2, 1, 8),
(2, 1, 1, 6),
(2, 2, 1, 5);