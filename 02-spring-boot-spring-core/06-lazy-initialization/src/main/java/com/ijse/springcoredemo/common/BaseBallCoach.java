package com.ijse.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {
    public BaseBallCoach() {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise 1 hour for BaseBall";
    }

    @Override
    public String getTakeABrake() {
        return "take 20 minutes break for BaseBall";
    }
}
