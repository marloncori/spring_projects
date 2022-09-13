package com.millenium.company.services;

import com.millenium.company.models.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmpleadoService {

    public List<Empleado> findEmployees();

    public Empleado addEmployee(Empleado empleado);

    public ResponseEntity<Empleado> findEmployee(Long id);

    public ResponseEntity<Empleado> editEmployee( Long id, Empleado empleado);

    public ResponseEntity<Map<String,Boolean>> eraseEmployee(Long id);

}
