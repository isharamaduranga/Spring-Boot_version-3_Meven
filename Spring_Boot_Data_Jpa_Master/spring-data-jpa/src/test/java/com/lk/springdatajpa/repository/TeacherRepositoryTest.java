package com.lk.springdatajpa.repository;

import com.lk.springdatajpa.entity.Course;
import com.lk.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course1 = Course.builder()
                .title("Java Fundamentals")
                .credit(85)
                .build();

        Course course2 = Course.builder()
                .title("Object Oriented Programming")
                .credit(75)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Niroth")
                .lastName("samarawickckrama")
                //.courses(List.of(course1,course2))
                .build();

        teacherRepository.save(teacher);
    }


}