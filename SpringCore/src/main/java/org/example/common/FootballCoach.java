package org.example.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashSet;


@Component
@Primary
public class FootballCoach implements Coach{

    @Override
    public String getDailyWorkout() {

        return "Do smash workout";

    }
}
