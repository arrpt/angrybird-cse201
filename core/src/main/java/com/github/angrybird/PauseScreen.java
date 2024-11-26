package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class PauseScreen implements Screen {

    Main game;
    private Texture pausebg;
    private Texture resume1;
    private Texture resume2;
    private Texture home1;
    private Texture home2;
    private Texture restart1;
    private Texture restart2;
    private LevelScreen levelScreen;



    public PauseScreen(Main game, LevelScreen levelScreen){
        this.game = game;
        this.levelScreen = levelScreen;
    }
    @Override
    public void show() {
        pausebg = new Texture("pausebg1.png");
        resume1 = new Texture("resume1.png");
        resume2 = new Texture("resume2.png");
        home1 = new Texture("home1.png");
        home2 = new Texture("home2.png");
        restart1 = new Texture("restart1.png");
        restart2 = new Texture("restart2.png");

    }

    @Override
    public void render(float v) {
        //ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(pausebg, 640f-(376f/2f), 360f-(376f/2f), 376f, 376f);
        game.batch.draw(home1,640f-(376f/2f)+53f, 360f-(376f/2f)+(155f),86f,86f);
        game.batch.draw(restart1,640f-(376/2f)+86f+90f+60f, 360f-(376f/2f)+(155f),86f,86f);
        game.batch.draw(resume1,640f-43f,360f-(376f/2f)+(155f)-86f,86f,86f);

        //draw home2 if hover
        if(Gdx.input.getX()>640f-(376f/2f)+53f && Gdx.input.getX()<640f-(376f/2f)+53f+86f && 720f-Gdx.input.getY()>360f-(376f/2f)+(155f) && 720f-Gdx.input.getY()<360f-(376f/2f)+(155f)+86f){
            //game.batch.begin();
            game.batch.draw(home2,640f-(376f/2f)+53f, 360f-(376f/2f)+(155f),86f,86f);
            //game.batch.end();
            if(Gdx.input.isTouched()){
                game.setScreen(new MenuScreen(game));
                dispose();
            }
        }
        //game.batch.end();

        //draw restart2 if hover
        if(Gdx.input.getX()>640f-(376/2f)+86f+90f+60f && Gdx.input.getX()<640f-(376/2f)+86f+90f+60f+86f && 720f-Gdx.input.getY()>360f-(376f/2f)+(155f) && 720f-Gdx.input.getY()<360f-(376f/2f)+(155f)+86f){
            game.batch.draw(restart2,640f-(376/2f)+86f+90f+60f, 360f-(376f/2f)+(155f),86f,86f);
            if(Gdx.input.isTouched()){
                //if called from level 1 change to level1screen
                //if called from level 2 change to level2screen
                //
                if (levelScreen instanceof Level1Screen){
                    game.setScreen(new Level1Screen(game));

                } else if (levelScreen instanceof Level2Screen){
                    game.setScreen(new Level2Screen(game));

                } else if (levelScreen instanceof Level3Screen){
                    game.setScreen(new Level3Screen(game));

                }
                dispose();
            }
        }

        //draw resume2 if hover
        if(Gdx.input.getX()>640f-43f && Gdx.input.getX()<640f-43f+86f && 720f-Gdx.input.getY()>360f-(376f/2f)+(155f)-86f && 720f-Gdx.input.getY()<360f-(376f/2f)+(155f)){
            game.batch.draw(resume2,640f-43f,360f-(376f/2f)+(155f)-86f,86f,86f);
            if(Gdx.input.isTouched()){
                game.setScreen(levelScreen);
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

    }
}
