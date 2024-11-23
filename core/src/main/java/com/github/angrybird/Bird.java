package com.github.angrybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

public abstract class Bird {
    public int health;
    public Body body;
    public BodyDef bodyDef;
    public FixtureDef fixture;
    public Texture texture;

    public Bird() {
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
    }

    public abstract void createBody(World world, float x, float y);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
