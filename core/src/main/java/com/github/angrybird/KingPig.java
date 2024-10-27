package com.github.angrybird;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class KingPig {
    private BodyDef body;
    private FixtureDef fixture;
    private Sprite sprite;
    private int health;

    public KingPig(){
        body = new BodyDef();
        body.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
        health = 300;
    }
}
