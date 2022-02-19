package code.buffer.department_register.service;

import code.buffer.department_register.error.DepartmentNotFoundException;
import code.buffer.department_register.model.Department;
import code.buffer.department_register.repository.DepartmentRepository;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final String errorMsg = "Department has not been found in the database.";

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<List<Department>> fetchDepartments() throws DepartmentNotFoundException {
        Optional<List<Department>> departments = Optional.of(departmentRepository.findAll());
        if(!departments.isPresent()){
            throw new DepartmentNotFoundException(errorMsg);
        }
        return  departments;
    }

    @Override
    public Optional<Department> fetchOneDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentMaybe = departmentRepository.findById(id);
        if(!departmentMaybe.isPresent()){
            throw new DepartmentNotFoundException(errorMsg);
        }
        return departmentMaybe;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) throws DepartmentNotFoundException {
        Optional<Department> departmentInDB = departmentRepository.findById(id);

        if(departmentInDB.isPresent()) {
            if (!departmentInDB.get().getDepartmentName().isEmpty() && Objects.nonNull(department.getDepartmentName())
                    && !departmentInDB.get().getDepartmentName().equalsIgnoreCase(department.getDepartmentName())) {
                departmentInDB.get().setDepartmentName(department.getDepartmentName());
            }
            if (!departmentInDB.get().getDepartmentAddress().isEmpty() && Objects.nonNull(department.getDepartmentAddress())
                    && !departmentInDB.get().getDepartmentAddress().equalsIgnoreCase(department.getDepartmentAddress())) {
                departmentInDB.get().setDepartmentAddress(department.getDepartmentAddress());
            }
            if (!departmentInDB.get().getDepartmentCode().isEmpty() && Objects.nonNull(department.getDepartmentCode())
                    && !departmentInDB.get().getDepartmentName().equalsIgnoreCase(department.getDepartmentCode())) {
                departmentInDB.get().setDepartmentCode(department.getDepartmentCode());
            }
        } else {
            throw new DepartmentNotFoundException(errorMsg);
        }
        departmentRepository.save(departmentInDB.get());
        return departmentInDB.get();
    }

    @Override
    public Department fetchOneDepartmentByName(String name) throws DepartmentNotFoundException {
        Optional<Department> departmentMaybe = Optional.ofNullable(departmentRepository.findByDepartmentName(name));
        if(!departmentMaybe.isPresent()){
            throw new DepartmentNotFoundException(errorMsg);
        }
        return departmentMaybe.get();
    }


}