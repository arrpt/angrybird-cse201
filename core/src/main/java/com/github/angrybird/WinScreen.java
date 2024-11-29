package com.github.angrybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import static java.lang.Thread.sleep;

public class WinScreen implements Screen {
    Main game;
    LevelScreen levelScreen;
    Texture texture;
    private Texture home1;
    private Texture home2;
    LevelStatusManager levelStatusManager;

    public WinScreen(Main game, LevelScreen levelScreen){
        this.game = game;
        this.levelScreen = levelScreen;
    }

    @Override
    public void show() {
        texture  = new Texture("levelClear.png");
        home1 = new Texture("home1.png");
        home2 = new Texture("home2.png");

    }
    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(texture, 640f-250f, 0, 500f, 720f);
        game.batch.draw(home1,640f-43f, 360f-(155f),86f,86f);

        //draw home2 if hover
        if(Gdx.input.getX()>640f-43f && Gdx.input.getX()<640f-43f+86f && 720f-Gdx.input.getY()>360f-(155f) && 720f-Gdx.input.getY()<360f-(155f)+86f){
            //game.batch.begin();
            game.batch.draw(home2,640f-43f, 360f-(155f),86f,86f);
            //game.batch.end();
            if(Gdx.input.isTouched()){
                game.setScreen(new MenuScreen(game));
                dispose();
            }
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
        texture.dispose();
        home1.dispose();
        home2.dispose();
    }
}
