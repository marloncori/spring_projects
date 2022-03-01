package pl.millenium.employee_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.millenium.employee_register.model.Employee;
import pl.millenium.employee_register.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id") Long id){
        if(id == null){
            throw new IllegalArgumentException("Please provide a valid employee ID!");
        }
        Employee searchedEmployee = employeeService.findOneEmployee(id);
        return new ResponseEntity<>(searchedEmployee, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee newEmployee){
        if(newEmployee == null){
            throw new IllegalArgumentException("No EMPLOYEE DATA has been provided!");
        }
        Employee registeredEmployee = employeeService.addEmployee(newEmployee);
        return new ResponseEntity<>(registeredEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployeeInformation(@RequestBody Employee employee){
        if(employee == null){
            throw new IllegalArgumentException("No EMPLOYEE DATA has been provided!");
        }
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}