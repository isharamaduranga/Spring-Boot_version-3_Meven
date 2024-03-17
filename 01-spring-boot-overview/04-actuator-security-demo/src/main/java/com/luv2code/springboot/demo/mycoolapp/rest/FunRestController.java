package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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
