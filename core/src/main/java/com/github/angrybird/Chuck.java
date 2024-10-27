package com.github.angrybird;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Chuck {
    private BodyDef body;
    private FixtureDef fixture;

    public Chuck(){
        body = new BodyDef();
        body.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
    }
}
