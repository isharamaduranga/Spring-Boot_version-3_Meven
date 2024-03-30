package com.ijse.SpringBootmaster.service;

import com.ijse.SpringBootmaster.dto.DepartmentDTO;
import com.ijse.SpringBootmaster.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartment();

    DepartmentDTO getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long departmentId);
    DepartmentDTO updateDepartment(Long departmentId,DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByName(String name);

}
