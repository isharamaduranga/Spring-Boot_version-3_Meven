package com.ijse.springcoredemo.rest;

import com.ijse.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private final Coach myCoach;

    /**
     * already defined Tennis Coach is @Primary Coach (there for not need to use Qualifier)
     */
    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/takeabrake")
    public String getTakeABrake() {
        return myCoach.getTakeABrake();
    }
}
