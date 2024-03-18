package com.ijse.cruddemo;

import com.ijse.cruddemo.dao.AppDAO;
import com.ijse.cruddemo.entity.Course;
import com.ijse.cruddemo.entity.Instructor;
import com.ijse.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return  runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			deleteCourse(appDAO);

			//findInstructorDetails(appDAO);
			//deleteInstructorDetails(appDAO);

			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);
			//updateCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 11;
		System.out.println("Deleting Course Id : "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done !!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Finding Course Id : "+theId);
		Course course = appDAO.findCourseById(theId);

		//update the course
		System.out.println("Updating Course id : "+theId);
		course.setTitle("Geography Course");

		appDAO.update(course);
		System.out.println("Done !!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding Instructor Id : "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating Instructor id : "+theId);
		instructor.setLastName("Fernandoo");

		appDAO.update(instructor);

		System.out.println("Done !!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding Instructor Id : "+theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor : >>> "+instructor);
		System.out.println("Instructor Associated Courses: >>> "+instructor.getCourses());

		System.out.println("Done !!");


	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId =2;
		System.out.println("Finding Instructor Id : "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor >> "+instructor);

		//find courses from instructor
		System.out.println("Finding Courses from instructor id : "+theId);
		List<Course> courses = appDAO.findCoursesInstructorId(theId);

		//associate the object
		instructor.setCourses(courses);

		System.out.println("the associated courses >> "+instructor.getCourses());
		System.out.println("Done !");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding Instructor Id : "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor >> "+instructor);
		System.out.println("The Associated Courses >> "+instructor.getCourses());

		System.out.println("Done !!!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		//create the instructor
		Instructor instructor =
				new Instructor("Derick","Andrew","derickAndrew@gmail.com");

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
		System.out.println("Saving instructor : "+instructor);
		System.out.println("The Courses : "+instructor.getCourses());
		appDAO.save(instructor);
	}

	private void deleteInstructorDetails(AppDAO appDAO) {
		int theId = 5;
		System.out.println("Deleting Instructor ID : "+theId);
		appDAO.deleteInstructorDetailsById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetails(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor Details id : "+theId);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);

		if (instructorDetail != null){
			System.out.println("InstructorDetails : "+instructorDetail);
			System.out.println("The  associated Instructor  only : "+instructorDetail.getInstructor());
		}else{
			System.out.println("Instructor Details Not found this Id : "+theId);
		}
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting Instructor ID : "+theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding Instructor id : "+theId);

		Instructor instructor = appDAO.findInstructorById(theId);

		if (instructor!=null){
			System.out.println("Instructor : "+instructor);
			System.out.println("The  associated Instructor Details only : "+instructor.getInstructorDetail());
		}else{
			System.out.println("Instructor Not found this Id : "+theId);
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
				new Instructor("Derick","Andrew","derickAndrew@gmail.com");

		//create the instructor detail
		InstructorDetail instructorDetail =
				new InstructorDetail("https://www.derick.com/youtube", "Watching Netflix movies ..");
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// Save the Instructor
		// NOTE : this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving Instructor: "+instructor);
		appDAO.save(instructor);

		System.out.println("Done !!!");

	}

}
