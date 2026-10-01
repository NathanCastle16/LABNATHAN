package com.example.plantillalab.controller;

import com.example.plantillalab.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/estadistica")
    public String estadistica(Model model) {

        model.addAttribute(
                "listaEmpleadosDepartamento",
                employeeRepository.obtenerEmpleadosPorDepartamento()
        );

        return "employee/estadistica";
    }
}
