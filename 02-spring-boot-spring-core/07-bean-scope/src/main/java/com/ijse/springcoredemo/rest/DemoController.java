package com.ijse.springcoredemo.rest;

import com.ijse.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private final Coach myCoach;
    private final Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    /**
     * create a new instance of cricket Coach and check instance compatibility
     *
     * SCOPE_SINGLETON === false( because same instance)
     * SCOPE_PROTOTYPE === true( because create different instance)
     *
     */
    @GetMapping("/check")
    public String check() {
        return "Comparing Beans : myCoach === anotherCoach , " + (myCoach == anotherCoach);
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
