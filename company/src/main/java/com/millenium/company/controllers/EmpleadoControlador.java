package com.millenium.company.controllers;

import com.millenium.company.models.Empleado;
import com.millenium.company.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoService service;

    @GetMapping("/empleados")
    public List<Empleado> getAllEmployees(){
        return service.findEmployees();
    }

    @PostMapping("/empleados")
    public Empleado addNewEmployee(@RequestBody Empleado empleado){
        return  service.addEmployee(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getOneEmployee(@PathVariable Long id){
        return service.findEmployee(id);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> updateEmployee(@PathVariable Long id, @RequestBody Empleado empleado){
         return service.editEmployee(id, empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        return service.eraseEmployee(id);
    }

}
