package com.ijse.SpringBootmaster.controller;

import com.ijse.SpringBootmaster.dto.DepartmentDTO;
import com.ijse.SpringBootmaster.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private DepartmentDTO department;

    @BeforeEach
    void setUp() {
        department = DepartmentDTO.builder()
                .departmentName("test Department")
                .departmentAddress("Negombo 07")
                .departmentCode("Dep-1012")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        DepartmentDTO inputDepartment = DepartmentDTO.builder()
                .departmentName("test Department")
                .departmentAddress("Negombo 07")
                .departmentCode("Dep-1012")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment));
        mockMvc.perform(post("").
                        contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\": \"test Department\",\n" +
                                "    \"departmentAddress\" :\"Negombo 07\",\n" +
                                "    \"departmentCode\":\"Dep-1012\"\n" +
                                "\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() {
    }
}