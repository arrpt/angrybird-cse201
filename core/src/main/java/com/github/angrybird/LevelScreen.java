package com.github.angrybird;

import com.badlogic.gdx.Screen;

public class LevelScreen implements Screen {
    public boolean started;
    Main game;
    public int points;
    public int pigsnumber;
    public LevelStatusManager levelStatusManager;

    public LevelScreen(Main game){
        this.game = game;
        this.started = false;
        this.levelStatusManager = new LevelStatusManager();
        this.points = 0;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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
