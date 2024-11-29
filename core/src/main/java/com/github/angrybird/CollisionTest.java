package com.github.angrybird;

import org.junit.jupiter.api.Test;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {

    @Test
    void pigBirdCollision() {

//        if ((userDataA instanceof Bird && userDataB instanceof Pig) || (userDataA instanceof Pig && userDataB instanceof Bird)) {
//            Bird bird = (Bird) (userDataA instanceof Bird ? userDataA : userDataB);
//            Pig pig = (Pig) (userDataA instanceof Pig ? userDataA : userDataB);
//            pig.health -= min(bird.health, pig.health);
//            bird.health -= min(bird.health, pig.health);
//            if (pig.health == 0) {
//                removeBody.addLast(pig.body);
//                screen.points += pig.score;
//                screen.pigsnumber--;
//                pig.isVisible = 0;
//            }
//        }


        int pigga = 300;
        int bird = 100;
        int expectedPigga=200;
        int expectedRedBird=0;

        boolean pigga1 = true;
        boolean redBird1 = true;

        if(pigga1 && redBird1 || redBird1 && pigga1){
            pigga -= min(bird, pigga);
            bird -= min(bird, pigga);
            if(pigga == 0){
                pigga1 = false;
            }
            if(bird == 0){
                redBird1 = false;
            }
        }

        assertEquals(expectedPigga, pigga);
        assertEquals(expectedRedBird, bird);

    }

    @Test
    void materialBirdCollision() {

        int material = 300;
        int bird = 100;
        int expectedMaterial=200;
        int expectedBird=0;

        boolean material1 = true;
        boolean bird1 = true;

        if(material1 && bird1 || bird1 && material1){
            material -= min(bird, material);
            bird -= min(bird, material);
            if(material == 0){
                material1 = false;
            }
            if(bird == 0){
                bird1 = false;
            }
        }

        assertEquals(expectedMaterial, material);
        assertEquals(expectedBird, bird);
    }

    @Test
    void pigPigCollision() {

        int pigga = 300;
        int pigga2 = 100;
        int expectedPigga=200;
        int expectedPigga2=0;

        boolean pigga1 = true;
        boolean pigga2_1 = true;

        if(pigga1 && pigga2_1 || pigga2_1 && pigga1){
            pigga -= min(pigga, pigga2);
            pigga2 -= min(pigga, pigga2);
            if(pigga == 0){
                pigga1 = false;
            }
            if(pigga2 == 0){
                pigga2_1 = false;
            }
        }

        assertEquals(expectedPigga, pigga);
        assertEquals(expectedPigga2, pigga2);
    }

    @Test
    void materialPigCollision() {

        int material = 300;
        int pigga = 100;
        int expectedMaterial=200;
        int expectedPigga=0;

        boolean material1 = true;
        boolean pigga1 = true;

        if(material1 && pigga1 || pigga1 && material1){
            material -= min(pigga, material);
            pigga -= min(pigga, material);
            if(material == 0){
                material1 = false;
            }
            if(pigga == 0){
                pigga1 = false;
            }
        }

        assertEquals(expectedMaterial, material);
        assertEquals(expectedPigga, pigga);
    }



}



