package com.github.angrybird;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class RedBird {
    private BodyDef body;
    private FixtureDef fixture;

    public RedBird(){
        body = new BodyDef();
        body.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
    }
}
