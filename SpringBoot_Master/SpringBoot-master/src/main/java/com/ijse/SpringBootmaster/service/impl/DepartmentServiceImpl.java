package com.ijse.SpringBootmaster.service.impl;

import com.ijse.SpringBootmaster.dto.DepartmentDTO;
import com.ijse.SpringBootmaster.entity.Department;
import com.ijse.SpringBootmaster.exception.DepartmentNotFoundException;
import com.ijse.SpringBootmaster.repository.DepartmentRepository;
import com.ijse.SpringBootmaster.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentRepository.save(modelMapper.map(departmentDTO, Department.class));
        return modelMapper.map(department, DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departmentList = departmentRepository.findAll();
        return modelMapper.map(departmentList, new TypeToken<List<DepartmentDTO>>(){}.getType());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return modelMapper.map(department.get(),DepartmentDTO.class);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        Optional<Department> byId = departmentRepository.findById(departmentId);
        if (byId.isEmpty()){
            throw new IllegalStateException("This department id "+departmentId+" not found !!");
        }else{
            departmentRepository.deleteById(departmentId);
        }
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {

        // Retrieve the department entity by its ID
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException("Department with ID " + departmentId + " not found"));


        // Update the department entity with the data from the incoming DepartmentDTO
        if (departmentDTO.getDepartmentName() != null && !"".equalsIgnoreCase(departmentDTO.getDepartmentName())){
            department.setDepartmentName(departmentDTO.getDepartmentName());
        }
        if (departmentDTO.getDepartmentAddress() != null && !"".equalsIgnoreCase(departmentDTO.getDepartmentAddress())) {
            department.setDepartmentAddress(departmentDTO.getDepartmentAddress());
        }
        if (departmentDTO.getDepartmentCode() != null && !"".equalsIgnoreCase(departmentDTO.getDepartmentCode())) {
            department.setDepartmentCode(departmentDTO.getDepartmentCode());
        }

        // Save the updated department entity
        department=departmentRepository.save(department);

        // Map the updated department entity back to DepartmentDTO and return it
        return modelMapper.map(department,DepartmentDTO.class);

    }

    @Override
    public DepartmentDTO getDepartmentByName(String name) {
        return modelMapper.map(departmentRepository.findByDepartmentName(name),DepartmentDTO.class);
    }
}
