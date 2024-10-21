package com.github.angrybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.audio.Music;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    //private Texture image;
    //private FitViewport viewport;
    public Music bgmusic;

    @Override
    public void create() {
        //viewport = new FitViewport(640, 480);
        batch = new SpriteBatch();
        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("intro2.mp3"));
        bgmusic.play();

        //image = new Texture("libgdx.png");
        this.setScreen(new StartupScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public void resize(int width, int height) {
        //viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        //batch.dispose();
        //image.dispose();
    }
}
