package com.github.angrybird;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.github.angrybird.bird.RedBird;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SlingshotTest {

    @Test
    void calculateTrajectory1() {
        Slingshot slingshot = new Slingshot(0, 0);
        Vector2 birdPosition = new Vector2(0, 0);
        Vector2 targetPosition = new Vector2(10, 10);

        Vector2 initialVelocity = new Vector2(0,0);
        Vector2 gravity= new Vector2(0, -9.8f);
        float timeStep = 1/60f;

        for(int i=0; i<100; i++){
            float t= i*timeStep;
            Vector2 position = new Vector2(
                birdPosition.x + initialVelocity.x * t + 0.5f * gravity.x * t * t,
                birdPosition.y + initialVelocity.y * t + 0.5f * gravity.y * t * t
            );
        }

        assertEquals(10, targetPosition.x, 0.1);
    }

    @Test
    void calculateTrajectory2() {
        Slingshot slingshot = new Slingshot(0, 0);
        Vector2 birdPosition = new Vector2(0, 0);
        Vector2 targetPosition = new Vector2(10, 10);

        Vector2 initialVelocity = new Vector2(0,0);
        Vector2 gravity= new Vector2(0, -9.8f);
        float timeStep = 1/60f;

        for(int i=0; i<100; i++){
            float t= i*timeStep;
            Vector2 position = new Vector2(
                birdPosition.x + initialVelocity.x * t + 0.5f * gravity.x * t * t,
                birdPosition.y + initialVelocity.y * t + 0.5f * gravity.y * t * t
            );
        }

        assertEquals(10, targetPosition.x, 0.1);
    }

    @Test
    void calculateTrajectory3() {
        Slingshot slingshot = new Slingshot(0, 0);
        Vector2 birdPosition = new Vector2(0, 0);
        Vector2 targetPosition = new Vector2(10, 10);

        Vector2 initialVelocity = new Vector2(0,0);
        Vector2 gravity= new Vector2(0, -9.8f);
        float timeStep = 1/60f;

        for(int i=0; i<100; i++){
            float t= i*timeStep;
            Vector2 position = new Vector2(
                birdPosition.x + initialVelocity.x * t + 0.5f * gravity.x * t * t,
                birdPosition.y + initialVelocity.y * t + 0.5f * gravity.y * t * t
            );
        }

        assertEquals(10, targetPosition.x, 0.1);
    }
}





