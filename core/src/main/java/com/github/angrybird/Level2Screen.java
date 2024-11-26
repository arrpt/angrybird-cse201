package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.utils.Queue;
import com.github.angrybird.bird.Bird;
import com.github.angrybird.bird.Chuck;
import com.github.angrybird.bird.RedBird;
import com.github.angrybird.bird.Terence;
import com.github.angrybird.material.*;
import com.github.angrybird.pig.KingPig;
import com.github.angrybird.pig.MustPig;
import com.github.angrybird.pig.Pigga;

import java.util.ArrayList;

public class Level2Screen extends LevelScreen implements Screen {

    //Main game;
    //public boolean started = false;
    private Texture sky;
    private Ground ground;
    private Texture pauseButton;
    private Texture pauseButton2;
    //    private Texture slingRight;
//    private Texture slingLeft;
    private Texture sling;
    private Texture grass;
    //private Texture vstone1;
    //private Texture vwood1;
    //private Texture hglass1;
    private World world;
    private RedBird redBird;
    private Slingshot slingshot;
    private BitmapFont font;
    private Hwood hwood;
    private Vglass vglass1;
    private Vglass vglass2;
    private Vglass vglass3;
    private Vwood vwood1;
    private Vwood vwood2;
    private Hglass hglass1;
    private Hstone hstone;
    //    private Box2DDebugRenderer box2ddebugrenderer;
    Chuck chuck;
    //    Terence terence;
    Pigga pigga1;
    Pigga pigga2;
    MustPig mustPig;
//    KingPig kingPig;

    private boolean initialized = false;

    public Queue<Bird> birdQueue = new Queue<>();
    public Queue<Body> removeBody = new Queue<>();
    //public ArrayList<AngryObject> renderObjects = new ArrayList<>();

    public Level2Screen(Main game){
        super(game);
    }

    @Override
    public void show() {
        if(initialized){
            return;
        }
        world = new World(new Vector2(0, -9.8f), true);
        world.setContactListener(new GameContactListener(world, removeBody, this));
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
        //vstone1 = new Texture("vstone1.png");
        //vwood1 = new Texture("vwood1.png");
        //hglass1 = new Texture("hglass1.png");

        slingshot = new Slingshot(250f, 635f-455f+130f);

        //Font here
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("angrybirds-regular.ttf"));
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("angrybirds-regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        parameter.borderWidth = 1;
        font = fontGenerator.generateFont(parameter);
        fontGenerator.dispose();


        //birds
        redBird = new RedBird(world, 250f, 635f-455f+130f);
        chuck = new Chuck(world, 200f - 70f, 635f-455f+130f);
//        terence = new Terence(world, 200f - 150f, 635f-455f+130f);

        //materials
        hwood = new Hwood(world, 800f, 635f-455f+212f+150f+100f);
        vglass1 = new Vglass(world, 800f-106f+11f, 635f-455f+106f);
        vglass2= new Vglass(world, 800f+106f-11f, 635f-455f+106f);
        //vglass3= new Vglass(world, 800f, 635f-455f+106f);
        vwood1 = new Vwood(world, 800f-106f+13f, 635f-455f+212f+150f);
        vwood2 = new Vwood(world, 800f+106f-13f, 635f-455f+212f+150f);
        hglass1 = new Hglass(world,800f, 635f-455f+212f );
        //hstone = new Hstone(world, 800f, 635f-455f+212f+22f);

        //pigs
        pigga1 = new Pigga(world, 800, 635f-455f+130f);
        pigga2 = new Pigga(world, 800f, 635f-455f+212f+100f);
        mustPig = new MustPig(world, 800f, 690f);
//        kingPig = new KingPig(world, 200f+450f, 635f-455f+130f);
//        box2ddebugrenderer = new Box2DDebugRenderer();

        ground = new Ground(world);

        //birdQueue = new Queue<>();
        birdQueue.addLast(redBird);
        birdQueue.addLast(chuck);
//        birdQueue.addLast(terence);
        initialized=true;
        System.out.println("Size: "+birdQueue.size);


    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();

        for (int i = 0; i < removeBody.size; i++) {
            Body body = removeBody.removeFirst();
            world.destroyBody(body);
        }


        game.batch.draw(sky, 0, 0, 1280f, 720f);
        game.batch.draw(ground.texture, 0, -450f, 1280f, 635f);
        game.batch.draw(pauseButton, 1220f, 660f, 50f, 50f);

        game.batch.draw(sling,200f,635f-455f,92f,170f);

        //((AngryObject)redBird).render(game.batch);
        hwood.render(game.batch);
        vglass1.render(game.batch);
        vglass2.render(game.batch);
        //vglass3.render(game.batch);
        vwood1.render(game.batch);
        vwood2.render(game.batch);
        hglass1.render(game.batch);
        //hstone.render(game.batch);
        chuck.render(game.batch);
//        terence.render(game.batch);
        pigga1.render(game.batch);
        pigga2.render(game.batch);
        mustPig.render(game.batch);
//        kingPig.render(game.batch);
        redBird.render(game.batch);
        //game.batch.draw(grass, 0, 635f-455f, 1280f, 50f);
        font.draw(game.batch, "nicer", 10, 710);
        font.draw(game.batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 300, 710);

        //change to pauseButton2 if hover
        if (!birdQueue.isEmpty()) {
            if (Gdx.input.isTouched() && Gdx.input.getX() > 200f - 180f && Gdx.input.getX() < 200f + 180f && 720f - Gdx.input.getY() > 635f - 455f && 720f - Gdx.input.getY() < 635f - 455f + 170f + 180f) {
                slingshot.pull(Gdx.input.getX(), 720 - Gdx.input.getY(), birdQueue.first().body);
                slingshot.calculateTrajectory(birdQueue.first().body, 20, game.batch);
            } else if (!Gdx.input.isTouched() && slingshot.isPulled()) {
                slingshot.release(birdQueue.first().body);
                birdQueue.first().isReleased=1;
                birdQueue.first().body.setGravityScale(1);
                //birdQueue.removeFirst();
                super.started = true;
            }
        }

        if (!birdQueue.isEmpty() && birdQueue.first().body.getLinearVelocity().x==0.0f && birdQueue.first().body.getLinearVelocity().y==0.0f  && birdQueue.first().isReleased==1) {

            birdQueue.removeFirst();
            Bird nextBird = birdQueue.first();
            slingshot.animateBirdToPosition(nextBird, slingshot.getAnchorPoint(), 1); // 1 second duration
//            birdQueue.removeFirst();
        }



        if(Gdx.input.getX()>1220f && Gdx.input.getX()<1270f && 720f-Gdx.input.getY()>660f && 720f-Gdx.input.getY()<710f){
            game.batch.draw(pauseButton2, 1220f, 660f, 50f, 50f);
            if(Gdx.input.isTouched()){
                game.setScreen(new PauseScreen(game, this));
                //dispose();
            }
        }
        game.batch.end();

        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
        world.step(1 / 60f, 6, 2);
//        box2ddebugrenderer.render(world, game.batch.getProjectionMatrix().cpy().scale(1, 1, 0));
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
//        box2ddebugrenderer.dispose();
    }

}
