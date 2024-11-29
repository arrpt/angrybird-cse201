//package com.github.angrybird;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SlingshotTest {
//
//    @org.junit.jupiter.api.Test
//    void calculateTrajectory() {
//        //complete the test
//
//    }
//}

package com.github.angrybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SlingshotTest {

    @Test
    void calculateTrajectory() {
        // Create a mock World object
        World world = mock(World.class);
        when(world.getGravity()).thenReturn(new Vector2(0, -9.8f));

        // Create a mock Body object
        Body birdBody = mock(Body.class);
        when(birdBody.getPosition()).thenReturn(new Vector2(0, 0));
        when(birdBody.getWorld()).thenReturn(world);
        when(birdBody.getMass()).thenReturn(1.0f);

        // Create a mock SpriteBatch object
        SpriteBatch batch = mock(SpriteBatch.class);

        // Create a Slingshot object
        Slingshot slingshot = new Slingshot(0, 0);

        // Generate trajectory points
        List<Vector2> trajectoryPoints = new ArrayList<>();
        doAnswer(invocation -> {
            Vector2 position = new Vector2(invocation.getArgument(1), invocation.getArgument(2));
            trajectoryPoints.add(position);
            return null;
        }).when(batch).draw((Texture) any(), anyFloat(), anyFloat(), anyFloat(), anyFloat());

        slingshot.calculateTrajectory(birdBody, 10, batch);

        // Simulate bird's movement and compare with trajectory points
        Vector2 initialPosition = birdBody.getPosition();
        Vector2 initialVelocity = slingshot.getAnchorPoint().cpy().sub(slingshot.getPullPoint()).scl(600);
        Vector2 gravity = world.getGravity();
        float timeStep = 0.5f;

        for (int i = 1; i <= 10; i++) {
            float t = i * timeStep;
            Vector2 expectedPosition = new Vector2(
                initialPosition.x + initialVelocity.x * t + 0.5f * gravity.x * t * t,
                initialPosition.y + initialVelocity.y * t + 0.5f * gravity.y * t * t
            );
            assertEquals(expectedPosition, trajectoryPoints.get(i - 1), "The trajectory point does not match the expected position.");
        }
    }
}
