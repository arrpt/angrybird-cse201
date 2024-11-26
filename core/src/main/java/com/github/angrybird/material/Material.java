package com.github.angrybird.material;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.github.angrybird.AngryObject;

public abstract class Material extends AngryObject {
    public int health;
    public Body body;
    public BodyDef bodyDef;
    public FixtureDef fixture;
    public Texture texture;
    public TextureRegion textureRegion;
    public int score;

    public Material() {
        super();
    }
}
