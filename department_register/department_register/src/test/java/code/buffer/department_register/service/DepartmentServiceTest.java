package code.buffer.department_register.service;

import code.buffer.department_register.controller.DepartmentController;
import code.buffer.department_register.error.DepartmentNotFoundException;
import code.buffer.department_register.model.Department;
import code.buffer.department_register.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    /* this will be called for every test case, this happens with mocking and simulating layers
     * not taken into account in specific tests
     */
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                                .departmentName("IT")
                                    .departmentAddress("Ahmedabad")
                                        .departmentCode("IT-07")
                                            .departmentId(10L)
                                                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    /* I have to mock this test, because I am focusing in the service layer, I do not car
     * now about accessing the repository layer to get the response from this function calling
     */
    @Test
    @DisplayName("Get data based on valid department name.")
    public void ifPresentDepartmentNameShouldBeFound() throws DepartmentNotFoundException {
        String departmentName = "IT";
        Department maybeFound = departmentService.fetchOneDepartmentByName(departmentName);
        assertEquals(departmentName, maybeFound.getDepartmentName());
   }

}