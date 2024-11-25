package com.github.angrybird;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.angrybird.bird.Chuck;
import com.github.angrybird.bird.RedBird;
import com.github.angrybird.bird.Terence;

public abstract class AngryObject {
    public int isVisible;
    public AngryObject(){
        isVisible = 1;
    }
}
