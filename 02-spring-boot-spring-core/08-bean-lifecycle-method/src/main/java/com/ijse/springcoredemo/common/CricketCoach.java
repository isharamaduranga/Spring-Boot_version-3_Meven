package com.ijse.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
    }

    //define out init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff() : " + getClass().getSimpleName());
    }

    //define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff() : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes !!!";
    }

    @Override
    public String getTakeABrake() {
        return "After the Practice Gets 5 Minutes";
    }
}
