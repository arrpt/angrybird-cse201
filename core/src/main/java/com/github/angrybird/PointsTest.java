package com.github.angrybird;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    @Test
    void testPoints() {
        int redPoints = 100;
        int chuckPoints = 200;
        int terencePoints = 300;
        int glassPoints = 100;
        int woodPoints = 200;
        int stonePoints = 300;
        int piggaPoints = 500;
        int mustPigPoints = 1000;
        int kingPigPoints = 2000;
        int expectedPoints = 4700;

        int points =0;

        for (int i=0 ; i<9 ; i++){
            if(i==0){
                points += redPoints;

            }
            else if(i==1){
                points += chuckPoints;
            }
            else if(i==2){
                points += terencePoints;
            }
            else if(i==3){
                points += glassPoints;
            }
            else if(i==4){
                points += woodPoints;
            }
            else if(i==5){
                points += stonePoints;
            }
            else if(i==6){
                points += piggaPoints;
            }
            else if(i==7){
                points += mustPigPoints;
            }
            else if(i==8){
                points += kingPigPoints;
            }

        }
        assertEquals(expectedPoints, points);
        
    }


}
