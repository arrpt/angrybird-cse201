package com.github.angrybird;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class GameContactListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Object userDataA = contact.getFixtureA().getBody().getUserData();
        Object userDataB = contact.getFixtureB().getBody().getUserData();

        // Bird hits Ground
        if (userDataA instanceof Bird && userDataB instanceof Ground) {
            Bird bird = (Bird) userDataA;
            System.out.println("Bird hits Ground");
            // bird.health -= 10;
        } else if (userDataA instanceof Ground && userDataB instanceof Bird) {
            Bird bird = (Bird) userDataB;
            System.out.println("Bird hits Ground");
            // bird.health -= 10;
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
