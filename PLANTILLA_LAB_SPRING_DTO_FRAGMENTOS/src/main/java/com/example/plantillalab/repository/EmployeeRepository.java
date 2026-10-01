package com.example.plantillalab.repository;

import com.example.plantillalab.dto.EmpleadosPorDepartamentoDto;
import com.example.plantillalab.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = """
            SELECT d.department_name AS departamento,
                   COUNT(e.employee_id) AS cantidad
            FROM departments d
            LEFT JOIN employees e
                ON d.department_id = e.department_id
            GROUP BY d.department_name
            """, nativeQuery = true)
    List<EmpleadosPorDepartamentoDto> obtenerEmpleadosPorDepartamento();
}
