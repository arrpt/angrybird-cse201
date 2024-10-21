package com.github.angrybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {
    Main game;
    private Texture bgimage;
    private Music bgmusic;
    private Texture level1;
    private Texture level2;

    public MenuScreen(Main game){
        this.game = game;
    }
    //write code for changing the screen to MenuScreen when play button is clicked

    @Override
    public void show() {
        //bgmusic = Gdx.audio.newMusic(Gdx.files.internal("intro2.mp3"));

        bgimage = new Texture("angrybirdsintro3.png"); // credits - https://www.deviantart.com/krimadraws/art/Angry-Birds-Splash-screen-but-even-more-Classic-916194469
        level1 = new Texture("play1.png");
        level2 = new Texture("play2.png");
    }

    @Override
    public void render(float v) {
        //bgmusic.play();
        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(bgimage, 0, 0, 1280f, 720f);

        game.batch.draw(level1, 540f-(100f/2f), 60f, 100f, 97.67f);
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
