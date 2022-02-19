package code.buffer.department_register.service;

import code.buffer.department_register.error.DepartmentNotFoundException;
import code.buffer.department_register.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public Optional<List<Department>> fetchDepartments() throws DepartmentNotFoundException;

    public Optional<Department> fetchOneDepartment(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartmentById(Long id, Department department) throws DepartmentNotFoundException;

    public Department fetchOneDepartmentByName(String name) throws DepartmentNotFoundException;
}
