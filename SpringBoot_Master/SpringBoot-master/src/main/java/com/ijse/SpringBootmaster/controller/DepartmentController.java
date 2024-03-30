package com.ijse.SpringBootmaster.controller;

import com.ijse.SpringBootmaster.dto.DepartmentDTO;
import com.ijse.SpringBootmaster.exception.DepartmentNotFoundException;
import com.ijse.SpringBootmaster.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/department")
@RequiredArgsConstructor
@Log4j2
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("")
    public DepartmentDTO saveDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        log.info(" Inside Save Department of DepartmentController ..");
        return departmentService.saveDepartment(departmentDTO);
    }

    @GetMapping("")
    public List<DepartmentDTO> getAllDepartment(){
        log.info(" Inside Get ALL DepartmentS of DepartmentController ..");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        log.info(" Inside Get Department By id of DepartmentController ..");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId){
        log.info(" Inside DELETE Department of DepartmentController ..");
         departmentService.deleteDepartmentById(departmentId);
         return "Department deleted successfully";
    }

    @PutMapping("/{departmentId}")
    public DepartmentDTO updateDepartment(@PathVariable("departmentId") Long departmentId,
                                        @RequestBody(required = false)  DepartmentDTO departmentDTO) {
        log.info(" Inside Update Department By Id of DepartmentController ..");
        return departmentService.updateDepartment(departmentId,departmentDTO);
    }

    @GetMapping("/name")
    public DepartmentDTO getDepartmentByName(@RequestParam(value = "name") String name){
        log.info(" Inside Get Department By Name of DepartmentController ..");
        return departmentService.getDepartmentByName(name);

    }

}
