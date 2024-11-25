package com.github.angrybird.material;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

public class Hglass extends Material {

    public Hglass(World world, float x, float y){
        super();
        health = 100;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        fixture = new FixtureDef();
        texture = new Texture("hglass1.png");
        createBody(world, x, y);
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
        body.setGravityScale(1);
        body.setUserData(this);
        rectangle.dispose();
    }

    public void render(SpriteBatch batch){
        batch.draw(textureRegion,
            body.getPosition().x - textureRegion.getRegionWidth() / 2f,
            body.getPosition().y - textureRegion.getRegionHeight() / 2f,
            textureRegion.getRegionWidth() / 2f,
            textureRegion.getRegionHeight() / 2f,
            textureRegion.getRegionWidth(),
            textureRegion.getRegionHeight(),
            1, 1,
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
