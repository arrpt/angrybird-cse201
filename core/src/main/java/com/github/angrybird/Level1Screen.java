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
import com.github.angrybird.material.Hstone;
import com.github.angrybird.material.Hwood;
import com.github.angrybird.material.Vglass;
import com.github.angrybird.pig.KingPig;
import com.github.angrybird.pig.MustPig;
import com.github.angrybird.pig.Pigga;

import java.util.ArrayList;

public class Level1Screen extends LevelScreen implements Screen {

    //Main game;
    public boolean started = false;
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
//    private Box2DDebugRenderer box2ddebugrenderer;
    Chuck chuck;
    Terence terence;
    Pigga pigga;
    MustPig mustPig;
    KingPig kingPig;

    private boolean initialized = false;

    public Queue<Bird> birdQueue = new Queue<>();
    public Queue<Body> removeBody = new Queue<>();
    //public ArrayList<AngryObject> renderObjects = new ArrayList<>();

    public Level1Screen(Main game){
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

        redBird = new RedBird(world, 250f, 635f-455f+130f);
        hwood = new Hwood(world, 800f, 635f-455f);
        vglass = new Vglass(world, 800f, 635f-455f+212f);
        hstone = new Hstone(world, 800f, 635f-455f+212f+22f);
        ground = new Ground(world);
        chuck = new Chuck(world, 200f - 70f, 635f-455f+130f);
        terence = new Terence(world, 200f - 150f, 635f-455f+130f);
        pigga = new Pigga(world, 200f+300f, 635f-455f+130f);
        mustPig = new MustPig(world, 200f+400f, 635f-455f+130f);
        kingPig = new KingPig(world, 200f+500f, 635f-455f+130f);
//        box2ddebugrenderer = new Box2DDebugRenderer();

        //birdQueue = new Queue<>();
        birdQueue.addLast(redBird);
        birdQueue.addLast(chuck);
        birdQueue.addLast(terence);
        initialized=true;
        System.out.println("Size: "+birdQueue.size);
        // renderObjects.add(redBird);
//        renderObjects.add(hwood);
//        renderObjects.add(vglass);
//        renderObjects.add(hstone);
//        renderObjects.add(chuck);
//        renderObjects.add(terence);
//        renderObjects.add(pigga);
//        renderObjects.add(mustPig);
//        renderObjects.add(kingPig);

    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();

        for (int i = 0; i < removeBody.size; i++) {
            Body body = removeBody.removeFirst();
            world.destroyBody(body);
        }
//
//        for (AngryObject object : renderObjects) {
//            System.out.println("Instance: "+object.getClass().getName());
//            System.out.println("isVisible: "+object.isVisible);
//            if (object.isVisible == 1) {
//                if (object instanceof RedBird){
//                    ((RedBird)object).render(game.batch);
//                }
//
//            }
//        }
        // AngryObject temp = renderObjects.get(0);
//        System.out.println("Instance: "+temp.getClass().getName());
//        System.out.println("if instance equal redBird: "+(temp instanceof RedBird));
//        if (temp instanceof RedBird){
//            RedBird temp2 = (RedBird) temp;
//            temp2.render(game.batch);
//
//        }
//        System.out.println(temp.equals(redBird));
        game.batch.draw(sky, 0, 0, 1280f, 720f);
        game.batch.draw(ground.texture, 0, -450f, 1280f, 635f);
        game.batch.draw(pauseButton, 1220f, 660f, 50f, 50f);
        //game.batch.draw(slingRight, 640f-50f, 635f-45 1f, 36f, 200f);
        //game.batch.draw(slingLeft, 640f-50f-32f, 635f-451f+200f-115f, 42f, 124f);

        game.batch.draw(sling,200f,635f-455f,92f,170f);

        //((AngryObject)redBird).render(game.batch);
        hwood.render(game.batch);
        vglass.render(game.batch);
        hstone.render(game.batch);
        chuck.render(game.batch);
        terence.render(game.batch);
        pigga.render(game.batch);
        mustPig.render(game.batch);
        kingPig.render(game.batch);
        redBird.render(game.batch);
        //game.batch.draw(grass, 0, 635f-455f, 1280f, 50f);
        font.draw(game.batch, "nicer", 10, 710);
        font.draw(game.batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 300, 710);
        //change to pauseButton2 if hover
        //float birdRadius = 5f;
        //Vector2 touchPoint = new Vector2(Gdx.input.getX(), 720 - Gdx.input.getY());
        //System.out.println("BirdQueue size: "+birdQueue.size);

//        int temp=0;
//        while(temp!=1){
//            ((birdQueue.first())).body.toString();
//            redBird.body.toString();
//            temp++;
//        }
//        System.out.println(redBird.body.toString());


//        if (Gdx.input.isTouched() && Gdx.input.getX()>200f-180f && Gdx.input.getX()<200f+180f && 720f-Gdx.input.getY()>635f-455f && 720f-Gdx.input.getY()<635f-455f+170f+180f) {
//
//            slingshot.pull(Gdx.input.getX(), 720 - Gdx.input.getY(), birdQueue.first().body);
//            slingshot.calculateTrajectory(birdQueue.first().body, 20, game.batch);
//        }
//        else if (!Gdx.input.isTouched() && slingshot.isPulled()) {
//            slingshot.release(birdQueue.first().body);
//            birdQueue.first().body.setGravityScale(1);
//            birdQueue.removeFirst();
//            if (!birdQueue.isEmpty() && birdQueue.first().body.getLinearVelocity().isZero()) {
//                Bird nextBird = birdQueue.first();
//                slingshot.animateBirdToPosition(nextBird, slingshot.getAnchorPoint(), 1); // 1 second duration
//                birdQueue.removeFirst();
//            }
//        }



        if (!birdQueue.isEmpty()) {
            if (Gdx.input.isTouched() && Gdx.input.getX() > 200f - 180f && Gdx.input.getX() < 200f + 180f && 720f - Gdx.input.getY() > 635f - 455f && 720f - Gdx.input.getY() < 635f - 455f + 170f + 180f) {
                slingshot.pull(Gdx.input.getX(), 720 - Gdx.input.getY(), birdQueue.first().body);
                slingshot.calculateTrajectory(birdQueue.first().body, 20, game.batch);
            } else if (!Gdx.input.isTouched() && slingshot.isPulled()) {
                slingshot.release(birdQueue.first().body);
                birdQueue.first().isReleased=1;
                birdQueue.first().body.setGravityScale(1);
                //birdQueue.removeFirst();
                started = true;
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
