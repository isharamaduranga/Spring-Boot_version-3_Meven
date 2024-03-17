package com.ijse.springcoredemo.common;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim 1000 meters as a warm up";
    }

    @Override
    public String getTakeABrake() {
        return "take a break 45 minutes";
    }
}
