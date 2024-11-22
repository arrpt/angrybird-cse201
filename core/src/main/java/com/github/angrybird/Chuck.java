package com.github.angrybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

public class Chuck {
    int health;
    private BodyDef bodyDef;
    private FixtureDef fixture;
    private Body body;
    private Texture texture;

    public Chuck(){
        health = 150;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
        texture = new Texture("yellow1.png");
    }

    public void createBody(World world, float x, float y){
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
        CircleShape c = new CircleShape();
        c.setRadius(5f);
        fixture.shape = c;
        fixture.density = 1f;
        fixture.friction = 0.5f;
        fixture.restitution = 0.6f;
        body.createFixture(fixture);
        body.setLinearVelocity(0, 0);
        body.setAngularVelocity(0);
        body.setGravityScale(0);
        c.dispose();
    }

    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public FixtureDef getFixture() {
        return fixture;
    }

    public Texture getTexture() {
        return texture;
    }

    public Body getBody() {
        return body;
    }

    public void dispose(){
        texture.dispose();
    }

    public int getHealth() {
        return health;
    }

    public void setGravityScale(float gravityScale){
        body.setGravityScale(gravityScale);
    }



}
