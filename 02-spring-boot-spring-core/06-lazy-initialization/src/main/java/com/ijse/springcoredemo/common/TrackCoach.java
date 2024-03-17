package com.ijse.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
/**
 *  @Lazy annotation we can use individually, but
 *  it's not appropriate for large number of beans situation
 *  we can use application.properties file set that true (spring.main.lazy-initialization=true)
 */
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
