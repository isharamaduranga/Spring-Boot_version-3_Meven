package com.ijse.springcoredemo.rest;

import com.ijse.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    /**
     * setter method injection
     */
    @Autowired
    /* we can use any method name setter method injection way*/
   public void setCoach(Coach theCoach) {
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
