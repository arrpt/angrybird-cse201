package com.github.angrybird;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Queue;
import com.github.angrybird.bird.Bird;
import com.github.angrybird.material.Material;
import com.github.angrybird.pig.Pig;

import static java.lang.Math.min;

public class GameContactListener implements ContactListener {
    private final World world;
    public Queue<Body> removeBody;
    LevelScreen screen;


    public GameContactListener(World world, Queue<Body> removeBody, LevelScreen screen) {
        this.world = world;
        this.removeBody = removeBody;
        this.screen = screen;
    }

    @Override
    public void beginContact(Contact contact) {
        if (screen.started) {
            Object userDataA = contact.getFixtureA().getBody().getUserData();
            Object userDataB = contact.getFixtureB().getBody().getUserData();

            // Bird hits material
            if ((userDataA instanceof Bird && userDataB instanceof Material) || (userDataA instanceof Material && userDataB instanceof Bird)) {
                Bird bird = (Bird) (userDataA instanceof Bird ? userDataA : userDataB);
                Material material = (Material) (userDataA instanceof Material ? userDataA : userDataB);
                material.health -= min(bird.health, material.health);
                bird.health -= min(bird.health, material.health);
                if (material.health == 0) {
                    removeBody.addLast(material.body);
                    screen.points += material.score;
                    material.isVisible = 0;
                }

            }

            // bird hits pig
            if ((userDataA instanceof Bird && userDataB instanceof Pig) || (userDataA instanceof Pig && userDataB instanceof Bird)) {
                Bird bird = (Bird) (userDataA instanceof Bird ? userDataA : userDataB);
                Pig pig = (Pig) (userDataA instanceof Pig ? userDataA : userDataB);
                pig.health -= min(bird.health, pig.health);
                bird.health -= min(bird.health, pig.health);
                if (pig.health == 0) {
                    removeBody.addLast(pig.body);
                    screen.points += pig.score;
                    screen.pigsnumber--;
                    pig.isVisible = 0;
                }
            }

            // material hits material
            if ((userDataA instanceof Material && userDataB instanceof Material)) {
                Material materialA = (Material) (userDataA);
                Material materialB = (Material) (userDataB);
                materialA.health -= min(materialA.health, materialB.health)/100;
                materialB.health -= min(materialA.health, materialB.health)/100;
                if (materialA.health == 0) {
                    removeBody.addLast(materialA.body);
                    screen.points += materialA.score;
                    materialA.isVisible = 0;
                }
                if (materialB.health == 0) {
                    removeBody.addLast(materialB.body);
                    screen.points += materialB.score;
                    materialB.isVisible = 0;
                }
            }

            // pig hits pig
            if ((userDataA instanceof Pig && userDataB instanceof Pig)) {
                Pig pigA = (Pig) (userDataA);
                Pig pigB = (Pig) (userDataB);
                pigA.health -= min(pigA.health, pigB.health);
                pigB.health -= min(pigA.health, pigB.health);
                if (pigA.health == 0) {
                    removeBody.addLast(pigA.body);
                    screen.points += pigA.score;
                    screen.pigsnumber--;
                    pigA.isVisible = 0;
                }
                if (pigB.health == 0) {
                    removeBody.addLast(pigB.body);
                    screen.points += pigB.score;
                    screen.pigsnumber--;
                    pigB.isVisible = 0;
                }
            }

            // material hits pig
            if ((userDataA instanceof Material && userDataB instanceof Pig) || (userDataA instanceof Pig && userDataB instanceof Material)) {
                Material material = (Material) (userDataA instanceof Material ? userDataA : userDataB);
                Pig pig = (Pig) (userDataA instanceof Pig ? userDataA : userDataB);
                material.health -= min(pig.health, material.health);
                pig.health -= min(pig.health, material.health);
                if (material.health == 0) {
                    removeBody.addLast(material.body);
                    screen.points += material.score;
                    material.isVisible = 0;
                }
                if (pig.health == 0) {
                    removeBody.addLast(pig.body);
                    screen.points += pig.score;
                    screen.pigsnumber--;
                    pig.isVisible = 0;
                }
            }

            // material hits ground
            if ((userDataA instanceof Material && userDataB instanceof Ground) || (userDataA instanceof Ground && userDataB instanceof Material)) {
                Material material = (Material) (userDataA instanceof Material ? userDataA : userDataB);
                material.health--;
                if (material.health == 0) {
                    removeBody.addLast(material.body);
                    material.isVisible = 0;
                }
            }

            // pigs hit ground
            if ((userDataA instanceof Pig && userDataB instanceof Ground) || (userDataA instanceof Ground && userDataB instanceof Pig)) {
                Pig pig = (Pig) (userDataA instanceof Pig ? userDataA : userDataB);
                pig.health--;
                if (pig.health == 0) {
                    removeBody.addLast(pig.body);
                    screen.points += pig.score;
                    screen.pigsnumber--;
                    pig.isVisible = 0;
                }
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }
}
