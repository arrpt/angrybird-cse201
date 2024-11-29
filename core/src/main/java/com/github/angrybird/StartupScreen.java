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
    private Texture playButton1;
    private Texture playButton2;

    public StartupScreen(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("intro2.mp3"));
        bgimage = new Texture("angrybirdsintro3.png"); // credits - https://www.deviantart.com/krimadraws/art/Angry-Birds-Splash-screen-but-even-more-Classic-916194469
        playButton1 = new Texture("play6.png");
        playButton2 = new Texture("play7.png");
    }

    @Override
    public void render(float v) {
        //bgmusic.play();
        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(bgimage, 0, 0, 1280f, 720f);

        game.batch.draw(playButton1, 640f-(100f/2f), 60f, 100f, 97.67f);
        //change to playButton2 if hover
        if(Gdx.input.getX()>590f && Gdx.input.getX()<690f && 720f-Gdx.input.getY()>60f && 720f-Gdx.input.getY()<157.67f){
            game.batch.draw(playButton2, 640f-(100f/2f), 60f, 100f, 97.67f);
            if(Gdx.input.isTouched()){
                //bgmusic.stop();
                game.setScreen(new MenuScreen(game));

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
        //bgmusic.dispose();
    }
}
