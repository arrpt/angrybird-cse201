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
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static com.github.angrybird.LevelStatusManager.FILE_PATH;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    public Music bgmusic;
    public static LevelStatusManager levelStatusManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("intro2.mp3"));
        bgmusic.play();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            levelStatusManager = new LevelStatusManager(this);
            levelStatusManager.saveStatus();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                levelStatusManager = (LevelStatusManager) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //levelStatusManager = new LevelStatusManager(this);
        //levelStatusManager.setLevelStatus("level1", "fail");
        //levelStatusManager.setLevelStatus("level2", "fail");
        //levelStatusManager.setLevelStatus("level3", "fail");
        this.setScreen(new StartupScreen(this));
    }


    @Override
    public void render() {
        super.render();
    }

    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }
}
