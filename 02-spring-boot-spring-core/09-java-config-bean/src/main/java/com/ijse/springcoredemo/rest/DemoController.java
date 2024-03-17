package com.ijse.springcoredemo.rest;

import com.ijse.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private final Coach myCoach;

   /* @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
    }*/

    // If i already use bean id( @Bean("aquatic") its introduced Qualifier("aquatic") )
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
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
