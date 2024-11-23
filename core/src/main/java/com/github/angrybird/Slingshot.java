package com.github.angrybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Slingshot {
    //public Texture leftSling;
    //public Texture rightSling;
    public Texture sling;
    private Vector2 anchorPoint;
    private Vector2 pullPoint;
    private boolean isPulled;
    final int maxRadius;

    public Slingshot(float x, float y) {
        anchorPoint = new Vector2(x, y);
        pullPoint = new Vector2(x, y);
        isPulled = false;
        //leftSling = new Texture("slingleft.png");
        //rightSling = new Texture("slingright.png");
        sling = new Texture("sling.png");
        maxRadius = 100;
    }

    public void pull(float x, float y, Body birdBody) {
        Vector2 newPullPoint = new Vector2(x, y);
        if (newPullPoint.dst(anchorPoint) > maxRadius) {
            newPullPoint = anchorPoint.cpy().add(newPullPoint.sub(anchorPoint).nor().scl(maxRadius));
        }
        pullPoint.set(newPullPoint);
        isPulled = true;
        birdBody.setTransform(pullPoint, birdBody.getAngle());


    }

    public void release(Body birdBody) {
        if (isPulled) {
            Vector2 force = anchorPoint.cpy().sub(pullPoint).scl(600); // Adjust the scaling factor as needed
            birdBody.applyLinearImpulse(force, birdBody.getWorldCenter(), true);
//            birdBody.setAwake(true);
//            Vector2 additionalForce = force.scl(10000f);
//            birdBody.applyForceToCenter(additionalForce, true);
            isPulled = false;
            pullPoint.set(anchorPoint);
        }
    }


    public Vector2 getTrajectoryPoint(Vector2 start, Vector2 velocity, float n) {
//        float t = 1 / 60f;
//        float tt = t * t;
//        float stepVelocityX = t * -velocity.x;
//        float stepVelocityY = t * -velocity.y;
//        float stepGravityX = tt * 0f;
//        float stepGravityY = tt * (-9.8f);
//        float tpx = start.x + n * stepVelocityX + 0.5f * (n * n + n) * stepGravityX;
//        float tpy = start.y + n * stepVelocityY + 0.5f * (n * n + n) * stepGravityY;
//        return new Vector2(tpx, tpy);

        float t = n;
        float gravity = -9.8f; // Assuming gravity is -9.8 m/s^2

        float tpx = start.x + velocity.x * t;
        float tpy = start.y + velocity.y * t + 0.5f * gravity * t * t;

        return new Vector2(tpx, tpy);
    }

    public void calculateTrajectory(Body birdBody, int numPoints, SpriteBatch batch) {
        Texture target = new Texture("red1.png");
        Vector2 initialPosition = birdBody.getPosition();
        Vector2 initialVelocity = anchorPoint.cpy().sub(pullPoint).scl(600); // Initial velocity
        Vector2 gravity = birdBody.getWorld().getGravity();
        float timeStep = 1/500f; // Assuming 60 FPS

        for (int i = 0; i < numPoints; i++) {
            float t = i * timeStep;
//            Vector2 position = new Vector2(
//                initialPosition.x + initialVelocity.x * t + 0.5f * gravity.x * t * t,
//                initialPosition.y + initialVelocity.y * t + 0.5f * gravity.y * t * t
//            );
            Vector2 position = getTrajectoryPoint(initialPosition, initialVelocity, t);
            batch.draw(target, position.x, position.y, 5f, 5f); // Draw small dots for trajectory
        }
        target.dispose();
    }


//    public Vector2 getTrajectoryPoint(Vector2 start, Vector2 velocity, float time) {
//    float t = time;
//    float gravity = -9.8f; // Assuming gravity is -9.8 m/s^2
//
//    float tpx = start.x + velocity.x * t;
//    float tpy = start.y + velocity.y * t + 0.5f * gravity * t * t;
//
//    return new Vector2(tpx, tpy);
//    }
//
//    public void calculateTrajectory(Body birdBody, int numPoints, SpriteBatch batch) {
//        Texture target = new Texture("red1.png");
//        Vector2 initialPosition = birdBody.getPosition();
//        Vector2 initialVelocity = anchorPoint.cpy().sub(pullPoint).scl(80); // Initial velocity
//
//        for (int i = 0; i < numPoints; i++) {
//            float t = i * 0.005f; // Adjust the time step as needed
//            Vector2 position = getTrajectoryPoint(initialPosition, initialVelocity, t);
//            batch.draw(target, position.x, position.y, 5f, 5f); // Draw small dots for trajectory
//        }
//        target.dispose();
//    }

    public Vector2 getAnchorPoint() {
        return anchorPoint;
    }

    public Vector2 getPullPoint() {
        return pullPoint;
    }

    public boolean isPulled() {
        return isPulled;
    }
}
