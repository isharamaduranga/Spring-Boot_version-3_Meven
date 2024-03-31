package com.lk.springdatajpa.repository;

import com.lk.springdatajpa.entity.Guardian;
import com.lk.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ishara@gmail.com")
                .firstName("ishara")
                .lastName("maduranga")
                //.guardianName("Pasindu")
                //.guardianEmail("pasindu@gmail.com")
                //.guardianMobile("0771234567")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("john")
                .email("perera@gmail.com")
                .mobile("0776127575")
                .build();

        Student student = Student.builder()
                .emailId("ishara@gmail.com")
                .firstName("ishara")
                .lastName("maduranga")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student>studentList = studentRepository.findAll();

        System.out.println("Student List >> "+studentList);
    }

    @Test
    public void getStudentsByName(){
        List<Student> stuList = studentRepository.findByFirstName("ishara");
        System.out.println("Student List find By Name >> "+stuList);
    }

    @Test
    public void getStudentsByFirstNameContaining(){
        List<Student> stuList = studentRepository.findByFirstNameContaining("is");
        System.out.println("Student List find By First Name containing >> "+stuList);
    }

    @Test
    public void getStudentsBasedOnGuardianName(){
        List<Student> stuList = studentRepository.findByGuardianName("praneeth");
        System.out.println("Student List based on Guardian Name >> "+stuList);
    }

    @Test
    public void getStudentsByFirstNameAndLastName(){
        List<Student> stuList = studentRepository.findByFirstNameAndLastName("ishara","maduranga");
        System.out.println("Student List of firstname and lastname >> "+stuList);
    }

    @Test
    public void getStudentsByEmail(){
        Student student = studentRepository.getStudentByEmailAddress("ishara@gmail.com");
         System.out.println("Student By Email Address >> "+student);
    }

    @Test
    public void getStudentsFirstNameByEmail(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("dinuth@gmail.com");
        System.out.println("Student First Name By Email Address >> "+firstName);
    }

    @Test
    public void getStudentByEmailForNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("dinuth@gmail.com");
        System.out.println("Student  By Email Address (NATIVE Q) >> "+student);
    }

    @Test
    public void getStudentByEmailForNativeBasedParamId(){
        Student student = studentRepository.getStudentByEmailAddressNativeInParam("ishara@gmail.com");
        System.out.println("Student  By Email Address (NATIVE Param Id) >> "+student);
    }

    @Test
    public void updateStudentFirstNameByEmailId(){
        int updated = studentRepository.updateStudentNameByEmailId("Sethmal", "dinuth@gmail.com");
        System.out.println("Update Student By Email Address  >> "+updated);
    }


}