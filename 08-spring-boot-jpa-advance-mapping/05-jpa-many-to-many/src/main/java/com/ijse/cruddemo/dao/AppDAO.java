package com.ijse.cruddemo.dao;

import com.ijse.cruddemo.entity.Course;
import com.ijse.cruddemo.entity.Instructor;
import com.ijse.cruddemo.entity.InstructorDetail;
import com.ijse.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailsById(int id);

    List<Course>findCoursesInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);


    void update(Instructor instructor);

    void update(Course course);

    Course  findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

   void deleteStudentById(int id);


}
