package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ishara = new Student(
                    "Ishara",
                    "ishara970206@gmail.com",
                    LocalDate.of(1997, Month.FEBRUARY, 6)

            );
            Student dinuth = new Student(
                    "dinuth",
                    "dinuth345@gmail.com",
                    LocalDate.of(2003, Month.JANUARY, 7)

            );
            repository.saveAll(
                    List.of(ishara,dinuth)
            );

        };
    }
}
