CREATE DATABASE plantilla_lab;
GO

USE plantilla_lab;
GO

CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);
GO

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    department_id INT,
    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_id)
        REFERENCES departments(department_id)
);
GO

INSERT INTO departments (department_id, department_name)
VALUES
    (10, 'Ventas'),
    (20, 'Sistemas'),
    (30, 'Recursos Humanos');
GO

INSERT INTO employees (employee_id, first_name, department_id)
VALUES
    (1, 'Ana', 10),
    (2, 'Luis', 10),
    (3, 'Carlos', 20),
    (4, 'Maria', 20),
    (5, 'Pedro', 20);
GO

SELECT d.department_name AS departamento,
       COUNT(e.employee_id) AS cantidad
FROM departments d
LEFT JOIN employees e
    ON d.department_id = e.department_id
GROUP BY d.department_name;
GO
