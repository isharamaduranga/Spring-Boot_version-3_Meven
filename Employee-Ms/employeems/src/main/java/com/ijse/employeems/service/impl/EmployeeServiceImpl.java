package com.ijse.employeems.service.impl;

import com.ijse.employeems.dto.EmployeeDTO;
import com.ijse.employeems.entity.Employee;
import com.ijse.employeems.repo.EmployeeRepository;
import com.ijse.employeems.service.EmployeeService;
import com.ijse.employeems.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO){

        if (employeeRepository.existsById(employeeDTO.getEmpId())) {
            return VarList.RSP_DUPLICATED;
        }else{
            employeeRepository.save(modelMapper.map(employeeDTO,Employee.class));
            return VarList.RSP_SUCCESS;
        }

    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return modelMapper.map(
                employeeRepository.findAll(),
                new TypeToken<ArrayList<EmployeeDTO>>(){}.getType());
    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(employeeDTO.getEmpId())) {
            employeeRepository.save(modelMapper.map(employeeDTO,Employee.class));
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    @Override
    public EmployeeDTO searchEmployeeById(int empId) {
        if (employeeRepository.existsById(empId)){
           return modelMapper.map(employeeRepository.findById(empId).orElse(null),EmployeeDTO.class);

        }else{
            return null;
        }
    }

    @Override
    public String deleteEmployee(int empId) {
        if (employeeRepository.existsById(empId)) {
            employeeRepository.deleteById(empId);
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
