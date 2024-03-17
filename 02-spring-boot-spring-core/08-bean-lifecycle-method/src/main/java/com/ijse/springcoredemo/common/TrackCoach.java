package com.ijse.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise 40 minutes for Track";
    }

    @Override
    public String getTakeABrake() {
        return "take 15 minutes break for Track";
    }
}
