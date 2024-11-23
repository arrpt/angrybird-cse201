package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Level1Screen implements Screen {

    Main game;
    private Texture sky;
    private Ground ground;
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
    private BitmapFont font;
    private Hwood hwood;
    private Vglass vglass;
    private Hstone hstone;
    private Box2DDebugRenderer box2ddebugrenderer;
    Chuck chuck;
    Terence terence;
    Pigga pigga;
    MustPig mustPig;
    KingPig kingPig;

    public Level1Screen(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -9.8f), true);
        world.setContactListener(new GameContactListener());
        //box2ddebugrenderer = new Box2DDebugRenderer();
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


        slingshot = new Slingshot(250f, 635f-455f+130f);

        //Font here
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("angrybirds-regular.ttf"));
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("angrybirds-regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        parameter.borderWidth = 1;
        font = fontGenerator.generateFont(parameter);
        fontGenerator.dispose();

        redBird = new RedBird(world, 200f, 635f-455f+130f);
        hwood = new Hwood(world, 800f, 635f-455f);
        vglass = new Vglass(world, 800f, 635f-455f+212f);
        hstone = new Hstone(world, 800f, 635f-455f+212f+22f);
        ground = new Ground(world);
        chuck = new Chuck(world, 200f + 100f, 635f-455f+130f);
        terence = new Terence(world, 200f + 200f, 635f-455f+130f);
        pigga = new Pigga(world, 200f+300f, 635f-455f+130f);
        mustPig = new MustPig(world, 200f+400f, 635f-455f+130f);
        kingPig = new KingPig(world, 200f+500f, 635f-455f+130f);
        box2ddebugrenderer = new Box2DDebugRenderer();
    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(sky, 0, 0, 1280f, 720f);
        game.batch.draw(ground.texture, 0, -450f, 1280f, 635f);
        game.batch.draw(pauseButton, 1220f, 660f, 50f, 50f);
        //game.batch.draw(slingRight, 640f-50f, 635f-45 1f, 36f, 200f);
        //game.batch.draw(slingLeft, 640f-50f-32f, 635f-451f+200f-115f, 42f, 124f);

        game.batch.draw(sling,200f,635f-455f,92f,170f);
        redBird.render(game.batch);
        hwood.render(game.batch);
        vglass.render(game.batch);
        hstone.render(game.batch);
        chuck.render(game.batch);
        terence.render(game.batch);
        pigga.render(game.batch);
        mustPig.render(game.batch);
        kingPig.render(game.batch);

        //game.batch.draw(grass, 0, 635f-455f, 1280f, 50f);
        font.draw(game.batch, "nicer", 10, 710);
        font.draw(game.batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 300, 710);
        //change to pauseButton2 if hover
        float birdRadius = 5f;
        //Vector2 touchPoint = new Vector2(Gdx.input.getX(), 720 - Gdx.input.getY());
        if (Gdx.input.isTouched() && Gdx.input.getX()>200f-180f && Gdx.input.getX()<200f+180f && 720f-Gdx.input.getY()>635f-455f && 720f-Gdx.input.getY()<635f-455f+170f+180f) {

            slingshot.pull(Gdx.input.getX(), 720 - Gdx.input.getY(), redBird.body);
            slingshot.calculateTrajectory(redBird.body, 20, game.batch);
        } else if (!Gdx.input.isTouched() && slingshot.isPulled()) {
            slingshot.release(redBird.body);
            redBird.body.setGravityScale(1);
        }
        //world.step(1 / 60f, 6, 2);
        //world.step(1 / 60f, 6, 2);
        //world.step(1 / 60f, 6, 2);

        if(Gdx.input.getX()>1220f && Gdx.input.getX()<1270f && 720f-Gdx.input.getY()>660f && 720f-Gdx.input.getY()<710f){
            game.batch.draw(pauseButton2, 1220f, 660f, 50f, 50f);
            if(Gdx.input.isTouched()){
                game.setScreen(new PauseScreen(game));
                dispose();
            }
        }
        game.batch.end();

        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        box2ddebugrenderer.render(world, game.batch.getProjectionMatrix().cpy().scale(1, 1, 0));
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
        box2ddebugrenderer.dispose();
    }

//    private void createGroundBody() {
//        ground = new Texture("groundl1.png");
//        BodyDef groundBodyDef = new BodyDef();
//        groundBodyDef.position.set(0, -450f);
//        groundBodyDef.type = BodyDef.BodyType.StaticBody;
//
//        Body groundBody = world.createBody(groundBodyDef);
//
//        PolygonShape groundBox = new PolygonShape();
//        groundBox.setAsBox(1280f, 635f);
//
//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = groundBox;
//        fixtureDef.density = 0.0f;
//        fixtureDef.friction = 0.5f;
//        fixtureDef.restitution = 0.2f;
//
//        groundBody.createFixture(fixtureDef);
//        groundBox.dispose();
//    }
}
