package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
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
    private Texture red1;
    private Texture yellow1;
    private Texture bigRed1;


    public Level1Screen(Main game){
        this.game = game;
    }

    @Override
    public void show() {

        sky = new Texture("skyl1.png");
        ground = new Texture("groundl1.png");
        pauseButton = new Texture("pausebutton.png");
        pauseButton2 = new Texture("pausebutton2.png");
        grass = new Texture("grass.png");
//        slingRight = new Texture("slingright.png");
//        slingLeft = new Texture("slingleft.png");
        sling = new Texture("sling.png");
        red1 = new Texture("red1.png");
        yellow1 = new Texture("yellow1.png");
        bigRed1 = new Texture("bigred1.png");



    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(sky, 0, 0, 1280f, 720f);
        game.batch.draw(ground, 0, -450f, 1280f, 635f);
        game.batch.draw(pauseButton, 1220f, 660f, 50f, 50f);
        //game.batch.draw(slingRight, 640f-50f, 635f-451f, 36f, 200f);
        //game.batch.draw(slingLeft, 640f-50f-32f, 635f-451f+200f-115f, 42f, 124f);
        game.batch.draw(sling,200f,635f-455f,92f,170f);
        game.batch.draw(red1, 200f+45f, 635f-455f+120f, 42f, 42f);
        game.batch.draw(yellow1, 180f, 635f-455f, 52f, 52f);
        game.batch.draw(bigRed1,80f,635f-455f, 88f, 88f);


        //game.batch.draw(grass, 0, 635f-455f, 1280f, 50f);
        //change to pauseButton2 if hover
        if(Gdx.input.getX()>1220f && Gdx.input.getX()<1270f && 720f-Gdx.input.getY()>660f && 720f-Gdx.input.getY()<710f){
            game.batch.draw(pauseButton2, 1220f, 660f, 50f, 50f);
//            if(Gdx.input.isTouched()){
//                game.setScreen(new PauseScreen(game));
//                dispose();
//            }
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

    }
}
