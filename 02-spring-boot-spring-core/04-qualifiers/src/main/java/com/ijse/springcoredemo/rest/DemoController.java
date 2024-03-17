package com.ijse.springcoredemo.rest;

import com.ijse.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private final Coach myCoach;

    /**
     * check @Qualifier annotation uses
     */
    @Autowired
   public  DemoController(@Qualifier("tennisCoach") Coach theCoach) {
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
