package com.github.angrybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Slingshot {
    public Texture leftSling;
    public Texture rightSling;
    private Vector2 anchorPoint;
    private Vector2 pullPoint;
    private boolean isPulled;
    final int maxRadius;

    public Slingshot(float x, float y) {
        anchorPoint = new Vector2(x, y);
        pullPoint = new Vector2(x, y);
        isPulled = false;
        leftSling = new Texture("slingleft.png");
        rightSling = new Texture("slingright.png");
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
            Vector2 force = anchorPoint.cpy().sub(pullPoint).scl(80); // Adjust the scaling factor as needed
            birdBody.applyLinearImpulse(force, birdBody.getWorldCenter(), true);
//            birdBody.setAwake(true);
//            Vector2 additionalForce = force.scl(10000f);
//            birdBody.applyForceToCenter(additionalForce, true);
            isPulled = false;
            pullPoint.set(anchorPoint);
        }
    }

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
