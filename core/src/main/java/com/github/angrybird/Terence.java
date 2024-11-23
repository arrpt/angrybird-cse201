package com.github.angrybird;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;

public class Terence extends Bird {
//    public int health;
//    public Body body;
//    public BodyDef bodyDef;
//    public FixtureDef fixture;
//    public Texture texture;
//    public TextureRegion textureRegion;

    public Terence(World world, float x, float y){
        super();
        super.health = 100;
        super.bodyDef = new BodyDef();
        super.bodyDef.type = BodyDef.BodyType.DynamicBody;
        super.fixture = new FixtureDef();
        super.texture = new Texture("bigred1.png");
        super.textureRegion = new TextureRegion(texture);
        createBody(world, x, y);
    }

    public void createBody(World world, float x, float y){
        bodyDef.position.set(x, y);
        super.body = world.createBody(bodyDef);
        CircleShape c = new CircleShape();
        c.setRadius(37f);
        fixture.shape = c;
        fixture.density = 0.17f;
        fixture.friction = 0.5f;
        fixture.restitution = 0.6f;
        body.setAngularDamping(5f);
        body.createFixture(fixture);
        body.setLinearVelocity(0, 0);
        body.setAngularVelocity(0);
        body.setGravityScale(1);
        body.setUserData(this);
        c.dispose();
    }

    public void render(SpriteBatch batch){
        batch.draw(textureRegion,
            body.getPosition().x - textureRegion.getRegionWidth() / 2f-4f,
            body.getPosition().y - textureRegion.getRegionHeight() / 2f+5f,
            textureRegion.getRegionWidth() / 2f,
            textureRegion.getRegionHeight() / 2f,
            textureRegion.getRegionWidth(),
            textureRegion.getRegionHeight(),
            1f, 1f,
            (float) Math.toDegrees(body.getAngle()));
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
