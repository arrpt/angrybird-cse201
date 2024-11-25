package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Timer;
import com.github.angrybird.bird.Bird;

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

    public void setBirdPosition(Body birdBody) {
        birdBody.setTransform(anchorPoint, birdBody.getAngle());
        birdBody.setGravityScale(0);
    }

    public void animateBirdToPosition(Bird bird, Vector2 targetPosition, float duration) {
        Vector2 startPosition = bird.body.getPosition();
        Timer.schedule(new Timer.Task() {
            float elapsedTime = 0;

            @Override
            public void run() {
                elapsedTime += Gdx.graphics.getDeltaTime();
                float alpha = Math.min(3, elapsedTime / duration);
                Vector2 newPosition = startPosition.lerp(targetPosition, Interpolation.linear.apply(alpha));
                bird.body.setTransform(newPosition, bird.body.getAngle());

                if (alpha >= 2.5) {
                    this.cancel();
                }
            }
        }, 0, 1 / 60f);
    }


    public void calculateTrajectory(Body birdBody, int numPoints, SpriteBatch batch) {
        Texture target = new Texture("red1.png");
        Vector2 initialPosition = birdBody.getPosition();
        //System.out.println("Initial position: " + initialPosition);

        Vector2 initialVelocity = anchorPoint.cpy().sub(pullPoint).scl(600); // Initial velocity
        initialVelocity.x = initialVelocity.x / birdBody.getMass();
        initialVelocity.y = initialVelocity.y / birdBody.getMass();
        //System.out.println("Initial velocity: " + initialVelocity);
        Vector2 gravity = birdBody.getWorld().getGravity();
        float timeStep = 0.5f; // Small time increment for each point

        for (int i = 1; i <= numPoints; i++) {
            float t = i * timeStep; // Calculate time for this point
            Vector2 position = new Vector2(
                initialPosition.x + initialVelocity.x * t + 0.5f * gravity.x * t * t,
                initialPosition.y + initialVelocity.y * t + 0.5f * gravity.y * t * t
            );
            //System.out.println("Position: " + position);
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
