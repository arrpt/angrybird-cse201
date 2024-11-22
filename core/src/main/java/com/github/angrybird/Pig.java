//package com.github.angrybird;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.physics.box2d.*;
//
//public class KingPig {
//    private BodyDef bodyDef;
//    private FixtureDef fixture;
//    private Body body;
//    private Sprite sprite;
//    private int health;
//    private Texture texture;
//
//    public KingPig() {
//        this(300, "kingpig.png");
//    }
//
//    public KingPig(int health, String texturePath) {
//        bodyDef = new BodyDef();
//        bodyDef.type = BodyDef.BodyType.DynamicBody;
//        fixture = new FixtureDef();
//        this.health = health;
//        texture = new Texture(texturePath);
//        sprite = new Sprite(texture);
//    }
//
//    public void createBody(World world, float x, float y) {
//        bodyDef.position.set(x, y);
//        body = world.createBody(bodyDef);
//        CircleShape c = new CircleShape();
//        c.setRadius(5f);
//        fixture.shape = c;
//        fixture.density = 1f;
//        fixture.friction = 0.5f;
//        fixture.restitution = 0.6f;
//        body.createFixture(fixture);
//        c.dispose();
//    }
//
//    public BodyDef getBodyDef() {
//        return bodyDef;
//    }
//
//    public FixtureDef getFixture() {
//        return fixture;
//    }
//
//    public Body getBody() {
//        return body;
//    }
//
//    public Sprite getSprite() {
//        return sprite;
//    }
//
//    public int getHealth() {
//        return health;
//    }
//
//    public Texture getTexture() {
//        return texture;
//    }
//
//    public void dispose() {
//        texture.dispose();
//    }
//}

package com.github.angrybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

public class Pig {
    int health;
    private Body body;
    private BodyDef bodyDef;
    private FixtureDef fixture;
    private Texture texture;

    public Pig(){
        health = 50;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
        texture = new Texture("pig.png");
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

}

