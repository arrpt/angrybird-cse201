package com.github.angrybird.bird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.github.angrybird.AngryObject;

public abstract class Bird extends AngryObject {
    public int health;
    public int isReleased;
    public Body body;
    public BodyDef bodyDef;
    public FixtureDef fixture;
    public Texture texture;
    public TextureRegion textureRegion;

    public Bird() {
        super();
        isReleased=0;
    }
}
