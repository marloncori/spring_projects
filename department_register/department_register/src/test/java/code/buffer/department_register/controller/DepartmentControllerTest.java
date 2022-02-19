package code.buffer.department_register.controller;

import code.buffer.department_register.model.Department;
import code.buffer.department_register.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department mockDepartment;

    @BeforeEach
    void setUp() {
        mockDepartment = Department.builder()
                        .departmentName("Electronics Dpt.")
                            .departmentAddress("Gliwice")
                                .departmentCode("EE-058")
                                    .departmentId(154654984L)
                                        .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                    .departmentName("Electronics Dpt.")
                    .departmentAddress("Gliwice")
                    .departmentCode("EE-058")
                    .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(mockDepartment);

        /* call the end point here*/
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"department_name\":\"Electronics Dpt.\",\n" +
                        "\t\"department_address\":\"Gliwice\",\n" +
                        "\t\"department_code\":\"EE-058\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchOneDepartment(1L))
                .thenReturn(Optional.ofNullable(mockDepartment));

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$department_name")
                    .value(mockDepartment.getDepartmentName()));
    }
}