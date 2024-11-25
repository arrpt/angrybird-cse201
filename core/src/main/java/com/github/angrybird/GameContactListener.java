package com.github.angrybird;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Queue;
import com.github.angrybird.bird.Bird;
import com.github.angrybird.material.Vglass;

public class GameContactListener implements ContactListener {
    private final World world;
    public Queue<Body> removeBody;

    public GameContactListener(World world, Queue<Body> removeBody) {
        this.world = world;
        this.removeBody = removeBody;
    }

    @Override
    public void beginContact(Contact contact) {
        Object userDataA = contact.getFixtureA().getBody().getUserData();
        Object userDataB = contact.getFixtureB().getBody().getUserData();

        // Bird hits Ground
        if ((userDataA instanceof Bird && userDataB instanceof Vglass) || (userDataA instanceof Vglass && userDataB instanceof Bird)) {
            Bird bird = (Bird) (userDataA instanceof Bird ? userDataA : userDataB);
            Vglass vglass = (Vglass) (userDataA instanceof Vglass ? userDataA : userDataB);
            //world.destroyBody(vglass.body);
            vglass.isVisible = 0;
            removeBody.addLast(vglass.body);
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
