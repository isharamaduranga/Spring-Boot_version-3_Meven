package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for using application.properties file

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for teamInfo
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return " Coach : " + coachName + " , Team Name : " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello world !!!";
    }


    // new endpoint for work out
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a Hard 5k !";
    }

    // new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is a your lucky day !";
    }


}
