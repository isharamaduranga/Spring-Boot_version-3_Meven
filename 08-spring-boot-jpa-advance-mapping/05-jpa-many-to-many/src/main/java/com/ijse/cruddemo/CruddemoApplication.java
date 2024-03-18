package com.ijse.cruddemo;

import com.ijse.cruddemo.dao.AppDAO;
import com.ijse.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createCourseAndStudent(appDAO);
            // findCourseAndStudent(appDAO);
            // findStudentAndCourse(appDAO);
            // addMoreCoursesForStudent(appDAO);
            // deleteCourse(appDAO);
             deleteStudent(appDAO);

        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Deleting student id : "+theId);
        appDAO.deleteStudentById(theId);
        System.out.println("Done ..");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int theId = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(theId);

        // create more courses
        Course course1 = new Course("Artificial Intelligence");
        Course course2 = new Course("Power and Electrical");
        Course course3 = new Course("Game Development");

        student.addCourse(course1);
        student.addCourse(course2);
        student.addCourse(course3);

        System.out.println("Updating student : "+student);
        System.out.println("Updating associated Courses : "+student.getCourses());

        appDAO.update(student);
    }

    private void findStudentAndCourse(AppDAO appDAO) {
        int studentId =2;

        Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
        System.out.println("Loading Student : "+ student);
        System.out.println("Courses "+student.getCourses());

        System.out.println("Done !!");
    }

    private void findCourseAndStudent(AppDAO appDAO) {
        int courseId =10;

        Course course = appDAO.findCourseAndStudentByCourseId(courseId);
        System.out.println("Loading Course : "+ course);
        System.out.println("Students "+course.getStudents());

        System.out.println("Done !!");
    }

    private void createCourseAndStudent(AppDAO appDAO) {
        //CREATE a Course
        Course course = new Course("Biology");


        //CREATE a Student
        Student student1 = new Student("Ishara", "Maduranga", "isha970206@gmail.com");
        Student student2 = new Student("Dinuth", "Dheeraka", "dinuth345@gmail.com");
        Student student3 = new Student("Praneeth", "Geethanjana", "praneeth20@gmail.com");


        //add student to the course
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);


        //save the course and associated students
        System.out.println("Saving the Courses"+course);
        System.out.println("Saving the Student"+course.getStudents());

        appDAO.save(course);

        System.out.println("Done !!");
    }

    private void deleteCourseAndReview(AppDAO appDAO) {
        // get the course and reviews
        int theId = 10;
        System.out.println("Deleting course id : " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done !!");
    }

    private void retrieveCourseAndReview(AppDAO appDAO) {

        // get the course and reviews
        int theId = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(theId);

        //print the course
        System.out.println(course);

        //print the reviews
        System.out.println(course.getReviews());

        System.out.println("Done");

    }

    private void createCourseAndReview(AppDAO appDAO) {
        // create a course
        Course course = new Course("Software Engineering");

        //add some review
        course.addReview(new Review("Great Course ever ..."));
        course.addReview(new Review("Best Course I love this ..."));
        course.addReview(new Review("Valuable content cover this course..."));

        //save the course
        System.out.println("Savings the course");
        System.out.println(course);
        System.out.println(course.getReviews());

        appDAO.save(course);
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 13;
        System.out.println("Deleting Course Id : " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done !!");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Finding Course Id : " + theId);
        Course course = appDAO.findCourseById(theId);

        //update the course
        System.out.println("Updating Course id : " + theId);
        course.setTitle("Geography Course");

        appDAO.update(course);
        System.out.println("Done !!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding Instructor Id : " + theId);
        Instructor instructor = appDAO.findInstructorById(theId);

        //update the instructor
        System.out.println("Updating Instructor id : " + theId);
        instructor.setLastName("Fernandoo");

        appDAO.update(instructor);

        System.out.println("Done !!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding Instructor Id : " + theId);
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("Instructor : >>> " + instructor);
        System.out.println("Instructor Associated Courses: >>> " + instructor.getCourses());

        System.out.println("Done !!");


    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding Instructor Id : " + theId);
        Instructor instructor = appDAO.findInstructorById(theId);

        System.out.println("Instructor >> " + instructor);

        //find courses from instructor
        System.out.println("Finding Courses from instructor id : " + theId);
        List<Course> courses = appDAO.findCoursesInstructorId(theId);

        //associate the object
        instructor.setCourses(courses);

        System.out.println("the associated courses >> " + instructor.getCourses());
        System.out.println("Done !");

    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding Instructor Id : " + theId);
        Instructor instructor = appDAO.findInstructorById(theId);

        System.out.println("Instructor >> " + instructor);
        System.out.println("The Associated Courses >> " + instructor.getCourses());

        System.out.println("Done !!!");

    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        //create the instructor
        Instructor instructor =
                new Instructor("Derick", "Andrew", "derickAndrew@gmail.com");

        //create the instructor detail
        InstructorDetail instructorDetail =
                new InstructorDetail("https://www.derick.com/youtube", "Watching Netflix movies ..");
        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        //create some courses
        Course course1 = new Course("Biology Course");
        Course course2 = new Course("Science Course");

        //add course to instructor
        instructor.add(course1);
        instructor.add(course2);

        //save the instructor
        //
        // This will also save the courses bacause of CascadeType.PERSIST
        //
        System.out.println("Saving instructor : " + instructor);
        System.out.println("The Courses : " + instructor.getCourses());
        appDAO.save(instructor);
    }

    private void deleteInstructorDetails(AppDAO appDAO) {
        int theId = 5;
        System.out.println("Deleting Instructor ID : " + theId);
        appDAO.deleteInstructorDetailsById(theId);
        System.out.println("Done!");
    }

    private void findInstructorDetails(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding Instructor Details id : " + theId);

        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);

        if (instructorDetail != null) {
            System.out.println("InstructorDetails : " + instructorDetail);
            System.out.println("The  associated Instructor  only : " + instructorDetail.getInstructor());
        } else {
            System.out.println("Instructor Details Not found this Id : " + theId);
        }
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting Instructor ID : " + theId);

        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Finding Instructor id : " + theId);

        Instructor instructor = appDAO.findInstructorById(theId);

        if (instructor != null) {
            System.out.println("Instructor : " + instructor);
            System.out.println("The  associated Instructor Details only : " + instructor.getInstructorDetail());
        } else {
            System.out.println("Instructor Not found this Id : " + theId);
        }
    }

    private void createInstructor(AppDAO appDAO) {
	/*	//create the instructor
		Instructor instructor =
				new Instructor("Ishara","Maduranga","isharamaduranag500@gmail.com");

		//create the instructor detail
		InstructorDetail instructorDetail =
				new InstructorDetail("https://www.ishara.com/youtube", "Read a Books ..");
*/
        //create the instructor
        Instructor instructor =
                new Instructor("Derick", "Andrew", "derickAndrew@gmail.com");

        //create the instructor detail
        InstructorDetail instructorDetail =
                new InstructorDetail("https://www.derick.com/youtube", "Watching Netflix movies ..");
        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // Save the Instructor
        // NOTE : this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving Instructor: " + instructor);
        appDAO.save(instructor);

        System.out.println("Done !!!");

    }

}
