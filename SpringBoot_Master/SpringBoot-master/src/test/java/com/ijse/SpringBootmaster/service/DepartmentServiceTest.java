package com.ijse.SpringBootmaster.service;

import com.ijse.SpringBootmaster.dto.DepartmentDTO;
import com.ijse.SpringBootmaster.entity.Department;
import com.ijse.SpringBootmaster.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
class DepartmentServiceTest {

    private final DepartmentService departmentService;

    @MockBean
    private final DepartmentRepository departmentRepository;




    @BeforeEach
    void setUp() {
        Department testDepartment = Department.builder()
                .departmentName("test Department")
                .departmentAddress("Negombo 07")
                .departmentCode("Dep-1012")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT Department"))
                .thenReturn(testDepartment);

    }

    @Test
    @DisplayName("Get Data bases on valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT Department";
        DepartmentDTO found = departmentService.getDepartmentByName(departmentName);


        assertEquals(departmentName, found.getDepartmentName());

    }
}