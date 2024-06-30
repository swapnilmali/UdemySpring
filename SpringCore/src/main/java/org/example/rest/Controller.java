package org.example.rest;

import org.example.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach mycoach;
    private Coach mycoach1;
    private Coach mycoach2;

    @Autowired
    public Controller(@Qualifier("cricketCoach") Coach coach,
                      @Qualifier("cricketCoach") Coach coach1){   // Constructor
        mycoach = coach;
        mycoach1 = coach1;

    }
   /* @Autowired
    public void setCoach(org.example.common.Coach coach1){
        mycoach1 = coach1;
    }*/
   /* @Autowired
    @Qualifier("hockeyCoach")
    public void setCoach1(Coach coach2){
        mycoach2 = coach2;
    }*/
    @GetMapping("/workout")      // endpoint
      String getDailyWorkout(){
        return mycoach.getDailyWorkout();

    }
    @GetMapping("/beancheck")
        boolean getcheck(){
            return (mycoach == mycoach1);
        }

}
