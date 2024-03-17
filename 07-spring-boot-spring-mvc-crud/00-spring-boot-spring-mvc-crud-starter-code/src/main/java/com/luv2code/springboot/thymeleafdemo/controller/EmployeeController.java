package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for "/list

    @GetMapping("/list")
    public String listOfEmployees(Model model) {
        // get the employee from db

        List<Employee> employeeList = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        //save the employee
        employeeService.save(employee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theID , Model model) {

        // get the employee from the services
        Employee employee = employeeService.findById(theID);

        //set employee in the modal to pre-populate the form
        model.addAttribute("employee",employee);

        //save over to our form
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theID) {

        // get the employee from the services
        employeeService.deleteById(theID);

        //save over to our form
        return "redirect:/employees/list";
    }

}
