package com.ijse.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
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
