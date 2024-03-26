package com.ijse.employeems.service;

import com.ijse.employeems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    String updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO searchEmployeeById(int empId);

    String deleteEmployee(int empId);
}
