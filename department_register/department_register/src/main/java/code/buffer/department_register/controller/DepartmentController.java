package code.buffer.department_register.controller;

import code.buffer.department_register.error.DepartmentNotFoundException;
import code.buffer.department_register.model.Department;
import code.buffer.department_register.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Data has been saved to the database.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public Optional<List<Department>> fetchDepartmentList() throws DepartmentNotFoundException {
        LOGGER.info("The list of registerd departments has been retrieved.");
        Optional<List<Department>> departments = departmentService.fetchDepartments();
            if(!departments.isPresent()){
                throw new DepartmentNotFoundException("Currently there are no departments saved in the database.");
            }
            return departments;
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable(value = "id") Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentMaybe = departmentService.fetchOneDepartment(id);
            if(!departmentMaybe.isPresent()){
                throw new DepartmentNotFoundException();
            };
            return departmentMaybe;
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable(value = "id") Long id){
        departmentService.deleteDepartmentById(id);
        return "Department successfully deleted!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable(value = "id") Long id, @RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.updateDepartmentById(id, department);
    }

    @GetMapping("/departments/name/{id}")
    public Optional<Department> fetchDepartmentByName(@PathVariable(value = "name") String name) throws DepartmentNotFoundException {
        Optional<Department> departmentMaybe = Optional.ofNullable(departmentService.fetchOneDepartmentByName(name));
                if(!departmentMaybe.isPresent()) {
                    throw new DepartmentNotFoundException("Requested department not available in database.");
                }
        return departmentMaybe;
    }
}
