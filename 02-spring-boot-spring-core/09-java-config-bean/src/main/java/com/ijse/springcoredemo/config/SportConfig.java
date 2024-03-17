package com.ijse.springcoredemo.config;

import com.ijse.springcoredemo.common.Coach;
import com.ijse.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

 /* @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
  */

    // If i need different name use we can use bean id( @Bean("aquatic") )
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
