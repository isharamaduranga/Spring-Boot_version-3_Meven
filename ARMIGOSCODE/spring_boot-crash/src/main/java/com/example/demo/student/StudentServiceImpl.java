package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email is already taken !!");
        }
        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("that account does not exists!!");
        }
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student with id " + studentId + " does not exists !!!")
        );

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()){
                throw new IllegalStateException("email is already taken !!");
            }
            student.setEmail(email);
        }
    }
}
