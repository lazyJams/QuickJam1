package net.lazyio.quickjam.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.lazyio.engine.entity.Entity;
import net.lazyio.engine.entity.behaviors.IRender;
import net.lazyio.engine.entity.behaviors.ITick;

public class Player extends Entity implements IRender, ITick {

    public Player(Vector2 pos, Vector2 size, String tag) {
        super(pos, size, tag);
    }

    @Override
    public void tick(float delta) {

    }

    @Override
    public void render(SpriteBatch batch, float delta) {

    }
}
