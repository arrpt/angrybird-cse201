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
    private Texture level3;
    private Texture textLogo;
    private LevelStatusManager levelStatusManager;


    public MenuScreen(Main game){
        this.game = game;
    }
    //write code for changing the screen to MenuScreen when play button is clicked

    @Override
    public void show() {
        //bgmusic = Gdx.audio.newMusic(Gdx.files.internal("intro2.mp3"));

        bgimage = new Texture("menubg.png"); // credits - https://www.deviantart.com/krimadraws/art/Angry-Birds-Splash-screen-but-even-more-Classic-916194469
        level1 = new Texture("level1.png");
        level2 = new Texture("level2.png");
        level3= new Texture("level3.png");
        textLogo = new Texture("textLogo.png");
        levelStatusManager = new LevelStatusManager();
    }

    @Override
    public void render(float v) {
        //bgmusic.play();
        ScreenUtils.clear(Color.BLACK);
        game.batch.begin();
        game.batch.draw(bgimage, 0, 0, 1280f, 720f);
        game.batch.draw(level1, 320f-(220f/2f), 360f-(220f/2f), 220f, 220f);
        game.batch.draw(level2, 640f-(220f/2f), 360f-(220f/2f), 220f, 220f);
        game.batch.draw(level3, 960f-(220f/2f), 360f-(220f/2f), 220f, 220f);
        game.batch.draw(textLogo,640f-(660f/2f), 600f-(150f/2f),660f,150f);

        //change to level 1 if clicked on level1 button
//        if(Gdx.input.getX()>210f && Gdx.input.getX()<430f && 720f-Gdx.input.getY()>250f && 720f-Gdx.input.getY()<470f) {
//            if (Gdx.input.isTouched()) {
//                game.setScreen(new Level1Screen(game));
//                dispose();
//            }
//        }
//        //change to level 2 if clicked on level2 button
//        if(Gdx.input.getX()>530f && Gdx.input.getX()<750f && 720f-Gdx.input.getY()>250f && 720f-Gdx.input.getY()<470f) {
//            if (Gdx.input.isTouched()) {
//                game.setScreen(new Level2Screen(game));
//                dispose();
//            }
//        }
//
//        //change to level 3 if clicked on level3 button
//        if(Gdx.input.getX()>850f && Gdx.input.getX()<1070f && 720f-Gdx.input.getY()>250f && 720f-Gdx.input.getY()<470f) {
//            if (Gdx.input.isTouched()) {
//                game.setScreen(new Level3Screen(game));
//                dispose();
//            }
//        }

        if (!"pass".equals(levelStatusManager.getLevelStatus("level1"))) {
            if (Gdx.input.getX() > 210f && Gdx.input.getX() < 430f && 720f - Gdx.input.getY() > 250f && 720f - Gdx.input.getY() < 470f) {
                if (Gdx.input.isTouched()) {
                    game.setScreen(new Level1Screen(game));
                    dispose();
                }
            }
        }

        // Check level 2 status
        if (!"pass".equals(levelStatusManager.getLevelStatus("level2"))) {
            if (Gdx.input.getX() > 530f && Gdx.input.getX() < 750f && 720f - Gdx.input.getY() > 250f && 720f - Gdx.input.getY() < 470f) {
                if (Gdx.input.isTouched()) {
                    game.setScreen(new Level2Screen(game));
                    dispose();
                }
            }
        }

        // Check level 3 status
        if (!"pass".equals(levelStatusManager.getLevelStatus("level3"))) {
            if (Gdx.input.getX() > 850f && Gdx.input.getX() < 1070f && 720f - Gdx.input.getY() > 250f && 720f - Gdx.input.getY() < 470f) {
                if (Gdx.input.isTouched()) {
                    game.setScreen(new Level3Screen(game));
                    dispose();
                }
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
