package com.ijse.springcoredemo.common;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practise 30 minutes for Tennis";
    }

    @Override
    public String getTakeABrake() {
        return "take 8 minutes break for tennis";
    }
}
