package com.ijse.cruddemo;

import com.ijse.cruddemo.dao.AppDAO;
import com.ijse.cruddemo.entity.Instructor;
import com.ijse.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			//findInstructorDetails(appDAO);
			deleteInstructorDetails(appDAO);
		};
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
		int theId = 3;
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
