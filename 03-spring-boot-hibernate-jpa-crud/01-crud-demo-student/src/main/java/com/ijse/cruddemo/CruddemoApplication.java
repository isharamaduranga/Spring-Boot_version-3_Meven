package com.ijse.cruddemo;

import com.ijse.cruddemo.dao.StudentDAO;
import com.ijse.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

             createMultipleStudent(studentDAO);

            // readStudent(studentDAO);

            // fetchAllStudent(studentDAO);

            // fetchAllFindByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            // deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting All Students");
        int deletedCount = studentDAO.deleteAll();
        System.out.println("Deleted row count : "+deletedCount);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int stuId = 5;
        System.out.println("Deleted student : " + stuId);
        studentDAO.delete(stuId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        int sId = 2;
        Student myStudent = studentDAO.findById(sId);

        //Change the First name to "Mahinda"
        System.out.println("updating student ...");
        myStudent.setFirstName("Mahinda");

        //update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("Updated student : " + myStudent);

    }

    private void fetchAllFindByLastName(StudentDAO studentDAO) {

        //get a list of  students
        List<Student> studentList = studentDAO.findByLastName("perera");

        //display list of  students
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void fetchAllStudent(StudentDAO studentDAO) {

        //get a list of  students
        List<Student> allStudent = studentDAO.findAll();

        //display list of  students
        allStudent.forEach(student -> System.out.println(student));
    }

    private void readStudent(StudentDAO studentDAO) {
        // create student object
        System.out.println("creating new student object");

        //save the student
        System.out.println("Saving the student ....");
        Student tempStudent = new Student("Pasan", "Sadakalum", "pasankalum500@gmail.com");
        studentDAO.save(tempStudent);

        //display id of saved student
        System.out.println("saved student id : " + tempStudent.getId());

        //restive student based on the id: primary key
        int stuId = tempStudent.getId();
        System.out.println("Retrieving the student with Id : " + stuId);
        Student student = studentDAO.findById(stuId);

        //display content
        System.out.println("Saved Student details : " + student);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        //create multiple students
        System.out.println("Creating 3 Student object ...");
        Student tempStudent1 = new Student("Dinuth", "dheeraka", "dinuth345@gmail.com");
        Student tempStudent2 = new Student("John", "perera", "john200@gmail.com");
        Student tempStudent3 = new Student("Fedrick", "thisera", "fedrick552@gmail.com");

        //save the student objects
        System.out.println("Saving the student ....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new Student object ...");
        Student tempStudent = new Student("Ishara", "Maduranga", "isharamaduranga500@gmail.com");
        System.out.println("Saving the student ....");

        //save the student object
        studentDAO.save(tempStudent);

        //display id of the save student
        System.out.println("Save student .. Generated id : " + tempStudent.getId());
    }


}
