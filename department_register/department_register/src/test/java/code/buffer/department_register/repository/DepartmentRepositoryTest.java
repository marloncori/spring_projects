package code.buffer.department_register.repository;

import code.buffer.department_register.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                                .departmentName("Robotics Engineering")
                                    .departmentAddress("Silesia")
                                        .departmentCode("RE-79")
                                            .build();
        entityManager.persist(department);
    }

    @Test
    @DisplayName("Department has been searched in the database by provided ID.")
    public void whenFoundByIdThenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Robotics Engineering");
    }
}