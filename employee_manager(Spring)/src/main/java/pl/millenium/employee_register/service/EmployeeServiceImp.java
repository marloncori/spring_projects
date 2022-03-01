package pl.millenium.employee_register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.millenium.employee_register.exception.EmployeeNotFoundException;
import pl.millenium.employee_register.model.Employee;
import pl.millenium.employee_register.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findOneEmployee(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " has not been found in the database."));
    }

    public Employee addEmployee(Employee employee){
        if(employee == null){
            throw new IllegalArgumentException("WARNING: No data has been entered.");
        }
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee newEmployee){
        Optional<Employee> oldEmployee = Optional.ofNullable(newEmployee);
        if(oldEmployee.isEmpty()){
            throw new IllegalArgumentException("WARNING: No new data has been provided! Unable to update information.");
        }
        Employee empl = oldEmployee.get();
        if(!empl.getEmail().equals(newEmployee.getEmail())){
           empl.setEmail(newEmployee.getEmail());
        }
        if(!empl.getJobTitle().equalsIgnoreCase(newEmployee.getJobTitle())){
            empl.setJobTitle(newEmployee.getJobTitle());
        }
        if(!empl.getName().equals(newEmployee.getName())){
            empl.setName(newEmployee.getName());
        }
        if(!empl.getPhone().equals(newEmployee.getPhone())){
            empl.setPhone(newEmployee.getPhone());
        }
        if(!empl.getImageUrl().equals(newEmployee.getImageUrl())){
            empl.setImageUrl(newEmployee.getImageUrl());
        }
        return employeeRepository.save(empl);
    }

    public void deleteEmployee(Long id){
        if(id == null){
            throw new IllegalArgumentException("No data has been provided. Could not delete employee.");
        }
        employeeRepository.deleteEmployeeById(id);
    }
}
