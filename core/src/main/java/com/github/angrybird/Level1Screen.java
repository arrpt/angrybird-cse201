package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

public class Level1Screen implements Screen {

    Main game;
    private Texture sky;
    private Texture ground;
    private Texture pauseButton;
    private Texture pauseButton2;
//    private Texture slingRight;
//    private Texture slingLeft;
    private Texture sling;
    private Texture grass;
    private Texture vstone1;
    private Texture vwood1;
    private Texture hglass1;
    private World world;
    private RedBird redBird;
    private Slingshot slingshot;

    public Level1Screen(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -9.8f), true);
        sky = new Texture("skyl1.png");
        //ground = new Texture("groundl1.png");
        pauseButton = new Texture("pausebutton.png");
        pauseButton2 = new Texture("pausebutton2.png");
        grass = new Texture("grass.png");
//        slingRight = new Texture("slingright.png");
//        slingLeft = new Texture("slingleft.png");
        sling = new Texture("sling.png");
        //red1 = new Texture("red1.png");
        //yellow1 = new Texture("yellow1.png");
        //bigRed1 = new Texture("bigred1.png");
        vstone1 = new Texture("vstone1.png");
        vwood1 = new Texture("vwood1.png");
        hglass1 = new Texture("hglass1.png");
        slingshot = new Slingshot(200, 200);
        //pig1= new Texture("pig1.png");
        redBird = new RedBird();
        redBird.createBody(world, 100, 300);
        createGroundBody();
    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(sky, 0, 0, 1280f, 720f);
        game.batch.draw(ground, 0, -450f, 1280f, 635f);
        game.batch.draw(pauseButton, 1220f, 660f, 50f, 50f);
        //game.batch.draw(slingRight, 640f-50f, 635f-45 1f, 36f, 200f);
        //game.batch.draw(slingLeft, 640f-50f-32f, 635f-451f+200f-115f, 42f, 124f);
        game.batch.draw(sling,200f,635f-455f,92f,170f);
        game.batch.draw(vstone1,800f,635f-455f, 22f, 212f);
        game.batch.draw(vwood1, 800f+212f-22f, 635f-455f, 22f, 212f);
        game.batch.draw(hglass1, 800f, 635f-455f+212f, 212f, 22f);
        game.batch.draw(slingshot.rightSling, slingshot.getAnchorPoint().x, slingshot.getAnchorPoint().y, 50f, 50f);
        game.batch.draw(redBird.getTexture(), redBird.getBody().getPosition().x, redBird.getBody().getPosition().y);
        game.batch.draw(slingshot.leftSling, slingshot.getAnchorPoint().x-50f, slingshot.getAnchorPoint().y, 50f, 50f);
        game.batch.draw(grass, 0, 635f-455f, 1280f, 50f);
        //change to pauseButton2 if hover

        if (Gdx.input.isTouched()) {
            slingshot.pull(Gdx.input.getX(), 720 - Gdx.input.getY(), redBird.getBody());
        } else if (slingshot.isPulled()) {
            slingshot.release(redBird.getBody());
            redBird.setGravityScale(1);
        }

        world.step(1 / 60f, 6, 2);
        if(Gdx.input.getX()>1220f && Gdx.input.getX()<1270f && 720f-Gdx.input.getY()>660f && 720f-Gdx.input.getY()<710f){
            game.batch.draw(pauseButton2, 1220f, 660f, 50f, 50f);
            if(Gdx.input.isTouched()){
                game.setScreen(new PauseScreen(game));
                dispose();
            }
        }
        game.batch.end();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
    }

    private void createGroundBody() {
        ground = new Texture("groundl1.png");
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.position.set(0, -450f);
        groundBodyDef.type = BodyDef.BodyType.StaticBody;

        Body groundBody = world.createBody(groundBodyDef);

        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(1280f, 635f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = groundBox;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.2f;

        groundBody.createFixture(fixtureDef);
        groundBox.dispose();
    }
}
