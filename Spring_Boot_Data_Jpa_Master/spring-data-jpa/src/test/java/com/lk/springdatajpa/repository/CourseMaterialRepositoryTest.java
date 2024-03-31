package com.lk.springdatajpa.repository;

import com.lk.springdatajpa.entity.Course;
import com.lk.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Biology")
                .credit(90)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.youtube.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println(courseMaterials);
    }

}