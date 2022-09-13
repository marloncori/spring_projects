package com.millenium.company.services;

import com.millenium.company.exceptions.ResourceNotFoundException;
import com.millenium.company.models.Empleado;
import com.millenium.company.models.ErrorMsg;
import com.millenium.company.repositories.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepositorio repository;

    @Autowired
    ErrorMsg error;

    @Override
    public List<Empleado> findEmployees(){
        return repository.findAll();
    }

    @Override
    public Empleado addEmployee(Empleado empleado){
        return repository.save(empleado);
    }

    @Override
    public ResponseEntity<Empleado> findEmployee(Long id){
        Empleado empleado = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(error.getMsg()));
        return ResponseEntity.ok(empleado);
    }

    @Override
    public ResponseEntity<Empleado> editEmployee( Long id, Empleado empleado){
        Empleado employee = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(error.getMsg()));

        employee.setId(empleado.getId());
        employee.setNombre(empleado.getNombre());
        employee.setApellido(empleado.getApellido());
        employee.setEmail(empleado.getEmail());

        Empleado empleadoActual = repository.save(employee);
        return ResponseEntity.ok(empleadoActual);
    }

    @Override
    public ResponseEntity<Map<String,Boolean>> eraseEmployee(Long id){
        Empleado employee = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(error.getMsg()));
        repository.delete(employee);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
