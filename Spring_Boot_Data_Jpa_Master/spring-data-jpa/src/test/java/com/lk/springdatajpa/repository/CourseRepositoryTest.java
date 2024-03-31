package com.lk.springdatajpa.repository;

import com.lk.springdatajpa.entity.Course;
import com.lk.springdatajpa.entity.Guardian;
import com.lk.springdatajpa.entity.Student;
import com.lk.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses() {
        List<Course> all = courseRepository.findAll();

        System.out.println("List of Courses : " + all);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Sanu")
                .lastName("vithanage")
                .build();
        Course course = Course.builder()
                .title("Spring Boot")
                .teacher(teacher)
                .credit(50)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> allCourses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElement = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Total elements ; " + totalElement);
        System.out.println("Total Pages ; " + totalPages);
        System.out.println("Courses ; " + allCourses);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditByDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit")
                                        .descending())
                );

        List<Course> courseList = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courseList : "+courseList);
    }

    @Test
    public void  printFindByTitleContaining(){
        Pageable firstPageByTenRecord = PageRequest.of(0,10);

        List<Course> courseList = courseRepository.findByTitleContaining("Ob",firstPageByTenRecord).getContent();

        System.out.println("FilterTitleByPagination : "+courseList);
    }

    @Test
    public void  saveCourseWithStudentsWithTeacher(){

        Guardian guardian = Guardian.builder()
                .name("kalindu")
                .email("kalindu@gmail.com")
                .mobile("0776127122")
                .build();

        Student student1 = Student.builder()
                .emailId("Praneeth@gmail.com")
                .firstName("Praneeth")
                .lastName("Geethanjana")
                .guardian(guardian)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ruchika")
                .lastName("sadaruwan")
                .build();

        Course course = Course.builder()
                .title("History")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student1);


        courseRepository.save(course);
    }

}