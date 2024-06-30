package org.example.common;

import org.springframework.stereotype.Component;

@Component
public class HockyCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do running workout";
    }
}
