package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class StartupScreen implements Screen {
    Main game;
    private Texture bgimage;
    private Music bgmusic;

    public StartupScreen(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("intro.mp3"));
        bgimage = new Texture("angrybirdsintro.jpg"); // credits - https://www.deviantart.com/krimadraws/art/Angry-Birds-Splash-screen-but-even-more-Classic-916194469
    }

    @Override
    public void render(float v) {
        bgmusic.play();
        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(bgimage, 0, 0, 640, 480);
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
        bgmusic.dispose();
    }
}
