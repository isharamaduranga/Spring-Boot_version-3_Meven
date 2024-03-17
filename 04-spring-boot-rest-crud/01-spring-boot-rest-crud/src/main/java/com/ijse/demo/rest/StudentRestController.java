package com.ijse.demo.rest;

import com.ijse.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    //define @PostConstructor to load the student Data ... only one
    @PostConstruct
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Ishara", "maduranga"));
        studentList.add(new Student("Kalana", "dulanjana"));
        studentList.add(new Student("John", "Perera"));
        studentList.add(new Student("Prabath", "Silva"));
    }

    // define endpoint for /student - return a list of student
    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentList;
    }

    //define endpoint or /students/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //Just index the list ... keep it simple for now

        //CHECK THE STUDENT LIST SIZE
        if ((studentId >= studentList.size() || (studentId < 0))) {
            throw new StudentNotFoundException("Student Id Not found - " + studentId);
        }
        return studentList.get(studentId);
    }
}
