package com.ijse.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

/**
 * change bean scope to SCOPE_PROTOTYPE (But its by default SCOPE_SINGLETON)
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println(" In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes !!!";
    }

    @Override
    public String getTakeABrake() {
        return "After the Practice Gets 5 Minutes";
    }
}
