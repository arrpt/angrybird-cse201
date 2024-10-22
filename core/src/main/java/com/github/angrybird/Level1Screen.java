package com.github.angrybird;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class Level1Screen implements Screen {

    Main game;
    private Texture sky;
    private Texture ground;
    private Texture pauseButton;


    public Level1Screen(Main game){
        this.game = game;
    }

    @Override
    public void show() {

        sky = new Texture("skyl1.png");
        ground = new Texture("groundl1.png");
        pauseButton = new Texture("pausebutton.png");


    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(sky, 0, 0, 1280f, 720f);
        game.batch.draw(ground, 0, -450f, 1280f, 635f);
        game.batch.draw(pauseButton, 1220f, 720f, 114f, 114f);
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
