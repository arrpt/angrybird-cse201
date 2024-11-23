package com.github.angrybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

public class Ground {
    public Texture texture;
    public Body body;
    public BodyDef bodyDef;
    public FixtureDef fixture;

    public Ground(World world){
        texture = new Texture("groundl1.png");
        bodyDef = new BodyDef();
        bodyDef.position.set(0, -450f);
        bodyDef.type = BodyDef.BodyType.StaticBody;

        body = world.createBody(bodyDef);

        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(1280f, 635f);

        fixture = new FixtureDef();
        fixture.shape = groundBox;
        fixture.density = 0.0f;
        fixture.friction = 0.8f;
        fixture.restitution = 0.2f;

        body.createFixture(fixture);
        body.setUserData(this);
        groundBox.dispose();
        //body.dispose();
    }
}
