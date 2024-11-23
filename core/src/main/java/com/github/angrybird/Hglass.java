package com.github.angrybird;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;

public class Hglass {
    public int health;
    public Body body;
    public BodyDef bodyDef;
    public FixtureDef fixture;
    public Texture texture;

    public Hglass(){
        health = 100;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
        texture = new Texture("hglass1.png");
    }

    public void createBody(World world, float x, float y){
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
        PolygonShape rectangle = new PolygonShape();
        float width = texture.getWidth()/2f;
        float height = texture.getHeight()/2f;
        rectangle.setAsBox(width, height);

        fixture.shape = rectangle;
        fixture.density = 1f;
        fixture.friction = 0.5f;
        fixture.restitution = 0.6f;
        body.createFixture(fixture);
        body.setLinearVelocity(0, 0);
        body.setAngularVelocity(0);
        body.setGravityScale(0);
        body.setUserData(this);
        rectangle.dispose();
    }

//    public void setGravityScale(float gravityScale){
//        body.setGravityScale(gravityScale);
//    }

//    public BodyDef getBodyDef() {
//        return bodyDef;
//    }
//
//    public FixtureDef getFixture() {
//        return fixture;
//    }

//    public Texture getTexture() {
//        return texture;
//    }

//    public Body getBody() {
//        return body;
//    }

    public void dispose(){
        texture.dispose();
    }
}
