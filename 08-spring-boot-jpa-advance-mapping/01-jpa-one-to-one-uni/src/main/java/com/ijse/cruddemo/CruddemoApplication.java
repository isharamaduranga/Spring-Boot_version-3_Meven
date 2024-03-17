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
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor instructor =
				new Instructor("Ishara","Maduranga","isharamaduranag500@gmail.com");

		//create the instructor detail
		InstructorDetail instructorDetail =
				new InstructorDetail("https://www.ishara.com/youtube", "Read a Books ..");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// Save the Instructor
		// NOTE : this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving Instructor: "+instructor);
		appDAO.save(instructor);

	}

}
